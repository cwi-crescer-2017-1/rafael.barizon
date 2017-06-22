/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import br.com.crescer.aula3.pessoa.PessoaDaoImpl;
import br.com.crescer.aula3.pessoa.Pessoa;
import br.com.crescer.aula3.pessoa.PessoaDao;

/**
 *
 * @author rafael.barizon
 */
public class NovoClass {

    public static void main(String[] args){
        final Pessoa p = new Pessoa();
        final PessoaDao pessoaDao = new PessoaDaoImpl();
        p.setId(1l);
        p.setNome("Rafael");
         
        pessoaDao.insert(p);
        
    } 
    
}
