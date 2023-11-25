package master;

import javax.swing.JOptionPane;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arilc
 */
public class Koneksi {
    private static Connection koneksi;
    public static Connection getConnection() throws SQLException{
        String hubung="jdbc:mysql://localhost/pbo";   
        if (koneksi==null){
             koneksi=DriverManager.getConnection(hubung,"root","");     
        }
        return koneksi;
    } 

    static void tesConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
