package MyFrame.ServerFrame;
import Socket.Server;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ServerFrame extends JFrame {
    JLabel serverSwitch = new JLabel("Server has been closed.");//显示服务器状态
    JButton open = new JButton("Open");
    JButton close = new JButton("Close");
    static Date date = new Date();//创建时间类
    public static TextArea serverText = new TextArea("Server is Closed.");//输出聊天框
    private Thread serverThread = new Thread(new ServerThread());//创建服务器群发线程
    private Server server=new Server();//创建服务器对象

    public ServerFrame(String title) {
        super(title);
        this.setLayout(null);

        serverText.setBounds(20, 20, 700, 330);//设置输出框位置
        add(serverText);//添加聊天框

        serverThread.setDaemon(true);//设置为守护线程
        serverSwitch.setBounds(300, 350, 150, 40);
        add(serverSwitch);

        open.setBounds(200, 420, 100, 30);
        add(open);
        openButtonLister openButtonLister = new openButtonLister();
        open.addActionListener(openButtonLister);

        close.setBounds(450, 420, 100, 30);
        add(close);
        close.setEnabled(false);
        closeButtonLister closeButtonLister = new closeButtonLister();
        close.addActionListener(closeButtonLister);
    }

    class openButtonLister implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            ServerFrame.this.serverSwitch.setText("Server has been opened.");
            serverThread.start();
            open.setEnabled(false);
            close.setEnabled(true);
        }
    }

    class closeButtonLister implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            ServerFrame.this.serverSwitch.setText("Please restart the server.");
            open.setEnabled(false);
            close.setEnabled(false);
            server.closeServer();
        }
    }
    class ServerThread implements Runnable {
        public void run() {
            server.creatServer();//服务器运行
        }
    }

    public static void setTextIn(String str) {
        serverText.append('\n'+str);
    }
}