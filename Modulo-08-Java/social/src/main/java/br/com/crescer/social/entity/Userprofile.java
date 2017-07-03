/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafael.barizon
 */
@Entity
@Table(name = "USERPROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userprofile.findAll", query = "SELECT u FROM Userprofile u"),
    @NamedQuery(name = "Userprofile.findByBirthday", query = "SELECT u FROM Userprofile u WHERE u.birthday = :birthday"),
    @NamedQuery(name = "Userprofile.findByGender", query = "SELECT u FROM Userprofile u WHERE u.gender = :gender"),
    @NamedQuery(name = "Userprofile.findByName", query = "SELECT u FROM Userprofile u WHERE u.name = :name"),
    @NamedQuery(name = "Userprofile.findByIdUser", query = "SELECT u FROM Userprofile u WHERE u.idUser = :idUser")})
public class Userprofile implements Serializable {

//    @ManyToMany(mappedBy = "contentLikes")
//    private Set<Postcontents> postcontentLikes;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
//    private Set<Postcontents> postcontentLikes1;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "BIRTHDAY")
    private String birthday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENDER")
    private long gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USER")
    private BigDecimal idUser;
    
//    @ManyToMany(mappedBy = "userprofileSet")
//    private Set<Postcontents> postcontentsSet;
    @JsonIgnore
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID",foreignKey = @ForeignKey(name = "FK_USERSOCIAL"), insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usersocial usersocial;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
//    private Set<Postcontents> postcontentsSet1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userprofile")
//    private Set<Relationship> relationshipSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userprofile1", fetch = FetchType.LAZY)
//    private Set<Relationship> relationshipSet1;

    public Userprofile() {
    }

    public Userprofile(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public Userprofile(BigDecimal idUser, String birthday, long gender, String name) {
        this.idUser = idUser;
        this.birthday = birthday;
        this.gender = gender;
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

//    @XmlTransient
//    public Set<Postcontents> getPostcontentsSet() {
//        return postcontentsSet;
//    }
//
//    public void setPostcontentsSet(Set<Postcontents> postcontentsSet) {
//        this.postcontentsSet = postcontentsSet;
//    }

    public Usersocial getUsersocial() {
        return usersocial;
    }

    public void setUsersocial(Usersocial usersocial) {
        this.usersocial = usersocial;
    }

//    @XmlTransient
//    public Set<Postcontents> getPostcontentsSet1() {
//        return postcontentsSet1;
//    }
//
//    public void setPostcontentsSet1(Set<Postcontents> postcontentsSet1) {
//        this.postcontentsSet1 = postcontentsSet1;
//    }
//
//    @XmlTransient
//    public Set<Relationship> getRelationshipSet() {
//        return relationshipSet;
//    }
//
//    public void setRelationshipSet(Set<Relationship> relationshipSet) {
//        this.relationshipSet = relationshipSet;
//    }

//    @XmlTransient
//    public Set<Relationship> getRelationshipSet1() {
//        return relationshipSet1;
//    }
//
//    public void setRelationshipSet1(Set<Relationship> relationshipSet1) {
//        this.relationshipSet1 = relationshipSet1;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userprofile)) {
            return false;
        }
        Userprofile other = (Userprofile) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entity.Userprofile[ idUser=" + idUser + " ]";
    }

//    public Set<Postcontents> getPostcontentLikes() {
//        return postcontentLikes;
//    }
//
//    public void sePpostcontentLikes(Set<Postcontents> postcontentsSet) {
//        this.postcontentLikes = postcontentsSet;
//    }
//
//    public Set<Postcontents> getPostcontentLikes1() {
//        return postcontentLikes1;
//    }
//
//    public void setPostcontentLikes1(Set<Postcontents> postcontentsSet1) {
//        this.postcontentLikes1 = postcontentsSet1;
//    }
    
}
