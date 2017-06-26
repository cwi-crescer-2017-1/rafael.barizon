/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec.locacao;

import br.com.crescer.aula4exec.GenericDao;

/**
 *
 * @author Barizon
 */
public class LocacaoDaoImpl extends GenericDao<Locacao, Long>{
    
    public LocacaoDaoImpl(Class<Locacao> entity) {
        super(entity);
    }
    
}
