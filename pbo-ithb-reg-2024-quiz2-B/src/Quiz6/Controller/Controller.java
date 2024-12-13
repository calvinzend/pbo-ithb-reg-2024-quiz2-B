package Quiz6.Controller;

import javax.swing.JOptionPane;

import Quiz6.Model.Artworks;
import Quiz6.Model.SingletonManager;
import Quiz6.Model.User;
import Quiz6.View.Login;
import Quiz6.View.Menu;
import Quiz6.View.MenuList;

public class Controller {
    public static void checkLogin(String email, String pass){
        if (User.getData(email, pass)) {
            JOptionPane.showMessageDialog(null, "Login berhasil");
            SingletonManager.getInstance().setUser(User.getUser(email, pass));
            System.out.println(SingletonManager.getInstance().getUser().getName());
            new Menu();
        }else{
            JOptionPane.showMessageDialog(null, "Login gagal");
            new Login();
        }
    }

    public static void addArtwork(Artworks data){
        if (Artworks.addData(data)) {
            JOptionPane.showMessageDialog(null, "berhasil diAdd");
            
        }else{
            JOptionPane.showMessageDialog(null, "Gagal di Add");

        }
        new Menu();
    }
}
