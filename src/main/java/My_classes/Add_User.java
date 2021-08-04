package My_classes;

import My_Forms.Login;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Add_User {

    public Add_User() {
    }

    public void addUser(int ID, String Name, String Email, String Username,String Password) {
        try {
            String sql = "INSERT INTO users"
                    + "(id, name, email, username, password)"
                    + " VALUES (?,?,?,?,?)";
            Connection conn = DB.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ID);
            pst.setString(2, Name);
            pst.setString(3, Email);
            pst.setString(4, Username);
            pst.setString(5, Password);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "ADDED");
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "ENTER VALID DATA! TRY AGAIN!");
        }
    }

}
