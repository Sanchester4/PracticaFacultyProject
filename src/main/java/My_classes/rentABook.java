package My_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class rentABook {

    Connection conn, conn2;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public rentABook() {
    }

    public void rentFunction(String sql) throws SQLException, ClassNotFoundException {
        conn = DB.getConnection();
        conn2 = DB.getConnection();
        Statement st1 = conn.createStatement();
        ResultSet rs = st1.executeQuery("SELECT * FROM library WHERE `AUTHOR`='" + sql + "'");
        while (rs.next()) {
            ps = conn2.prepareStatement("insert into rentedBooks values(?,?,?,?,?)");
            ps.setInt(1, rs.getInt("ID"));
            ps.setString(2, rs.getString("BOOK NAME"));
            ps.setString(3, rs.getString("AUTHOR"));
            ps.setInt(4, rs.getInt("YEAR"));
            ps.setString(5, rs.getString("GENRE"));
            ps.executeUpdate();
            int count = rs.getInt(1);
            System.out.println("Number of rows: " + count);
        }

    }

    public void returnBookFunction(String sql) throws SQLException, ClassNotFoundException {
        conn = DB.getConnection();
        conn2 = DB.getConnection();

        Statement st1 = conn.createStatement();
        ResultSet rs = st1.executeQuery("SELECT * FROM `rentedBooks` WHERE `AUTHOR`='" + sql + "'");
        while (rs.next()) {
            ps = conn2.prepareStatement("INSERT INTO `library` values(?,?,?,?,?)");
            ps.setInt(1, rs.getInt("ID"));
            ps.setString(2, rs.getString("BOOK NAME"));
            ps.setString(3, rs.getString("AUTHOR"));
            ps.setInt(4, rs.getInt("YEAR"));
            ps.setString(5, rs.getString("GENRE"));
            ps.executeUpdate();
            System.out.println("Copy succes!");
        }

    }

    public int returnRowTable(String query) throws SQLException, ClassNotFoundException {
        Connection con = null;
        con = DB.getConnection();
        Statement s = con.createStatement();
        int count;
        try (ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM " + query + "")) {
            r.next();
            count = r.getInt("rowcount");
        }
        System.out.println("MyTable has " + count + " row(s).");
        return count;
    }

}
