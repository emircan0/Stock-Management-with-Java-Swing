
package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dbHelper.DbHelper;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


public class StokListelemeModeli {

    private String StokKodu;
    private String StokAdi;
    private int StokTipi;
    private String Birimi;
    private String Barkodu;
    private Double KDVTipi;
    private String Aciklama;
    private String Tarih;

    private int StokTipiId;
    private String StokTipiKodu;
    private String StokTipiAdi;
    private String StokTipiAciklama;

    private int KdvTipiID;
    private String KdvTipiKodu;
    private String KdvTipiAdi;
    private Double KdvTipiOrani;

    public StokListelemeModeli(String StokKodu, String StokAdi, int StokTipi, String Birimi,
            String Barkodu, Double KDVTipi, String Aciklama, String Tarih, int StokTipiId,
            String StokTipiKodu, String StokTipiAdi, String StokTipiAciklama, int KdvTipiID, String KdvTipiKodu,
            String KdvTipiAdi, Double KdvTipiOrani) {
        this.StokKodu = StokKodu;
        this.StokAdi = StokAdi;
        this.StokTipi = StokTipi;
        this.Birimi = Birimi;
        this.Barkodu = Barkodu;
        this.KDVTipi = KDVTipi;
        this.Aciklama = Aciklama;
        this.Tarih = Tarih;
        this.StokTipiId = StokTipiId;
        this.StokTipiKodu = StokTipiKodu;
        this.StokTipiAdi = StokTipiAdi;
        this.StokTipiAciklama = StokTipiAciklama;
        this.KdvTipiID = KdvTipiID;
        this.KdvTipiKodu = KdvTipiKodu;
        this.KdvTipiAdi = KdvTipiAdi;
        this.KdvTipiOrani = KdvTipiOrani;

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

    public int getStokTipiId() {
        return StokTipiId;
    }

    public void setStokTipiId(int StokTipiId) {
        this.StokTipiId = StokTipiId;
    }

    public String getStokTipiKodu() {
        return StokTipiKodu;
    }

    public void setStokTipiKodu(String StokTipiKodu) {
        this.StokTipiKodu = StokTipiKodu;
    }

    public String getStokTipiAdi() {
        return StokTipiAdi;
    }

    public void setStokTipiAdi(String StokTipiAdi) {
        this.StokTipiAdi = StokTipiAdi;
    }

    public String getStokTipiAciklama() {
        return StokTipiAciklama;
    }

    public void setStokTipiAciklama(String StokTipiAciklama) {
        this.StokTipiAciklama = StokTipiAciklama;
    }

    public int getKdvTipiID() {
        return KdvTipiID;
    }

    public void setKdvTipiID(int KdvTipiID) {
        this.KdvTipiID = KdvTipiID;
    }

    public String getKdvTipiKodu() {
        return KdvTipiKodu;
    }

    public void setKdvTipiKodu(String KdvTipiKodu) {
        this.KdvTipiKodu = KdvTipiKodu;
    }

    public String getKdvTipiAdi() {
        return KdvTipiAdi;
    }

    public void setKdvTipiAdi(String KdvTipiAdi) {
        this.KdvTipiAdi = KdvTipiAdi;
    }

    public Double getKdvTipiOrani() {
        return KdvTipiOrani;
    }

    public void setKdvTipiOrani(Double KdvTipiOrani) {
        this.KdvTipiOrani = KdvTipiOrani;
    }
    


     public ArrayList<StokListelemeModeli> getStok() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<StokListelemeModeli> stoks = null;

        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM stok.alanadi LEFT JOIN stok.stoktipi ON "
                    + "stok.alanadi.StokTipi = stok.stoktipi.stokTipiKodu LEFT JOIN stok.kdvtipi ON"
                    + " stok.alanadi.KDVTipi = stok.kdvtipi.kdvTipiKodu;;";
            resultSet = statement.executeQuery(sql);
            stoks = new ArrayList<>();
            while (resultSet.next()) {
                StokListelemeModeli stok = new StokListelemeModeli(
                        resultSet.getString("StokKodu"),
                        resultSet.getString("StokAdi"),
                        resultSet.getInt("StokTipi"),
                        resultSet.getString("Birimi"),
                        resultSet.getString("Barkodu"),
                        resultSet.getDouble("KDVTipi"),
                        resultSet.getString("Aciklama"),
                        resultSet.getString("OlusturmaTarihi"),
                        resultSet.getInt("stokTipiId"),
                        resultSet.getString("stokTipiKodu"),
                        resultSet.getString("stokTipiAdi"),
                        resultSet.getString("stokTipiAciklama"),
                        resultSet.getInt("kdvTipiID"),
                        resultSet.getString("kdvTipiKodu"),
                        resultSet.getString("kdvTipiAdi"),
                        resultSet.getDouble("kdvTipiOrani")
                );
                stoks.add(stok);
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
            }
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
        return stoks;
    }
    
    

}
