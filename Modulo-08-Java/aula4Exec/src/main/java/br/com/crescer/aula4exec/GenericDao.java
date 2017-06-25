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
public class GenericDao<T, ID> implements CrudDao<T, ID>{

    
    
    private final Class<T> entity;
    
    public GenericDao(Class<T> entity){
        this.entity = entity;
    }
    
    @Override
    public T save(T e) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        final Session session = em.unwrap(Session.class);
        em.getTransaction().begin();
        session.save(e);
        em.getTransaction().commit();
        
        
        em.close();
        emf.close();
        return e;
    }

    @Override
    public void remove(T e) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        final Session session = em.unwrap(Session.class);
        em.getTransaction().begin();
        session.delete(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public T loadById(ID id) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        final Session session = em.unwrap(Session.class);
        em.getTransaction().begin();
        T t = em.find(entity, id);
        em.close();
        emf.close();
        return t; 
    }

    @Override
    public List<T> findAll() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        final Session session = em.unwrap(Session.class);
        em.getTransaction().begin();
        List<T> listT = session.createCriteria(entity).list();
        em.close();
        emf.close();
        return listT;
    }
    
//    public void close(){
//        em.close();
//        em.getEntityManagerFactory().close();
//    }
}
