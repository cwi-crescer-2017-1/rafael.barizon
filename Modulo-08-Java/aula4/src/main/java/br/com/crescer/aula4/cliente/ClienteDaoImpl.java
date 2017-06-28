/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.cliente;

import br.com.crescer.aula4.EntityManagerUtils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class ClienteDaoImpl implements ClienteDao {

    @Override
    public void insert(Cliente cliente) {
        final EntityManagerFactory emf = new EntityManagerUtils().getEntityManagerFactory();
        final EntityManager em = new EntityManagerUtils().getEntityManager(emf);
        final Cliente cli = cliente;        
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();

        em.close();
        emf.close();
        //new EntityManagerUtils().close(em, emf);
    }

    @Override
    public void update(Cliente cliente) {
        final EntityManagerFactory emf = new EntityManagerUtils().getEntityManagerFactory();
        final EntityManager em = new EntityManagerUtils().getEntityManager(emf);

        final Cliente update = em.find(Cliente.class, cliente.getId());
        em.detach(update);
        update.setNome(cliente.getNome());
        
        em.getTransaction().begin();
        em.merge(update);
        em.getTransaction().commit();
        
        //new EntityManagerUtils().close(em, emf);
        em.close();
        emf.close();
    }

    @Override
    public void delete(Cliente cliente) {
        final EntityManagerFactory emf = new EntityManagerUtils().getEntityManagerFactory();
        final EntityManager em = new EntityManagerUtils().getEntityManager(emf);
        final Cliente excluir = em.find(Cliente.class, cliente.getId());
        
        em.getTransaction().begin();
        em.remove(excluir);
        em.getTransaction().commit();
        
        //new EntityManagerUtils().close(em, emf);
        em.close();
        emf.close();
    }

    @Override
    public Cliente loadBy(Long id) {
        final EntityManagerFactory emf = new EntityManagerUtils().getEntityManagerFactory();
        final EntityManager em = new EntityManagerUtils().getEntityManager(emf);
        final Cliente cli = em.find(Cliente.class, id);
        //new EntityManagerUtils().close(em, emf);
        
        em.close();
        emf.close();
        return cli;
    }
    
}
