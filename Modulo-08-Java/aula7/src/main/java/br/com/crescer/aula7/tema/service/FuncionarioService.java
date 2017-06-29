/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.service;

import br.com.crescer.aula7.tema.entity.Funcionario;
import br.com.crescer.aula7.tema.repository.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barizon
 */
@Service
public class FuncionarioService implements GenericService<Funcionario, Long>{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void remove(Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }

    @Override
    public Funcionario loadById(Long id) {
        return funcionarioRepository.findOne(id);
    }

    @Override
    public List<Funcionario> findAll() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }
}
