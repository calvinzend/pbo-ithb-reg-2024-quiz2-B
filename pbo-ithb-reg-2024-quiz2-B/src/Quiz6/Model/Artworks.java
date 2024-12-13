package Quiz6.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Artworks {
    private int id, user_id;
    private String title, deskription, image_path;
    
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Artworks(int id, String title, String deskription, String image_path,int user_id) {
        this.id = id;
        this.title = title;
        this.deskription = deskription;
        this.image_path = image_path;
        this.user_id = user_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDeskription() {
        return deskription;
    }
    public void setDeskription(String deskription) {
        this.deskription = deskription;
    }
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }


    public static  ArrayList<Artworks> getData(int id){
        String query = "SELECT a.* FROM users u  inner join artwork a on a.user_id = u.id where u.id = ?";

        ArrayList<Artworks> data = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {

            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    data.add(new Artworks(rs.getInt("id"), 
                    rs.getString("title"),
                     rs.getString("description"),
                      rs.getString("image_path"),
                      rs.getInt("user_id")));
                }
            }
        }catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
        }
        return data;
    }
    public static boolean addData(Artworks data) {
        String query = "INSERT INTO artwork VALUES(?,?,?,?,?)";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);

            st.setInt(1, data.getId());
            st.setString(2, data.getTitle());
            st.setString(3, data.getDeskription());
            st.setString(4, data.getImage_path());
            st.setInt(5, data.getUser_id());
        
            st.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
