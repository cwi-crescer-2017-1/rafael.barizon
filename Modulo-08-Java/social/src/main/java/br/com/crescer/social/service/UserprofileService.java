/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Userprofile;
import br.com.crescer.social.entity.Usersocial;
import br.com.crescer.social.repository.UserprofileRepository;
import br.com.crescer.social.repository.UsersocialRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barizon
 */
@Service
public class UserprofileService {

    @Autowired
    private UserprofileRepository userprofileRepository;
    @Autowired
    private UsersocialRepository usrep;

    public BigDecimal save(Userprofile up) {
        return userprofileRepository.save(up).getIdUser();
    }

    public Userprofile findOne(BigDecimal idUser) {
        return userprofileRepository.findOneByIdUser(idUser);
    }

    public void remove(Userprofile up) {
        userprofileRepository.delete(up);
    }

    public ArrayList<Userprofile> findByName(String name) {
        return userprofileRepository.findAllByName(name);
    }

    public Userprofile findOne(String username) {
        Usersocial us = usrep.findOneByUsername(username);
        
        return userprofileRepository.findOneByIdUser(us.getId());
    }

    public void update(Userprofile up) {
        Userprofile user = userprofileRepository.findOneByIdUser(up.getIdUser());
        user.setBirthday(up.getBirthday());
        user.setGender(up.getGender());
        user.setName(up.getName());
        userprofileRepository.save(user);
    }

}
