package Ui.ServerUi;

import MyFrame.ServerFrame.ServerFrame;

public class ServerUi {
    public  static void  creatServer(){
        ServerFrame serverFrame = new ServerFrame("服务器");
        serverFrame .setSize(380, 290);
        serverFrame .setLayout(null);
        serverFrame .setLocationRelativeTo(null);//中间显示
        serverFrame .setResizable(false);//窗体大小不可调整
        serverFrame .setDefaultCloseOperation(3);//关闭程序
        serverFrame .setAlwaysOnTop(true);//设置悬浮
        serverFrame .setVisible(true);//显示界面
    }
    public static void main(String[] args) {
        creatServer();
    }
}
