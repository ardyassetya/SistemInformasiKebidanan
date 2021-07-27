/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kebidanan.CheckConnection;
import kebidanan.Kebidanan;
import model.Bidan;
import model.Pasien;

import model.RujukanMDL;

/**
 *
 * @author Ardyas Setya Nugraha
 */
public class RujukanManager {
    public static List<RujukanMDL> showAllrujukan(){
         List<RujukanMDL> rujukanList = new ArrayList<>();
         
         try {
            Connection conn = Kebidanan.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from rujukan");
            while (rs.next()){
                RujukanMDL rujukan = new RujukanMDL();
                Pasien pasien = new Pasien();
                Bidan bidan = new Bidan();
                rujukan.setId_rujukan(rs.getInt("id_rujukan"));
                pasien.setNIK(rs.getString("NIK"));
                bidan.setSTR(rs.getString("STR"));
                rujukan.setRs_rujukan(rs.getString("rs_rujukan"));
                rujukan.setAlamat_rs(rs.getString("alamat_rs"));
                rujukan.setNama_dokter(rs.getString("nama_dokter"));
                rujukan.setTgl_rujukan(rs.getDate("tgl_rujukan"));
                rujukan.setTindakan(rs.getString("tindakan"));
              
                rujukanList.add(rujukan);
                }
         }catch (SQLException ex){
             Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rujukanList;
}
}
