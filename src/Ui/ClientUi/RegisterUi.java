package Ui.ClientUi;

import MyFrame.ClientFrame.RegisterFrame;

import javax.swing.*;

public class RegisterUi  {
    public static void  createRegister() {
        RegisterFrame registerFrame = new RegisterFrame("Register");
        registerFrame.setSize(380, 290);//Set the size of the frame
        registerFrame.setLayout(null);//Set the layout of the frame
        registerFrame.setLocationRelativeTo(null);//Display in the center
        registerFrame.setResizable(false);//The size of the frame can not be changed
        registerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Close the program
        registerFrame.setAlwaysOnTop(true);//Set the frame to float
        registerFrame.setVisible(true);//Display the frame
    }
}
