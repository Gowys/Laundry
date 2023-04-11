package VIew;
import Control.Control_Transaksi;
import Entity.Entity_Transaksi;
import Entity.Entity_Database;
import Fill.QueryPelanggan;
import Fill.QueryJenis;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class GUI_Transaksi extends javax.swing.JFrame {
    
    public Connection conn;
    public Statement stat;
    public ResultSet rs;
    
    DefaultTableModel model = new DefaultTableModel();
    
    private int idtrans;
    private int idpelanggan;
    private int idcuci;
    
    private int berat;
    private int harga;
    private int totalharga;
    private int bayar;
    private int kembalian;
    
    public String user;
    String tgl;
    PreparedStatement prepstat;

    public GUI_Transaksi() {
    
    }

    GUI_Transaksi(String username) {
        initComponents();
        this.setLocationRelativeTo(this);
        txtidjenis.setVisible(false);
        cmbjenis.setEnabled(false);
        berat = 0;
        onCommand();
        
        System.out.println(user);
        model.addColumn("ID");
        model.addColumn("PELANGGAN");
        model.addColumn("TGL ORDER");
        model.addColumn("TGL SELESAI");
        model.addColumn("JENIS CUCI");
        model.addColumn("BERAT(Kg)");
        model.addColumn("TOTAL");
        model.addColumn("KASIR");
        
        try{
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tbltransaksi tran, tbluser usr, tblcucian cuci, tblpelanggan plg WHERE tran.uname=usr.username AND tran.idjeniscuci=cuci.idjenis AND tran.idpel=plg.idpelanggan");
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("idtransaksi"), rs.getString("namapelanggan"), rs.getString("tglorder"), rs.getString("tglselesai"), rs.getString("jeniscucian"), rs.getString("berat"), rs.getString("totalharga"), rs.getString("nama")});
            }
        } catch(Exception e){
            
        }
        tbltransaksi.setModel(model);
        this.user = username;
    }
    public void fillPelanggan(){
        QueryPelanggan mq = new QueryPelanggan();
        HashMap<String, Integer> map = mq.populateCombo();
        for(String row : map.keySet()){
        }
    }
    public void fillCucian(){
        cmbjenis.removeAllItems();
        QueryJenis mq = new QueryJenis();
        HashMap<String, Integer> map = mq.populateCombo();
        for(String row : map.keySet()){
            cmbjenis.addItem(row);
        }
    }
    private void fillText(){
        try {
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            String sql = "SELECT notelp, alamat FROM tblpelanggan WHERE idpelanggan='"+ idpelanggan +"'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
           
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            
        }
    }
    private void fillHarga(){
        try {
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            String sql = "SELECT harga FROM tblcucian WHERE idjenis='"+ idcuci +"'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
            txtharga.setText(rs.getString(1));
            harga = rs.getInt(1);
            }
            rs.close();
            stat.close();
            if(berat == 0){
                
            }else{
                totalharga = harga * berat;
                txttotal.setText(Integer.toString(totalharga));
                if(bayar == 0){
                    
                }else{
                    kembalian = bayar - totalharga;
                    txtkembalian.setText(Integer.toString(bayar - totalharga));
                    
                }
            }
        } catch (Exception e) {
            
        }
    }
    private void shutCommand(){
        cmdinsert.setVisible(false);
        cmdsave.setVisible(true);
        cmdcancel.setVisible(true);
    }
    private void onCommand(){
        cmdinsert.setVisible(true);
        cmdsave.setVisible(false);
        cmdcancel.setVisible(false);
    }
    
    private void setNull(){
        
        cmbjenis.setEnabled(false);
        
        txtidtransaksi.setText("");
        
        
        
        txtidjenis.setText("");
        txtharga.setText("");
        txtberat.setText("");
        
        tglselesai.setCalendar(null);
        
        txttotal.setText("");
        txtbayar.setText("");
        txtkembalian.setText("");
    }
    private void refresh(){
        onCommand();
        cmdinsert.setVisible(true);
        cmdsave.setVisible(false);
        cmdcancel.setVisible(false);
        
        try{
            model.setRowCount(0);
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            rs = stat.executeQuery("SELECT * FROM tbltransaksi tran, tbluser usr, tblcucian cuci, tblpelanggan plg WHERE tran.uname=usr.username AND tran.idjeniscuci=cuci.idjenis AND tran.idpel=plg.idpelanggan");
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("idtransaksi"), rs.getString("namapelanggan"), rs.getString("tglorder"), rs.getString("tglselesai"), rs.getString("jeniscucian"), rs.getString("berat"), rs.getString("totalharga"), rs.getString("nama")});
            }
        } catch(Exception e){
            System.err.println(e);
            tbltransaksi.setModel(model);
        }
    }
    private void setId(){
        try {
            Statement stat = (Statement)Entity_Database.getConn().createStatement();
            String sql = "SELECT * FROM tbltransaksi ORDER BY idtransaksi DESC";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                int id = Integer.parseInt(rs.getString("idtransaksi"))+1;
                txtidtransaksi.setText(Integer.toString(id));
                idtrans= id;
            }else{
                txtidtransaksi.setText("1");
                idtrans=1;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtidtransaksi = new javax.swing.JTextField();
        cmbjenis = new javax.swing.JComboBox<>();
        txtidjenis = new javax.swing.JTextField();
        txtberat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        tglselesai = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        cmdinsert = new javax.swing.JButton();
        cmdcancel = new javax.swing.JButton();
        cmdsave = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cmdlogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TRANSACTION MANAGEMENT");
        setMinimumSize(new java.awt.Dimension(870, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbltransaksi.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tbltransaksi);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 76, 830, 190);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("TRANSAKSI");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(276, 11, 330, 59);

        jLabel1.setText("ID Transaksi");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 300, 70, 16);

        jLabel2.setText("Pelanggan");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 335, 60, 16);

        jLabel7.setText("Tanggal Selesai");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(339, 405, 80, 16);

        jLabel8.setText("Jenis Layanan");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(339, 301, 80, 16);

        jLabel9.setText("Berat (Kg)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(339, 370, 60, 16);

        txtidtransaksi.setEditable(false);
        txtidtransaksi.setBackground(new java.awt.Color(255, 255, 255));
        txtidtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidtransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(txtidtransaksi);
        txtidtransaksi.setBounds(101, 297, 45, 22);

        cmbjenis.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbjenisPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbjenisActionPerformed(evt);
            }
        });
        cmbjenis.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbjenisPropertyChange(evt);
            }
        });
        getContentPane().add(cmbjenis);
        cmbjenis.setBounds(434, 297, 160, 22);

        txtidjenis.setEditable(false);
        txtidjenis.setBackground(new java.awt.Color(255, 255, 255));
        txtidjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidjenisActionPerformed(evt);
            }
        });
        getContentPane().add(txtidjenis);
        txtidjenis.setBounds(562, 337, 25, 22);

        txtberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtberatActionPerformed(evt);
            }
        });
        txtberat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtberatKeyReleased(evt);
            }
        });
        getContentPane().add(txtberat);
        txtberat.setBounds(434, 367, 85, 22);

        jLabel10.setText("Harga / Kg");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(339, 340, 70, 16);

        txtharga.setEditable(false);
        txtharga.setBackground(new java.awt.Color(255, 255, 255));
        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtharga);
        txtharga.setBounds(434, 337, 85, 22);
        getContentPane().add(tglselesai);
        tglselesai.setBounds(434, 405, 160, 22);

        jLabel11.setText("Total Harga");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(660, 301, 60, 16);

        jLabel13.setText("Kembalian");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(660, 378, 60, 16);

        txttotal.setEditable(false);
        txttotal.setBackground(new java.awt.Color(255, 255, 255));
        txttotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotalKeyReleased(evt);
            }
        });
        getContentPane().add(txttotal);
        txttotal.setBounds(752, 298, 100, 22);

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        txtbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbayarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbayar);
        txtbayar.setBounds(752, 337, 100, 22);

        txtkembalian.setEditable(false);
        txtkembalian.setBackground(new java.awt.Color(255, 255, 255));
        txtkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembalianActionPerformed(evt);
            }
        });
        getContentPane().add(txtkembalian);
        txtkembalian.setBounds(752, 375, 100, 22);

        cmdinsert.setBackground(new java.awt.Color(217, 215, 241));
        cmdinsert.setText("ADD");
        cmdinsert.setBorderPainted(false);
        cmdinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdinsertActionPerformed(evt);
            }
        });
        getContentPane().add(cmdinsert);
        cmdinsert.setBounds(101, 443, 97, 41);

        cmdcancel.setBackground(new java.awt.Color(217, 215, 241));
        cmdcancel.setText("CANCEL");
        cmdcancel.setBorderPainted(false);
        cmdcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdcancel);
        cmdcancel.setBounds(613, 443, 75, 41);

        cmdsave.setBackground(new java.awt.Color(217, 215, 241));
        cmdsave.setText("SAVE");
        cmdsave.setBorderPainted(false);
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
            }
        });
        getContentPane().add(cmdsave);
        cmdsave.setBounds(514, 443, 72, 41);

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch);
        txtsearch.setBounds(101, 335, 167, 22);

        jPanel1.setBackground(new java.awt.Color(246, 251, 244));

        jLabel12.setText("Pembayaran");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(537, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(156, 156, 156))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 750, 510);

        cmdlogout.setBackground(new java.awt.Color(102, 102, 0));
        cmdlogout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmdlogout.setForeground(new java.awt.Color(255, 51, 51));
        cmdlogout.setText("Logout");
        cmdlogout.setBorderPainted(false);
        cmdlogout.setContentAreaFilled(false);
        cmdlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(cmdlogout);
        cmdlogout.setBounds(740, 20, 71, 21);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdinsertActionPerformed

        cmbjenis.setEnabled(true);
        fillPelanggan();
        fillCucian();
        
        shutCommand();
        setId();
        System.out.println(user);
        cmbjenis.setSelectedIndex(0);
        txtberat.setText("");
        
        tglselesai.setCalendar(null);
        
        txttotal.setText("");
        txtbayar.setText("");
        txtkembalian.setText("");
        
    }//GEN-LAST:event_cmdinsertActionPerformed

    private void txtidjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidjenisActionPerformed

    private void txtberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtberatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtberatActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbayarActionPerformed

    private void txtkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembalianActionPerformed

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        long millis=System.currentTimeMillis();  
        java.sql.Date order = new java.sql.Date(millis);
        
        DateFormat formattgl = new SimpleDateFormat("yyy-MM-dd");
        tgl = formattgl.format(tglselesai.getDate()).toString();
        

        Entity_Transaksi transaksi = new Entity_Transaksi();
        transaksi.setIdtransaksi(idtrans);
        transaksi.setTglorder(order.toString());
        transaksi.setTglselesai(tgl);
        transaksi.setBerat(Integer.parseInt(txtberat.getText().trim()));
        transaksi.setTotalharga(Integer.parseInt(txtharga.getText()));
        transaksi.setBayar(Integer.parseInt(txtbayar.getText()));
        transaksi.setKembalian(Integer.parseInt(txtkembalian.getText()));
        transaksi.setIdjeniscuci(Integer.parseInt(txtidjenis.getText()));
        transaksi.setUsername(user);
        
        Control_Transaksi control = new Control_Transaksi();
        control.insertTransaksi(transaksi);
        refresh();
        cmbjenis.removeAllItems();
        setNull();
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void txtidtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidtransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidtransaksiActionPerformed

    private void cmbjenisPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbjenisPropertyChange
       
    }//GEN-LAST:event_cmbjenisPropertyChange

    private void cmbjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbjenisActionPerformed

    private void cmdcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcancelActionPerformed
        
        cmbjenis.removeAllItems();
        setNull();
        onCommand();
    }//GEN-LAST:event_cmdcancelActionPerformed

    private void cmbjenisPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbjenisPopupMenuWillBecomeInvisible
        QueryJenis qj = new QueryJenis();
        HashMap<String, Integer> map = qj.populateCombo();
        txtidjenis.setText(map.get(cmbjenis.getSelectedItem().toString()).toString());
        
        int id = map.get(cmbjenis.getSelectedItem().toString());
        idcuci = id;
        fillHarga();
    }//GEN-LAST:event_cmbjenisPopupMenuWillBecomeInvisible

    private void txtberatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtberatKeyReleased
        this.berat = Integer.parseInt(txtberat.getText().trim());
        totalharga = berat * harga;
        txttotal.setText(Integer.toString(totalharga));
        if(bayar==0){
        
        }else{
            txtkembalian.setText(Integer.toString(bayar - totalharga));
            kembalian = Integer.parseInt(txtkembalian.getText());
        }
    }//GEN-LAST:event_txtberatKeyReleased

    private void txtbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbayarKeyReleased
        bayar = Integer.parseInt(txtbayar.getText().trim());
        kembalian = bayar - totalharga;
        txtkembalian.setText(String.valueOf(kembalian));
        
    }//GEN-LAST:event_txtbayarKeyReleased

    private void txttotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyReleased
        txtkembalian.setText(Integer.toString(totalharga - bayar));
    }//GEN-LAST:event_txttotalKeyReleased

    private void cmdlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdlogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Anda ingin keluar dari aplikasi?",
            "Confirm",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else{
        
        }
    }//GEN-LAST:event_cmdlogoutActionPerformed

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
                                       
        String cari = txtsearch.getText();
        TableRowSorter tr = new TableRowSorter(model);
        tbltransaksi.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(cari));
    
    }//GEN-LAST:event_txtsearchKeyReleased

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
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Transaksi().setVisible(true);
            }
        });
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbjenis;
    private javax.swing.JButton cmdcancel;
    private javax.swing.JButton cmdinsert;
    private javax.swing.JButton cmdlogout;
    private javax.swing.JButton cmdsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltransaksi;
    private com.toedter.calendar.JDateChooser tglselesai;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtberat;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtidjenis;
    private javax.swing.JTextField txtidtransaksi;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
