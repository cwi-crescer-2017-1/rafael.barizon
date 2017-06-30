/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Barizon
 */
@Entity
@Table(name = "post")
public class Content implements Serializable{
    
    private static final String SQ_NAME = "SEQ_POST";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity=Profile.class)
    @PrimaryKeyJoinColumn(name="id_user", referencedColumnName="id_user")
    private Profile profile;
    
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    
    @Basic(optional = false)
    @Column(name = "numberOfLikes")
    private int numberOfLikes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "like")
    private List<Profile> likes;
    
    @Basic(optional = false)
    @Column(name = "publishDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date publishDate;

    public List<Profile> getLikes() {
        return likes;
    }

    public void setLikes(List<Profile> likes) {
        this.likes = likes;
    }    
    
    public Content(){
        this.publishDate = new Date();
        this.numberOfLikes = 0;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Date getPublishDate() {
        return publishDate;
    }
    
}
