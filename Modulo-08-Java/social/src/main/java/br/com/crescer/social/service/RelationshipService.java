/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Relationship;
import br.com.crescer.social.entity.RelationshipPK;
import br.com.crescer.social.entity.RelationshipStatus;
import br.com.crescer.social.repository.RelationshipRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barizon
 */
@Service
public class RelationshipService {

    @Autowired
    private RelationshipRepository relationshipRepository; 
    
    public ArrayList<Relationship> getAll(BigDecimal id_user) {
        return (ArrayList<Relationship>)relationshipRepository.findByUserprofile1_idUserAndRelationshipStatus(id_user, RelationshipStatus.accepted);
    }

    public void save(Relationship us) {
        us.setRelationshipStatus(RelationshipStatus.pending);
        relationshipRepository.save(us);
        RelationshipPK pk2 = new RelationshipPK(us.getRelationshipPK().getIdUserRelationship(), us.getRelationshipPK().getIdUser());
        Relationship us2 = new Relationship(pk2, RelationshipStatus.received);
        relationshipRepository.save(us2);
    }
    
    public void update(Relationship us){
        relationshipRepository.save(us);
        RelationshipPK pk2 = new RelationshipPK(us.getRelationshipPK().getIdUserRelationship(), us.getRelationshipPK().getIdUser());
        Relationship us2 = new Relationship(pk2, us.getRelationshipStatus());
        relationshipRepository.save(us2);
    }
}
