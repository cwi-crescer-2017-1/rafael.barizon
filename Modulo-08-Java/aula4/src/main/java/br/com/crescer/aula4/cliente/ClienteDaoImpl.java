/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.cliente;

import br.com.crescer.aula4.EntityManagerUtils;
import javax.persistence.EntityManager;


public class ClienteDaoImpl implements ClienteDao {

    @Override
    public void insert(Cliente cliente) {
        EntityManagerUtils emu = new EntityManagerUtils();
        final EntityManager em = emu.getEntityManager();
                
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        emu.close(em);
    }

    @Override
    public void update(Cliente cliente) {
        EntityManagerUtils emu = new EntityManagerUtils();
        final EntityManager em = emu.getEntityManager();

        final Cliente update = em.find(Cliente.class, cliente.getId());
        em.detach(update);
        update.setNome(cliente.getNome());
        
        em.getTransaction().begin();
        em.merge(update);
        em.getTransaction().commit();
        
        emu.close(em);
        
    }

    @Override
    public void delete(Cliente cliente) {
        EntityManagerUtils emu = new EntityManagerUtils();
        final EntityManager em = emu.getEntityManager();
        final Cliente excluir = em.find(Cliente.class, cliente.getId());
        
        em.getTransaction().begin();
        em.remove(excluir);
        em.getTransaction().commit();
        
        emu.close(em);
    }

    @Override
    public Cliente loadBy(Long id) {
        EntityManagerUtils emu = new EntityManagerUtils();
        final EntityManager em = emu.getEntityManager();
        final Cliente cli = em.find(Cliente.class, id);
        emu.close(em);
        return cli;
    }
    
}
