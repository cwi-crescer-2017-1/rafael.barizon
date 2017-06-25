/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec.locacao;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Barizon
 */
@Entity
@Table(name = "LOCACAO")
public class Locacao {
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO")
    private Long id;
    
    @Basic
    @Column(name = "VALOR_TOTAL")
    private double valor; 
    
    @Basic
    @Column(name = "ID_FUNCIONARIO")
    private Long id_funcionario; 
    
    @Basic
    @Column(name = "ID_CLIENTE")
    private Long id_cliente; 
    
    @Basic
    @Column(name = "ID_VIDEO")
    private Long id_video; 
    
    @Basic
    @Column(name = "DATA_DEVOLUCAO")
    private Date data_devolucao; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_video() {
        return id_video;
    }

    public void setId_video(Long id_video) {
        this.id_video = id_video;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
}
