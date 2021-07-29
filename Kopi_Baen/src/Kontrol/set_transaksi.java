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

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class set_transaksi extends Koneksi
{
    public set_transaksi()
    {
        getConnection();
    }
   
    public void tampil(DefaultTableModel DTM, String cari)
    {
        String sql = "SELECT * FROM kopi, detail_pesanan WHERE kopi.id_kopi = detail_pesanan.id_kopi AND detail_pesanan.id_order = '"+cari+"'";
        try {
            stat = konek.createStatement();
            RS = stat.executeQuery(sql);
            Object[]data = new Object[4];
            while(RS.next())
            {
                data[0] = RS.getString("id_order");
                data[1] = RS.getString("id_kopi");
                data[2] = RS.getString("nama_cust");
                data[3] = RS.getString("jumlah");
                DTM.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    // total order
    public ResultSet total (String total) {
        String sql = "SELECT SUM(kopi.harga*detail_pesanan.jumlah) AS total FROM kopi, detail_pesanan WHERE kopi.id_kopi ="
                + " detail_pesanan.id_kopi AND detail_pesanan.id_order = '"+total+"' GROUP BY detail_pesanan.id_order";
        try {
            stat = konek.createStatement();
            RS = stat.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
        return RS;
    }
    
    // simpan data
     public void simpandata(String iduser, String idorder, String nama_cust, String tanggal, int total) {
        String sql = "INSERT INTO transaksi VALUES (null,'"+iduser+"','"+idorder+"','"+nama_cust+"','"+tanggal+"','"+total+"')";
        try {
            stat = konek.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
     
    // tampil data
    public void tampil(String idOrder) throws SQLException {
        String sql = "SELECT id_transaksi FROM transaksi WHERE id_order = '"+idOrder+"'";
        stat = konek.createStatement();
        stat.executeQuery(sql);
        
        
    }
    
    public Boolean cekId(String id_order) throws SQLException
     {
          String sql = "SELECT * FROM transaksi WHERE id_order = '"+id_order+"'";
          stat = konek.createStatement();
          RS = stat.executeQuery(sql);
          return RS.next();
      }
    
}
