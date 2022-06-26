package File;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileControl {
    private File file;

    public void initialise() {
        file = new File("logfile/log.txt");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized String read() {
        String content = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                content += line + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public synchronized void write(String str) throws IOException {
        FileOutputStream fout = new FileOutputStream(file, true);
        OutputStreamWriter writer = new OutputStreamWriter(fout);
        BufferedWriter buffWriter = new BufferedWriter(writer);
        buffWriter.write(str);
        buffWriter.newLine();
        buffWriter.close();
    }

    public synchronized void saveLog() throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

        //确认源文件
        File file=new File("logfile/log.txt");
        //确认输入流
        FileReader fr=new FileReader(file);
        //读数据
        int n;
        StringBuilder sb=new StringBuilder();
        while ((n=fr.read())!=-1){
            sb.append((char)n);
        }
        //及时关闭输入
        fr.close();

        //确定输出目标
        File file2=new File("logfile/log_"+ sdf.format(date) +".txt");
        if(!file2.exists()){
            file2.createNewFile();
        }
        //确认输出流
        FileWriter fw=new FileWriter(file2);
        //写数据
        for (int i = 0; i <sb.length() ; i++) {
            char a=sb.charAt(i);
            fw.write(a);
        }
        //及时关闭输出
        fw.close();

    }
}
