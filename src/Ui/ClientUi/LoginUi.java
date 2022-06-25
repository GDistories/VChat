package Ui.ClientUi;

import MyFrame.ClientFrame.LoginFrame;

import javax.swing.*;

public class LoginUi {
    public static void createGui() {
        LoginFrame loginframe = new LoginFrame("Login");
        loginframe.setSize(380, 290);//设置界面大小
        loginframe.setLayout(null);//取消布局器
        loginframe.setLocationRelativeTo(null);//中间显示
        loginframe.setResizable(false);//窗体大小不可调整
        loginframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭程序
        loginframe.setAlwaysOnTop(true);//设置悬浮
        loginframe.setVisible(true);//显示界面
    }
    public static void main(String[] args) {
        createGui();
    }
}