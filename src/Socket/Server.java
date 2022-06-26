package Socket;

import File.FileControl;
import MyFrame.ServerFrame.ServerFrame;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {
    public static List<Socket> socketList = new ArrayList<Socket>();
    private ServerSocket serverSocket;
    FileControl fileControl = new FileControl();//Create a file control object

    public void creatServer() {
        serverSocket = null;//Create the server socket
        fileControl.initialise();//Initialise the file control object
        try {
            serverSocket = new ServerSocket(1505);//Create the server socket
            System.out.println("Server is running...");
            Date date = new Date();
            ServerFrame.setTextIn("Server is start at " + date.toString());
            while (true) {
                Socket socket = serverSocket.accept();     //Accept the connection from the client

                System.out.println("User " + socket.getPort() + " is now online!");//Print the message to the server console
                ServerFrame.setTextIn("User " + socket.getPort() + " is now online!");//Print the message to the server console

                PrintWriter pw = null;
                try {
                    pw = new PrintWriter(socket.getOutputStream());//Create a new PrintWriter
                } catch (IOException e) {
                    e.printStackTrace();
                }
                pw.println(fileControl.read());//Send the data to the client
                pw.flush();//Flush the data to the client

                socketList.add(socket);//Add the client to the socket list
                printSocketList();
                new Thread(new ServerThread(socket, socketList, fileControl)).start();//Create a new thread to receive data from the client
            }
        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printSocketList() {
        String currentUser = "Current Online User:,";
        PrintWriter pw = null;//Create a new PrintWriter
        for (Socket socket : socketList) {
            currentUser += socket.getPort() + ",";
        }

        for (Socket socket : socketList) {
            try {
                pw = new PrintWriter(socket.getOutputStream());//Create a new PrintWriter
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.println(currentUser);//Send the data to the client
            pw.flush();//Flush the data to the client
        }
    }

    public void closeServer() {//Close the server
        PrintWriter pw = null;
        Date date = new Date();
        ServerFrame.setTextIn("Server is closed at " + date.toString());
        try {
            fileControl.saveLog();//Save the log
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Socket item : socketList) {//Close the client socket
            try {
                pw = new PrintWriter(item.getOutputStream());//Create a new PrintWriter
                pw.println("Server Has Been Closed!");//Send the data to the client
                pw.flush();//Flush the data to the client
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (pw != null) pw.close();
                if(serverSocket!=null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //Close the client socket
        }
    }
}

class ServerThread implements Runnable {//Create a new thread to send data to the client
    public Socket socket;//Create a new socket
    public static List<Socket> socketList = new ArrayList<Socket>();//Create a new socket list
    public Date date;
    FileControl fileControl;

    public ServerThread(Socket socket, List<Socket> socketList, FileControl fileControl) {//Create a new thread to send data to the client
        this.socket = socket;
        this.socketList = socketList;
        this.fileControl = fileControl;
    }
    public void run() {
        BufferedReader br = null;//Create a new BufferedReader
        PrintWriter pw = null;//Create a new PrintWriter
        System.out.println("Start New Thread");//Print the message to the server console
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Create a new BufferedReader
            while (true) {
                date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Create a new SimpleDateFormat
                String str = br.readLine();//Read the data from the client
                ServerFrame.setTextIn(sdf.format(date) + "\nUser " + socket.getPort() + " says: " + str + "\n");
                fileControl.write(sdf.format(date) + "\nUser " + socket.getPort() + " says: " + str + "\n");
                //Print the message to the server console
                for (Socket item : socketList) {//Traverse the client list and send data to each client
                    pw = new PrintWriter(item.getOutputStream());//Create a new PrintWriter
                    pw.println(sdf.format(date) + "\nUser " + socket.getPort() + " says: " + str + "\n");//Send the data to the client
                    pw.flush();//Flush the data to the client
                }
            }
        } catch (IOException e) {//Grab connection disconnection exception, describe client exit
//            e.printStackTrace();
            socketList.remove(socket);//Remove the client from the socket list
            printSocketList();
            System.out.println("User " + socket.getPort() + " is Offline!");//Print the message to the server console
            ServerFrame.setTextIn("User " + socket.getPort() + " is Offline!");//Print the message to the server console

        } finally {
            try {//Close the client socket
                if (br != null) br.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("New Thread End");//Print the message to the server console
    }

    public void printSocketList() {
        String currentUser = "Current Online User:,";
        PrintWriter pw = null;//Create a new PrintWriter
        for (Socket socket : socketList) {
            currentUser += socket.getPort() + ",";
        }

        for (Socket socket : socketList) {
            try {
                pw = new PrintWriter(socket.getOutputStream());//Create a new PrintWriter
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.println(currentUser);//Send the data to the client
            pw.flush();//Flush the data to the client
        }
    }
}