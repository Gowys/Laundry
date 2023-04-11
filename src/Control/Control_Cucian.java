package Control;
import java.sql.*;
import Entity.Entity_Database;
import Entity.Entity_Cucian;
import javax.swing.JOptionPane;
public class Control_Cucian {
    public static void main(String[] args){
    
    }
    Connection conn;
    Statement stat;
    ResultSet res;
    
    public Control_Cucian(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dblaundry", "root", "");
            stat = conn.createStatement();
            System.out.println("Connection Succeed");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void insertCucian(Entity_Cucian cucian){
        String addcucian = "INSERT INTO tblcucian VALUES('"
                + cucian.getIdjenis()+"','"
                + cucian.getJeniscucian()+"','"
                + cucian.getHarga()+"')";
        try{
            stat.executeUpdate(addcucian);
            JOptionPane.showMessageDialog(null, "Successfully added data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Failed to add data");
        }
    }
    
    public void updateCucian(Entity_Cucian cucian){
        try{
            stat.executeUpdate("UPDATE tblcucian SET jeniscucian='"
                +cucian.getJeniscucian()+"', harga='"
                +cucian.getHarga()+"' WHERE idjenis='"+cucian.getIdjenis()+"'");
            JOptionPane.showMessageDialog(null, "Successfully Edit data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Failed to Edit data");
        }
        
    }
    public void deleteCucian(String idjenis){
        try{
            stat.executeUpdate("DELETE FROM tblcucian WHERE idjenis= "+idjenis+"'");
            JOptionPane.showMessageDialog(null, "Data has been Removed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data has been Removed");
        }
    }

    public void deleteCucian(Entity_Cucian cucian) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
