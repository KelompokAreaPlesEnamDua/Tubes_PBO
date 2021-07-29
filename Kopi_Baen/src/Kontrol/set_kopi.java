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

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class set_kopi extends Koneksi
{
    
    public set_kopi()
    {
        getConnection();
    }
    
    // simpan data kopi
    public void simpanData(String idKopi, String namaKopi, int harga)
    {
        String sql = "INSERT INTO kopi VALUES('"+idKopi+"','"+namaKopi+"','"+harga+"')";
        try {
            stat = konek.createStatement();
            stat.executeUpdate(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // tampil data
    public void tampilData(DefaultTableModel DTM)
    {
        String sql = "SELECT * FROM kopi";
        try {
            stat = konek.createStatement();
            RS = stat.executeQuery(sql);
            Object[]data = new Object[3];
            while(RS.next())
            {
                data[0] = RS.getString("id_kopi");
                data[1] = RS.getString("nama_kopi");
                data[2] = RS.getString("harga");
                DTM.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // update data
    public void updateData(String idKopi, String namaKopi, int harga)
    {
        String sql = "UPDATE kopi SET nama_kopi = '"+namaKopi+"', harga = '"+harga+"' WHERE id_kopi = '"+idKopi+"'";
        try {
            stat = konek.createStatement();
            stat.executeUpdate(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // hapus data
    public void hapusData(String idKopi)
    {
        String sql = "DELETE FROM kopi WHERE id_kopi = '"+idKopi+"'";
        try {
            stat = konek.createStatement();
            stat.executeUpdate(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    public ResultSet cari(String cari)throws Exception
    {
        String sql = "SELECT * FROM kopi WHERE id_kopi = '"+cari+"'";
        stat = konek.createStatement();
        return RS = stat.executeQuery(sql);
    }
    
    public void caridata(DefaultTableModel DTM, String cari) {
        try {
            String sql = "SELECT * FROM kopi WHERE id_kopi LIKE '%"+cari+"%' OR nama_kopi LIKE '%"+cari+"%' OR harga LIKE '%"+cari+"%'";
            stat = konek.createStatement();
            RS = stat.executeQuery(sql);
            Object [] data = new Object[3];
                while(RS.next()) 
                {
                    data[0] = RS.getString("id_kopi");
                    data[1] = RS.getString("nama_kopi");
                    data[2] = RS.getString("harga");
                    DTM.addRow(data);
                }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
}
