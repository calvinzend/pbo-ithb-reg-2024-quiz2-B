package Quiz6.View;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import Quiz6.Controller.Controller;
import Quiz6.Model.Artworks;
import Quiz6.Model.SingletonManager;

public class MenuList extends JFrame{
    public MenuList(){
        super("Menu list");
        setSize(400,400);
        JPanel list = new JPanel(new GridLayout(20,1));

        ArrayList<Artworks> seni = Artworks.getData(SingletonManager.getInstance().getUser().getId());
        JButton add = new JButton("add Artwork");
        JLabel judul = new JLabel("ARTWORKS MENU LIST");
        list.add(add);
        list.add(judul);


        for (Artworks seniKarya : seni) {
            JLabel title = new JLabel("Title :"+seniKarya.getTitle());
            JLabel artistName = new JLabel(" artistName :"+SingletonManager.getInstance().getUser().getName());
            JLabel desk = new JLabel("deskripsi  :"+seniKarya.getDeskription());

            ImageIcon logoIcon = new ImageIcon(seniKarya.getImage_path());
            Image scaledImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            logoIcon = new ImageIcon(scaledImage);
            JLabel logoLabel = new JLabel(logoIcon);

            list.add(title);
            list.add(artistName);
            list.add(desk);
            list.add(logoLabel);

        }
        
        add(list);

         add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddList();
               dispose();
            }
        });
        setVisible(true);
    }
}
