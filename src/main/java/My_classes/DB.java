package My_classes;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DB {

    static String dbUrl = "jdbc:mysql://localhost:3306/library_system_management?";
    static String userName = "root";
    static String dbName = "library_system_management";
    static Integer portNumber = 3306;
    static String pass = "";
     
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, userName, pass);

            
            if (connection != null) {
                System.out.println("Connection to the database was successfull!!!");
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return connection; 
    }
}
