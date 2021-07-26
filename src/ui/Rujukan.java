/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import mgr.PasienManager;
import static ui.dashboard.ListPasien;
import static ui.dashboard.tableModel;

/**
 *
 * @author Ardyas Setya Nugraha
 */
public class Rujukan extends javax.swing.JFrame {

    /**
     * Creates new form Rujukan
     */
    public Rujukan() {
        initComponents();
    }
        public static DefaultTableModel tableModelrujukan;
    
      private void initTableRujukan(){
        String[] tableColumns = new String []{"No Rujukan", "Rumah Sakit", "Alamat RS","Nama Dokter", 
            "Tanggel Rujukan","Nama Pasien","No.Telp","Tindakan","No. BPJS"};
    
        int[] columnWidth = {
            180,270,200,200,200,200,200,200,200
        };

        tableModelrujukan = new DefaultTableModel(tableColumns,0);
        tablerujukan.setModel (tableModelrujukan);
        tablerujukan.setRowHeight(30);

        int i =0;
        for (int width : columnWidth ){
            TableColumn column = tablerujukan.getColumnModel().getColumn(i++);
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
      
//      public static void loadRujukan(){
//        dashboard.ListRujukan = new ArrayList<>();
//        dashboard.ListRujukan = PasienManager.showAllpasien();
//        dashboard.ListRujukan.setRowCount(0);
//        dashboard.ListRujukan.forEach((var Pasien) -> {
//                tableModelrujukan.addRow(new Object[]{
//                    Pasien.getNIK(),
//                    Pasien.getNama_pasien(),
//                    Pasien.getTempat_lahir(),
//                    Pasien.getTgl_lahir(), 
//                    Pasien.getAlamat_pasien(), 
//                    Pasien.getNo_telp(), 
//                    Pasien.getTgl_positif(), 
//                    Pasien.getKeluhan(), 
//                    Pasien.getBpjs(), 
//               });
//        });
//       
//    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        textbidan = new javax.swing.JLabel();
        textbidan1 = new javax.swing.JLabel();
        textbidan2 = new javax.swing.JLabel();
        textbidan3 = new javax.swing.JLabel();
        textbidan4 = new javax.swing.JLabel();
        textbidan5 = new javax.swing.JLabel();
        niktf = new javax.swing.JTextField();
        niktf1 = new javax.swing.JTextField();
        niktf2 = new javax.swing.JTextField();
        niktf3 = new javax.swing.JTextField();
        niktf4 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        textbidan6 = new javax.swing.JLabel();
        niktf5 = new javax.swing.JTextField();
        textbidan7 = new javax.swing.JLabel();
        niktf6 = new javax.swing.JTextField();
        textbidan8 = new javax.swing.JLabel();
        niktf7 = new javax.swing.JTextField();
        textbidan9 = new javax.swing.JLabel();
        niktf8 = new javax.swing.JTextField();
        textbidan10 = new javax.swing.JLabel();
        textbidan11 = new javax.swing.JLabel();
        niktf10 = new javax.swing.JTextField();
        tambahbtn2 = new com.k33ptoo.components.KButton();
        tambahbtn = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablerujukan = new javax.swing.JTable();
        tambahbtn1 = new com.k33ptoo.components.KButton();
        tambahbtn3 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(46, 196, 182));
        kGradientPanel1.setkGradientFocus(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(203, 243, 240));

        textbidan.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan.setText("No. Rujukan");

        textbidan1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan1.setText("Rumah Sakit");

        textbidan2.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan2.setText("Alamat Rujukan");

        textbidan3.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan3.setText("Dokter");

        textbidan4.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan4.setText("Tanggal Rujukan");

        textbidan5.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan5.setText("Tindakan");

        niktf.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        niktf1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        niktf2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        niktf3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        niktf4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        textbidan6.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan6.setText("Nama Pasien");

        niktf5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        textbidan7.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan7.setText("Nik");

        niktf6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        textbidan8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan8.setText("Alamat ");

        niktf7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        textbidan9.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan9.setText("Dokter");

        niktf8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        textbidan10.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        textbidan10.setText("Tanggal Lahir");

        textbidan11.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        niktf10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        tambahbtn2.setText("Cari");
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

        tablerujukan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablerujukan);

        tambahbtn1.setText("Hapus");
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

        tambahbtn3.setText("Cetak");
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

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambahbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tambahbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tambahbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textbidan5)
                            .addComponent(textbidan4)
                            .addComponent(textbidan2)
                            .addComponent(textbidan)
                            .addComponent(textbidan1)
                            .addComponent(textbidan3))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(niktf1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(niktf2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(niktf3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(niktf4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(niktf, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textbidan11)
                            .addComponent(textbidan10)
                            .addComponent(textbidan8)
                            .addComponent(textbidan6)
                            .addComponent(textbidan7)
                            .addComponent(textbidan9))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(niktf6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(niktf7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(niktf8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(niktf5)
                            .addComponent(niktf10)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tambahbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textbidan6)
                            .addComponent(niktf5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tambahbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textbidan7)
                            .addComponent(niktf6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textbidan8)
                            .addComponent(niktf7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textbidan9)
                            .addComponent(niktf8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textbidan10)
                            .addComponent(niktf10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(textbidan11))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textbidan)
                            .addComponent(niktf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textbidan1)
                            .addComponent(niktf1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textbidan2)
                            .addComponent(niktf2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textbidan3)
                            .addComponent(niktf3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textbidan4)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textbidan5)
                            .addComponent(niktf4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtnActionPerformed
       
    }//GEN-LAST:event_tambahbtnActionPerformed

    private void tambahbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahbtn1ActionPerformed

    private void tambahbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahbtn3ActionPerformed

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
            java.util.logging.Logger.getLogger(Rujukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rujukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rujukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rujukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rujukan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField niktf;
    private javax.swing.JTextField niktf1;
    private javax.swing.JTextField niktf10;
    private javax.swing.JTextField niktf2;
    private javax.swing.JTextField niktf3;
    private javax.swing.JTextField niktf4;
    private javax.swing.JTextField niktf5;
    private javax.swing.JTextField niktf6;
    private javax.swing.JTextField niktf7;
    private javax.swing.JTextField niktf8;
    private javax.swing.JTable tablerujukan;
    private com.k33ptoo.components.KButton tambahbtn;
    private com.k33ptoo.components.KButton tambahbtn1;
    private com.k33ptoo.components.KButton tambahbtn2;
    private com.k33ptoo.components.KButton tambahbtn3;
    private javax.swing.JLabel textbidan;
    private javax.swing.JLabel textbidan1;
    private javax.swing.JLabel textbidan10;
    private javax.swing.JLabel textbidan11;
    private javax.swing.JLabel textbidan2;
    private javax.swing.JLabel textbidan3;
    private javax.swing.JLabel textbidan4;
    private javax.swing.JLabel textbidan5;
    private javax.swing.JLabel textbidan6;
    private javax.swing.JLabel textbidan7;
    private javax.swing.JLabel textbidan8;
    private javax.swing.JLabel textbidan9;
    // End of variables declaration//GEN-END:variables
}