package Socket;
import MyFrame.ClientFrame.ChatRoomFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public PrintWriter pw = null;//Create an empty PrintWriter
    public Socket socket;//Create an empty Socket


    public Client(Socket socket) {
        socket = null;//Create an empty Socket
        try {
            socket = new Socket("127.0.0.1", 1505);//Connect to the server
            this.socket = socket;
            System.out.println("Connected to Server Successfully!");
            ChatRoomFrame.setTextIn("Connected to Server Successfully!");

        } catch (IOException e) {//If the connection fails, print the error message
            e.printStackTrace();
            ChatRoomFrame.setTextIn("Server is not running! Connected to Server Failed!");
            System.out.println("Server is not running! Connected to Server Failed!");
        }
        Thread receptThread = new Thread(new ClientThread(socket));//Create a new thread to receive data from the server
        receptThread.setDaemon(true);//Set the thread as a daemon thread
        receptThread.start();//Start the thread
    }

    public void creatInput(String sendInformation, Socket socket) {
        try {
            pw = new PrintWriter(socket.getOutputStream());//Create a new PrintWriter
            pw.println(sendInformation);//Send the data to the server
            pw.flush();//Flush the data to the server
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket(Socket socket) {
        try {
            if (pw != null) pw.close();//Close the PrintWriter
            if (socket != null) socket.close();//Close the Socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ClientThread implements Runnable {//Create a new thread to receive data from the server

    public Socket socket;
    public BufferedReader br;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = br.readLine();
                if (str.equals("Server Has Been Closed!")) {//If the server closes, close the client
                    if (br != null) br.close();
                }
                if (str.contains("Current Online User:")) {//If the server sends the current online user list, display it
                    ChatRoomFrame.setCurrentUser(str);
                }else{
                    ChatRoomFrame.setTextIn(str);
                }
            }
        } catch (IOException e) {//If the connection fails, print the error message
            e.printStackTrace();
            System.out.println("Server shutdown, forced exit!");
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}