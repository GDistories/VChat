package Socket;
import MyFrame.ClientFrame.ChatRoomFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public PrintWriter pw = null;//创建空输出缓冲流
    public Socket socket;//创建套接字


    public Client(Socket socket) {
        socket = null;//创建套接字
        try {
            socket = new Socket("127.0.0.1", 1505);//绑定套接字
            this.socket = socket;
            System.out.println("恭喜你连接成功!");
        } catch (IOException e) {//，创建套接字失败，请求连接失败，抛出异常，打印消息
            e.printStackTrace();
            System.out.println("服务器未开启，连接失败");
        }
        Thread receptThread = new Thread(new ClientThread(socket));//创建接收线程
        receptThread.setDaemon(true);//设置接受线程为守护线程
        receptThread.start();//开启接收线程
    }

    public void creatInput(String sendInformation, Socket socket) {
        try {
            pw = new PrintWriter(socket.getOutputStream());//创建输出流
            pw.println(sendInformation);//客户端输出
            pw.flush();//刷新流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket(Socket socket) {
        try {
            if (pw != null) pw.close();//关闭输出流
            if (socket != null) socket.close();//关闭套接字
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ClientThread implements Runnable {//接收消息线程

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
                if (str.equals("ServerHasBeenClosed")) {//获取服务器关闭指示，关闭端口
                    if (br != null) br.close();
                }
                System.out.println(str);
                ChatRoomFrame.setTextIn(str);
            }
        } catch (IOException e) {//抓取流异常判断连接是否断开
            e.printStackTrace();
            System.out.println("服务器关闭，强制退出");
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}