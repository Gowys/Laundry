package VIew;

import javax.swing.JOptionPane;

public class GUI_Navigasi extends javax.swing.JFrame {
    
    public GUI_Navigasi() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuuser = new javax.swing.JMenu();
        menuservice = new javax.swing.JMenu();
        menucustomer = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        menulogout = new javax.swing.JMenu();

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu-user.png"))); // NOI18N
        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NAVIGATION");
        setMinimumSize(new java.awt.Dimension(858, 450));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuuser.setText("User Management");
        menuuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuuserMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuuser);

        menuservice.setText("Service Management");
        menuservice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuserviceMousePressed(evt);
            }
        });
        jMenuBar1.add(menuservice);

        menucustomer.setText("  Customer Management");
        menucustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menucustomerMousePressed(evt);
            }
        });
        jMenuBar1.add(menucustomer);

        jMenu6.setText("                                                                    ");
        jMenuBar1.add(jMenu6);

        menulogout.setText("   Logout");
        menulogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menulogoutMousePressed(evt);
            }
        });
        jMenuBar1.add(menulogout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menulogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulogoutMousePressed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Anda ingin keluar dari aplikasi?",
            "Confirm",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else{
        
        }
    }//GEN-LAST:event_menulogoutMousePressed

    private void menucustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menucustomerMousePressed
        this.setVisible(true);
        new GUI_Pelanggan().setVisible(true);
    }//GEN-LAST:event_menucustomerMousePressed

    private void menuserviceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuserviceMousePressed
        this.setVisible(true);
        new GUI_Cucian().setVisible(true);
    }//GEN-LAST:event_menuserviceMousePressed

    private void menuuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuuserMouseClicked
        this.setVisible(true);
        new GUI_User().setVisible(true);
    }//GEN-LAST:event_menuuserMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_Navigasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Navigasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Navigasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Navigasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Navigasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menucustomer;
    private javax.swing.JMenu menulogout;
    private javax.swing.JMenu menuservice;
    private javax.swing.JMenu menuuser;
    // End of variables declaration//GEN-END:variables
}
