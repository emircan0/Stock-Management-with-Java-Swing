package model;

import java.io.Serializable;
import command.StokListCommand;
import dbHelper.DbHelper;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StokKartModel implements Serializable {

    private String StokKodu;
    private String StokAdi;
    private int StokTipi;
    private String Birimi;
    private String Barkodu;
    private Double KDVTipi;
    private String Aciklama;
    private String Tarih;
    private int i =0;

    public StokKartModel(String StokKodu, String StokAdi, int StokTipi, String Birimi,
            String Barkodu, Double KDVTipi, String Aciklama, String Tarih) {
        this.StokKodu = StokKodu;
        this.StokAdi = StokAdi;
        this.StokTipi = StokTipi;
        this.Birimi = Birimi;
        this.Barkodu = Barkodu;
        this.KDVTipi = KDVTipi;
        this.Aciklama = Aciklama;
        this.Tarih = Tarih;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
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
    
    public void stokVeritabaninaEkle() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "INSERT INTO alanadi (StokKodu, StokAdi, StokTipi, Birimi, Barkodu, KDVTipi, Aciklama, OlusturmaTarihi) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Use the setter methods of PreparedStatement to set the values
            statement.setString(1, StokKodu);
            statement.setString(2, StokAdi);
            statement.setInt(3, StokTipi);
            statement.setString(4, Birimi);
            statement.setString(5, Barkodu);
            statement.setDouble(6, KDVTipi);
            statement.setString(7, Aciklama);
            statement.setString(8, Tarih);

            int result = statement.executeUpdate();

            // Otomatik olarak oluşturulan ID'yi al
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int generatedID = resultSet.getInt(1);
                System.out.println("Oluşturulan ID: " + generatedID);
            }

            //arrayListCont.execute(); // Tabloyu güncelle
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        } finally {
            // Kaynakları kapatma
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stokVeritabanindanSil() {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbHelper.getConnection();
            String sql = "DELETE FROM alanadi WHERE StokKodu = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, StokKodu);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Silme işlemi sırasında bir hata oluştu
            e.printStackTrace();
        } 
    }
    public void stokVeritabanindaGuncelle() {
       
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbHelper.getConnection();
            String sql = "UPDATE alanadi SET StokAdi = ?, StokTipi = ?, Birimi = ?, Barkodu = ?, KDVTipi = ?, Aciklama = ?, OlusturmaTarihi = ? WHERE StokKodu = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, StokAdi);
            preparedStatement.setInt(2, StokTipi);
            preparedStatement.setString(3, Birimi);
            preparedStatement.setString(4, Barkodu);
            preparedStatement.setDouble(5, KDVTipi);
            preparedStatement.setString(6, Aciklama);
            preparedStatement.setString(7, Tarih);
            preparedStatement.setString(8, StokKodu);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Güncelleme işlemi sırasında bir hata oluştu
            e.printStackTrace();
        } 
    }
    
    public static ArrayList<StokKartModel> BindList() throws SQLException {
        ArrayList<StokKartModel> stokList = new ArrayList<>();
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "SELECT * FROM alanadi";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String stokKodu = resultSet.getString("StokKodu");
                String stokAdi = resultSet.getString("StokAdi");
                int stokTipi = resultSet.getInt("StokTipi");
                String birimi = resultSet.getString("Birimi");
                String barkodu = resultSet.getString("Barkodu");
                double kdvTipi = resultSet.getDouble("KDVTipi");
                String aciklama = resultSet.getString("Aciklama");
                String tarih = resultSet.getString("OlusturmaTarihi");

                StokKartModel stok = new StokKartModel(stokKodu, stokAdi, stokTipi, birimi, barkodu, kdvTipi, aciklama, tarih);
                stokList.add(stok);
            }
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        } finally {
            // Kaynakları kapatma
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stokList;
    }
    public StokKartModel beforNextStock(String secim, int i) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DbHelper dbHelper = new DbHelper();

        PreparedStatement pr = null;
        StokKartModel stock = null;
        ResultSet rs = null;
        String query = null;

        if (secim.equals("first")) {
            query = "SELECT * FROM alanadi ORDER BY StokKodu ASC LIMIT 1;";
        } else if (secim.equals("last")) {
            query = "SELECT * FROM alanadi ORDER BY StokKodu DESC LIMIT 1;";
        } else if (secim.equals("next")) {
            query = "SELECT * FROM alanadi WHERE StokKodu = (SELECT min(StokKodu) FROM alanadi WHERE StokKodu > '" + i + "');";
        } else if (secim.equals("before")) {
            query = "SELECT * FROM alanadi WHERE StokKodu = (SELECT max(StokKodu) FROM alanadi WHERE StokKodu < '" + i + "');";

        }

        try {
            pr = dbHelper.getConnection().prepareStatement(query);
            rs = pr.executeQuery();
            if (rs.next()) {
                String stokKodu = rs.getString("StokKodu");
                String stokAdi = rs.getString("StokAdi");
                int stokTipi = rs.getInt("StokTipi");
                String birimi = rs.getString("Birimi");
                String barkodu = rs.getString("Barkodu");
                Double kdvTipi = rs.getDouble("KDVTipi");
                String aciklama = rs.getString("Aciklama");
                String tarih = rs.getString("OlusturmaTarihi");

                stock = new StokKartModel(stokKodu, stokAdi, stokTipi, birimi, barkodu, kdvTipi, aciklama, tarih);
                stock.setStokKodu(stokKodu);
                
                setI(Integer.parseInt(stokKodu));
                
            }   
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pr.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stock;
    }
    
    
    
}
