/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barizon
 * @param <Entity>
 * @param <ID>
 */
@Service
public abstract interface GenericService <Entity, ID> {
    
    Entity save(Entity e);

    void remove(Entity e);

    Entity loadById(ID id);

    List<Entity> findAll();
}
