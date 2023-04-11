/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIew;

import Control.Control_User;
import Entity.Entity_Database;
import Entity.Entity_User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author dell
 */
public class GUI_Register extends javax.swing.JFrame {
    public Connection conn;
    public Statement stat;
    public ResultSet rs;
   
    DefaultTableModel model = new DefaultTableModel();
    
    private String uid;
    private String nama;
    
    Control_User conLog = new Control_User();
    
    public GUI_Register() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        model.addColumn("USERNAME");
        model.addColumn("FULL NAME");
        
        try{
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tbluser");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("username"), rs.getString("nama")});
            }
        } catch(Exception e){
            //tbluser.setModel(model);
        }
    }
    
    private void refresh(){
          
        txtuser.setText("");
        txtpass.setText("");
        txtnama.setText("");
        
        try{
            model.setRowCount(0);
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tbluser");
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("username"), rs.getString("nama")});
            }
        } catch(Exception e) {
            System.err.println(e);
            //tbluser.setModel(model);
        }
    }
    
    private void clearData(){
        txtuser.setText("");
        txtpass.setText("");
        txtnama.setText("");
        
    }
    
    private void run(){
        new GUI_Login().setVisible(true);
    }
    
    
    /**
     * Creates new form GUI_Register
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        cmdregister = new javax.swing.JButton();
        cmdcancel = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        cmdlogin = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        login.setText("Login");
        login.setMaximumSize(new java.awt.Dimension(169, 32767));
        login.setMinimumSize(new java.awt.Dimension(169, 56));
        login.setPreferredSize(new java.awt.Dimension(169, 56));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 24, 95));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(24, 99, 80, 12);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(14, 24, 95));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(24, 144, 80, 12);

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 11)); // NOI18N
        jLabel5.setText("Nama");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(24, 189, 80, 12);

        txtuser.setText(" ");
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        getContentPane().add(txtuser);
        txtuser.setBounds(118, 96, 150, 30);

        txtnama.setText(" ");
        getContentPane().add(txtnama);
        txtnama.setBounds(120, 190, 150, 30);

        cmdregister.setBackground(new java.awt.Color(217, 215, 241));
        cmdregister.setText("Register");
        cmdregister.setBorderPainted(false);
        cmdregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdregisterMouseClicked(evt);
            }
        });
        cmdregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdregisterActionPerformed(evt);
            }
        });
        getContentPane().add(cmdregister);
        cmdregister.setBounds(83, 255, 90, 22);

        cmdcancel.setBackground(new java.awt.Color(217, 215, 241));
        cmdcancel.setText("Cancel");
        cmdcancel.setBorderPainted(false);
        cmdcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdcancel);
        cmdcancel.setBounds(196, 255, 100, 22);

        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass);
        txtpass.setBounds(120, 140, 150, 30);

        cmdlogin.setBackground(new java.awt.Color(217, 215, 241));
        cmdlogin.setText("Login");
        cmdlogin.setBorderPainted(false);
        cmdlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdloginMouseClicked(evt);
            }
        });
        cmdlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdloginActionPerformed(evt);
            }
        });
        getContentPane().add(cmdlogin);
        cmdlogin.setBounds(370, 160, 110, 22);

        jPanel1.setBackground(new java.awt.Color(246, 251, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 24, 95));
        jLabel1.setText("LAUNDRY REGISTER");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 530, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void cmdregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdregisterActionPerformed
        // TODO add your handling code here:
        String pass = String.valueOf(txtpass.getPassword());
        
        if(txtuser.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
        }
        else if(txtpass.getPassword().equals("")){
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong");
        }
        else if(txtnama.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
        }else{
        Entity_User user = new Entity_User();
        user.setUsername(txtuser.getText().trim());
        user.setPassword(pass);
        user.setNama(txtnama.getText().trim());
        
        Control_User control = new Control_User();
        control.insertUser(user);
        JOptionPane.showMessageDialog(null, "Register telah berhasil, silahkan login", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        refresh();
        }
    }//GEN-LAST:event_cmdregisterActionPerformed

    private void cmdcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcancelActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null,"Anda ingin membatalkan register?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        }else{
            txtuser.requestFocus();
        }
    }//GEN-LAST:event_cmdcancelActionPerformed

    private void cmdregisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdregisterMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdregisterMouseClicked

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void cmdloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdloginActionPerformed

    private void cmdloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdloginMouseClicked
        // TODO add your handling code here:
        //conLog.registerUser(txtuser.getText(), String.valueOf(txtpass.getPassword()));
        //new GUI_ProgressBar().setVisible(true);
        
        //run();
        
        new GUI_Login().setVisible(true);
        dispose();
        //new GUI_Login().setVisible(true);
        
                   
    }//GEN-LAST:event_cmdloginMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdcancel;
    private javax.swing.JButton cmdlogin;
    private javax.swing.JButton cmdregister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu login;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}