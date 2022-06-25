package Ui.layout;

import javax.swing.*;

public class LoginUiMid extends JPanel {
    private JLabel userName = new JLabel();//账号图标
    private JLabel password = new JLabel();//密码图标
    private JTextField accountField = new JTextField();//账号框
    private JPasswordField passwordField = new JPasswordField();//密码框

    public LoginUiMid() {
        this.setSize(260, 70);
        this.setLayout(null);
        this.setOpaque(false);
        setAccountIcon();//设置账户图标
        setPasswordIcon();//设置密码图标
        setField();//设置文本框
    }

    void setAccountIcon(){
        ImageIcon accountIcon = new ImageIcon("images/chat/login.png");
        userName.setIcon(accountIcon);
        userName.setBounds(0, 0, 32, 32);
        this.add(userName);
    }

    void setPasswordIcon(){
        ImageIcon passwordIcon = new ImageIcon("images/chat/password.png");
        password.setIcon(passwordIcon);
        password.setBounds(0, 35, 32, 32);
        this.add(password);
    }

    void setField(){
        accountField.setBounds(35, 0, 100, 30);
        add(accountField);
        passwordField.setBounds(35, 35, 100, 30);
        add(passwordField);
    }
}
