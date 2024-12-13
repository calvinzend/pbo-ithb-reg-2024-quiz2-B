package Quiz6.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
   private int id;
   private String name, email, password;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }



    public static boolean getData(String email, String pass) {
        String query = "SELECT * FROM USERS WHERE email =  ? and password = ?";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {

            st.setString(1, email);
            st.setString(2, pass);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return true;
                }else{
                    return false;
                }
            }
        }catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
            return false;
        }
    }

    public static User getUser(String email, String pass) {
        String query = "SELECT * FROM USERS WHERE email =  ? and password = ?";
        User user  = null;

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {

            st.setString(1, email);
            st.setString(2, pass);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id")
                    , rs.getString("name"), 
                    rs.getString("email"),
                    rs.getString("password"));
                }
            }
        }catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
        }
        return user;
    }
}
