/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author Barizon
 * @param <T>
 * @param <ID>
 */
public class GenericDao<T, ID> implements CrudDao<T, ID> {

    private final Class<T> entity;
    private EntityManagerFactory emf;
    private EntityManager em;
    private Session session;

    private void start() {
        emf = Persistence.createEntityManagerFactory("CRESCER");
        em = emf.createEntityManager();
        session = em.unwrap(Session.class);
    }

    private void finish() {
        em.close();
        emf.close();
    }

    public GenericDao(Class<T> entity) {
        this.entity = entity;
    }

    @Override
    public T save(T e) {
        start();
        em.getTransaction().begin();
        session.save(e);
        em.getTransaction().commit();
        
        finish();
        return e;
    }

    @Override
    public void remove(T e) {
        start();
        em.getTransaction().begin();
        em.remove(em.contains(e) ? e : em.merge(e)); //session.delete(e);
        em.getTransaction().commit();
        finish();
    }

    @Override
    public T loadById(ID id) {
        start();
        em.getTransaction().begin();
        T t = em.find(entity, id);
        finish();
        return t;
    }

    @Override
    public List<T> findAll() {
        start();
        em.getTransaction().begin();
        List<T> listT = session.createCriteria(entity).list();
        finish();
        return listT;
    }

}
