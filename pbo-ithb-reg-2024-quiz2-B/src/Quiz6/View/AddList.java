package Quiz6.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Quiz6.Controller.Controller;
import Quiz6.Model.Artworks;
import Quiz6.Model.SingletonManager;

import javax.swing.*;

public class AddList extends JFrame{
    public AddList(){
        super("Add list");
        setSize(400,400);

        JPanel panel = new JPanel(new GridLayout(6,2));

        JLabel title = new JLabel("Title:");
        JTextField titleValue = new JTextField(10);
        JLabel deskripsi = new JLabel("deskripsi:");
        JTextField deskValue = new JTextField(10);
        JLabel image = new JLabel("image:");
        JButton imageButton = new JButton("Image");
        JTextField imageValue= new JTextField(20);
        JFileChooser imgChooser= new JFileChooser();

        JButton submit = new JButton("Submit");

        panel.add(title);
        panel.add(titleValue);
        panel.add(deskripsi);
        panel.add(deskValue);
        panel.add(image);
        panel.add(imageValue);
        panel.add(imageButton);
        panel.add(new JLabel());
        panel.add(submit);
        add(panel);

        imageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int returnValue = imgChooser.showOpenDialog(panel);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        java.io.File selectedFile = imgChooser.getSelectedFile();
                        imageValue.setText(selectedFile.getAbsolutePath());
                        
                        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            
                        Image image = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
                        imageIcon = new ImageIcon(image);
                    }
                }
            });
        submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Controller.addArtwork(new Artworks(0, titleValue.getText(), deskValue.getText(), imageValue.getText(), SingletonManager.getInstance().getUser().getId()));
                    dispose();
                }
            });

        

        setVisible(true);
    }
}
