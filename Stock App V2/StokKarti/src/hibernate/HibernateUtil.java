    package hibernate;

import model.KdvTipiModel;
import model.StokKartModel;
import model.StokListelemeModeli;
import model.StokTipiModel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        try{
            SessionFactory sessionFactory = new  Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(KdvTipiModel.class)  
           // .addAnnotatedClass(StokKartModel.class)
           // .addAnnotatedClass(StokListelemeModeli.class)     
            .addAnnotatedClass(StokTipiModel.class)
            .buildSessionFactory();

            return sessionFactory;

        } catch (Exception e){
            e.printStackTrace();

            System.out.println("Session factory oluşturulurken hata oluştu" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

  
}