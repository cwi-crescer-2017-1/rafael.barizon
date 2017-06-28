/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafael.barizon
 */
public class EntityManagerUtils {
    
    public EntityManagerFactory  getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("CRESCER");
    }
    public EntityManager getEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }

    public void close(EntityManager em, EntityManagerFactory emf) {
        em.close();
        emf.close();
    }
    
}
