package Ui.ServerUi;

import MyFrame.ServerFrame.ServerFrame;

import javax.swing.*;

public class ServerUi {
    public static void creatServer() {
        ServerFrame serverFrame = new ServerFrame("Server");
        serverFrame.setSize(760, 580);
        serverFrame.setLayout(null);
        serverFrame.setLocationRelativeTo(null);//中间显示
        serverFrame.setResizable(false);//窗体大小不可调整
        serverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭程序
        serverFrame.setAlwaysOnTop(true);//设置悬浮
        serverFrame.setVisible(true);//显示界面
    }

    public static void main(String[] args) {
        creatServer();
    }
}