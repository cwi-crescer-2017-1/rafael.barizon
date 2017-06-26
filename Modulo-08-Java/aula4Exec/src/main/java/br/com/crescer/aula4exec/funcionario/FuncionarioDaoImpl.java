/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec.funcionario;

import br.com.crescer.aula4exec.GenericDao;

/**
 *
 * @author Barizon
 */
public class FuncionarioDaoImpl extends GenericDao<Funcionario, Long>{
    
    public FuncionarioDaoImpl(Class<Funcionario> entity) {
        super(entity);
    }
    
}
