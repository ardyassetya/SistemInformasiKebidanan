/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgr;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kebidanan.CheckConnection;
import kebidanan.Kebidanan;
import model.Pasien;

/**
 *
 * @author Ardyas Setya Nugraha
 */
public class PasienManager {
    public static List<Pasien> showAllpasien(){
         List<Pasien> pasienList = new ArrayList<>();
         
         try {
            Connection conn = Kebidanan.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from pasien");
            while (rs.next()){
                Pasien pasien = new Pasien();
                pasien.setNIK(rs.getString("NIK"));
                pasien.setNama_pasien(rs.getString("nama_pasien"));
                pasien.setTempat_lahir(rs.getString("tempat_lahir"));
                pasien.setTgl_lahir(rs.getDate("tgl_lahir"));
                pasien.setAlamat_pasien(rs.getString("alamat_pasien"));
                pasien.setNo_telp(rs.getString("no_telp"));
                pasien.setTgl_positif(rs.getDate("tgl_positif"));
                pasien.setKeluhan(rs.getString("keluhan"));
                pasien.setBpjs(rs.getString("bpjs"));
                pasienList.add(pasien);
            }
         }catch (SQLException ex){
             Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return pasienList;
     }
    
    public static Pasien showPasien(String NIK)throws SQLException{
           Connection conn = Kebidanan.getConnection();
           Pasien pasien = new Pasien();
           PreparedStatement pstmn =conn.prepareStatement("Select * from pasien where NIK =?");
           pstmn.setString(1,NIK);
           ResultSet rs = pstmn.executeQuery();
            while (rs.next()){
                pasien.setNIK(rs.getString("NIK"));
                pasien.setNama_pasien(rs.getString("nama_pasien"));
                pasien.setTempat_lahir(rs.getString("tempat_lahir"));
                pasien.setTgl_lahir(rs.getDate("tgl_lahir"));
                pasien.setAlamat_pasien(rs.getString("alamat_pasien"));
                pasien.setNo_telp(rs.getString("no_telp"));
                pasien.setTgl_positif(rs.getDate("tgl_positif"));
                pasien.setKeluhan(rs.getString("keluhan"));
                pasien.setBpjs(rs.getString("bpjs"));
            }
         return pasien;
     }

    

}
