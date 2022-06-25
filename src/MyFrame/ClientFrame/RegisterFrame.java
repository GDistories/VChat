package MyFrame.ClientFrame;

import Ui.ClientUi.LoginUi;
import Ui.layout.LoginUiMid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private LoginUiMid registerUiMid = new LoginUiMid();
    private RegisterUiBottom registerUiBottom = new RegisterUiBottom();

    public RegisterFrame(String title) {
        super(title);
        this.setBackground(Color.white);
        registerUiMid.setBounds(120, 50, 260, 70);//绘制标签文本框
        add(registerUiMid);//加入
        registerUiBottom.setBounds(92, 140, 200, 40);//绘制按钮
        add(registerUiBottom);//加入
    }

    class RegisterUiBottom extends JPanel {
        private JButton loginButton = new JButton("Register");//绘制按钮
        private JButton returnButton = new JButton("Back");//绘制按钮

        public RegisterUiBottom() {
            this.setSize(200, 40);
            this.setOpaque(false);
            loginButton.setBounds(0, 0, 30, 30);
            add(loginButton);

            returnButton.setBounds(60, 0, 30, 30);
            add(returnButton);

            ReturnButtonLister returnButtonLister = new ReturnButtonLister();//建立返回按钮监听器对象
            returnButton.addActionListener(returnButtonLister);//绑定监听器
        }
    }

    public void returner() {//返回事件
        RegisterFrame.this.dispose();
        LoginUi.createGui();
    }

    class ReturnButtonLister implements ActionListener {//返回按钮监听器
        public void actionPerformed(ActionEvent actionEvent) {
            returner();
        }
    }
}
