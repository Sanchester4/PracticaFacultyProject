/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexa
 */
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