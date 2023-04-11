package VIew;
import Control.Control_User;
import Entity.Entity_User;
import Control.Data_User;
import Entity.Entity_Database;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_User extends javax.swing.JFrame {
    
    public Connection conn;
    public Statement stat;
    public ResultSet rs;
   
    DefaultTableModel model = new DefaultTableModel();
    
    private String uid;
    private String nama;
    public GUI_User() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        onCommand();
        cmbakses.setSelectedIndex(-1);
        cmdupdate.setEnabled(false);
        cmddelete.setEnabled(false);
        model.addColumn("USERNAME");
        model.addColumn("AKSES");
        model.addColumn("FULL NAME");
        
        try{
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tbluser");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("username"), rs.getString("akses"), rs.getString("nama")});
            }
        } catch(Exception e){
            
        }
        tbluser.setModel(model);
    }
    
    private void deplace(int i){
        try{
            uid = model.getValueAt(i,0).toString();
            txtuser.setText(model.getValueAt(i,0).toString());
            cmbakses.setSelectedItem(model.getValueAt(i,1).toString());
            txtnama.setText(model.getValueAt(i,2).toString());
            nama = model.getValueAt(i,2).toString();
            
            cmdupdate.setEnabled(true);
            cmddelete.setEnabled(true);
            
        } catch(Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error"+e.getLocalizedMessage());
        }
    }
   
    private void shutCommand(){
        cmddelete.setVisible(false);
        cmdupdate.setVisible(false);
        cmdinsert.setVisible(false);
        cmdsave.setVisible(true);
        cmdcancel.setVisible(true);
    }
    private void onCommand(){
        cmddelete.setVisible(true);
        cmdupdate.setVisible(true);
        cmdinsert.setVisible(true);
        cmdsave.setVisible(false);
        cmdcancel.setVisible(false);
    }
    
    private void refresh(){
        onCommand();

        cmddelete.setVisible(true);
        cmdupdate.setVisible(true);
        cmdinsert.setVisible(true);
        cmdsave.setVisible(false);
        cmdcancel.setVisible(false);
        cmdupdate.setEnabled(false);
        cmddelete.setEnabled(false);
        
        txtuser.setText("");
        txtpass.setText("");
        txtnama.setText("");
        cmbakses.setSelectedIndex(-1);
        
        try{
            model.setRowCount(0);
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tbluser");
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("username"), rs.getString("akses"), rs.getString("nama")});
            }
        } catch(Exception e) {
            System.err.println(e);
            tbluser.setModel(model);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmdupdate = new javax.swing.JButton();
        cmddelete = new javax.swing.JButton();
        cmdinsert = new javax.swing.JButton();
        cmdcancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmdsave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbluser = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        cmbakses = new javax.swing.JComboBox<>();
        txtpass = new javax.swing.JPasswordField();
        txtuser = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("USER MANAGEMENT");
        setBackground(new java.awt.Color(102, 204, 255));
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(740, 375));
        setName("formuser"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(246, 251, 244));

        cmdupdate.setBackground(new java.awt.Color(217, 215, 241));
        cmdupdate.setText("UPDATE");
        cmdupdate.setBorderPainted(false);
        cmdupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdupdateActionPerformed(evt);
            }
        });

        cmddelete.setBackground(new java.awt.Color(217, 215, 241));
        cmddelete.setText("DELETE");
        cmddelete.setBorderPainted(false);
        cmddelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmddeleteActionPerformed(evt);
            }
        });

        cmdinsert.setBackground(new java.awt.Color(217, 215, 241));
        cmdinsert.setText("ADD");
        cmdinsert.setBorderPainted(false);
        cmdinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdinsertActionPerformed(evt);
            }
        });

        cmdcancel.setBackground(new java.awt.Color(217, 215, 241));
        cmdcancel.setText("CANCEL");
        cmdcancel.setBorderPainted(false);
        cmdcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 24, 95));
        jLabel2.setText("USER MANAGEMENT");

        cmdsave.setBackground(new java.awt.Color(217, 215, 241));
        cmdsave.setText("SAVE");
        cmdsave.setBorderPainted(false);
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
            }
        });

        tbluser.setModel(new javax.swing.table.DefaultTableModel(
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
        tbluser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbluserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbluser);

        jLabel4.setText("Nama");

        jLabel3.setText("Akses");

        lblpass.setText("Password");

        jLabel1.setText("Username");

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        cmbakses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USER" }));
        cmbakses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbaksesActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(47, 164, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmddelete)
                        .addGap(77, 77, 77)
                        .addComponent(cmdcancel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblpass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbakses, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cmdinsert, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmdupdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblpass)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdinsert)
                            .addComponent(cmdupdate)
                            .addComponent(cmdsave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdcancel)
                            .addComponent(cmddelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbaksesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbaksesActionPerformed

    }//GEN-LAST:event_cmbaksesActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed

    }//GEN-LAST:event_txtnamaActionPerformed

    private void tbluserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbluserMouseClicked
        try{
            int i=tbluser.getSelectedRow();
            deplace(i);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tbluserMouseClicked

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        String pass = String.valueOf(txtpass.getPassword());

        if(txtuser.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
        }
        else if(txtpass.getPassword().equals("")){
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong");
        }
        else if(cmbakses.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Hak akses user tidak boleh kosong");
        }
        else if(txtnama.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
        }else{
            Entity_User user = new Entity_User();
            user.setUsername(txtuser.getText().trim());
            user.setPassword(pass);
            user.setAkses(cmbakses.getSelectedItem().toString());
            user.setNama(txtnama.getText().trim());

            Control_User control = new Control_User();
            control.insertUser(user);
            refresh();
        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void cmdcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcancelActionPerformed
        onCommand();
        refresh();
    }//GEN-LAST:event_cmdcancelActionPerformed

    private void cmdinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdinsertActionPerformed

        shutCommand();
        txtuser.requestFocus();
        txtuser.setText("");
        txtpass.setText("");
        cmbakses.setSelectedIndex(-1);
        txtnama.setText("");
    }//GEN-LAST:event_cmdinsertActionPerformed

    private void cmddeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmddeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to delete this data?", "Warning", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            Entity_User user = new Entity_User();
            user.setUsername(uid);

            Control_User control = new Control_User();
            control.deleteUser(user);
            refresh();
        }else{

        }

    }//GEN-LAST:event_cmddeleteActionPerformed

    private void cmdupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdupdateActionPerformed
        String pass = String.valueOf(txtpass.getPassword());

        if(txtnama.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
        }else{
            if("".equals(pass)){
                Entity_User user = new Entity_User();

                user.setUsername(uid);
                user.setAkses(cmbakses.getSelectedItem().toString());
                user.setNama(txtnama.getText().trim());

                Control_User control = new Control_User();
                control.updateUser2(user);
                refresh();
            }else{
                Entity_User user = new Entity_User();
                user.setUsername(uid);
                user.setPassword(pass);
                user.setAkses(cmbakses.getSelectedItem().toString());
                user.setNama(txtnama.getText().trim());

                Control_User control = new Control_User();
                control.updateUser(user);
                refresh();
            }
        }
    }//GEN-LAST:event_cmdupdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(GUI_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbakses;
    private javax.swing.JButton cmdcancel;
    private javax.swing.JButton cmddelete;
    private javax.swing.JButton cmdinsert;
    private javax.swing.JButton cmdsave;
    private javax.swing.JButton cmdupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblpass;
    private javax.swing.JTable tbluser;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
