/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Usersocial;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.barizon
 */
public interface UsersocialRepository extends CrudRepository<Usersocial, Long>{

    public Usersocial findOneByUsername(String username);
}
