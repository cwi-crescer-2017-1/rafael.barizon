package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Userprofile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.social.entity.Usersocial;
import br.com.crescer.social.service.UsersocialService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.core.Authentication;
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
    public BigDecimal cadastrar(@RequestBody Usersocial us) {
        return usersocialService.save(us);
    }
    
//    @GetMapping
//    public Usersocial findOne(@RequestBody Usersocial us) {
//       return usersocialService.findByUsername(us.getUsername());
//    }
    
    @GetMapping
    public Object listarUsuarios(Authentication authentication) {
        Userprofile u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(Userprofile.class::cast)
                .orElse(null);
        
        return u;
    }
    
    
    @PostMapping("/update")
    public void save(@RequestBody Usersocial us){
        Usersocial user = new Usersocial(us.getId(), us.getPassword(), us.getUsername());
        user.validate();
        usersocialService.update(user);
    }
    
    @PostMapping("/remove")
    public void remove(@RequestBody Usersocial us){
        usersocialService.remove(us);
    }
    
}
