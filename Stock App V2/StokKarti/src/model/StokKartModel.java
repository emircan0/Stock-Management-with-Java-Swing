package model;

import hibernate.HibernateUtil;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
@Table(name = "alanadi")
public class StokKartModel implements Serializable {

    @Id
    @Column(name = "StokKodu")
    private String StokKodu;

    @Column(name = "StokAdi")
    private String StokAdi;

    @Column(name = "StokTipiKodu")
    private int StokTipiKodu;

    @Column(name = "Birimi")
    private String Birimi;

    @Column(name = "Barkodu")
    private String Barkodu;

    @Column(name = "KDVTipiKodu")
    private Double KDVTipiKodu;

    @Column(name = "Aciklama")
    private String Aciklama;

    @Column(name = "OlusturmaTarihi")
    private String Tarih;
    

    public StokKartModel(String StokKodu, String StokAdi, int StokTipiKodu, String Birimi, 
            String Barkodu, Double KDVTipiKodu, String Aciklama, String Tarih) {
        
        this.StokKodu = StokKodu;
        this.StokAdi = StokAdi;
        this.StokTipiKodu = StokTipiKodu;
        this.Birimi = Birimi;
        this.Barkodu = Barkodu;
        this.KDVTipiKodu = KDVTipiKodu;
        this.Aciklama = Aciklama;
        this.Tarih = Tarih;

        
    }
    
    
    
    public StokKartModel(){
        
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
        return StokTipiKodu;
    }

    public void setStokTipi(int StokTipiKodu) {
        this.StokTipiKodu = StokTipiKodu;
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
        return KDVTipiKodu;
    }

    public void setKDVTipi(Double KDVTipi) {
        this.KDVTipiKodu = KDVTipiKodu;
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
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(this);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    } catch (HibernateException ex) {
        ex.printStackTrace();
    }
}


    public void stokVeritabanindanSil() {
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(this);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    } catch (HibernateException ex) {
        ex.printStackTrace();
    }
}


    public void stokVeritabanindaGuncelle() {
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(this);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    } catch (HibernateException ex) {
        ex.printStackTrace();
    }
}


   public static List<StokKartModel> BindList() {
    List<StokKartModel> stokList = new ArrayList<>();
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            stokList = session.createQuery("FROM StokKartModel", StokKartModel.class).getResultList();
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
    return stokList;
}


    public StokKartModel beforeNextStock(String secim, int i) {
    StokKartModel stock = null;
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            TypedQuery<StokKartModel> query = null;
            if (secim.equals("next")) {
                query = session.createQuery("FROM StokKartModel s WHERE s.StokKodu > :i ORDER BY s.StokKodu ASC", StokKartModel.class);
            } else if (secim.equals("before")) {
                query = session.createQuery("FROM StokKartModel s WHERE s.StokKodu < :i ORDER BY s.StokKodu DESC", StokKartModel.class);
            }

            if (query != null) {
                query.setParameter("i", i);
                query.setMaxResults(1);
                stock = query.getSingleResult();
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
    return stock;
}
    
     public static StokKartModel getFirstStock() {
    StokKartModel firstStock = null;
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            firstStock = session.createQuery("FROM StokKartModel S ORDER BY S.StokKodu ASC", StokKartModel.class)
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
    return firstStock;
}
     
     public static StokKartModel getLastStock() {
    StokKartModel lastStock = null;
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            lastStock = session.createQuery("FROM StokKartModel S ORDER BY S.StokKodu DESC", StokKartModel.class)
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
    return lastStock;
}

public StokKartModel getAdjacentStock(String currentStokKodu, boolean isNext) {
    StokKartModel stock = null;
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            String queryStr = isNext ? "FROM StokKartModel s WHERE s.StokKodu > :stokKodu ORDER BY s.StokKodu ASC" : "FROM StokKartModel s WHERE s.StokKodu < :stokKodu ORDER BY s.StokKodu DESC";
            TypedQuery<StokKartModel> query = session.createQuery(queryStr, StokKartModel.class);
            query.setParameter("stokKodu", currentStokKodu);
            query.setMaxResults(1);
            stock = query.getSingleResult();
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
    return stock;
}

public static List<StokKartModel> getStokKartListWithJoin() {
    List<StokKartModel> stokKartList = null;
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            stokKartList = session.createQuery("SELECT s FROM StokKartModel s JOIN s.kdvTipi k JOIN s.stokTipi t", StokKartModel.class).getResultList();
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
    return stokKartList;
}





}