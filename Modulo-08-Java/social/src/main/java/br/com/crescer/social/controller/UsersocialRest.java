package br.com.crescer.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.social.entity.Usersocial;
import br.com.crescer.social.service.UsersocialService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Barizon
 */
@RestController
@RequestMapping("/usersocial")
public class UsersocialRest {
    @Autowired
    private UsersocialService usersocialService; 
    
    @PostMapping("/cadastro")
    public void cadastrar(@RequestBody Usersocial us) {
        usersocialService.save(us);
    }
    
    @GetMapping
    public Usersocial findOne(@RequestBody Usersocial us) {
       return usersocialService.findByUsername(us.getUsername());
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Usersocial us){
        usersocialService.save(us);
    }
    
    @PostMapping("/remove")
    public void remove(@RequestBody Usersocial us){
        usersocialService.remove(us);
    }
    
}
