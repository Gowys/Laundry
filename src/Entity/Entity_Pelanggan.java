package Entity;
public class Entity_Pelanggan {
    public static void main(String[] args){
    
    }
    int idpelanggan;
    String namapelanggan;
    String notelp;
    String alamat;
    
    String ip;
    String np;
    String hp;
    String almt;
    
    public void setIdpelanggan(int idpelanggan){
        this.idpelanggan = idpelanggan;
    }
    public void setNamapelanggan(String namapelanggan){
        this.namapelanggan = namapelanggan;
    }
    public void setNotelp(String notelp){
        this.notelp = notelp;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public int getIdpelanggan(){
        return idpelanggan;
    }
    public String getNamapelanggan(){
        return namapelanggan;
    }
    public String getNotelp(){
        return notelp;
    }
    public String getAlamat(){
        return alamat;
    }
    
    public void setIp(String ip){
        this.ip = ip;
    }
    public void setNp(String np){
        this.np = np;
    }
    public void setHp(String hp){
        this.hp = hp;
    }
    public void setAlmt(String almt){
        this.almt = almt;
    }
    public String getIp(){
        return ip;
    }
    public String getNp(){
        return np;
    }
    public String getHp(){
        return hp;
    }
    public String getAlmt(){
        return almt;
    }
    
    @Override
    public String toString(){
        return np;
    }
}
