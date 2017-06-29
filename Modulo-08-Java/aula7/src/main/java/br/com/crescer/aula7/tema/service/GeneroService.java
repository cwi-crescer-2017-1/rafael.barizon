/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.service;

import br.com.crescer.aula7.entity.Genero;
import br.com.crescer.aula7.tema.repository.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barizon
 */
@Service
public class GeneroService implements GenericService<Genero, Long>{

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public void remove(Genero genero) {
        generoRepository.delete(genero);
    }

    @Override
    public Genero loadById(Long id) {
        return generoRepository.findOne(id);
    }

    @Override
    public List<Genero> findAll() {
        return (List<Genero>) generoRepository.findAll();
    }
    
}
