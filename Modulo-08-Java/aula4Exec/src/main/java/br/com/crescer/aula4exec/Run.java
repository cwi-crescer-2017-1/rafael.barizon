/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec;

import br.com.crescer.aula4exec.cliente.Cliente;
import br.com.crescer.aula4exec.cliente.ClienteDaoImpl;
import br.com.crescer.aula4exec.funcionario.Funcionario;
import br.com.crescer.aula4exec.funcionario.FuncionarioDaoImpl;
import br.com.crescer.aula4exec.genero.Genero;
import br.com.crescer.aula4exec.genero.GeneroDaoImpl;
import br.com.crescer.aula4exec.locacao.Locacao;
import br.com.crescer.aula4exec.locacao.LocacaoDaoImpl;
import br.com.crescer.aula4exec.video.Video;
import br.com.crescer.aula4exec.video.VideoDaoImpl;
import java.util.List;

/**
 *
 * @author Barizon
 */
public class Run {
    public static void main(String[] args) {
        //GenericDao<Cliente, Long> Cliente = new GenericDao<>();
        
        CrudDao daoFuncionario = new FuncionarioDaoImpl(Funcionario.class);
        CrudDao daoCliente = new ClienteDaoImpl(Cliente.class);
        CrudDao daoGenero = new GeneroDaoImpl(Genero.class);
        CrudDao daoVideo = new VideoDaoImpl(Video.class);
        CrudDao daoLocacao = new LocacaoDaoImpl(Locacao.class);
        
        Funcionario funcionario = new Funcionario();
        Cliente cliente = new Cliente();
        Genero genero = new Genero();
        Video video = new Video();
        Locacao locacao = new Locacao();
        
//        
//        funcionario.setNome("Carlos Alberto");
//        funcionario.setRg("2313225756");
//        
        cliente.setNome("Rafael Barizon");
        cliente.setCpf("02521450030");
        cliente.setCelular("54 9 9165 3981");
        
//        genero.setDescricao("ACAO");
//        video.setValor(5.00);
//        video.setNome("Mad Max: Fury Road");
//        video.setId_genero(genero.getId());
//        
//        locacao.setId_cliente(cliente.getId());
//        locacao.setId_funcionario(funcionario.getId());
//        locacao.setId_video(video.getId());
        
        
        
//        daoFuncionario.save(funcionario);
//        List<Cliente> list = daoCliente.findAll();
//        for(Cliente c : list){
//            System.out.println(c.getId()+" - "+c.getNome() + " - " + c.getCpf() + " - " + c.getCelular());
//        }
        
//        daoCliente.remove(list.get(2));
        Cliente c = (Cliente) daoCliente.loadById(50l);
        System.out.println(c.getId()+" - "+c.getNome() + " - " + c.getCpf() + " - " + c.getCelular());
//        list = daoCliente.findAll();
//        for(Cliente c : list){
//            System.out.println(c.getId()+" - "+c.getNome() + " - " + c.getCpf() + " - " + c.getCelular());
//        }
//        daoGenero.save(genero);
        
//        daoVideo.save(video);
//        daoLocacao.save(locacao);
        
    }
}
