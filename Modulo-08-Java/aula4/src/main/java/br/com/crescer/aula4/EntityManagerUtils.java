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
    
    public EntityManager getEntityManager() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        return emf.createEntityManager();
    }

    public void close(EntityManager em) {
        em.close();
        em.getEntityManagerFactory().close();
    }
    
}
