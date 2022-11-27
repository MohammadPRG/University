package Repository;

import Connection.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Repository<E> {
    private List<E> Db = new ArrayList<E>();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public boolean create(E e) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            return true;

        } catch (Exception ex) {
            System.out.println("Transaction is roll back.");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public E read(Class<E> type, int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            E e = session.get(type, id);
            session.getTransaction().commit();
            return e;

        } catch (Exception ex) {
            System.out.println("Transaction is roll back.");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }

    }

    public boolean delete(Class<E> type, int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            E e = session.get(type, id);
            session.delete(e);
            session.getTransaction().commit();
            return true;

        } catch (Exception ex) {
            System.out.println("Transaction is roll back.");
            session.getTransaction().rollback();
            return false;

        } finally {
            session.close();
        }
    }

    public boolean update(Class<E> type, int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Object object = session.get(type, id);
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            return true;

        } catch (Exception ex) {
            System.out.println("Transaction is roll back.");
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public List<E> loadAll(String name){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createNativeQuery("select * from " + name);
            List result = query.list();
            session.getTransaction().commit();
            return result;

        } catch (Exception ex) {
            System.out.println("Transaction is roll back.");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
