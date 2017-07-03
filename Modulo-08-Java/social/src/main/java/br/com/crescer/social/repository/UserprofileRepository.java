/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Userprofile;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Barizon
 */
public interface UserprofileRepository  extends CrudRepository<Userprofile, Long>{

    public ArrayList<Userprofile> findAllByName(String name);
    
    public Userprofile findOneByIdUser(BigDecimal id);

    
}
