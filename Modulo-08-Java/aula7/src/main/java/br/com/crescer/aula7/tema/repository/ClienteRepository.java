/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.repository;

import br.com.crescer.aula7.tema.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Barizon
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

    public Cliente findByCpf(String cpf);
}
