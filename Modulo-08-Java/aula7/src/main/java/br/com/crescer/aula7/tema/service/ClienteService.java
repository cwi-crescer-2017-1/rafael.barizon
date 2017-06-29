/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.service;

import br.com.crescer.aula7.tema.entity.Cliente;
import br.com.crescer.aula7.tema.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barizon
 */
@Service
public class ClienteService implements GenericService<Cliente, Long> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void remove(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    public Cliente loadById(Long id) {
        return clienteRepository.findOne(id);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

}
