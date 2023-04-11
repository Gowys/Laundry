package Control;
import java.sql.*;
import Entity.Entity_Database;
import Entity.Entity_Pelanggan;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Control_Pelanggan {
    public static void main(String[] args){
    
    }
    Connection conn;
    PreparedStatement prepstat;
    Statement stat;
    ResultSet res;
   
    public Control_Pelanggan(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dblaundry", "root", "");
            stat = conn.createStatement();
            System.out.println("Connection Succeed");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void insertPlg(Entity_Pelanggan plg){
        String addplg = "INSERT INTO tblpelanggan VALUES('"
                +plg.getIdpelanggan()+"','"
                + plg.getNamapelanggan()+"','"
                + plg.getNotelp()+"','"
                + plg.getAlamat()+"')";
        try{
            stat.executeUpdate(addplg);
            JOptionPane.showMessageDialog(null, "Successfully added data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to add data");
        }
    }
    
    public void updatePlg(Entity_Pelanggan plg){
        try{
            stat.executeUpdate("UPDATE tblpelanggan SET namapelanggan='"
                + plg.getNamapelanggan()+"', notelp='"
                + plg.getNotelp()+"', alamat='"
                + plg.getAlamat()+
                "' WHERE idpelanggan='"+plg.getIdpelanggan()+"'");
            JOptionPane.showMessageDialog(null, "Successfully Edit data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Edit data");
        }
    }
    
    public void deletePlg(Entity_Pelanggan plg){
        try{
            stat.executeUpdate("DELETE FROM tblpelanggan WHERE idpelanggan='"+plg.getIdpelanggan()+"';");
            JOptionPane.showMessageDialog(null, "Data has been Removed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data has been Removed");
        }
    }
}
