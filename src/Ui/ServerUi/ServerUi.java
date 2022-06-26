package Ui.ServerUi;

import File.FileControl;
import MyFrame.ServerFrame.ServerFrame;

import javax.swing.*;

public class ServerUi {
    public static void creatServer() {
        ServerFrame serverFrame = new ServerFrame("Server");
        serverFrame.setSize(760, 580);
        serverFrame.setLayout(null);
        serverFrame.setLocationRelativeTo(null);//Display in the center
        serverFrame.setResizable(false);//The size of the frame can not be changed
        serverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Close the program
        serverFrame.setAlwaysOnTop(true);//Set the frame to float
        serverFrame.setVisible(true);//Display the frame
    }

    public static void main(String[] args) {
        creatServer();
    }
}