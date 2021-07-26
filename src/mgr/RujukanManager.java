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
import model.Pasien;
import model.Rujukan;

/**
 *
 * @author Ardyas Setya Nugraha
 */
public class RujukanManager {
//    public static List<Rujukan> showAllrujukan(){
//         List<Pasien> rujukanList = new ArrayList<>();
//         
//         try {
//            Connection conn = Kebidanan.getConnection();
//            Statement stmn = conn.createStatement();
//            ResultSet rs = stmn.executeQuery("Select * from rujukan");
//            while (rs.next()){
//                Rujukan rujukan = new Rujukan();
//                Pasien pasien = new Pasien();
//                rujukan.setId_rujukan(rs.getInt("id_rujukan"));
//                pasien.setNIK(rs.getString("NIK"));
//                rujukan.setNama_pasien(rs.getString("nama_pasien"));
//                rujukan.setTempat_lahir(rs.getString("tempat_lahir"));
//                rujukan.setTgl_lahir(rs.getDate("tgl_lahir"));
//                rujukan.setAlamat_pasien(rs.getString("alamat_pasien"));
//                rujukan.setNo_telp(rs.getString("no_telp"));
//                rujukan.setTgl_positif(rs.getDate("tgl_positif"));
//                rujukan.setKeluhan(rs.getString("keluhan"));
//                rujukan.setBpjs(rs.getString("bpjs"));
//                pasienList.add(pasien);
//            }
//         }catch (SQLException ex){
//             Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         return pasienList;
}
