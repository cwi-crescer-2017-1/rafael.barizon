/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4exec.funcionario;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Barizon
 */
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO")
    private Long id;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;    
    @Basic
    @Column(name = "BAIRRO")
    private String bairro;
    @Basic
    @Column(name = "CIDADE")
    private String cidade;
    @Basic
    @Column(name = "NUMERO_CASA")
    private String numero_casa;
    @Basic
    @Column(name = "RUA")
    private String rua;
    @Basic(optional = false)
    @Column(name = "RG")
    private String rg;
    
    @Basic
    @Column(name = "EMAIL")
    private String email;
    
    @Basic
    @Column(name = "TELEFONE")
    private String telefone;
    
    @Basic
    @Column(name = "CELULAR")
    private String celular;
    
        
    @Basic
    @Column(name = "SALARIO")
    private String salario;
    
    @Basic
    @Column(name = "FUNCAO")
    private String funcao;
    
    @Basic
    @Column(name = "CPF")
    private String cpf;
    
    @Basic
    @Column(name = "NASCIMENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    
    
    
}
