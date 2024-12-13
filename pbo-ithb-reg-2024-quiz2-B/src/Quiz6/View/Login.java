package Quiz6.View;

import java.awt.GridBagLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Quiz6.Controller.Controller;


public class Login extends JFrame{
    private JLabel email,password;
    private JTextField emailValue;
    private JPasswordField passValue;
    private JButton login;

    public Login(){
        super("LOGIN");
        setSize(400,400);

        JPanel frame = new JPanel(new GridBagLayout());

        email = new JLabel("Email :");
        emailValue = new JTextField(10);

        password = new JLabel("Password :");
        passValue = new JPasswordField(10);

        login = new JButton("Login");

        frame.add(email);
        frame.add(emailValue);
        frame.add(password);
        frame.add(passValue);
        frame.add(login);
        add(frame);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Controller.checkLogin(emailValue.getText(), new String(passValue.getPassword()));
               dispose();
            }
        });


        setVisible(true);
    }

}
