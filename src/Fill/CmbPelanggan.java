package Fill;
public class CmbPelanggan {
public int idpel;
public String namapel;
public String hppel;
public String alamatpel;
    
    public CmbPelanggan(int id, String nama, String hp, String alamat){
        this.idpel = id;
        this.namapel = nama;
        this.hppel = hp;
        this.alamatpel = alamat;
    }
    
    public int getIdpel(){
        return idpel;
    }
    
    public void setIdpel(int id){
        this.idpel = id;
    }
   
    public String getNamapel(){
        return namapel;
    }
    
    public void setNamapel(String nama){
        this.namapel = nama;
    }   
    
    public String getHppel(){
        return hppel;
    }
    
    public void setHppel(String hp){
        this.hppel = hp;
    }  
    
    public String getAlamatpel(){
        return alamatpel;
    }
    
    public void setAlamatpel(String alamat){
        this.alamatpel = alamat;
    }  
}
