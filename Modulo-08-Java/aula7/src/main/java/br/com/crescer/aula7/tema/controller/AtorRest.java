/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Ator;
import br.com.crescer.aula7.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael.barizon
 */
@RestController
public class AtorRest {
    @Autowired
    AtorService atorService;
    
    
    @RequestMapping(value = "/oi", method = RequestMethod.GET)
    public String oi(){
        return "OIIII";
    }
    
//    @RequestMapping(value = "/ator/{id}", method = RequestMethod.GET)
//    public Ator getAtorById(@PathVariable Long id){
//        return atorService.getAtorById(id);
//    }
    
}
