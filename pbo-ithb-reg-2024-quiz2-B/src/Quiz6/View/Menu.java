package Quiz6.View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class Menu extends JFrame{
    private JPanel menu;
    private JButton list;
    public Menu(){
        setSize(400, 200);
        menu = new JPanel(new GridBagLayout());
        list = new JButton("List");
        JButton add = new JButton("add Artwork");
        add(list);
        add(add);

        list.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MenuList();
                    dispose();
                }
            });
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddList();
                   dispose();
                }
            });
        menu.add(list);
        menu.add(add);
        add(menu);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Menu();
    }
}
