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

    public LoginFrame(String title) {//Draw the frame
        super(title);
        this.setBackground(Color.white);
        loginUiMid.setBounds(120,50,260,70);
        add(loginUiMid);
        loginUiBottom.setBounds(92,140,200,40);
        add(loginUiBottom);
    }
    class LoginUiBottom extends JPanel {//Draw the bottom of the frame
        private JButton loginButton = new JButton("Login");
        private JButton registerButton = new JButton("Register");
        public LoginUiBottom(){
            this.setSize(200, 40);
            //this.setLayout(null);
            this.setOpaque(false);
            loginButton.setBounds(0,0,30,30);//Set the button position
            add(loginButton);//Add the button to the frame
            MyButtonListen myButtonListen=new MyButtonListen();
            loginButton.addActionListener(myButtonListen);

            registerButton.setBounds(60,0,30,30);
            add(registerButton);
            MyButtonListen2 myButtonListen2 =new MyButtonListen2();//Set the button listener
            registerButton.addActionListener(myButtonListen2);//Add the button listener
        }
    }
    class MyButtonListen implements ActionListener//Set the button listener(Login)
    {
        public void actionPerformed(ActionEvent actionEvent) {
            Login();
        }
    }
    class MyButtonListen2 implements ActionListener//Set the button listener(Register)
    {
        public void actionPerformed(ActionEvent actionEvent) {
            Register();
        }
    }
    public  void Login(){//Login
        this.dispose();//Close the frame
        ChatRoomUi.creatChatRoomUi();//Create the chat room frame
    }
    public  void Register(){//Register
        this.dispose();//Close the frame
        RegisterUi.createRegister();//Create the register frame
    }
}

