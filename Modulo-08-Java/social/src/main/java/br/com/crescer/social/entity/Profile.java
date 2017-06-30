/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import oracle.jdbc.proxy.annotation.Post;
import org.aspectj.asm.internal.Relationship;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Barizon
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable{
   
    @Id
    @Column(name = "id_user")
    private Long id_user;
      
    @OneToOne(targetEntity=User.class)
    @PrimaryKeyJoinColumn(name="id_user", referencedColumnName="id")
    private User user;

    @Column(name = "name")
    @Basic(optional = false)
    private String name;

    @Column(name = "birthday")
    @Basic(optional = false)
    private String birthday;
    
    @Column(name = "gender")
    @Basic(optional = false)
    private Gender gender;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Post> posts;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationship")
    private List<Relationship> relationship;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Relationship> getRelationship() {
        return relationship;
    }

    public void setRelationship(List<Relationship> relationship) {
        this.relationship = relationship;
    }
    
    
}
