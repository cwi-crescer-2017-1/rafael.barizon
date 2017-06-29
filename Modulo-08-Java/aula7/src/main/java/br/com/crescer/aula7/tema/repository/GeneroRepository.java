/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.repository;

import br.com.crescer.aula7.entity.Genero;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Barizon
 */
public interface GeneroRepository extends CrudRepository<Genero, Long>{
    
}
