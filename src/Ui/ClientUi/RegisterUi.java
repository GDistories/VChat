package Ui.ClientUi;

import MyFrame.ClientFrame.RegisterFrame;

public class RegisterUi  {
    public static void  createRegister() {
        RegisterFrame registerFrame = new RegisterFrame("Register");
        registerFrame.setSize(380, 290);//设置界面大小
        registerFrame.setLayout(null);//取消布局器
        registerFrame.setLocationRelativeTo(null);//中间显示
        registerFrame.setResizable(false);//窗体大小不可调整
        registerFrame.setDefaultCloseOperation(3);//关闭程序
        registerFrame.setAlwaysOnTop(true);//设置悬浮
        registerFrame.setVisible(true);//显示界面
    }
}
