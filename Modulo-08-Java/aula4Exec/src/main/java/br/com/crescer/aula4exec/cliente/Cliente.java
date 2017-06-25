package br.com.crescer.aula4exec.cliente;

//import static com.sun.org.apache.xerces.internal.impl.dtd.models.SimpleContentModel.SEQUENCE;
import java.io.Serializable;
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
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
    
    
    
//Todas as entidades terão um `@GeneratedValue(strategy = GenerationType.SEQUENCE 
//...` que vai apontar para a sequence com o mesmo nome da tabela.
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "CPF")
    private String cpf;
    
    @Basic
    @Column(name = "RG")
    private String rg;
    
    @Basic
    @Column(name = "RUA")
    private String rua;
    
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
    @Column(name = "EMAIL")
    private String email;
    
    @Basic
    @Column(name = "TELEFONE")
    private String telefone;
    
    @Basic(optional = false)
    @Column(name = "CELULAR")
    private String celular;
    
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
