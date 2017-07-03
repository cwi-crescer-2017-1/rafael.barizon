/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Base64;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author rafael.barizon
 */
@Entity
@Table(name = "USERSOCIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usersocial.findAll", query = "SELECT u FROM Usersocial u"),
    @NamedQuery(name = "Usersocial.findById", query = "SELECT u FROM Usersocial u WHERE u.id = :id"),
    @NamedQuery(name = "Usersocial.findByPassword", query = "SELECT u FROM Usersocial u WHERE u.password = :password"),
    @NamedQuery(name = "Usersocial.findByUsername", query = "SELECT u FROM Usersocial u WHERE u.username = :username")})
public class Usersocial implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usersocial")
    private Userprofile userprofile;

    private static final String SQ_NAME = "SEQ_USUARIO";

    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usersocial")
//    private Userprofile userprofile;

    public Usersocial() {
    }

    public Usersocial(BigDecimal id) {
        this.id = id;
    }

    public Usersocial(BigDecimal id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Userprofile getUserprofile() {
//        return userprofile;
//    }
//
//    public void setUserprofile(Userprofile userprofile) {
//        this.userprofile = userprofile;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usersocial)) {
            return false;
        }
        Usersocial other = (Usersocial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entity.Usersocial[ id=" + id + " ]";
    }

    private String encrypt(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public void validate() {
        this.password = encrypt(password);
    }

    public Userprofile getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(Userprofile userprofile) {
        this.userprofile = userprofile;
    }
    
}
