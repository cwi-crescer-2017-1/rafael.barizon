/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.controller;

import br.com.crescer.aula7.entity.Genero;
import br.com.crescer.aula7.tema.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barizon
 */
@RestController
@RequestMapping("/genero")
public class GeneroRest {
    @Autowired
    private GeneroService generoService; 
    
    @GetMapping("/{id}")
    public Genero findOne(@PathVariable("id") Long id) {
        return generoService.loadById(id);
    }

    @ResponseBody
    @GetMapping
    public List<Genero> findAll() {
        return generoService.findAll();
    }
    
    @PostMapping
    public Genero save(@RequestBody Genero c){
        return generoService.save(c);
    }
    
    @PostMapping("/{id}")
    public void remove(@RequestBody Genero c){
        generoService.remove(c);
    }
    
}