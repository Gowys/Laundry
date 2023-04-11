package Entity;
public class Entity_Transaksi {
    public static void main(String[] args){
    
    }
    int idtransaksi;
    String tglorder;
    String tglselesai;
    int berat;
    int totalharga;
    int bayar;
    int kembalian;
    int idjeniscuci;
    int idpel;
    String username;
    
    public void setIdtransaksi(int idtransaksi){
        this.idtransaksi = idtransaksi;
    }
    public void setTglorder(String tglorder){
        this.tglorder = tglorder;
    }
    public void setTglselesai(String tglselesai){
        this.tglselesai = tglselesai;
    }
    public void setBerat(int berat){
        this.berat = berat;
    }
    public void setTotalharga(int totalharga){
        this.totalharga = totalharga;
    }
    public void setBayar(int bayar){
        this.bayar = bayar;
    }
    public void setKembalian(int kembalian){
        this.kembalian = kembalian;
    }
    public void setIdjeniscuci(int idjeniscuci){
        this.idjeniscuci = idjeniscuci;
    }
    public void setIdpel(int idpel){
        this.idpel = idpel;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public int getIdtransaksi(){
        return idtransaksi;
    }
    public String getTglorder(){
        return tglorder;
    }
    public String getTglselesai(){
        return tglselesai;
    }
    public int getBerat(){
        return berat;
    }
    public int getTotalharga(){
        return totalharga;
    }
    public int getBayar(){
        return bayar;
    }
    public int getKembalian(){
        return kembalian;
    }
    public int getIdjeniscuci(){
        return idjeniscuci;
    }
    public int getIdpel(){
        return idpel;
    }
    public String getUsername(){
        return username;
    }

}
