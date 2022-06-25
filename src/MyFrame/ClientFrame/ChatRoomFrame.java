package MyFrame.ClientFrame;

import Socket.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class ChatRoomFrame extends JFrame {
    public static TextArea textOut = new TextArea("Start the Chat Room!");//输出聊天框
    private JTextArea textIn = new JTextArea();//输入文本框
    private JButton sendButton = new JButton("Send");//发送按钮
    private String sendInformation;
    private Client client;//创建客户类
    public Socket socket;//创建套接字

    public ChatRoomFrame(String title) {
        super(title);
        client = new Client(socket);
        socket = client.socket;
        textOut.setBounds(0, 0, 590, 330);//设置输出框位置
        add(textOut);//添加聊天框
        //textOut.setEnabled(false);//不可编辑
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口全部关闭

        textIn.setBounds(0, 340, 590, 80);
        add(textIn);//添加输入文本框

        sendButton.setBounds(520, 422, 70, 30);
        add(sendButton);//添加发送按钮
        SendButtonLister sendButtonLister = new SendButtonLister();//创建发送监听器
        sendButton.addActionListener(sendButtonLister);//绑定监听器

    }


    class SendButtonLister implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            sendInformation();
        }
    }

    void sendInformation() {//发送消息
        sendInformation = textIn.getText();
        client.creatInput(sendInformation, socket);
        textIn.setText("");
    }

    public static void setTextIn(String str) {
        textOut.append('\n'+str);
    }
}
