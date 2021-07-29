/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrol;

/**
 *
 * @author lenovo pc
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Koneksi {
    Statement stat;
    ResultSet RS;
    static Connection konek;
    // koneksi ke database mysql
    public static Connection getConnection()
    {
        try{
            // DriverManager : class untuk mengelola driver
            // Connection : interface untuk menyediakan method untuk 
            // menghubungi database
            konek = DriverManager.getConnection 
            // file database di mysql
            ("jdbc:mysql://localhost:3306/kopi_bae","root","");
            System.out.println("Koneksi Berhasil");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Koneksi Gagal");
            System.exit(0);
            
        }
        return konek;        
    }
}

