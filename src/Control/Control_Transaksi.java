package Control;
import java.sql.*;
import Entity.Entity_Database;
import Entity.Entity_Transaksi;
import javax.swing.JOptionPane;
public class Control_Transaksi {
    public static void main(String[] args){
    
    }
    Connection conn;
    Statement stat;
    ResultSet res;
    
    public Control_Transaksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dblaundry", "root", "");
            stat = conn.createStatement();
            System.out.println("Connection Succeed");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void insertTransaksi(Entity_Transaksi transaksi){
        String addtransaksi = "INSERT INTO tbltransaksi VALUES('"+transaksi.getIdtransaksi()+"','"
                + transaksi.getTglorder()+"','"
                + transaksi.getTglselesai()+"','"
                + transaksi.getBerat()+"','"
                + transaksi.getTotalharga()+"','"
                + transaksi.getBayar()+"','"
                + transaksi.getKembalian()+"','"
                + transaksi.getIdjeniscuci()+"','"
                + transaksi.getIdpel()+"','"
                + transaksi.getUsername()+"')";
        try{
            stat.executeUpdate(addtransaksi);
            JOptionPane.showMessageDialog(null, "Successfully added data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+ "Failed to add data");
        }
    }
}
