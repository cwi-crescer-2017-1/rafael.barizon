package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Postcontents;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.social.service.PostContentsService;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Barizon
 */
@RestController
@RequestMapping("/postcontents")
public class PostContentsRest {

    @Autowired
    private PostContentsService postContentsService;

    @RequestMapping(value = {"/feed/{id}"}, method = RequestMethod.GET)
    public List<Postcontents> findPosts(@PathVariable(value = "id") BigDecimal id) {
        return postContentsService.findAllFriendsPost(id);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public List<Postcontents> findAllForId(@PathVariable(value = "id") BigDecimal id) {
        return postContentsService.findAllForId(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Postcontents c) {
        c.setPublishDate(new Date());
        postContentsService.save(c);
    }

    @PostMapping("/remove/{id}")
    public void remove(@PathVariable(value = "id") BigDecimal id) {
        postContentsService.remove(id);
    }

    
    @PostMapping("/gg")
    public void gg(@RequestBody Postcontents post){
        post.setNumberOfLikes();
        postContentsService.setLikes(post);
        //
    }
}
