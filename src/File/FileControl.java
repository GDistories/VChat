package File;

import java.io.*;
import java.util.Objects;

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

    public synchronized void newWrite(String str) throws IOException {
        FileOutputStream fout = new FileOutputStream(file, false);
        OutputStreamWriter writer = new OutputStreamWriter(fout);
        BufferedWriter buffWriter = new BufferedWriter(writer);
        buffWriter.write(str);
        buffWriter.newLine();
        buffWriter.close();
    }
}
