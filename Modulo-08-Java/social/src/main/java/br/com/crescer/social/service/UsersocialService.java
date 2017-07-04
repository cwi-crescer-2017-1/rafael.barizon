/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.repository.UserprofileRepository;
import br.com.crescer.social.entity.Userprofile;
import br.com.crescer.social.repository.UsersocialRepository;
import br.com.crescer.social.entity.Usersocial;
import java.math.BigDecimal;
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
    
    
    public BigDecimal save(Usersocial u) {
        //Usersocial u =  up.getUsersocial();
        u.validate();
        return usersocialRepository.save(u).getId();
//        up.setIdUser(u.getId());
//        System.out.println(u.getId()+ " -- saber qual id");
//        up.setUsersocial(u);
//        System.out.println(up.toString());
//        userprofileRepository.save(up);
    }
    
    public void update(Usersocial u) {
        u.validate();
        Usersocial us;
        us = usersocialRepository.findOneById(u.getId());
        us.setPassword(u.getPassword());
        usersocialRepository.save(us);
    }
  
    public Usersocial findByUsername(String username) {
        return usersocialRepository.findOneByUsername(username);
    }

    public void remove(Usersocial us) {
        usersocialRepository.delete(us);
    }
    
}
