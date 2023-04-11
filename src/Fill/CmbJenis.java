package Fill;
public class CmbJenis {
public int idjns;
public String cuci;
public int hrg;
    
    public CmbJenis(int id, String cuci, int harga){
        this.idjns = id;
        this.cuci = cuci;
        this.hrg = harga;
    }
    
    public int getIdcuci(){
        return idjns;
    }
    
    public void setIdcuci(int id){
        this.idjns = id;
    }
    public String getCuci(){
        return cuci;
    }
    
    public void setCuci(String cuci){
        this.cuci = cuci;
    }
   
    public int getHarga(){
        return hrg;
    }
    
    public void setHarga(int harga){
        this.hrg = harga;
    }
    
}
