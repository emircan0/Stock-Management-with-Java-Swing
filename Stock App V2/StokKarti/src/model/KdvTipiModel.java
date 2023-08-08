package model;

import dbHelper.DbHelper;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import hibernate.HibernateUtil;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
@Table(name = "kdvtipi")
public class KdvTipiModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kdvTipiID")
    private int KdvTipiID;

    @Column(name = "kdvTipiKodu")
    private String KDVTipiKodu;

    @Column(name = "kdvTipiAdi")
    private String KdvTipiAdi;

    @Column(name = "kdvTipiOrani")
    private Double KdvTipiOrani;
    
    public KdvTipiModel() {
    }

    public KdvTipiModel(String KDVTipiKodu, String KdvTipiAdi, Double KdvTipiOrani) {
        this.KDVTipiKodu = KDVTipiKodu;
        this.KdvTipiAdi = KdvTipiAdi;
        this.KdvTipiOrani = KdvTipiOrani;
    }

    public int getKdvTipiID() {
        return KdvTipiID;
    }

    public void setKdvTipiID(int KdvTipiID) {
        this.KdvTipiID = KdvTipiID;
    }

    public String getKdvTipiKodu() {
        return KDVTipiKodu;
    }

    public void setKdvTipiKodu(String KDVTipiKodu) {
        this.KDVTipiKodu = KDVTipiKodu;
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
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                session.save(this); // KdvTipiModel nesnesini veritabanına ekleme
                session.getTransaction().commit();
            } catch (Exception ex) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public void kdvVeritabaninaSil() {
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                session.delete(this); // KdvTipiModel nesnesini veritabanından silme
                session.getTransaction().commit();
            } catch (Exception ex) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

   
     public static List<KdvTipiModel> BindList() {
        List<KdvTipiModel> kdvTipiList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                kdvTipiList = session.createQuery("FROM KdvTipiModel", KdvTipiModel.class).getResultList();
                session.getTransaction().commit();
            } catch (Exception ex) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return kdvTipiList;
    }

    public KdvTipiModel beforeNextStock(String secim, int i) {
        KdvTipiModel kdvTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                TypedQuery<KdvTipiModel> query = null;
                if (secim.equals("next")) {
                    query = session.createQuery("FROM KdvTipiModel k WHERE k.KdvTipiID > :i ORDER BY k.KdvTipiID ASC", KdvTipiModel.class);
                } else if (secim.equals("before")) {
                    query = session.createQuery("FROM KdvTipiModel k WHERE k.KdvTipiID < :i ORDER BY k.KdvTipiID DESC", KdvTipiModel.class);
                }

                if (query != null) {
                    query.setParameter("i", i);
                    query.setMaxResults(1);
                    kdvTipi = query.getSingleResult();
                }
                session.getTransaction().commit();
            } catch (Exception ex) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return kdvTipi;
    }

    public static KdvTipiModel getFirstKdvTipi() {
        KdvTipiModel firstKdvTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                firstKdvTipi = session.createQuery("FROM KdvTipiModel k ORDER BY k.KdvTipiID ASC", KdvTipiModel.class)
                        .setMaxResults(1)
                        .uniqueResult();
                session.getTransaction().commit();
            } catch (Exception ex) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return firstKdvTipi;
    }

    public static KdvTipiModel getLastKdvTipi() {
        KdvTipiModel lastKdvTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                lastKdvTipi = session.createQuery("FROM KdvTipiModel k ORDER BY k.KdvTipiID DESC", KdvTipiModel.class)
                        .setMaxResults(1)
                        .uniqueResult();
                session.getTransaction().commit();
            } catch (Exception ex) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return lastKdvTipi;
    }

    public KdvTipiModel getAdjacentKdvTipi(int currentKdvTipiID, boolean isNext) {
        KdvTipiModel kdvTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                String queryStr = isNext ? "FROM KdvTipiModel k WHERE k.KdvTipiID > :kdvTipiID ORDER BY k.KdvTipiID ASC" : "FROM KdvTipiModel k WHERE k.KdvTipiID < :kdvTipiID ORDER BY k.KdvTipiID DESC";
                TypedQuery<KdvTipiModel> query = session.createQuery(queryStr, KdvTipiModel.class);
                query.setParameter("kdvTipiID", currentKdvTipiID);
                query.setMaxResults(1);
                kdvTipi = query.getSingleResult();
                session.getTransaction().commit();
            } catch (Exception ex) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return kdvTipi;
    }
}
    
   
