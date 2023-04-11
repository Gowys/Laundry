package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Entity_Database {
    public static Connection conn=null;
    public static Statement stat=null;
    public ResultSet res=null;
    
    public static Connection getConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dblaundry", "root", "");
            stat = conn.createStatement();
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }
    
}
