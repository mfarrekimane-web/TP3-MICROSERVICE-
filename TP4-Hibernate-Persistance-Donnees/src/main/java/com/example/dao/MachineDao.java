package com.example.dao;

import com.example.entities.Machine;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.query.Query;
public class MachineDao implements IDao<Machine> {
    public List<Machine> findByMarque(String marque) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Machine> query = session.createQuery(
                    "from Machine m where m.marque = :marque", Machine.class);
            query.setParameter("marque", marque);
            return query.list();
        }
    }

    @Override
    public boolean create(Machine o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw new RuntimeException("Erreur transactionnelle : " + e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Machine o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw new RuntimeException("Erreur transactionnelle : " + e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Machine o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw new RuntimeException("Erreur transactionnelle : " + e.getMessage(), e);
        }
    }

    @Override
    public Machine getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Machine.class, id);
        }
    }

    @Override
    public List<Machine> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Machine", Machine.class).list();
        }
    }
}