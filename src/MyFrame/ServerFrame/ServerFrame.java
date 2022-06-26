package MyFrame.ServerFrame;
import Socket.Server;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ServerFrame extends JFrame {
    JLabel serverSwitch = new JLabel("Server has been closed.");//Create the label
    JButton open = new JButton("Open");
    JButton close = new JButton("Close");
    static Date date = new Date();//Create the date object
    public static TextArea serverText = new TextArea("Server is Closed.");//Create the text area
    private Thread serverThread = new Thread(new ServerThread());//Create the server group sending thread
    private Server server=new Server();//Create the server object

    public ServerFrame(String title) {
        super(title);
        this.setLayout(null);

        serverText.setBounds(20, 20, 700, 330);//Set the position and size of the text area
        add(serverText);//Add the text area to the frame

        serverThread.setDaemon(true);//Set the server group sending thread as a daemon thread
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
            server.creatServer();//Create the server
        }
    }

    public static void setTextIn(String str) {
        serverText.append('\n'+str);
    }
}