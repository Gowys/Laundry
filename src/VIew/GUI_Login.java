package VIew;
import java.sql.*;
import Entity.Entity_Database;
import Entity.Entity_Transaksi;
import VIew.GUI_Transaksi;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class GUI_Login extends javax.swing.JFrame {
    
    public Connection conn;
    public Statement stat;
    public ResultSet rs;
    public String username;
    
    public GUI_Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        txtusername.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmdlogin = new javax.swing.JButton();
        cmdcancel = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("CUSTOMER DATA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN PAGE");
        setBackground(new java.awt.Color(0, 204, 255));
        setMinimumSize(new java.awt.Dimension(338, 253));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(txtusername);
        txtusername.setBounds(160, 90, 140, 20);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 24, 95));
        jLabel1.setText("USERNAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 100, 70, 12);

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 24, 95));
        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 140, 70, 12);

        cmdlogin.setBackground(new java.awt.Color(217, 215, 241));
        cmdlogin.setText("LOGIN");
        cmdlogin.setBorder(null);
        cmdlogin.setBorderPainted(false);
        cmdlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdloginActionPerformed(evt);
            }
        });
        getContentPane().add(cmdlogin);
        cmdlogin.setBounds(40, 190, 110, 51);

        cmdcancel.setBackground(new java.awt.Color(217, 215, 241));
        cmdcancel.setText("CANCEL");
        cmdcancel.setBorderPainted(false);
        cmdcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdcancel);
        cmdcancel.setBounds(190, 190, 110, 51);
        getContentPane().add(txtpassword);
        txtpassword.setBounds(160, 130, 140, 20);

        jPanel1.setBackground(new java.awt.Color(246, 251, 244));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(14, 24, 95));
        jLabel4.setText("LAUNDRY LOGIN");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 20, 210, 40);

        jPanel2.setBackground(new java.awt.Color(47, 164, 255));
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 360, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 360, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void cmdloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdloginActionPerformed
        
        try{
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("select * from tbluser where username='"+txtusername.getText().trim()+"' AND password='"+ txtpassword.getText()+"'");

            if(rs.next()){
                if("ADMIN".equals(rs.getString("akses"))) {
                    String nama = rs.getString("nama");
                    JOptionPane.showMessageDialog(rootPane, "Selamat Datang Admin : " + nama);
                    new GUI_Navigasi().setVisible(true);
                    this.dispose();
                }
                else if("USER".equals(rs.getString("akses"))){
                    
                    String username = rs.getString("username");
                    String nama = rs.getString("nama");
                    JOptionPane.showMessageDialog(rootPane, "Selamat Datang User : " + nama);
                    new GUI_Transaksi(username).setVisible(true);
                    this.setVisible(false);        
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Username atau Password salah");
                txtpassword.setText("");
                txtusername.requestFocus();
                
            }
                    
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdloginActionPerformed

    private void cmdcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcancelActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null,"Anda ingin membatalkan login?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        }else{
            txtusername.requestFocus();
        }
        
    }//GEN-LAST:event_cmdcancelActionPerformed

    public void actionPerformed(ActionEvent e) {
        
        new GUI_Transaksi().setVisible(true);
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Login().setVisible(true);
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdcancel;
    private javax.swing.JButton cmdlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
