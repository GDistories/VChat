package Socket;

import MyFrame.ServerFrame.ServerFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {
    public static List<Socket> socketList = new ArrayList<Socket>();
    private ServerSocket serverSocket;

    public void creatServer() {
        serverSocket = null;//创界服务器套接字
        try {
            serverSocket = new ServerSocket(1505);//绑定端口
            System.out.println("Server is running...");
            Date date = new Date();
            ServerFrame.setTextIn("Server is start at " + date.toString());
            while (true) {
                Socket socket = serverSocket.accept();     //从连接请求队列中取出一个连接
                System.out.println("上线通知： 用户" + socket.getPort() + "上线了！");//用户上线公告
                socketList.add(socket);//加入队列
                printSocketList();//打印队列
                new Thread(new ServerThread(socket, socketList)).start();//创建新线程
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
        System.out.println("当前在线用户：");
        for (Socket socket : socketList) {
            System.out.println(socket.getPort());
        }
    }

    public void closeServer() {//关闭服务器
        PrintWriter pw = null;
        for (Socket item : socketList) {//关闭所有端口
            try {
                pw = new PrintWriter(item.getOutputStream());//创建数据输出流
                pw.println("Server Has Been Closed!");//发送服务器关闭指示
                pw.flush();//刷新
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
            //发送退出指令
        }
    }
}

class ServerThread implements Runnable {//服务器群发消息线程
    public Socket socket;//端口
    public static List<Socket> socketList = new ArrayList<Socket>();//客户队列

    public ServerThread(Socket socket, List<Socket> socketList) {//绑定端口和队列
        this.socket = socket;
        this.socketList = socketList;
    }
    public void run() {
        BufferedReader br = null;//创建空输入流
        PrintWriter pw = null;//创建空输出流
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//创建输入流
            while (true) {
                String str = br.readLine();//数据读取
                //公告退出if...
                for (Socket item : socketList) {//遍历客户队列，向每一个客户发送数据
                    pw = new PrintWriter(item.getOutputStream());//创建数据输出流
                    pw.println("用户" + socket.getPort() + "说：" + str);//发送数据
                    pw.flush();//刷新
                }
            }
        } catch (IOException e) {//抓取连接断开异常，描述客户退出
//            e.printStackTrace();
            socketList.remove(socket);//移除客户
            System.out.println("下线通知： 用户" + socket.getPort() + "下线了！");//客户退出公告
        } finally {
            try {//关闭流
                if (br != null) br.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}