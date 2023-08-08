package model;


import hibernate.HibernateUtil;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "stoktipi")
public class StokTipiModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StokTipiID")
    private int StokTipiID;

    @Column(name = "StokTipiKodu")
    private String StokTipiKodu;

    @Column(name = "StokTipiAdi")
    private String StokTipiAdi;

    @Column(name = "StokTipiAciklama")
    private String StokTipiAciklama;

    public StokTipiModel() {
    }

    public StokTipiModel(String StokTipiKodu, String StokTipiAdi, String StokTipiAciklama) {
        this.StokTipiKodu = StokTipiKodu;
        this.StokTipiAdi = StokTipiAdi;
        this.StokTipiAciklama = StokTipiAciklama;
    }

    public int getStokTipiID() {
        return StokTipiID;
    }

    public void setStokTipiID(int StokTipiID) {
        this.StokTipiID = StokTipiID;
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

    public void stokTipiVeritabaninaEkle() {
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                session.save(this); // StokTipiModel nesnesini veritabanına ekleme
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

    public void stokTipiVeritabanindanSil() {
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                session.delete(this); // StokTipiModel nesnesini veritabanından silme
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

    public static List<StokTipiModel> BindList() {
        List<StokTipiModel> stokTipiList = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                stokTipiList = session.createQuery("FROM StokTipiModel", StokTipiModel.class).getResultList();
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
        return stokTipiList;
    }

    public StokTipiModel beforeNextStock(String secim, int i) {
        StokTipiModel stokTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                TypedQuery<StokTipiModel> query = null;
                if (secim.equals("next")) {
                    query = session.createQuery("FROM StokTipiModel s WHERE s.StokTipiID > :i ORDER BY s.StokTipiID ASC", StokTipiModel.class);
                } else if (secim.equals("before")) {
                    query = session.createQuery("FROM StokTipiModel s WHERE s.StokTipiID < :i ORDER BY s.StokTipiID DESC", StokTipiModel.class);
                }

                if (query != null) {
                    query.setParameter("i", i);
                    query.setMaxResults(1);
                    stokTipi = query.getSingleResult();
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
        return stokTipi;
    }

    public static StokTipiModel getFirstStokTipi() {
        StokTipiModel firstStokTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                firstStokTipi = session.createQuery("FROM StokTipiModel s ORDER BY s.StokTipiID ASC", StokTipiModel.class)
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
        return firstStokTipi;
    }

    public static StokTipiModel getLastStokTipi() {
        StokTipiModel lastStokTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                lastStokTipi = session.createQuery("FROM StokTipiModel s ORDER BY s.StokTipiID DESC", StokTipiModel.class)
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
        return lastStokTipi;
    }

    public StokTipiModel getAdjacentStokTipi(int currentStokTipiID, boolean isNext) {
        StokTipiModel stokTipi = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();
                String queryStr = isNext ? "FROM StokTipiModel s WHERE s.StokTipiID > :stokTipiID ORDER BY s.StokTipiID ASC" : "FROM StokTipiModel s WHERE s.StokTipiID < :stokTipiID ORDER BY s.StokTipiID DESC";
                TypedQuery<StokTipiModel> query = session.createQuery(queryStr, StokTipiModel.class);
                query.setParameter("stokTipiID", currentStokTipiID);
                query.setMaxResults(1);
                stokTipi = query.getSingleResult();
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
        return stokTipi;
    }
    
    public static void getStokipiList(JComboBox<String> boxStokTipi) {
    try {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            List<StokTipiModel> stokTipiList = session.createQuery("FROM StokTipiModel", StokTipiModel.class).getResultList();
            session.getTransaction().commit();

            for (StokTipiModel stokTipiModel : stokTipiList) {
                String stokTipi = stokTipiModel.getStokTipiKodu();
                boxStokTipi.addItem(stokTipi);
            }
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
}
