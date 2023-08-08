package model;

import dbHelper.DbHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class StokTipiModel implements Serializable {
    private int StokTipiID;
    private String StokTipiKodu;
    private String StokTipiAdi;
    private String StokTipiAciklama;
    private int i = 0;

    public StokTipiModel(String StokTipiKodu, String StokTipiAdi, String StokTipiAciklama) {
        this.StokTipiKodu = StokTipiKodu;
        this.StokTipiAdi = StokTipiAdi;
        this.StokTipiAciklama = StokTipiAciklama;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
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

    public int getStokTipiID() {
        return StokTipiID;
    }

    public void setStokTipiID(int StokTipiID) {
        this.StokTipiID = StokTipiID;
    }

    public void stokTipiVeritabaninaEkle() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "INSERT INTO stoktipi (StokTipiKodu, StokTipiAdi, StokTipiAciklama) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, StokTipiKodu);
            statement.setString(2, StokTipiAdi);
            statement.setString(3, StokTipiAciklama);

            int result = statement.executeUpdate();
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

    public void stokTipiVeritabanindanSil() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "DELETE FROM stoktipi WHERE stokTipiKodu = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, StokTipiKodu);

            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Stok Tipi başarıyla silindi.");
            } else {
                System.out.println("Stok Tipi silinemedi.");
            }
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        } finally {
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

  

    public static void getStokipiList(JComboBox<String> boxStokTipi) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DbHelper dbHelper = new DbHelper();

        try {
            connection = dbHelper.getConnection();
            String sql = "SELECT StokTipiKodu FROM stoktipi";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String stokTipi = resultSet.getString("StokTipiKodu");
                boxStokTipi.addItem(stokTipi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

    public StokTipiModel beforeNextStock(String secim, int i) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DbHelper dbHelper = new DbHelper();

        StokTipiModel stock = null;
        String query = null;

        if (secim.equals("first")) {
            query = "SELECT * FROM stoktipi ORDER BY StokTipiID ASC LIMIT 1";
        } else if (secim.equals("last")) {
            query = "SELECT * FROM stoktipi ORDER BY StokTipiID DESC LIMIT 1";
        } else if (secim.equals("next")) {
            query = "SELECT * FROM stoktipi WHERE StokTipiID > " + i + " ORDER BY StokTipiID ASC LIMIT 1";
        } else if (secim.equals("before")) {
            query = "SELECT * FROM stoktipi WHERE StokTipiID < " + i + " ORDER BY StokTipiID DESC LIMIT 1";
        }

        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int stokTipiID = resultSet.getInt("StokTipiID");
                String stokTipiKodu = resultSet.getString("StokTipiKodu");
                String stokTipiAdi = resultSet.getString("StokTipiAdi");
                String stokTipiAciklama = resultSet.getString("StokTipiAciklama");

                stock = new StokTipiModel(stokTipiKodu, stokTipiAdi, stokTipiAciklama);
                stock.setStokTipiID(stokTipiID);
                
                setI(stokTipiID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stock;
    }
}
