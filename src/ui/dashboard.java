/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kebidanan.Kebidanan;
import mgr.PasienManager;
import model.Pasien;
import java.sql.ResultSet;
import java.util.Calendar;
import kebidanan.CheckConnection;
import mgr.BidanManager;

/**
 *
 * @author Ardyas Setya Nugraha
 */
public class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    PreparedStatement pst = null;
    ResultSet rs = null;
    CardLayout cardLayout;
    int pasienID =0;
    int bidanID =0;
    
    public dashboard() {
        initComponents();
        cardLayout =(CardLayout)(crdpanel.getLayout());
        hitungpasien();
        hitungMelahirkan();
        initTableDashboard();
      
    }
   
 
    public static DefaultTableModel tableModel;
    public static DefaultTableModel tableModel2;
    public static DefaultTableModel tableModel1;
    public static List<model.Pasien> ListPasien;
    
    public static List<model.Bidan> ListBidan;
    
    
    //code dashboard
    private void initTableDashboard(){
        String[] tableColumns = new String []{"Nama Lengkap", "Alamat"};
    
        int[] columnWidth = {
           270,200
        };

        tableModel1 = new DefaultTableModel(tableColumns,0);
        tableDashboard.setModel (tableModel1);
        tableDashboard.setRowHeight(30);

        int i =0;
        for (int width : columnWidth ){
            TableColumn column = tableDashboard.getColumnModel().getColumn(i++);
            column.setMaxWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
            }
    } 
     public static void loadDashboard(){
        ListPasien = new ArrayList<>();
        ListPasien = PasienManager.showAllpasien();
        tableModel1.setRowCount(0);
        ListPasien.forEach((var Pasien) -> {
                tableModel1.addRow(new Object[]{
                   
                    Pasien.getNama_pasien(),
                   
                    Pasien.getAlamat_pasien(), 
                    
               });
        });
       
    }
     private void hitungpasien() {
        try {
            Connection con = Kebidanan.getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT count(NIK) as jumlah from pasien";

            rs = stm.executeQuery(sql);
            while (rs.next()) {
                jumlahpasien.setText(rs.getString("jumlah"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     private void hitungMelahirkan() {
        try {
            Connection con = Kebidanan.getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT count(NIK) as jumlah from pasien WHERE keluhan='melahirkan'";

            rs = stm.executeQuery(sql);
            while (rs.next()) {
                melahirkantxt.setText(rs.getString("jumlah"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     
     
 // coding pasien   
    private void initTablePasien(){
        String[] tableColumns = new String []{"NIK", "Nama Lengkap", "Tempat Lahir", 
            "Tanggel Lahir","Alamat","No.Telp","Tanggal Positif","Keterangan","No. BPJS"};
    
        int[] columnWidth = {
            180,270,200,200,200,200,200,200,200
        };

        tableModel = new DefaultTableModel(tableColumns,0);
        tablePasien.setModel (tableModel);
        tablePasien.setRowHeight(30);

        int i =0;
        for (int width : columnWidth ){
            TableColumn column = tablePasien.getColumnModel().getColumn(i++);
            column.setMaxWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
            }
    }
     
      public void showMessage(String message, int type) {
        if (type == 1) {
            JOptionPane.showMessageDialog(this, message, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
     }
     
      public static Date getTanggalFromtable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(),kolom));
        Date tanggal = null;
        try{
            tanggal = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }catch(ParseException ex){
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tanggal;
    }

       public static void loadPasien(){
        ListPasien = new ArrayList<>();
        ListPasien = PasienManager.showAllpasien();
        tableModel.setRowCount(0);
        ListPasien.forEach((var Pasien) -> {
                tableModel.addRow(new Object[]{
                    Pasien.getNIK(),
                    Pasien.getNama_pasien(),
                    Pasien.getTempat_lahir(),
                    Pasien.getTgl_lahir(), 
                    Pasien.getAlamat_pasien(), 
                    Pasien.getNo_telp(), 
                    Pasien.getTgl_positif(), 
                    Pasien.getKeluhan(), 
                    Pasien.getBpjs(), 
               });
        });
       
    }
     
      void tambahPasien() {
        try {
            Connection conn = Kebidanan.getConnection();
            Statement stm = conn.createStatement();
          //  SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
            String tgllahir = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
            String tglpositif = ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
            String query = "INSERT INTO `pasien` (`NIK`,`nama_pasien`,`tempat_lahir`,`tgl_lahir`,`alamat_pasien`,`no_telp`,`tgl_positif`,`keluhan`,`bpjs`) "
                    + "VALUES ('" + niktf.getText() 
                    + "', '" + namapasientf.getText() 
                    + "', '" + tempatlahirtf.getText() 
                    + "', '" + tgllahir
                    + "', '" + alamattf.getText() 
                    + "', '" + notlptf.getText() 
                    + "', '" + tglpositif
                    + "', '" + keluhantf.getText() 
                    + "', '" + bpjstf.getText() 
                    + "');";

           
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data sudah di tambah ", "infomasi", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "infomasi", JOptionPane.INFORMATION_MESSAGE);
        }    
    }

  void updatePasien(int id) {
     
      try {
            Connection conn = Kebidanan.getConnection();
            Statement stm = conn.createStatement();
         
            String query = "UPDATE Pasien SET NIK = '" + niktf.getText() + "',"
                    +"nama_pasien = '" + namapasientf.getText() + "',"
                    +"tempat_lahir = '" + tempatlahirtf.getText() + "',"
                    +"tgl_lahir = '" + jDateChooser1.getDate() + "',"
                    +"alamat_pasien = '" + alamattf.getText() + "',"
                    +"no_telp = '" + notlptf.getText() + "',"
                    +"tgl_positif = '" + jDateChooser2.getDate() + "',"
                    +"keluhan = '" + keluhantf.getText() + "',"
                    + "bpjs = '" + bpjstf.getText() + "' WHERE NIK = " + id + " ";

            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data sudah di update ", "infomasi", JOptionPane.INFORMATION_MESSAGE);

         
          

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data tidak terupdate" + e.getMessage(), "infomasi", JOptionPane.INFORMATION_MESSAGE);
        }
      
  }
  
  private void setPasienToComponent(String NIK) throws SQLException{
        Pasien pasien= PasienManager.showPasien(NIK);
        pasien.setNIK(NIK);
        namapasientf.setText(pasien.getNama_pasien());
        tempatlahirtf.setText(pasien.getTempat_lahir());
        jDateChooser1.setDate(pasien.getTgl_lahir());
        alamattf.setText(pasien.getAlamat_pasien());
        notlptf.setText(pasien.getNo_telp());
        jDateChooser2.setDate(pasien.getTgl_positif());
        keluhantf.setText(pasien.getKeluhan());
        bpjstf.setText(pasien.getBpjs());
                   
    }
  
  private boolean validateInput() throws SQLException{
//        String tgllahir = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
//        String tglpositif = ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();   
      boolean isComplete = false;
         Pasien pasien = new Pasien();
         if (niktf.getText().isEmpty()){
             isComplete=false;
             niktf.requestFocus();
         }else {
             pasien.setNIK(niktf.getText());
             isComplete = true;
        
             pasien.setNama_pasien(namapasientf.getText());
             isComplete = true;
       
             pasien.setTempat_lahir(tempatlahirtf.getText());
             isComplete = true;
 
             pasien.setTgl_lahir(jDateChooser1.getDate());
             isComplete = true;
   
             pasien.setAlamat_pasien(alamattf.getText());
             isComplete = true;
  
             pasien.setNo_telp(notlptf.getText());
             isComplete = true;
       
             pasien.setTgl_positif(jDateChooser2.getDate());
             isComplete = true;
       
             pasien.setKeluhan(keluhantf.getText());
             isComplete = true;
        
             pasien.setBpjs(bpjstf.getText());
             isComplete = true;
         }
         
           if(!isComplete){
            showMessage("data harus dilengkapi!",2);
            return false;
        }else{
            cardLayout.show(crdpanel, "Ppanel");
            return true;
        }
     }
  
  
  
  
  
  // data bidan
  private void initTableBidan(){
        String[] tableColumnss = new String []{"STR", "Nama Lengkap", "Tempat Lahir", 
            "Tanggal Lahir","Alamat","No.Telp","Email","Password"};
    
        int[] columnWidth = {
            180,270,200,200,200,200,200,200
        };

        tableModel2 = new DefaultTableModel(tableColumnss,0);
        tableBidan.setModel (tableModel2);
        tableBidan.setRowHeight(30);

        int i =0;
        for (int width : columnWidth ){
            TableColumn column = tableBidan.getColumnModel().getColumn(i++);
            column.setMaxWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
            }
    }
  
    public static void loadBidan(){
        ListBidan = new ArrayList<>();
        ListBidan = BidanManager.showAllbidan();
        tableModel2.setRowCount(0);
        ListBidan.forEach((var Bidan) -> {
                tableModel2.addRow(new Object[]{
                    Bidan.getSTR(),
                    Bidan.getNama_bidan(),
                    Bidan.getTempatlahir_bdn(),
                    Bidan.getTgllahir_bdn(), 
                    Bidan.getAlamat_bdn(), 
                    Bidan.getTelp_bdn(), 
                    Bidan.getEmail_bidan(), 
                    Bidan.getPassword_bidan(), 
                 
               });
        });
    }
     
      void tambahBidan() {
        try {
            Connection conn = Kebidanan.getConnection();
            Statement stm = conn.createStatement();
            //SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
            String tgllahirbidan = ((JTextField)tglbidan.getDateEditor().getUiComponent()).getText();
            String query = "INSERT INTO `bidan` (`STR`,`nama_bidan`,`tempatlahir_bdn`,`tgllahir_bdn`,`alamat_bdn`,`telp_bdn`,`email_bidan`,`password_bidan`) "
                    + "VALUES ('" + strtf.getText() 
                    + "', '" + namabidantf.getText() 
                    + "', '" + tempatlahirbidan.getText() 
                    + "', '" + tgllahirbidan
                    + "', '" + alamatbidan.getText() 
                    + "', '" + notlpbidan.getText()
                    + "', '" + emailbidan.getText() 
                    + "', '" + passbidan.getText() 
                    + "');";

           
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data sudah di tambah ", "infomasi", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "infomasi", JOptionPane.INFORMATION_MESSAGE);
        }    
    }

//  void updateBidan(int id) {
//        try {
//            Connection conn = Kebidanan.getConnection();
//            Statement stm = conn.createStatement();
//         
//            String query = "UPDATE Pasien SET NIK = '" + niktf.getText() + "',"
//                    +"nama_pasien = '" + namapasientf.getText() + "',"
//                    +"tempat_lahir = '" + tempatlahirtf.getText() + "',"
//                    +"tgl_lahir = '" + jDateChooser1.getDate() + "',"
//                    +"alamat_pasien = '" + alamattf.getText() + "',"
//                    +"no_telp = '" + notlptf.getText() + "',"
//                    +"tgl_positif = '" + jDateChooser2.getDate() + "',"
//                    +"keluhan = '" + keluhantf.getText() + "',"
//                    + "bpjs = '" + bpjstf.getText() + "' WHERE NIK = " + id + " ";
//
//            stm.executeUpdate(query);
//            JOptionPane.showMessageDialog(null, "Data sudah di update ", "infomasi", JOptionPane.INFORMATION_MESSAGE);
//
//        }}
  
      
      
      
      
      
   public void hitunglahir() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    int tambah = 270;
    int tambah2 = 290;
    java.util.Date tgl = jDateChooser2.getDate();
    Calendar calTambah = Calendar.getInstance();
    Calendar calTambah2 = Calendar.getInstance();

    calTambah.setTime(tgl);
    calTambah2.setTime(tgl);
    calTambah.add(Calendar.DAY_OF_MONTH, tambah);
    calTambah2.add(Calendar.DAY_OF_MONTH, tambah2);

    estimasi.setText(sdf.format(calTambah.getTime()));
    estimasi2.setText(sdf.format(calTambah2.getTime()));

        }
   
    
   
   
  
   
   void clearpasien(){
        niktf.setText(null); 
        namapasientf.setText(null); 
        tempatlahirtf.setText(null); 
        jDateChooser1.setDate(null);
        alamattf.setText(null); 
        notlptf.setText(null); 
        jDateChooser2.setDate(null);       
        keluhantf.setText(null); 
        bpjstf.setText(null); 
    

   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        menupanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Dbtn = new com.k33ptoo.components.KButton();
        Pbtn = new com.k33ptoo.components.KButton();
        Kbtn = new com.k33ptoo.components.KButton();
        Bbtn = new com.k33ptoo.components.KButton();
        jLabel22 = new javax.swing.JLabel();
        crdpanel = new javax.swing.JPanel();
        Dpanel = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        textbidan7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDashboard = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        melahirkantxt = new javax.swing.JLabel();
        textbidan4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jumlahpasien = new javax.swing.JLabel();
        textbidan = new javax.swing.JLabel();
        namabidan = new javax.swing.JLabel();
        Ppanel = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePasien = new javax.swing.JTable();
        tambahbtn = new com.k33ptoo.components.KButton();
        updatebtn = new com.k33ptoo.components.KButton();
        hapusbtn = new com.k33ptoo.components.KButton();
        Kpanel = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        Bpanel = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        strtf = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        namabidantf = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tempatlahirbidan = new javax.swing.JTextField();
        tglbidan = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        alamatbidan = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        notlpbidan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        emailbidan = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        passbidan = new javax.swing.JTextField();
        tambahbtn4 = new com.k33ptoo.components.KButton();
        tambahbtn5 = new com.k33ptoo.components.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBidan = new javax.swing.JTable();
        tambahpasien = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        niktf = new javax.swing.JTextField();
        namapasientf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tempatlahirtf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        alamattf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        notlptf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        bpjstf = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        tambahbtn1 = new com.k33ptoo.components.KButton();
        tambahbtn2 = new com.k33ptoo.components.KButton();
        keluhantf = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        estimasi = new javax.swing.JLabel();
        estimasi2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        tambahbtn3 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 600));

        menupanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(46, 196, 182));
        jLabel3.setText("SISTEM INFORMASI ");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(46, 196, 182));
        jLabel5.setText("KEBIDANAN");

        Dbtn.setText("Dashboard");
        Dbtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Dbtn.setkBorderRadius(20);
        Dbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        Dbtn.setkForeGround(new java.awt.Color(46, 196, 182));
        Dbtn.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        Dbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Dbtn.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        Dbtn.setkSelectedColor(new java.awt.Color(46, 196, 182));
        Dbtn.setkStartColor(new java.awt.Color(255, 255, 255));
        Dbtn.setName(""); // NOI18N
        Dbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DbtnActionPerformed(evt);
            }
        });

        Pbtn.setText("Data Pasien");
        Pbtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Pbtn.setkBorderRadius(20);
        Pbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        Pbtn.setkForeGround(new java.awt.Color(46, 196, 182));
        Pbtn.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        Pbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Pbtn.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        Pbtn.setkSelectedColor(new java.awt.Color(46, 196, 182));
        Pbtn.setkStartColor(new java.awt.Color(255, 255, 255));
        Pbtn.setName(""); // NOI18N
        Pbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PbtnActionPerformed(evt);
            }
        });

        Kbtn.setText("Rujukan");
        Kbtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Kbtn.setkBorderRadius(20);
        Kbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        Kbtn.setkForeGround(new java.awt.Color(46, 196, 182));
        Kbtn.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        Kbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Kbtn.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        Kbtn.setkSelectedColor(new java.awt.Color(46, 196, 182));
        Kbtn.setkStartColor(new java.awt.Color(255, 255, 255));
        Kbtn.setName(""); // NOI18N
        Kbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KbtnActionPerformed(evt);
            }
        });

        Bbtn.setText("Data bidan");
        Bbtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Bbtn.setkBorderRadius(20);
        Bbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        Bbtn.setkForeGround(new java.awt.Color(46, 196, 182));
        Bbtn.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        Bbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Bbtn.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        Bbtn.setkSelectedColor(new java.awt.Color(46, 196, 182));
        Bbtn.setkStartColor(new java.awt.Color(255, 255, 255));
        Bbtn.setName(""); // NOI18N
        Bbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BbtnActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(46, 196, 182));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/150x150.png"))); // NOI18N

        javax.swing.GroupLayout menupanelLayout = new javax.swing.GroupLayout(menupanel);
        menupanel.setLayout(menupanelLayout);
        menupanelLayout.setHorizontalGroup(
            menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menupanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(Dbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(36, 36, 36))
        );
        menupanelLayout.setVerticalGroup(
            menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menupanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addComponent(Dbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Pbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Kbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(Bbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jSplitPane1.setLeftComponent(menupanel);

        crdpanel.setLayout(new java.awt.CardLayout());

        Dpanel.setkEndColor(new java.awt.Color(46, 196, 182));
        Dpanel.setkStartColor(new java.awt.Color(203, 243, 240));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel2.setText("Apa Kabar, Ibu.");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 200));

        textbidan7.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan7.setText("Daftar Pasien");

        tableDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(tableDashboard);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textbidan7))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textbidan7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 200));

        jPanel5.setBackground(new java.awt.Color(203, 243, 240));

        melahirkantxt.setFont(new java.awt.Font("Roboto Medium", 0, 64)); // NOI18N
        melahirkantxt.setText("4");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(melahirkantxt)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(melahirkantxt)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        textbidan4.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan4.setText("Melahirkan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textbidan4))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textbidan4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 200));

        jPanel3.setBackground(new java.awt.Color(203, 243, 240));

        jumlahpasien.setFont(new java.awt.Font("Roboto Medium", 0, 64)); // NOI18N
        jumlahpasien.setText("4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jumlahpasien)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jumlahpasien)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        textbidan.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan.setText("Pasien");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textbidan))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textbidan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        namabidan.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N

        javax.swing.GroupLayout DpanelLayout = new javax.swing.GroupLayout(Dpanel);
        Dpanel.setLayout(DpanelLayout);
        DpanelLayout.setHorizontalGroup(
            DpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(DpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namabidan)
                    .addGroup(DpanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(DpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        DpanelLayout.setVerticalGroup(
            DpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(namabidan)
                .addGap(18, 18, 18)
                .addGroup(DpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DpanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        crdpanel.add(Dpanel, "Dpanel");

        Ppanel.setkEndColor(new java.awt.Color(46, 196, 182));
        Ppanel.setkStartColor(new java.awt.Color(203, 243, 240));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setText("Data Diri Pasien");

        jScrollPane1.setBackground(new java.awt.Color(46, 196, 182));

        tablePasien.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tablePasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tablePasien.setSelectionBackground(new java.awt.Color(46, 196, 182));
        jScrollPane1.setViewportView(tablePasien);

        tambahbtn.setText("Tambah");
        tambahbtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tambahbtn.setkBorderRadius(20);
        tambahbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        tambahbtn.setkForeGround(new java.awt.Color(46, 196, 182));
        tambahbtn.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        tambahbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambahbtn.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        tambahbtn.setkSelectedColor(new java.awt.Color(46, 196, 182));
        tambahbtn.setkStartColor(new java.awt.Color(255, 255, 255));
        tambahbtn.setName(""); // NOI18N
        tambahbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtnActionPerformed(evt);
            }
        });

        updatebtn.setText("Update");
        updatebtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        updatebtn.setkBorderRadius(20);
        updatebtn.setkEndColor(new java.awt.Color(255, 255, 255));
        updatebtn.setkForeGround(new java.awt.Color(46, 196, 182));
        updatebtn.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        updatebtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        updatebtn.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        updatebtn.setkSelectedColor(new java.awt.Color(46, 196, 182));
        updatebtn.setkStartColor(new java.awt.Color(255, 255, 255));
        updatebtn.setName(""); // NOI18N
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        hapusbtn.setText("Hapus");
        hapusbtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        hapusbtn.setkBorderRadius(20);
        hapusbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        hapusbtn.setkForeGround(new java.awt.Color(46, 196, 182));
        hapusbtn.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        hapusbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        hapusbtn.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        hapusbtn.setkSelectedColor(new java.awt.Color(46, 196, 182));
        hapusbtn.setkStartColor(new java.awt.Color(255, 255, 255));
        hapusbtn.setName(""); // NOI18N
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PpanelLayout = new javax.swing.GroupLayout(Ppanel);
        Ppanel.setLayout(PpanelLayout);
        PpanelLayout.setHorizontalGroup(
            PpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PpanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PpanelLayout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(hapusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tambahbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        PpanelLayout.setVerticalGroup(
            PpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PpanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(PpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        crdpanel.add(Ppanel, "Ppanel");

        Kpanel.setkEndColor(new java.awt.Color(46, 196, 182));
        Kpanel.setkStartColor(new java.awt.Color(203, 243, 240));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel4.setText("Data Diri Pasien");

        javax.swing.GroupLayout KpanelLayout = new javax.swing.GroupLayout(Kpanel);
        Kpanel.setLayout(KpanelLayout);
        KpanelLayout.setHorizontalGroup(
            KpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KpanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addContainerGap(731, Short.MAX_VALUE))
        );
        KpanelLayout.setVerticalGroup(
            KpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KpanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addContainerGap(602, Short.MAX_VALUE))
        );

        crdpanel.add(Kpanel, "Kpanel");

        Bpanel.setkEndColor(new java.awt.Color(46, 196, 182));
        Bpanel.setkStartColor(new java.awt.Color(203, 243, 240));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel6.setText("Data Diri Bidan");

        strtf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel18.setText("STR");

        namabidantf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel19.setText("Nama Pasien");

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel23.setText("Tempat Lahir");

        tempatlahirbidan.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tempatlahirbidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempatlahirbidanActionPerformed(evt);
            }
        });

        tglbidan.setDateFormatString("yyyy-MM-dd");

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel24.setText("Tanggal Lahir");

        alamatbidan.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        alamatbidan.setMinimumSize(new java.awt.Dimension(7, 15));
        alamatbidan.setPreferredSize(new java.awt.Dimension(7, 15));

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel25.setText("Alamat");

        notlpbidan.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel26.setText("No Telephone");

        emailbidan.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel27.setText("Email");

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel28.setText("Password");

        passbidan.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        passbidan.setMinimumSize(new java.awt.Dimension(7, 15));
        passbidan.setPreferredSize(new java.awt.Dimension(7, 15));

        tambahbtn4.setText("Hapus");
        tambahbtn4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tambahbtn4.setkBorderRadius(20);
        tambahbtn4.setkEndColor(new java.awt.Color(255, 255, 255));
        tambahbtn4.setkForeGround(new java.awt.Color(46, 196, 182));
        tambahbtn4.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        tambahbtn4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambahbtn4.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        tambahbtn4.setkSelectedColor(new java.awt.Color(46, 196, 182));
        tambahbtn4.setkStartColor(new java.awt.Color(255, 255, 255));
        tambahbtn4.setName(""); // NOI18N
        tambahbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtn4ActionPerformed(evt);
            }
        });

        tambahbtn5.setText("Tambah");
        tambahbtn5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tambahbtn5.setkBorderRadius(20);
        tambahbtn5.setkEndColor(new java.awt.Color(255, 255, 255));
        tambahbtn5.setkForeGround(new java.awt.Color(46, 196, 182));
        tambahbtn5.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        tambahbtn5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambahbtn5.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        tambahbtn5.setkSelectedColor(new java.awt.Color(46, 196, 182));
        tambahbtn5.setkStartColor(new java.awt.Color(255, 255, 255));
        tambahbtn5.setName(""); // NOI18N
        tambahbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtn5ActionPerformed(evt);
            }
        });

        tableBidan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableBidan);

        javax.swing.GroupLayout BpanelLayout = new javax.swing.GroupLayout(Bpanel);
        Bpanel.setLayout(BpanelLayout);
        BpanelLayout.setHorizontalGroup(
            BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BpanelLayout.createSequentialGroup()
                .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BpanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6))
                    .addGroup(BpanelLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BpanelLayout.createSequentialGroup()
                                .addComponent(tambahbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tambahbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(BpanelLayout.createSequentialGroup()
                                    .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(BpanelLayout.createSequentialGroup()
                                            .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tempatlahirbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel23))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel24)
                                                .addComponent(tglbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel26)
                                        .addComponent(notlpbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27)
                                        .addComponent(emailbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(alamatbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel28)))
                                .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addComponent(strtf)
                                    .addComponent(namabidantf, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        BpanelLayout.setVerticalGroup(
            BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BpanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strtf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BpanelLayout.createSequentialGroup()
                        .addComponent(namabidantf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(BpanelLayout.createSequentialGroup()
                                .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tglbidan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tempatlahirbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notlpbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BpanelLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alamatbidan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(passbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(BpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        crdpanel.add(Bpanel, "Bpanel");

        tambahpasien.setkEndColor(new java.awt.Color(46, 196, 182));
        tambahpasien.setkStartColor(new java.awt.Color(203, 243, 240));

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setText("Data Diri Pasien");

        niktf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        namapasientf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setText("NIK");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setText("Nama Pasien");

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel11.setText("Tempat Lahir");

        tempatlahirtf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tempatlahirtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempatlahirtfActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setText("Alamat");

        alamattf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel13.setText("No Telephone");

        notlptf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel14.setText("No BPJS");

        bpjstf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel15.setText("Tanggal Lahir");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        tambahbtn1.setText("Tambah");
        tambahbtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tambahbtn1.setkBorderRadius(20);
        tambahbtn1.setkEndColor(new java.awt.Color(255, 255, 255));
        tambahbtn1.setkForeGround(new java.awt.Color(46, 196, 182));
        tambahbtn1.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        tambahbtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambahbtn1.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        tambahbtn1.setkSelectedColor(new java.awt.Color(46, 196, 182));
        tambahbtn1.setkStartColor(new java.awt.Color(255, 255, 255));
        tambahbtn1.setName(""); // NOI18N
        tambahbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtn1ActionPerformed(evt);
            }
        });

        tambahbtn2.setText("Batal");
        tambahbtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tambahbtn2.setkBorderRadius(20);
        tambahbtn2.setkEndColor(new java.awt.Color(255, 255, 255));
        tambahbtn2.setkForeGround(new java.awt.Color(46, 196, 182));
        tambahbtn2.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        tambahbtn2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambahbtn2.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        tambahbtn2.setkSelectedColor(new java.awt.Color(46, 196, 182));
        tambahbtn2.setkStartColor(new java.awt.Color(255, 255, 255));
        tambahbtn2.setName(""); // NOI18N
        tambahbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtn2ActionPerformed(evt);
            }
        });

        keluhantf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        keluhantf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluhantfActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel16.setText("Keluhan");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setText("Estimasi Melahirkan");

        jPanel1.setOpaque(false);

        estimasi.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        estimasi.setText("00/00/0000");

        estimasi2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        estimasi2.setText("00/00/0000");

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("s/d");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(estimasi)
                .addGap(27, 27, 27)
                .addComponent(jLabel20)
                .addGap(35, 35, 35)
                .addComponent(estimasi2)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estimasi)
                    .addComponent(jLabel20)
                    .addComponent(estimasi2))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel21.setText("Hari Pertama Haid Terakhir (HPHT)");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        tambahbtn3.setText("Cek");
        tambahbtn3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tambahbtn3.setkBorderRadius(20);
        tambahbtn3.setkEndColor(new java.awt.Color(255, 255, 255));
        tambahbtn3.setkForeGround(new java.awt.Color(46, 196, 182));
        tambahbtn3.setkHoverEndColor(new java.awt.Color(46, 158, 162));
        tambahbtn3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambahbtn3.setkHoverStartColor(new java.awt.Color(46, 158, 162));
        tambahbtn3.setkSelectedColor(new java.awt.Color(46, 196, 182));
        tambahbtn3.setkStartColor(new java.awt.Color(255, 255, 255));
        tambahbtn3.setName(""); // NOI18N
        tambahbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tambahpasienLayout = new javax.swing.GroupLayout(tambahpasien);
        tambahpasien.setLayout(tambahpasienLayout);
        tambahpasienLayout.setHorizontalGroup(
            tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahpasienLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahpasienLayout.createSequentialGroup()
                        .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(bpjstf, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(notlptf, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(alamattf, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addGroup(tambahpasienLayout.createSequentialGroup()
                                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tempatlahirtf, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tambahpasienLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tambahpasienLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(tambahpasienLayout.createSequentialGroup()
                                        .addComponent(tambahbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tambahbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tambahpasienLayout.createSequentialGroup()
                                        .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel16)
                                            .addGroup(tambahpasienLayout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(48, 48, 48)
                                                .addComponent(tambahbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(23, 23, 23))
                                    .addComponent(keluhantf, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahpasienLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))))
                    .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(niktf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                        .addComponent(namapasientf, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tambahpasienLayout.setVerticalGroup(
            tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahpasienLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel8)
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(niktf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namapasientf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tambahpasienLayout.createSequentialGroup()
                        .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tempatlahirtf, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                    .addGroup(tambahpasienLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahpasienLayout.createSequentialGroup()
                        .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tambahbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(alamattf, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tambahpasienLayout.createSequentialGroup()
                        .addComponent(notlptf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bpjstf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(keluhantf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tambahpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        crdpanel.add(tambahpasien, "tambahpasien");

        jSplitPane1.setRightComponent(crdpanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DbtnActionPerformed
        cardLayout.show(crdpanel, "Dpanel");
        loadDashboard();
        hitungpasien();
        hitungMelahirkan();
      
        //hitungpasien();
    }//GEN-LAST:event_DbtnActionPerformed

    private void PbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PbtnActionPerformed
       cardLayout.show(crdpanel, "Ppanel");
       initTablePasien();
       loadPasien();
    }//GEN-LAST:event_PbtnActionPerformed

    private void KbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnActionPerformed
        //cardLayout.show(crdpanel, "Kpanel");
        new Rujukan().setVisible(true);
    }//GEN-LAST:event_KbtnActionPerformed

    private void BbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BbtnActionPerformed
        cardLayout.show(crdpanel, "Bpanel");
        initTableBidan();
        loadBidan();
    }//GEN-LAST:event_BbtnActionPerformed

    private void tambahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtnActionPerformed
        cardLayout.show(crdpanel, "tambahpasien");
    }//GEN-LAST:event_tambahbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
//        try{
//        int selectedRow = tablePasien.getSelectedRow();
//        if (selectedRow==-1){
//            showMessage("pilih baris dulu !!",2);
//        }else{
//                cardLayout.show(crdpanel, "tambahpasien");
//           
//        }
//        validateInput();
//       //setPasienToComponent(0);
//        }catch (Exception e){
//        }
//        
        
      
        
    }//GEN-LAST:event_updatebtnActionPerformed
    
    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        // TODO add your handling code here:
        try {
            int pilihan = JOptionPane.showConfirmDialog(this, " Apakah anda yakin akan menghapus data ini ?", "Konfirmasi", JOptionPane.WARNING_MESSAGE);
            if (pilihan == JOptionPane.YES_OPTION) {
                Connection con = Kebidanan.getConnection();
                int row = tablePasien.getSelectedRow();
                String value = (tablePasien.getModel().getValueAt(row, 0).toString());
                String sql = "DELETE FROM pasien WHERE NIK=" + value;
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) tablePasien.getModel();
                model.setRowCount(0);
                loadPasien();
                JOptionPane.showMessageDialog(rootPane, "Data Dihapus");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Baris Dulu");
        }
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void tempatlahirtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempatlahirtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempatlahirtfActionPerformed

    private void tambahbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtn1ActionPerformed
        // TODO add your handling code here:
         if (pasienID == 0) {
            tambahPasien();
            clearpasien();
            cardLayout.show(crdpanel, "Ppanel");
        } else {
            updatePasien(pasienID);
        }
        DefaultTableModel model = (DefaultTableModel)tablePasien.getModel();
        model.setRowCount(0);
        loadPasien();
                            
    }//GEN-LAST:event_tambahbtn1ActionPerformed

    private void tambahbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtn2ActionPerformed
        cardLayout.show(crdpanel, "Ppanel");
    }//GEN-LAST:event_tambahbtn2ActionPerformed

    private void tambahbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtn3ActionPerformed
        // TODO add your handling code here:
        hitunglahir();
    }//GEN-LAST:event_tambahbtn3ActionPerformed

    private void keluhantfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluhantfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keluhantfActionPerformed

    private void tempatlahirbidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempatlahirbidanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempatlahirbidanActionPerformed

    private void tambahbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtn4ActionPerformed
         try {
            int pilihan = JOptionPane.showConfirmDialog(this, " Apakah anda yakin akan menghapus data ini ?", "Konfirmasi", JOptionPane.WARNING_MESSAGE);
            if (pilihan == JOptionPane.YES_OPTION) {
                Connection con = Kebidanan.getConnection();
                int row = tableBidan.getSelectedRow();
                String value = (tableBidan.getModel().getValueAt(row, 0).toString());
                String sql = "DELETE FROM bidan WHERE STR=" + value;
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                DefaultTableModel model2 = (DefaultTableModel) tableBidan.getModel();
                model2.setRowCount(0);
                loadBidan();
                JOptionPane.showMessageDialog(rootPane, "Data Dihapus");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Baris Dulu");
        }
    }//GEN-LAST:event_tambahbtn4ActionPerformed

    private void tambahbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtn5ActionPerformed
      if (bidanID == 0) {
            tambahBidan();
            loadBidan();
        } else {
           // updateBidan(bidanID);
        }
        DefaultTableModel model2 = (DefaultTableModel)tableBidan.getModel();
        model2.setRowCount(0);
        loadBidan();
                            
    }//GEN-LAST:event_tambahbtn5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Bbtn;
    private keeptoo.KGradientPanel Bpanel;
    private com.k33ptoo.components.KButton Dbtn;
    private keeptoo.KGradientPanel Dpanel;
    private com.k33ptoo.components.KButton Kbtn;
    private keeptoo.KGradientPanel Kpanel;
    private com.k33ptoo.components.KButton Pbtn;
    private keeptoo.KGradientPanel Ppanel;
    private javax.swing.JTextField alamatbidan;
    private javax.swing.JTextField alamattf;
    private javax.swing.JTextField bpjstf;
    private javax.swing.JPanel crdpanel;
    private javax.swing.JTextField emailbidan;
    private javax.swing.JLabel estimasi;
    private javax.swing.JLabel estimasi2;
    private com.k33ptoo.components.KButton hapusbtn;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel jumlahpasien;
    private javax.swing.JTextField keluhantf;
    private javax.swing.JLabel melahirkantxt;
    private javax.swing.JPanel menupanel;
    private javax.swing.JLabel namabidan;
    private javax.swing.JTextField namabidantf;
    private javax.swing.JTextField namapasientf;
    private javax.swing.JTextField niktf;
    private javax.swing.JTextField notlpbidan;
    private javax.swing.JTextField notlptf;
    private javax.swing.JTextField passbidan;
    private javax.swing.JTextField strtf;
    private javax.swing.JTable tableBidan;
    private javax.swing.JTable tableDashboard;
    private javax.swing.JTable tablePasien;
    private com.k33ptoo.components.KButton tambahbtn;
    private com.k33ptoo.components.KButton tambahbtn1;
    private com.k33ptoo.components.KButton tambahbtn2;
    private com.k33ptoo.components.KButton tambahbtn3;
    private com.k33ptoo.components.KButton tambahbtn4;
    private com.k33ptoo.components.KButton tambahbtn5;
    private keeptoo.KGradientPanel tambahpasien;
    private javax.swing.JTextField tempatlahirbidan;
    private javax.swing.JTextField tempatlahirtf;
    private javax.swing.JLabel textbidan;
    private javax.swing.JLabel textbidan4;
    private javax.swing.JLabel textbidan7;
    private com.toedter.calendar.JDateChooser tglbidan;
    private com.k33ptoo.components.KButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
