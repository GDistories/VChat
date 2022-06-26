package Ui.ClientUi;

import MyFrame.ClientFrame.ChatRoomFrame;

import javax.swing.*;

public class ChatRoomUi  {
    public  static void creatChatRoomUi(){
        ChatRoomFrame chatRoomFrame = new ChatRoomFrame("ChatRoom");
        chatRoomFrame.setSize(800, 490);
        chatRoomFrame.setLayout(null);
        chatRoomFrame.setLocationRelativeTo(null);//Display in the center
        chatRoomFrame.setResizable(false);//The size of the frame can not be changed
        chatRoomFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Close the program
        chatRoomFrame.setAlwaysOnTop(true);//Set the frame to float
        chatRoomFrame.setVisible(true);//Display the frame
    }
}
