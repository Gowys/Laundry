package Fill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryJenis { 
   public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dblaundry", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(QueryJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

   public HashMap<String, Integer> populateCombo(){
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      Connection con = getConnection();
      Statement st;
      ResultSet rs;
      
       try {
           st = con.createStatement();
           rs = st.executeQuery("SELECT idjenis, jeniscucian, harga FROM tblcucian ORDER BY idjenis ASC");
           CmbJenis row;
           
           while(rs.next()){
               row = new CmbJenis(rs.getInt(1), rs.getString(2), rs.getInt(3));
               map.put(row.getCuci(), row.getIdcuci());
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(QueryJenis.class.getName()).log(Level.SEVERE, null, ex);
       }
      
       return map;
   }
}    
