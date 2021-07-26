/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebidanan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ardyas Setya Nugraha
 */
public class CheckConnection {
    public static void main(String[] args) {
        isConnected();

        
    }
    private static boolean isConnected(){
        try{
            Kebidanan.getConnection();
            System.out.println("Database Connected");
            return true;
            
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to connect database");
            return false;
        }
    }
 
}

