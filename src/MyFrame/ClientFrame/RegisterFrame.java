package MyFrame.ClientFrame;

import Ui.ClientUi.LoginUi;
import Ui.layout.LoginUiMid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private LoginUiMid registerUiMid = new LoginUiMid();
    private RegisterUiBottom registerUiBottom = new RegisterUiBottom();

    public RegisterFrame(String title) {
        super(title);
        this.setBackground(Color.white);
        registerUiMid.setBounds(120, 50, 260, 70);//Set the position and size of the frame
        add(registerUiMid);//Add the frame to the frame
        registerUiBottom.setBounds(92, 140, 200, 40);//Set the position and size of the button
        add(registerUiBottom);//Add the button to the frame
    }

    class RegisterUiBottom extends JPanel {
        private JButton loginButton = new JButton("Register");//Create the button
        private JButton returnButton = new JButton("Back");//Create the button

        public RegisterUiBottom() {
            this.setSize(200, 40);
            this.setOpaque(false);
            loginButton.setBounds(0, 0, 30, 30);
            add(loginButton);

            returnButton.setBounds(60, 0, 30, 30);
            add(returnButton);

            ReturnButtonLister returnButtonLister = new ReturnButtonLister();//Set the button listener
            returnButton.addActionListener(returnButtonLister);//Add the button listener
        }
    }

    public void returner() {//Return
        RegisterFrame.this.dispose();
        LoginUi.createGui();
    }

    class ReturnButtonLister implements ActionListener {//Set the button listener
        public void actionPerformed(ActionEvent actionEvent) {
            returner();
        }
    }
}
