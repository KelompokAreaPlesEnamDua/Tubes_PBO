/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrol;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo pc
 */
public class set_detailPesanan extends Koneksi
{
    public set_detailPesanan()
    {
        getConnection();
    }
    
    public void simpanData(String id_detail_pesanan, String id_order, String id_kopi, String jumlah, String nama_cust)
    {
        String sql = "INSERT INTO detail_pesanan VALUES ('"+id_detail_pesanan+"','"+id_order+"','"+id_kopi+"','"+jumlah+"','"+nama_cust+"')";
        try {
            stat = konek.createStatement();
            stat.executeUpdate(sql);
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    public void tampilData(DefaultTableModel DTM)
    {
        String sql = "SELECT * FROM detail_pesanan";
        try{
            stat = konek.createStatement();
            RS = stat.executeQuery(sql);
            Object[] data = new Object[5];
            while(RS.next())
            {
                data[0] = RS.getString("id_detail_pesanan");
                data[1] = RS.getString("id_order");
                data[2] = RS.getString("id_kopi");
                data[3] = RS.getString("jumlah");
                data[4] = RS.getString("nama_cust");
                DTM.addRow(data);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    public void updateData(String id_order, String id_kopi, String jumlah, String nama_cust)
    {
        String sql = "UPDATE detail_pesanan SET id_order = '"+id_order+"', id_kopi = '"+id_kopi+"', jumlah = '"+jumlah+"', nama_cust = '"+nama_cust+"'WHERE id_kopi = '"+id_kopi+"'";
        try{
            stat = konek.createStatement();
            stat.executeQuery(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    public void hapusData(String id_detailorder)
    {
        String sql = "DELETE FROM detail_pesanan WHERE id_detail_pesanan = '"+id_detailorder+"'";
        try{
            stat = konek.createStatement();
            stat.executeQuery(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: Gagal");
        }
    }
    
    public ResultSet setComboIdOrder()throws SQLException
    {
        String sql = "SELECT id_order FROM pemesanan";
        stat = konek.createStatement();
        return RS = stat.executeQuery(sql);
    }
    
    public ResultSet setComboIdMakanan() throws SQLException
    {
        String sql = "SELECT id_kopi FROM kopi";
        stat = konek.createStatement();
        return RS = stat.executeQuery(sql);
    }
    
    public ResultSet cariIdOrder(String cari) throws SQLException
    {
        String sql = "SELECT * FROM pemesanan WHERE id_order = '"+cari+"'";
        stat = konek.createStatement();
        return RS = stat.executeQuery(sql);
    }
    
    public ResultSet cariIdKopi(String cari) throws SQLException
    {
        String sql = "SELECT * FROM kopi WHERE id_kopi = '"+cari+"'";
        stat = konek.createStatement();
        return RS = stat.executeQuery(sql);
    }    
}
