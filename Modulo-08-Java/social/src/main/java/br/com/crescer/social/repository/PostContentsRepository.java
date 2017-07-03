/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Postcontents;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.barizon
 */
public interface PostContentsRepository extends CrudRepository<Postcontents, Long>{
 
    public ArrayList<Postcontents> findByUserProfile_idUser(BigDecimal l);
    
    
//    @Override
//    @Query("select p from Pessoa p where p.nome ...")
//    public List<Postcontents> findAll();

    public ArrayList<Postcontents>  findByUserProfile_idUserOrderByPublishDateDesc(BigDecimal id);

    public Postcontents findById(BigDecimal id);
}
