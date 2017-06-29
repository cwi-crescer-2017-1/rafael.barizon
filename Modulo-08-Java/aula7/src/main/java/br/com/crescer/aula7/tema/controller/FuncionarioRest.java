/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.controller;

import br.com.crescer.aula7.tema.entity.Funcionario;
import br.com.crescer.aula7.tema.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioRest {
    @Autowired
    private FuncionarioService funcionarioService; 
    
    @GetMapping("/{id}")
    public Funcionario findOne(@PathVariable("id") Long id) {
        return funcionarioService.loadById(id);
    }

    @ResponseBody
    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }
    
    @PostMapping
    public Funcionario save(@RequestBody Funcionario c){
        return funcionarioService.save(c);
    }
    
    @PostMapping("/{id}")
    public void remove(@RequestBody Funcionario c){
        funcionarioService.remove(c);
    }
    
}