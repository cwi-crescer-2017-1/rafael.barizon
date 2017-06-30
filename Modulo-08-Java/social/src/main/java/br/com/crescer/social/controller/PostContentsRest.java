package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Postcontents;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.social.service.PostContentsService;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.PathVariable;
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
        return postContentsService.findAll(id);
    }

//    @PostMapping("/save")
//    public Postcontents save(@RequestBody Postcontents c){
//        return postContentsService.save(c);
//    }
//    
//    @PostMapping("/remove")
//    public void remove(@RequestBody Postcontents c){
//        postContentsService.remove(c);
//    }
    
    
    
}
