/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package master;

import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
class Koneksi {
    private static Connection koneksi;
    
    public static Connection getConnection() throws SQLException{
        String db = "jdbc:mysql://localhost:3306/pbo";
        String user = "root";
        String pass = "";
        
        if(koneksi == null) {
            koneksi = DriverManager.getConnection(db, user, pass);
        }
        
        return koneksi;
        
    }
    
    public static void tesConnect(){
        try {
            Statement st = (Statement) Koneksi.getConnection().createStatement();
            String query = "select * from login";
            ResultSet rs = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal\n"+e.getMessage());
            System.exit(0);
        }
    }
}
