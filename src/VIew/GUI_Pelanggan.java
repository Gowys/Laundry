package VIew;
import Control.Control_Pelanggan;
import Control.Control_User;
import Entity.Entity_Pelanggan;
import Control.Data_Pelanggan;
import Entity.Entity_Database;
import Entity.Entity_User;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class GUI_Pelanggan extends javax.swing.JFrame {
    
    public Connection conn;
    public Statement stat;
    public ResultSet rs;
    
    DefaultTableModel model = new DefaultTableModel();
    
    private int idpel;

    public GUI_Pelanggan() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        onCommand();
        cmdupdate.setEnabled(false);
        cmddelete.setEnabled(false);
        
        model.addColumn("ID PEL");
        model.addColumn("NAMA");
        model.addColumn("NO TELP");
        model.addColumn("ALAMAT");
        
        try{
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tblpelanggan");
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("idpelanggan"), rs.getString("namapelanggan"), rs.getString("notelp"), rs.getString("alamat")});
            }
        } catch(Exception e){
            
        }
        tblpelanggan.setModel(model);
    }
     private void deplace(int i){
        try{
            idpel = Integer.parseInt(model.getValueAt(i,0).toString());
            txtid.setText(model.getValueAt(i,0).toString());
            txtnama.setText(model.getValueAt(i,1).toString());
            txthp.setText(model.getValueAt(i,2).toString());
            txtalamat.setText(model.getValueAt(i,3).toString());
            
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
        
        txtid.setText("");
        txtnama.setText("");
        txthp.setText("");
        txtalamat.setText("");
        
        
        try{
            model.setRowCount(0);
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tblpelanggan");
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("idpelanggan"), rs.getString("namapelanggan"), rs.getString("notelp"), rs.getString("alamat")});
            }
        } catch(Exception e) {
            System.err.println(e);
            tblpelanggan.setModel(model);
        }
    }
    private void setId(){
        try {
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            String sql = "SELECT * FROM tblpelanggan ORDER BY idpelanggan DESC";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                int id = Integer.parseInt(rs.getString("idpelanggan"))+1;
                txtid.setText(Integer.toString(id));
                idpel = id;
            }else{
                txtid.setText("1");
                idpel=1;
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txthp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpelanggan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cmddelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmdinsert = new javax.swing.JButton();
        cmdupdate = new javax.swing.JButton();
        cmdsave = new javax.swing.JButton();
        cmdcancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Pelanggan");
        setMinimumSize(new java.awt.Dimension(740, 375));
        setName("formpelanggan"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("ID Pelanggan");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(23, 108, 70, 16);

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(255, 255, 255));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid);
        txtid.setBounds(147, 105, 60, 22);

        jLabel3.setText("Nama Pelanggan");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(23, 139, 90, 16);

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        getContentPane().add(txtnama);
        txtnama.setBounds(147, 136, 120, 22);

        jLabel4.setText("No Telp");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(23, 173, 80, 16);

        txthp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthpActionPerformed(evt);
            }
        });
        getContentPane().add(txthp);
        txthp.setBounds(147, 170, 120, 22);

        tblpelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblpelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpelanggan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(331, 99, 427, 304);

        jLabel5.setText("Alamat");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(23, 204, 60, 16);

        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });
        getContentPane().add(txtalamat);
        txtalamat.setBounds(147, 201, 120, 22);

        jPanel1.setBackground(new java.awt.Color(246, 251, 244));

        cmddelete.setBackground(new java.awt.Color(217, 215, 241));
        cmddelete.setText("DELETE");
        cmddelete.setBorderPainted(false);
        cmddelete.setMaximumSize(new java.awt.Dimension(765, 414));
        cmddelete.setMinimumSize(new java.awt.Dimension(765, 414));
        cmddelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmddeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 24, 95));
        jLabel2.setText("CUSTOMER DATA");

        cmdinsert.setBackground(new java.awt.Color(217, 215, 241));
        cmdinsert.setText("ADD");
        cmdinsert.setBorderPainted(false);
        cmdinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdinsertActionPerformed(evt);
            }
        });

        cmdupdate.setBackground(new java.awt.Color(217, 215, 241));
        cmdupdate.setText("UPDATE");
        cmdupdate.setBorderPainted(false);
        cmdupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdupdateActionPerformed(evt);
            }
        });

        cmdsave.setBackground(new java.awt.Color(217, 215, 241));
        cmdsave.setText("SAVE");
        cmdsave.setBorderPainted(false);
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdinsert, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdupdate)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmddelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdcancel)))))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdinsert)
                    .addComponent(cmdupdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmddelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(194, 194, 194))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txthpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthpActionPerformed

    private void cmdinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdinsertActionPerformed

        setId();
        shutCommand();
        txtnama.requestFocus();
        txtnama.setText("");
        txthp.setText("");
        txtalamat.setText("");
    }//GEN-LAST:event_cmdinsertActionPerformed

    private void cmdupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdupdateActionPerformed
        if(txtnama.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama Pelanggan tidak boleh kosong");
        }
        else if(txthp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nomor Telpon tidak boleh kosong");
        }
        else if(txtalamat.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Alamat Pelanggan tidak boleh kosong");
        }else{
        Entity_Pelanggan pelanggan = new Entity_Pelanggan();
        pelanggan.setIdpelanggan(idpel);
        pelanggan.setNamapelanggan(txtnama.getText().trim());
        pelanggan.setNotelp(txthp.getText().trim());
        pelanggan.setAlamat(txtalamat.getText().trim());

        Control_Pelanggan control = new Control_Pelanggan();
        control.updatePlg(pelanggan);
        refresh();
        }
    }//GEN-LAST:event_cmdupdateActionPerformed

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        if(txtnama.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama Pelanggan tidak boleh kosong");
        }
        else if(txthp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nomor Telpon tidak boleh kosong");
        }
        else if(txtalamat.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Alamat Pelanggan tidak boleh kosong");
        }else{
        Entity_Pelanggan pelanggan = new Entity_Pelanggan();
        pelanggan.setIdpelanggan(idpel);
        pelanggan.setNamapelanggan(txtnama.getText().trim());
        pelanggan.setNotelp(txthp.getText().trim());
        pelanggan.setAlamat(txtalamat.getText().trim());

        Control_Pelanggan control = new Control_Pelanggan();
        control.insertPlg(pelanggan);
        refresh();
        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void cmdcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcancelActionPerformed
        onCommand();
        refresh();
    }//GEN-LAST:event_cmdcancelActionPerformed

    private void cmddeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmddeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to delete this data?", "Warning", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            Entity_Pelanggan pelanggan = new Entity_Pelanggan();
            pelanggan.setIdpelanggan(idpel);

            Control_Pelanggan control = new Control_Pelanggan();
            control.deletePlg(pelanggan);
            refresh();
        }else{
            
        }        
        
    }//GEN-LAST:event_cmddeleteActionPerformed

    private void tblpelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpelangganMouseClicked
        try{
            int i=tblpelanggan.getSelectedRow();
            deplace(i);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tblpelangganMouseClicked

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Pelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdcancel;
    private javax.swing.JButton cmddelete;
    private javax.swing.JButton cmdinsert;
    private javax.swing.JButton cmdsave;
    private javax.swing.JButton cmdupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpelanggan;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txthp;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
