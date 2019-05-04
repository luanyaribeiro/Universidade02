package repositories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
/*
* Author
* https://howtodoinjava.com/hibernate/hibernate-insert-query-tutorial/
* Classe baseada em tutorial encontrado no link acima
*
* */
public class HibernateDAO {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            return new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml")).buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}
