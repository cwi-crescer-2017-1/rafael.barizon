package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Relationship;
import br.com.crescer.social.entity.RelationshipPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.social.service.RelationshipService;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Barizon
 */
@RestController
@RequestMapping("/relationship")
public class RelationshipRest {

    @Autowired
    private RelationshipService relationshipService;

    @PostMapping("/relationshipRequest")
    public void relationshipRequest(@RequestBody Relationship us) {
        relationshipService.save(us);
    }
    
    
    @PostMapping("/relationshipUpdate")
    public void relationshipUpdate(@RequestBody Relationship us) {
        relationshipService.update(us);
    }
    
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ArrayList<Relationship> findAll(@PathVariable(value = "id") BigDecimal idUser) {
        System.out.println("he.loo");
        
        return relationshipService.getAllRelationshipsForUser(idUser);
    }

}
