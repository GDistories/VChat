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
        System.out.println("Now is writing..." + str);
        FileOutputStream fout = new FileOutputStream(file, true);
        OutputStreamWriter writer = new OutputStreamWriter(fout);
        BufferedWriter buffWriter = new BufferedWriter(writer);
        buffWriter.write(str);
        buffWriter.newLine();
        buffWriter.close();
        System.out.println("Write success!" + str);
    }

    public synchronized void saveLog() throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

        //Confirm source file
        File file=new File("logfile/log.txt");
        //Confirm input stream
        FileReader fr=new FileReader(file);
        //Read data from source file
        int n;
        StringBuilder sb=new StringBuilder();
        while ((n=fr.read())!=-1){
            sb.append((char)n);
        }
        //Close input stream
        fr.close();

        //Confirm target file
        File file2=new File("logfile/log_"+ sdf.format(date) +".txt");
        if(!file2.exists()){
            file2.createNewFile();
        }
        //Confirm output stream
        FileWriter fw=new FileWriter(file2);
        //Write data to target file
        for (int i = 0; i <sb.length() ; i++) {
            char a=sb.charAt(i);
            fw.write(a);
        }
        //Close output stream
        fw.close();

    }
}
