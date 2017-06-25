/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec;

import br.com.crescer.aula4exec.cliente.Cliente;
import br.com.crescer.aula4exec.funcionario.Funcionario;
import br.com.crescer.aula4exec.genero.Genero;
import br.com.crescer.aula4exec.locacao.Locacao;
import br.com.crescer.aula4exec.video.Video;

/**
 *
 * @author Barizon
 */
public class Run {
    public static void main(String[] args) {
        //GenericDao<Cliente, Long> Cliente = new GenericDao<>();
        
        CrudDao daoFuncionario = new GenericDao<Funcionario, Long>(Funcionario.class);
        CrudDao daoCliente = new GenericDao<Cliente, Long>(Cliente.class);
        CrudDao daoGenero = new GenericDao<Genero, Long>(Genero.class);
        CrudDao daoVideo = new GenericDao<Video, Long>(Video.class);
        CrudDao daoLocacao = new GenericDao<Locacao, Long>(Locacao.class);
        
        Funcionario funcionario = new Funcionario();
        Cliente cliente = new Cliente();
        Genero genero = new Genero();
        Video video = new Video();
        Locacao locacao = new Locacao();
        
        
        funcionario.setNome("Carlos Alberto");
        funcionario.setRg("2313225756");
        
        cliente.setNome("Rafael Barizon ");
        cliente.setCpf("02521450030");
        cliente.setCelular("54 9 9165 3981");
        
        genero.setDescricao("ACAO");
//        video.setValor(5.00);
//        video.setNome("Mad Max: Fury Road");
//        video.setId_genero(genero.getId());
//        
//        locacao.setId_cliente(cliente.getId());
//        locacao.setId_funcionario(funcionario.getId());
//        locacao.setId_video(video.getId());
        
        
        
//        daoFuncionario.save(funcionario);
//        daoCliente.save(cliente);
        daoGenero.save(genero);
        
//        daoVideo.save(video);
//        daoLocacao.save(locacao);
        
    }
}
