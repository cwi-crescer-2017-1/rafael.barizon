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
import br.com.crescer.social.repository.UserprofileRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    @Autowired
    UserprofileRepository rep;

    public ArrayList<Postcontents> findAllFeedPosts(BigDecimal id_user) {
        ArrayList<Postcontents> posts = new ArrayList<>();
        relationshipService
                .getAll(id_user)
                .stream()
                .forEach((r) -> {
                    ArrayList<Postcontents> p;
                    p = postContentsRepository.findByUserProfile_idUser(BigDecimal.valueOf(r.getRelationshipPK().getIdUserRelationship().doubleValue()));
                    p.forEach(po -> {
                        posts.add(po);
                    });
                });
        postContentsRepository.findByUserProfile_idUser(id_user)
                .stream()
                .forEach((post) -> {
                    posts.add(post);
                });
                
        Collections.sort(posts);
        return posts;
    }

    public ArrayList<Postcontents> findAllForId(BigDecimal id) {
        ArrayList<Postcontents> p = new ArrayList<>();
        postContentsRepository.findByUserProfile_idUserOrderByPublishDateDesc(id).forEach(po -> {
            Postcontents content = new Postcontents(po.getId(), po.getContent(), po.getNumberOfLikes(), po.getPublishDate());
            Userprofile up = new Userprofile(po.getUserProfile().getIdUser(), null, 0, po.getUserProfile().getName());
            content.setUserProfile(up);
            p.add(content);
        });
        return p;
    }

    public void save(Postcontents c) {
        postContentsRepository.save(c);
    }

    public void remove(BigDecimal id) {
        postContentsRepository.delete(id.longValue());
    }

//    public void update(BigDecimal id) {
//        Postcontents post = postContentsRepository.findOne(id);
//        post.setNumberOfLikes();
//        postContentsRepository.save(post);
//    }

    public void setLikes(BigDecimal id, BigDecimal idUser) {
        Postcontents post = postContentsRepository.findById(id);
        Userprofile up = rep.findOneByIdUser(idUser);
        
        post.addLike(up);
        postContentsRepository.save(post);
    }

    public void setLikes(Postcontents post) {
//        Userprofile up = rep.findOneByIdUser(post.getUserProfile().getIdUser());
//        Postcontents p = postContentsRepository.findById(post.getId());
//        p.addLike(up);
System.out.println("aaa");
        postContentsRepository.save(post);
    }

}
