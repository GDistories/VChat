package MyFrame.ServerFrame;
import Socket.Server;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerFrame extends JFrame {
    JLabel serverSwitch = new JLabel("服务器已关闭");
    JButton open = new JButton("开启");
    JButton close = new JButton("关闭");
    private Thread serverThread = new Thread(new ServerThread());//创建服务器群发线程
    private Server server=new Server();//创建服务器对象

    public static void main(String[] args) {
        ServerFrame serverFrame = new ServerFrame("Server");
        serverFrame.setSize(380, 290);
        serverFrame.setLayout(null);
        serverFrame.setLocationRelativeTo(null);//中间显示
        serverFrame.setResizable(false);//窗体大小不可调整
        serverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭程序
        serverFrame.setAlwaysOnTop(true);//设置悬浮
        serverFrame.setVisible(true);//显示界面
    }

    public ServerFrame(String title) {
        super(title);
        this.setLayout(null);
        serverThread.setDaemon(true);//设置为守护线程
        serverSwitch.setBounds(150, 50, 150, 40);
        add(serverSwitch);

        open.setBounds(110, 120, 60, 30);
        add(open);
        openButtonLister openButtonLister = new openButtonLister();
        open.addActionListener(openButtonLister);

        close.setBounds(200, 120, 60, 30);
        add(close);
        close.setEnabled(false);
        closeButtonLister closeButtonLister = new closeButtonLister();
        close.addActionListener(closeButtonLister);
    }

    class openButtonLister implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            ServerFrame.this.serverSwitch.setText("服务器已开启");
            serverThread.start();
            open.setEnabled(false);
            close.setEnabled(true);
            server.closeServer();
        }
    }

    class closeButtonLister implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            ServerFrame.this.serverSwitch.setText("请重启服务器");
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
}