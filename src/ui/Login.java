/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import kebidanan.Kebidanan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Ardyas Setya Nugraha
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    String email;
    ResultSet rs;
    CardLayout cardLayout;
     
    public Login() {
        initComponents();
        cardLayout =(CardLayout)(cardpanel.getLayout());
    }
    
void tambahBidan() {
        try {
            Connection conn = Kebidanan.getConnection();
            Statement stm = conn.createStatement();
            String query = "INSERT INTO `bidan` (`STR`,`email_bidan`,`password_bidan`) "
                    + "VALUES ('" + strtf.getText() 
                    + "', '" + emailtf.getText() 
                    + "', '" + jPasswordField2.getText() 
                    
                    + "');";

            
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Success register ", "infomasi", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "infomasi", JOptionPane.INFORMATION_MESSAGE);
        }    
    }

void login(){
     try{
            Connection con = Kebidanan.getConnection();
            Statement st=con.createStatement();
            String sql="SELECT * FROM bidan WHERE email_bidan='"+emailfield.getText()
                    +"' and password_bidan='"+jPasswordField1.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               email = rs.getString("email_bidan");

            
            }
        } catch (SQLException ex) {
        }
    
     if (email != null) {

            this.dispose();
            JOptionPane.showMessageDialog(this, "Login Berhasil");
            dashboard h = new dashboard();
            h.setVisible(true);
            
           
       }
      else {
            JOptionPane.showMessageDialog(this, "Login Gagal, Coba Lagi!!");
        }

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
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cardpanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        emailfield = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        loginbtn1 = new com.k33ptoo.components.KButton();
        regisbtn1 = new com.k33ptoo.components.KButton();
        regispanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        strtf = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        loginbtn2 = new com.k33ptoo.components.KButton();
        regisbtn2 = new com.k33ptoo.components.KButton();
        emailtf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(1366, 650));
        setSize(new java.awt.Dimension(900, 600));

        jSplitPane1.setBorder(null);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1297, 697));

        kGradientPanel2.setkEndColor(new java.awt.Color(46, 196, 182));
        kGradientPanel2.setkGradientFocus(0);
        kGradientPanel2.setkStartColor(new java.awt.Color(203, 243, 240));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(1066, 695));

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(46, 196, 182));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/bidan 300x300.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Selamat Datang Di");

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sistem Informasi Kebidanan");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10))
                    .addComponent(jLabel5))
                .addGap(344, 344, 344))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(113, 113, 113))
        );

        jSplitPane1.setLeftComponent(kGradientPanel2);

        cardpanel.setBackground(new java.awt.Color(255, 255, 255));
        cardpanel.setPreferredSize(new java.awt.Dimension(224, 695));
        cardpanel.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(224, 695));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(46, 196, 182));
        jLabel3.setText("Login / Register");

        emailfield.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        emailfield.setToolTipText("email@email.com");
        emailfield.setAlignmentX(1.0F);
        emailfield.setAlignmentY(1.0F);
        emailfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        emailfield.setCaretColor(new java.awt.Color(46, 196, 182));
        emailfield.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailfield.setMargin(new java.awt.Insets(5, 5, 5, 5));
        emailfield.setOpaque(false);
        emailfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailfieldActionPerformed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordField1.setToolTipText("password");
        jPasswordField1.setAlignmentX(1.0F);
        jPasswordField1.setAlignmentY(1.0F);
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPasswordField1.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 11)); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 11)); // NOI18N
        jLabel7.setText("Email");

        loginbtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginbtn1.setkBorderRadius(0);
        loginbtn1.setkEndColor(new java.awt.Color(203, 243, 240));
        loginbtn1.setkForeGround(new java.awt.Color(46, 196, 182));
        loginbtn1.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        loginbtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        loginbtn1.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        loginbtn1.setkSelectedColor(new java.awt.Color(46, 196, 182));
        loginbtn1.setkStartColor(new java.awt.Color(203, 243, 240));
        loginbtn1.setLabel("Login");
        loginbtn1.setName(""); // NOI18N
        loginbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtn1ActionPerformed(evt);
            }
        });

        regisbtn1.setText("Register");
        regisbtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        regisbtn1.setkBorderRadius(0);
        regisbtn1.setkEndColor(new java.awt.Color(203, 243, 240));
        regisbtn1.setkForeGround(new java.awt.Color(46, 196, 182));
        regisbtn1.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        regisbtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        regisbtn1.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        regisbtn1.setkSelectedColor(new java.awt.Color(46, 196, 182));
        regisbtn1.setkStartColor(new java.awt.Color(203, 243, 240));
        regisbtn1.setName(""); // NOI18N
        regisbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailfield, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGap(36, 36, 36))
                                .addComponent(jLabel6)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(regisbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(loginbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jLabel3)
                    .addGap(37, 37, 37)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(emailfield, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addComponent(loginbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(regisbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(237, Short.MAX_VALUE)))
        );

        cardpanel.add(jPanel1, "jPanel1");
        jPanel1.getAccessibleContext().setAccessibleDescription("");
        jPanel1.getAccessibleContext().setAccessibleParent(jSplitPane1);

        regispanel.setBackground(new java.awt.Color(255, 255, 255));
        regispanel.setPreferredSize(new java.awt.Dimension(224, 695));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(46, 196, 182));
        jLabel4.setText("Register");

        strtf.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        strtf.setToolTipText("email@email.com");
        strtf.setAlignmentX(1.0F);
        strtf.setAlignmentY(1.0F);
        strtf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        strtf.setCaretColor(new java.awt.Color(46, 196, 182));
        strtf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        strtf.setMargin(new java.awt.Insets(5, 5, 5, 5));
        strtf.setOpaque(false);
        strtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strtfActionPerformed(evt);
            }
        });

        jPasswordField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordField2.setToolTipText("password");
        jPasswordField2.setAlignmentX(1.0F);
        jPasswordField2.setAlignmentY(1.0F);
        jPasswordField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPasswordField2.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 11)); // NOI18N
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 11)); // NOI18N
        jLabel9.setText("STR");

        loginbtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginbtn2.setkBorderRadius(0);
        loginbtn2.setkEndColor(new java.awt.Color(203, 243, 240));
        loginbtn2.setkForeGround(new java.awt.Color(46, 196, 182));
        loginbtn2.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        loginbtn2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        loginbtn2.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        loginbtn2.setkSelectedColor(new java.awt.Color(46, 196, 182));
        loginbtn2.setkStartColor(new java.awt.Color(203, 243, 240));
        loginbtn2.setLabel("Login");
        loginbtn2.setName(""); // NOI18N
        loginbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtn2ActionPerformed(evt);
            }
        });

        regisbtn2.setText("Register");
        regisbtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        regisbtn2.setkBorderRadius(0);
        regisbtn2.setkEndColor(new java.awt.Color(203, 243, 240));
        regisbtn2.setkForeGround(new java.awt.Color(46, 196, 182));
        regisbtn2.setkHoverEndColor(new java.awt.Color(46, 196, 182));
        regisbtn2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        regisbtn2.setkHoverStartColor(new java.awt.Color(46, 196, 182));
        regisbtn2.setkSelectedColor(new java.awt.Color(46, 196, 182));
        regisbtn2.setkStartColor(new java.awt.Color(203, 243, 240));
        regisbtn2.setName(""); // NOI18N
        regisbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisbtn2ActionPerformed(evt);
            }
        });

        emailtf.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        emailtf.setToolTipText("email@email.com");
        emailtf.setAlignmentX(1.0F);
        emailtf.setAlignmentY(1.0F);
        emailtf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        emailtf.setCaretColor(new java.awt.Color(46, 196, 182));
        emailtf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailtf.setMargin(new java.awt.Insets(5, 5, 5, 5));
        emailtf.setOpaque(false);
        emailtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtfActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 11)); // NOI18N
        jLabel12.setText("Password");

        javax.swing.GroupLayout regispanelLayout = new javax.swing.GroupLayout(regispanel);
        regispanel.setLayout(regispanelLayout);
        regispanelLayout.setHorizontalGroup(
            regispanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regispanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(regispanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regispanelLayout.createSequentialGroup()
                        .addGroup(regispanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(strtf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(emailtf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regispanelLayout.createSequentialGroup()
                        .addGroup(regispanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(regisbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regispanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(113, 113, 113))
        );
        regispanelLayout.setVerticalGroup(
            regispanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regispanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strtf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailtf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(2, 2, 2)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regisbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        cardpanel.add(regispanel, "regispanel");

        jSplitPane1.setRightComponent(cardpanel);
        cardpanel.getAccessibleContext().setAccessibleDescription("");
        cardpanel.getAccessibleContext().setAccessibleParent(jSplitPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailfieldActionPerformed

    private void loginbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtn1ActionPerformed
        // TODO add your handling code here:
        login();
   
    }//GEN-LAST:event_loginbtn1ActionPerformed

    private void regisbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisbtn1ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(cardpanel, "regispanel");
    }//GEN-LAST:event_regisbtn1ActionPerformed

    private void strtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strtfActionPerformed

    private void loginbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtn2ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(cardpanel, "jPanel1");
    }//GEN-LAST:event_loginbtn2ActionPerformed

    private void regisbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisbtn2ActionPerformed
        // TODO add your handling code here:
        tambahBidan();
        
    }//GEN-LAST:event_regisbtn2ActionPerformed

    private void emailtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtfActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardpanel;
    private javax.swing.JTextField emailfield;
    private javax.swing.JTextField emailtf;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSplitPane jSplitPane1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KButton loginbtn1;
    private com.k33ptoo.components.KButton loginbtn2;
    private com.k33ptoo.components.KButton regisbtn1;
    private com.k33ptoo.components.KButton regisbtn2;
    private javax.swing.JPanel regispanel;
    private javax.swing.JTextField strtf;
    // End of variables declaration//GEN-END:variables
}