/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Relationship;
import br.com.crescer.social.entity.RelationshipStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.barizon
 */
public interface RelationshipRepository extends CrudRepository<Relationship, Long>{
         
    List<Relationship> findByUserprofile1_idUserAndRelationshipStatus
        (BigDecimal id_user, RelationshipStatus relationshipStatus);
        
        
    ArrayList<Relationship> findByUserprofile1_idUser(BigDecimal id_user);

    public ArrayList<Relationship> findByUserprofile1_idUserAndRelationshipStatusNotLike(BigDecimal id_user, RelationshipStatus relationshipStatus);

//    public ArrayList<Relationship> findByUserprofile1_idUserNotRelationshipStatus(BigDecimal id_user, RelationshipStatus relationshipStatus);
}
