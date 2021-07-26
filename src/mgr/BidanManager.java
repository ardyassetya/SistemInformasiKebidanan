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
import model.Bidan;

/**
 *
 * @author Ardyas Setya Nugraha
 */
public class BidanManager {
    public static List<Bidan> showAllbidan(){
         List<Bidan> bidanList = new ArrayList<>();
         
         try {
            Connection conn = Kebidanan.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from bidan");
            while (rs.next()){
                Bidan bidan = new Bidan();
                bidan.setSTR(rs.getString("STR"));
                bidan.setNama_bidan(rs.getString("nama_bidan"));
                bidan.setTempatlahir_bdn(rs.getString("tempatlahir_bdn"));
                bidan.setTgllahir_bdn(rs.getDate("tgllahir_bdn"));
                bidan.setAlamat_bdn(rs.getString("alamat_bdn"));
                bidan.setTelp_bdn(rs.getString("telp_bdn"));
                bidan.setEmail_bidan(rs.getString("email_bidan"));
                bidan.setPassword_bidan(rs.getString("password_bidan"));
        
               
                bidanList.add(bidan);
            }
         }catch (SQLException ex){
             Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return bidanList;
     }
}
