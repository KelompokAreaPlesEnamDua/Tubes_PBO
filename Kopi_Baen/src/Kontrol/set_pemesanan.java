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

public class set_pemesanan extends Koneksi
{
    public set_pemesanan()
    {
        getConnection();
    }
    
    // data order
    public void dataPesanan(String id_order, String tanggal, String jumlah, String namaCust, String idUser)
    {
        try {
            String sql = "INSERT INTO pemesanan VALUES ('"+id_order+"','"+tanggal+"','"+jumlah+"','"+namaCust+"','"+idUser+"')";
            stat = konek.createStatement();
            stat.executeUpdate(sql);
                 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    public void detailPesanan(String id_order, String id_kopi, String jumlah, String namaCust)
    {
        try {
            String sql = "INSERT INTO detail_pesanan VALUES ('"+id_order+"','"+id_kopi+"','"+jumlah+"','"+namaCust+"')";
            System.out.println(sql);
            stat = konek.createStatement();
            stat.executeUpdate(sql);
                 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // tampil data order
    public void tampilData(DefaultTableModel DTM)
    {
        String sql = "SELECT * FROM pemesanan";
        try {
            stat = konek.createStatement();
            RS = stat.executeQuery(sql);
            Object[]data = new Object[5];
            while(RS.next())
            {
                data[0] = RS.getString("id_order");
                data[1] = RS.getString("tanggal");
                data[2] = RS.getString("jumlah");
                data[3] = RS.getString("nm_customer");
                data[4] = RS.getString("id_user");
                DTM.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // update data order
    public void updateData(String id_order, String tanggal, String jumlah, String namaCust, String idUser)
    {
        String sql = "UPDATE pemesanan SET nm_customer = '"+namaCust+"', tanggal = '"+tanggal+"', jumlah = '"+jumlah+"', id_user = '"+idUser+"' WHERE id_order = '"+id_order+"'";
        try {
            stat = konek.createStatement();
            stat.executeUpdate(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // hapus data order
    public void hapusData(String idOrder)
    {
        String sql = "DELETE FROM pemesanan WHERE id_order = "+idOrder+"";
        try {
            stat = konek.createStatement();
            stat.executeUpdate(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // set user
    public ResultSet setCombo() throws SQLException
    {
        String sql = "SELECT posisi FROM user WHERE posisi = 'Admin'";
        stat = konek.createStatement();
        return RS = stat.executeQuery(sql);
    }
    
    public ResultSet setUser(String idUser) throws SQLException
    {
        String sql = "SELECT username FROM user WHERE id_user = '"+idUser+"'";
        stat = konek.createStatement();
        return RS = stat.executeQuery(sql);
    }
    
     public Boolean cekId(String id_order) throws SQLException
     {
          String sql = "SELECT * FROM pemesanan WHERE id_order = '"+id_order+"'";
          stat = konek.createStatement();
          RS = stat.executeQuery(sql);
          return RS.next();
      }
    
    
    
}
