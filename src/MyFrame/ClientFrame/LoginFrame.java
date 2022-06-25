package MyFrame.ClientFrame;

import Ui.ClientUi.ChatRoomUi;
import Ui.ClientUi.RegisterUi;
import Ui.layout.LoginUiMid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private LoginUiMid loginUiMid = new LoginUiMid();
    private LoginUiBottom loginUiBottom =new LoginUiBottom();

    public LoginFrame(String title) {//绘制标签和输入框
        super(title);
        this.setBackground(Color.white);
        loginUiMid.setBounds(120,50,260,70);
        add(loginUiMid);
        loginUiBottom.setBounds(92,140,200,40);
        add(loginUiBottom);
    }
    class LoginUiBottom extends JPanel {//绘制按钮
        private JButton loginButton = new JButton("Login");
        private JButton registerButton = new JButton("Register");
        public LoginUiBottom(){
            this.setSize(200, 40);
            //this.setLayout(null);
            this.setOpaque(false);
            loginButton.setBounds(0,0,30,30);//按钮位置设置
            add(loginButton);//将按钮加入
            MyButtonListen myButtonListen=new MyButtonListen();
            loginButton.addActionListener(myButtonListen);

            registerButton.setBounds(60,0,30,30);
            add(registerButton);
            MyButtonListen2 myButtonListen2 =new MyButtonListen2();//建立按钮监听器对象
            registerButton.addActionListener(myButtonListen2);//绑定监听器
        }
    }
    class MyButtonListen implements ActionListener//按钮监听器（登录）
    {
        public void actionPerformed(ActionEvent actionEvent) {
            Login();
        }
    }
    class MyButtonListen2 implements ActionListener//按钮监听器（注册）
    {
        public void actionPerformed(ActionEvent actionEvent) {
            Register();
        }
    }
    public  void Login(){//登录事件
        this.dispose();//关闭当前窗口
        ChatRoomUi.creatChatRoomUi();//打开聊天室窗口
    }
    public  void Register(){//注册事件
        this.dispose();//关闭当前窗口
        RegisterUi.createRegister();//打开注册窗口
    }
}

