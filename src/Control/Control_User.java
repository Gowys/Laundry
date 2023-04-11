package Control;
import java.sql.*;
import Entity.Entity_Database;
import Entity.Entity_User;
import javax.swing.JOptionPane;
public class Control_User {
    public static void main(String[] args){
    
    }
    Connection conn;
    Statement stat;
    ResultSet res;
    
    public Control_User(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dblaundry", "root", "");
            stat = conn.createStatement();
            System.out.println("Connection Succeed");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void insertUser(Entity_User user){
        String adduser = "INSERT INTO tbluser VALUES('"
                + user.getUsername()+"','"
                + user.getPassword()+"','"
                + user.getAkses()+"','"
                + user.getNama()+"')";
        try{
            stat.executeUpdate(adduser);
            JOptionPane.showMessageDialog(null, "Successfully added data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to add data");
        }
    }
    
    public void updateUser(Entity_User user){
        try{
            stat.executeUpdate("UPDATE tbluser SET password='"
                +user.getPassword()+"', akses='"+
                user.getAkses()+"', nama='"+ user.getNama()+
                "' WHERE username='"+user.getUsername()+"'");
            JOptionPane.showMessageDialog(null, "Successfully Edit data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Failed to Edit data");
        }
    }
    public void updateUser2(Entity_User user){
        String akses = user.getAkses();
        String nama = user.getNama();
        String username = user.getUsername();
       
        try{
            stat.executeUpdate("UPDATE tbluser SET akses='"+ akses +"', nama='"+ nama +"' WHERE username='"+username+"'");
            JOptionPane.showMessageDialog(null, "Successfully Edit data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Edit data");
        }
    }
    public void deleteUser(Entity_User user){
        try{
            stat.executeUpdate("DELETE FROM tbluser WHERE username='"+user.getUsername()+"';");
            JOptionPane.showMessageDialog(null, "Data has been Removed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data has been Removed");
        }
    }
}
