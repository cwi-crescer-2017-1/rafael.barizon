/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.repository.UsersocialRepository;
import br.com.crescer.social.entity.Usersocial;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barizon
 */
@Service
public class UsersocialService {

    @Autowired
    private UsersocialRepository usersocialRepository; 
    
    public void save(Usersocial u) {
        usersocialRepository.save(u);
    }
  
    public Usersocial findByUsername(String username) {
        return usersocialRepository.findOneByUsername(username);
    }

    public void remove(Usersocial us) {
        usersocialRepository.delete(us);
    }
    
}
