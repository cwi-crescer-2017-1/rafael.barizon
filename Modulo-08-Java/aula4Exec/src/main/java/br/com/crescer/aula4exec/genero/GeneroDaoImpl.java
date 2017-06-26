/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec.genero;

import br.com.crescer.aula4exec.GenericDao;


/**
 *
 * @author Barizon
 */
public class GeneroDaoImpl extends GenericDao<Genero, Long>{
    
    public GeneroDaoImpl(Class<Genero> entity) {
        super(entity);
    }
    
}
