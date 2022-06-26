package Ui.layout;

import javax.swing.*;

public class LoginUiMid extends JPanel {
    private JLabel userName = new JLabel();//Username label
    private JLabel password = new JLabel();//Password label
    private JTextField accountField = new JTextField();//Username text field
    private JPasswordField passwordField = new JPasswordField();//Password text field

    public LoginUiMid() {
        this.setSize(260, 70);
        this.setLayout(null);
        this.setOpaque(false);
        setAccountIcon();//Set the username icon
        setPasswordIcon();//Set the password icon
        setField();//Set the text field
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
