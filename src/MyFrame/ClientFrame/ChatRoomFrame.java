package MyFrame.ClientFrame;

import Socket.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatRoomFrame extends JFrame {
    public static TextArea textOut = new TextArea("Start the Chat Room!");//Output text area
    public static TextArea currentUser = new TextArea("Current User: ");//Output text area
    private JTextArea textIn = new JTextArea();//Input text area
    private JButton sendButton = new JButton("Send");//Send button
    private String sendInformation;
    private Client client;//Client object
    public Socket socket;//Socket object

    public ChatRoomFrame(String title) {
        super(title);
        client = new Client(socket);
        socket = client.socket;
            textOut.setBounds(0, 0, 590, 330);//Set the position of the output text area
        add(textOut);//Add the output text area
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close the program when the close button is clicked

        textIn.setBounds(0, 340, 590, 80);
        add(textIn);//Add the input text area

        sendButton.setBounds(520, 422, 70, 30);
        add(sendButton);//Add the send button
        SendButtonLister sendButtonLister = new SendButtonLister();//Create a SendButtonLister object
        sendButton.addActionListener(sendButtonLister);//Add the listener to the button

        currentUser.setBounds(620, 0, 150, 330);
        add(currentUser);//Add the output text area
    }


    class SendButtonLister implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            sendInformation();
        }
    }

    void sendInformation() {//Send the message to the server
        sendInformation = textIn.getText();
        client.creatInput(sendInformation, socket);
        textIn.setText("");
    }

    public static void setTextIn(String str) {
        textOut.append('\n'+str);
    }

    public static void setCurrentUser(String str) {
        String currentUserStr = "Current User: \n";
        String[] strs = str.split(",");
        for(int i = 1; i < strs.length; i++) {
            currentUserStr += "User " + strs[i] + "\n";
        }
        currentUser.setText(currentUserStr);
    }
}
