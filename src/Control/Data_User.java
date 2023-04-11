package Control;
import java.sql.*;

public class Data_User {

public Connection conn;
private String kolom[] = {"USERNAME","AKSES","NAMA LENGKAP"};
private java.util.Vector baris = new java.util.Vector();

    public Data_User(){
        getData(null);
    }
    public void finalize(){
        baris = null;
        conn = null;
    }
    public void getData(String kondisi){
        String query;
        
        query = "SELECT p.username, p.akses, p.nama FROM tbluser p";
        try{
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet rs = statement.executeQuery(query);
            
            baris.removeAllElements();
            
            while(rs.next()){
                Object[] row = {rs.getString(1), rs.getString(2), rs.getString(3)};
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
