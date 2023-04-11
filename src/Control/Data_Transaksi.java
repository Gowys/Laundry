package Control;
import java.sql.*;
public class Data_Transaksi {
    public Connection conn;
    private String kolom[] = {"ID","PELANGGAN","TGL ORDER","TGL SELESAI","LAYANAN","BERAT(KG)","TOTAL","PETUGAS"};
    private java.util.Vector baris = new java.util.Vector();
    
    public Data_Transaksi(){
        getData(null);
    }
     public void finalize(){
        baris = null;
        conn = null;
    }
    public void getData(String kondisi){
        String query;
        
        query = "SELECT a.idtransaksi, b.namapelanggan, a.tglorder, a.tglselesai, c.jeniscucian, a.berat, a.totalharga, d.nama FROM tbltransaksi a, tblpelanggan b, tblcucian c, tbluser d WHERE a.idpel=b.idpelanggan AND a.idjeniscuci=c.idjenis AND a.username=d.username";
        try{
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet rs = statement.executeQuery(query);
            
            baris.removeAllElements();
            
            while(rs.next()){
                Object[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
                baris.addElement(row);
                row = null;
            }
        } catch(java.sql.SQLException e) {
            System.out.println("Error:" + e);
        }
        query = null;
    }
    public int getColumn(){
        return kolom.length;
    }
    public int getRow(){
        return baris.size();
    }
    public Object getCell(int i, int j){
        if(!baris.isEmpty()){
            Object row[] = (Object[])baris.elementAt(i);
            return row[j];
        }else{
            return null;
        }
    }
    public String getHeader(int j){
        return kolom[j];
    }
    public boolean cellEditable(int i, int j){
        return false;
    }
}
