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
import javax.swing.table.DefaultTableModel;

public class set_log extends Koneksi
{
    public set_log()
    {
        getConnection();
    }
    
    public void tampil(DefaultTableModel DTM) throws SQLException 
    {
        String sql = "SELECT `pemesanan`.id_order, `pemesanan`.nm_customer, `pemesanan`.tanggal, user.id_user, user.username, kopi.id_kopi, kopi.nama_kopi, kopi.harga, `pemesanan`.jumlah "
                + "FROM user,`pemesanan`, kopi, detail_pesanan\n" 
                + "WHERE detail_pesanan.id_order = `pemesanan`.id_order AND `pemesanan`.id_user = user.id_user AND detail_pesanan.id_kopi = kopi.id_kopi GROUP BY detail_pesanan.id_order";
        
        stat = konek.createStatement();
        RS = stat.executeQuery(sql);
        Object[] data = new Object[9];
        while(RS.next())
        {
            data[0] = RS.getObject("id_order");
            data[1] = RS.getObject("nm_customer");
            data[2] = RS.getObject("tanggal");
            data[3] = RS.getObject("id_user");
            data[4] = RS.getObject("username");
            data[5] = RS.getObject("id_kopi");
            data[6] = RS.getObject("nama_kopi");
            data[7] = RS.getObject("harga");
            data[8] = RS.getObject("jumlah");
            DTM.addRow(data);       
        }
  }
    
}
