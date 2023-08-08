package stok;

/**
 *
 * @author emirc
 */
public class Stok {
    
    private String StokKodu;
    private String StokAdi;
    private int StokTipi;
    private String Birimi;
    private String Barkodu;
    private Double KDVTipi;
    private String Aciklama;
    private String Tarih;

    public Stok(String StokKodu, String StokAdi, int StokTipi, String Birimi, String Barkodu, Double KDVTipi, String Aciklama, String Tarih) {
        this.StokKodu = StokKodu;
        this.StokAdi = StokAdi;
        this.StokTipi = StokTipi;
        this.Birimi = Birimi;
        this.Barkodu = Barkodu;
        this.KDVTipi = KDVTipi;
        this.Aciklama = Aciklama;
        this.Tarih = Tarih;
    }

    public String getStokKodu() {
        return StokKodu;
    }

    public void setStokKodu(String StokKodu) {
        this.StokKodu = StokKodu;
    }

    public String getStokAdi() {
        return StokAdi;
    }

    public void setStokAdi(String StokAdi) {
        this.StokAdi = StokAdi;
    }

    public int getStokTipi() {
        return StokTipi;
    }

    public void setStokTipi(int StokTipi) {
        this.StokTipi = StokTipi;
    }

    public String getBirimi() {
        return Birimi;
    }

    public void setBirimi(String Birimi) {
        this.Birimi = Birimi;
    }

    public String getBarkodu() {
        return Barkodu;
    }

    public void setBarkodu(String Barkodu) {
        this.Barkodu = Barkodu;
    }

    public Double getKDVTipi() {
        return KDVTipi;
    }

    public void setKDVTipi(Double KDVTipi) {
        this.KDVTipi = KDVTipi;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String Aciklama) {
        this.Aciklama = Aciklama;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String Tarih) {
        this.Tarih = Tarih;
    }

    

}