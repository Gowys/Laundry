package Fill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public class QueryPelanggan {    
   public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dblaundry", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(QueryPelanggan.class.getName()).log(Level.SEVERE, null, ex);
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
           rs = st.executeQuery("SELECT idpelanggan, namapelanggan, notelp, alamat FROM tblpelanggan ORDER BY idpelanggan ASC");
           CmbPelanggan row;
           
           while(rs.next()){
               row = new CmbPelanggan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
               map.put(row.getNamapel(), row.getIdpel());
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(QueryPelanggan.class.getName()).log(Level.SEVERE, null, ex);
       }
      
       return map;
   }
}