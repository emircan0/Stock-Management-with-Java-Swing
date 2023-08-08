package model;

import command.StokListCommand;
import dbHelper.DbHelper;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class KdvTipiModel implements Serializable {

    private int KdvTipiID;
    private String KdvTipiKodu;
    private String KdvTipiAdi;
    private Double KdvTipiOrani;
    private StokListCommand arrayListCont;
    private int i=0;
   

    public KdvTipiModel(String KdvTipiKodu, String KdvTipiAdi, Double KdvTipiOrani) {
        this.KdvTipiKodu = KdvTipiKodu;
        this.KdvTipiAdi = KdvTipiAdi;
        this.KdvTipiOrani = KdvTipiOrani;
        
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    

    public  int getKdvTipiID() {
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

    public void setArrayListCont(StokListCommand arrayListCont) {
        this.arrayListCont = arrayListCont;
    }
     
       // KDV tiplerini veritabanından alarak JComboBox'a ekleyen fonksiyon
   public static void getKDVTipiList(JComboBox<String> boxKDVTipi) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    DbHelper dbHelper = new DbHelper();

    try {
        connection = dbHelper.getConnection();
        String sql = "SELECT kdvTipiKodu FROM kdvtipi"; // KDV tiplerinin bulunduğu tablo adını buraya yazın
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();

        // Veritabanından çekilen KDV tiplerini JComboBox'a ekleyin
        while (resultSet.next()) {
            String kdvTipi = resultSet.getString("kdvTipiKodu");
            boxKDVTipi.addItem(kdvTipi);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } 
}

    public void kdvVeritabaninaEkle() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "INSERT INTO kdvtipi (kdvTipiKodu, kdvTipiAdi, kdvTipiOrani) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

           
            statement.setString(1, KdvTipiKodu);
            statement.setString(2, KdvTipiAdi);
            statement.setDouble(3, KdvTipiOrani);

            int result = statement.executeUpdate();

            // Otomatik olarak oluşturulan ID'yi al
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int generatedID = resultSet.getInt(1);
                System.out.println("Oluşturulan ID: " + generatedID);
            }

            
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        } finally {
            
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
    
      public void kdvVeritabaninaSil() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "DELETE FROM kdvtipi WHERE kdvTipiKodu = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, KdvTipiKodu);

            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("KDV Tipi başarıyla silindi.");
            } else {
                System.out.println("KDV Tipi silinemedi.");
            }
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        } finally {
            // Kaynakları kapatma
            try {
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

   
    public KdvTipiModel beforNextStock(String secim, int i) {
         
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DbHelper dbHelper = new DbHelper();

        PreparedStatement pr = null;
        KdvTipiModel stock = null;
        ResultSet rs = null;
        String query = null;
         
         
        if (secim.equals("first")) {
            query = "SELECT * FROM kdvtipi ORDER BY kdvTipiID ASC LIMIT 1;";
        } else if (secim.equals("last")) {
            query = "SELECT * FROM kdvtipi ORDER BY kdvTipiID DESC LIMIT 1;";
        } else if (secim.equals("next")) {
            query = "SELECT * FROM kdvtipi WHERE kdvTipiID = (SELECT min(kdvTipiID) FROM kdvtipi WHERE kdvTipiID > " + i + ");";          
        } else if (secim.equals("before")) {
            query = "SELECT * FROM kdvtipi WHERE kdvTipiID = (SELECT max(kdvTipiID) FROM kdvtipi WHERE kdvTipiID < " + i + ");";
            
        }

         try {
        pr = dbHelper.getConnection().prepareStatement(query);
        rs = pr.executeQuery();
        if (rs.next()) {
                int kdvTipiID = rs.getInt("KdvTipiID");
                String kdvTipiKodu = rs.getString("kdvTipiKodu");
                String kdvTipiAdi = rs.getString("kdvTipiAdi");
                Double kdvTipiOrani = rs.getDouble("kdvTipiOrani");

                stock = new KdvTipiModel(kdvTipiKodu, kdvTipiAdi, kdvTipiOrani);
                stock.setKdvTipiID(kdvTipiID);
                
                setI(kdvTipiID);
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
