package Ui.ClientUi;

import MyFrame.ClientFrame.LoginFrame;

import javax.swing.*;

public class LoginUi {
    public static void createGui() {
        LoginFrame loginframe = new LoginFrame("Login");
        loginframe.setSize(380, 290);//Set the size of the frame
        loginframe.setLayout(null);//Set the layout of the frame
        loginframe.setLocationRelativeTo(null);//Display in the center
        loginframe.setResizable(false);//The size of the frame can not be changed
        loginframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Close the program
        loginframe.setAlwaysOnTop(true);//Set the frame to float
        loginframe.setVisible(true);//Display the frame
    }
    public static void main(String[] args) {
        createGui();
    }
}