package VIew;
import Control.Control_Cucian;
import Control.Control_User;
import Entity.Entity_Cucian;
import Control.Data_Cucian;
import Entity.Entity_Database;
import Entity.Entity_User;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GUI_Cucian extends javax.swing.JFrame {
    boolean hasil;
    public Connection conn;
    public Statement stat;
    public ResultSet rs;
    
    DefaultTableModel model = new DefaultTableModel();
    
    private int idjenis;
    
    public GUI_Cucian() {
        initComponents();
        groupButton();
        this.setLocationRelativeTo(this);
        
        model = new DefaultTableModel();
        tblcucian.setModel(model);
        
        onCommand();
       
        model.addColumn("ID CUCI");
        model.addColumn("LAYANAN");
        model.addColumn("HARGA");
        
        try{
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tblcucian");
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("idjenis"), rs.getString("jeniscucian"), rs.getInt("harga")});
            }
        } catch(Exception e){
            
        }
        tblcucian.setModel(model);
    }
    
    ButtonGroup bg1 = new ButtonGroup();
    
     private void groupButton(){
        bg1.add(rbCuciKering);
        bg1.add(rbCuciBasah);
        bg1.add(rbCuSet);
        bg1.add(rbUSet);
        
     }
    
    private void deplace(int i){
        try{
            idjenis = Integer.parseInt(model.getValueAt(i,0).toString());
            txtid.setText(model.getValueAt(i,0).toString());
            String jenis = model.getValueAt(i, 1).toString();
            if(jenis.equals("Cuci Kering")){
             rbCuciKering.setSelected(true);
            }if(jenis.equals("Cuci Basah")){
             rbCuciBasah.setSelected(true);             
            }if(jenis.equals("Cuci Basah + Setrika")){
             rbCuSet.setSelected(true);
            }if(jenis.equals("Cuci Uap + Setrika")){
             rbUSet.setSelected(true);
            }
            txtharga.setText(model.getValueAt(i,2).toString());
            cmdupdate.setEnabled(true);
            cmddelete.setEnabled(true);
        } catch(Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error"+e.getLocalizedMessage());
        }
    }
    private void shutCommand(){
        
    }
    private void onCommand(){
        
    }
    
    private void refresh(){
        onCommand();
        
        
        txtid.setText("");
        bg1.clearSelection();
        txtharga.setText("");
        
        
        try{
            model.setRowCount(0);
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tblcucian");
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("idjenis"), rs.getString("jeniscucian"), rs.getInt("harga")});
            }
        } catch(Exception e) {
            System.err.println(e);
            tblcucian.setModel(model);
        }
    }
    private void setId(){
        try {
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            String sql = "SELECT * FROM tblcucian ORDER BY idjenis DESC";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                int id = Integer.parseInt(rs.getString("idjenis"))+1;
                txtid.setText(Integer.toString(id));
                idjenis = id;
            }else{
                txtid.setText("1");
                idjenis=1;
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

        txtid = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        cmddelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmdcancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcucian = new javax.swing.JTable();
        cmdinsert = new javax.swing.JButton();
        cmdupdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmdsave = new javax.swing.JButton();
        rbCuciKering = new javax.swing.JRadioButton();
        rbCuciBasah = new javax.swing.JRadioButton();
        rbCuSet = new javax.swing.JRadioButton();
        rbUSet = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Cucian");
        setMinimumSize(new java.awt.Dimension(740, 375));
        setName("formcucian"); // NOI18N
        setResizable(false);

        txtid.setEditable(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });

        cmddelete.setText("Delete");
        cmddelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmddeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("Jenis Service");

        cmdcancel.setText("Cancel");
        cmdcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Harga / KG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("SERVICE MANAGEMENT");

        tblcucian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblcucian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcucianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcucian);

        cmdinsert.setText("Add");
        cmdinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdinsertActionPerformed(evt);
            }
        });

        cmdupdate.setText("Edit");
        cmdupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdupdateActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Service");

        cmdsave.setText("Save");
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
            }
        });

        rbCuciKering.setText("Cuci Kering");
        rbCuciKering.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                rbCuciKeringComponentMoved(evt);
            }
        });
        rbCuciKering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCuciKeringActionPerformed(evt);
            }
        });

        rbCuciBasah.setText("Cuci Basah");
        rbCuciBasah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCuciBasahActionPerformed(evt);
            }
        });

        rbCuSet.setText("Cuci Basah + Setrika");
        rbCuSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCuSetActionPerformed(evt);
            }
        });

        rbUSet.setText("Cuci + Setrika Uap");
        rbUSet.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                rbUSetComponentMoved(evt);
            }
        });
        rbUSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUSetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbCuciKering, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbCuciBasah, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbCuSet)
                                    .addComponent(rbUSet)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmdsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(89, 89, 89)
                                        .addComponent(cmdcancel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmdinsert)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmddelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdupdate))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rbCuciKering))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCuciBasah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCuSet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbUSet)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmdinsert, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmddelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmddeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmddeleteActionPerformed
    int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to delete this data?", "Warning", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            Entity_Cucian cucian = new Entity_Cucian();
            cucian.setIdjenis(idjenis);

            Control_Cucian control = new Control_Cucian();
            control.deleteCucian(cucian);
            refresh();
        }else{
            
        }
    }//GEN-LAST:event_cmddeleteActionPerformed

    private void cmdcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcancelActionPerformed
        onCommand();
        refresh();
    }//GEN-LAST:event_cmdcancelActionPerformed

    private void tblcucianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcucianMouseClicked
         txtid.setEditable(false);
         
         int i = tblcucian.getSelectedRow();
         TableModel model = tblcucian.getModel();
         txtid.setText(model.getValueAt(i,0).toString());
         String jenis = model.getValueAt(i, 1).toString();
         if(jenis.equals("Cuci Kering")){
             rbCuciKering.setSelected(true);
         }if(jenis.equals("Cuci Basah")){
             rbCuciBasah.setSelected(true);             
         }if(jenis.equals("Cuci Basah + Setrika")){
             rbCuSet.setSelected(true);
         }if(jenis.equals("Cuci Uap + Setrika")){
             rbUSet.setSelected(true);
         }
         txtharga.setText(model.getValueAt(i,2).toString());
    }//GEN-LAST:event_tblcucianMouseClicked

    private void cmdinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdinsertActionPerformed

        setId();
        shutCommand();
        String jenis = "";
        if(rbCuciKering.isSelected()){
            jenis = "Cuci Kering";
        } else if(rbCuciBasah.isSelected()){
            jenis = "Cuci Basah";
        } else if (rbCuSet.isSelected()){
           jenis = "Cuci Basah + Setrika";
        } else if (rbUSet.isSelected()){
            jenis = "Cuci Uap + Setrika";
        }
        txtharga.setText("");
        
    }//GEN-LAST:event_cmdinsertActionPerformed

    private void cmdupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdupdateActionPerformed
        String jenis = "";
        if(rbCuciKering.isSelected()){
            jenis = "Cuci Kering";
        } else if(rbCuciBasah.isSelected()){
            jenis = "Cuci Basah";
        } else if (rbCuSet.isSelected()){
           jenis = "Cuci Basah + Setrika";
        } else if (rbUSet.isSelected()){
            jenis = "Cuci Uap + Setrika";
        }
        int i = tblcucian.getSelectedRow();
        if(txtharga.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong");
        }
        else{
        Entity_Cucian cucian = new Entity_Cucian();
        cucian.setIdjenis(idjenis);
        cucian.setJeniscucian(jenis);
        if(rbCuciKering.isSelected()){
            jenis = "Cuci Kering";
        } else if(rbCuciBasah.isSelected()){
            jenis = "Cuci Basah";
        } else if (rbCuSet.isSelected()){
           jenis = "Cuci Basah + Setrika";
        } else if (rbUSet.isSelected()){
            jenis = "Cuci Uap + Setrika";
        }
        cucian.setHarga(Integer.parseInt(txtharga.getText().trim()));
        
        Control_Cucian control = new Control_Cucian();
        control.updateCucian(cucian);
        refresh();
        }
    }//GEN-LAST:event_cmdupdateActionPerformed

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        String jenis = "";
        if(rbCuciKering.isSelected()){
            jenis = "Cuci Kering";
        } else if(rbCuciBasah.isSelected()){
            jenis = "Cuci Basah";
        } else if (rbCuSet.isSelected()){
           jenis = "Cuci Basah + Setrika";
        } else if (rbUSet.isSelected()){
            jenis = "Cuci Uap + Setrika";
            JOptionPane.showMessageDialog(null,"Jenis Cucian tidak boleh kosong");
        }
         if(txtharga.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong");
        }
        else{
        Entity_Cucian cucian = new Entity_Cucian();
        cucian.setIdjenis(idjenis);
        cucian.setJeniscucian(jenis);
        if(rbCuciKering.isSelected()){
            jenis = "Cuci Kering";
        } else if(rbCuciBasah.isSelected()){
            jenis = "Cuci Basah";
        } else if (rbCuSet.isSelected()){
           jenis = "Cuci Basah + Setrika";
        } else if (rbUSet.isSelected()){
            jenis = "Cuci + Setrika Uap";
        }
        cucian.setHarga(Integer.parseInt(txtharga.getText().trim()));
        
        
        Control_Cucian control = new Control_Cucian();
        control.insertCucian(cucian);
        refresh();
        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void rbCuciKeringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCuciKeringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCuciKeringActionPerformed

    private void rbUSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUSetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbUSetActionPerformed

    private void rbCuciKeringComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_rbCuciKeringComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCuciKeringComponentMoved

    private void rbCuSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCuSetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCuSetActionPerformed

    private void rbCuciBasahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCuciBasahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCuciBasahActionPerformed

    private void rbUSetComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_rbUSetComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_rbUSetComponentMoved

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
            java.util.logging.Logger.getLogger(GUI_Cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Cucian().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCuSet;
    private javax.swing.JRadioButton rbCuciBasah;
    private javax.swing.JRadioButton rbCuciKering;
    private javax.swing.JRadioButton rbUSet;
    private javax.swing.JTable tblcucian;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables


}
