/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael.barizon
 */
@Entity
@Table(name = "POSTCONTENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postcontents.findAll", query = "SELECT p FROM Postcontents p"),
    @NamedQuery(name = "Postcontents.findById", query = "SELECT p FROM Postcontents p WHERE p.id = :id"),
    @NamedQuery(name = "Postcontents.findByContent", query = "SELECT p FROM Postcontents p WHERE p.content = :content"),
    @NamedQuery(name = "Postcontents.findByNumberOfLikes", query = "SELECT p FROM Postcontents p WHERE p.numberOfLikes = :numberOfLikes"),
    @NamedQuery(name = "Postcontents.findByPublishDate", query = "SELECT p FROM Postcontents p WHERE p.publishDate = :publishDate")})
public class Postcontents implements Serializable, Comparable<Postcontents> {

    @JoinTable(name = "CONTENTLIKE", joinColumns = {
        @JoinColumn(name = "ID_CONTENT", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")})
    @ManyToMany
    private Set<Userprofile> contentLikes;

    private static final String SQ_NAME = "SEQ_POSTCONTENT";
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
    @Column(name = "CONTENT")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBER_OF_LIKES")
    private long numberOfLikes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUBLISH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;

    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER", foreignKey = @ForeignKey(name = "FK_ID_USER"))
    @ManyToOne(optional = false)
    private Userprofile userProfile;

    public Postcontents() {
    }

    public Postcontents(BigDecimal id) {
        this.id = id;
    }

    public Postcontents(BigDecimal id, String content, long numberOfLikes, Date publishDate) {
        this.id = id;
        this.content = content;
        this.numberOfLikes = numberOfLikes;
        this.publishDate = publishDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes() {
        this.numberOfLikes = getContentLikes().size();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Userprofile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(Userprofile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postcontents)) {
            return false;
        }
        Postcontents other = (Postcontents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entity.Postcontents[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Postcontents o) {
        return this.publishDate.compareTo(o.getPublishDate());
    }

    public Set<Userprofile> getContentLikes() {
        return contentLikes;
    }

    public void addLike(Userprofile up) {
        this.contentLikes.add(up);
        setNumberOfLikes();
    }
    
    public void setContentLikesRemove(Userprofile up){
        this.contentLikes.remove(up);
        setNumberOfLikes();
    }

    public void setContentLikes(Set<Userprofile> contentLikes) {
        this.contentLikes = contentLikes;
        setNumberOfLikes();
    }
    
    
}
