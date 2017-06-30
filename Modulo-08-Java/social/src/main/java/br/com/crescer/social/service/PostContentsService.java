/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.controller.RelationshipRest;
import br.com.crescer.social.repository.PostContentsRepository;
import br.com.crescer.social.entity.Postcontents;
import br.com.crescer.social.entity.Userprofile;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barizon
 */
@Service
public class PostContentsService {

    @Autowired
    PostContentsRepository postContentsRepository;

    @Autowired
    RelationshipService relationshipService;

    public ArrayList<Postcontents> findAll(BigDecimal id_user) {
        ArrayList<Postcontents> posts = new ArrayList<>();
        relationshipService
                .getAll(id_user)
                .stream()
                .forEach((r) -> {
                    ArrayList<Postcontents> p;
                    p = postContentsRepository.findByUserProfile_idUser(BigDecimal.valueOf(r.getRelationshipPK().getIdUserRelationship().doubleValue()));
                    p.forEach(po -> {
                        Postcontents content = new Postcontents(po.getId(), po.getContent(), po.getNumberOfLikes(), po.getPublishDate());
                        Userprofile up = new Userprofile(po.getUserProfile().getIdUser(), null, 0, po.getUserProfile().getName());
                        content.setUserProfile(up);
                        posts.add(content);
                    });
                });
        Collections.sort(posts);
        return posts;
    }

}
