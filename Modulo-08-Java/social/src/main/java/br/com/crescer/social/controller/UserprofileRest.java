package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Userprofile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.social.entity.Usersocial;
import br.com.crescer.social.service.UserprofileService;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Barizon
 */
@RestController
@RequestMapping("/userprofile")
public class UserprofileRest {
    @Autowired
    private UserprofileService userprofileService; 
    
    @PostMapping("/cadastro")
    public BigDecimal cadastrar(@RequestBody Userprofile up) {
        return userprofileService.save(up);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Userprofile findOne(@PathVariable(value = "id") BigDecimal id) {
        System.out.println(id+" username vindo do alem parte 1");
       return userprofileService.findOne(id);
    }
    
    //@GetMapping
    @PostMapping
   // @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Userprofile findOne(@RequestBody String username)
        /*(@PathVariable(value = "username") String username)*/ {
        System.out.println(username+" username vindo do alem parte 1");
       return userprofileService.findOne(username);
    }
    
    //@GetMapping
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ArrayList<Userprofile> findByName(@PathVariable(value = "name") String name) {
       return userprofileService.findByName(name);
    }
    
//    @PostMapping("/update")
//    public void save(@RequestBody Userprofile up){
//        Userprofile user = new Userprofile(up.getId(), up.getPassword(), up.getUsername());
//        user.validate();
//        userprofileService.update(user);
//    }
    
    @PostMapping("/remove")
    public void remove(@RequestBody Userprofile up){
        userprofileService.remove(up);
    }
    
}
