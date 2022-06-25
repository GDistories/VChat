package Ui.ClientUi;

import MyFrame.ClientFrame.ChatRoomFrame;

import javax.swing.*;

public class ChatRoomUi  {
    public  static void creatChatRoomUi(){
        ChatRoomFrame chatRoomFrame = new ChatRoomFrame("聊天室");
        chatRoomFrame.setSize(720, 490);
        chatRoomFrame.setLayout(null);
        chatRoomFrame.setLocationRelativeTo(null);//中间显示
        chatRoomFrame.setResizable(false);//窗体大小不可调整
        chatRoomFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭程序
        chatRoomFrame.setAlwaysOnTop(true);//设置悬浮
        chatRoomFrame.setVisible(true);//显示界面
    }
}
