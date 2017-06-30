/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael.barizon
 */
@Entity
@Table(name = "RELATIONSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship.findAll", query = "SELECT r FROM Relationship r"),
    @NamedQuery(name = "Relationship.findByIdUser", query = "SELECT r FROM Relationship r WHERE r.relationshipPK.idUser = :idUser"),
    @NamedQuery(name = "Relationship.findByIdUserRelationship", query = "SELECT r FROM Relationship r WHERE r.relationshipPK.idUserRelationship = :idUserRelationship"),
    @NamedQuery(name = "Relationship.findByRelationshipStatus", query = "SELECT r FROM Relationship r WHERE r.relationshipStatus = :relationshipStatus")})
public class Relationship implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelationshipPK relationshipPK;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "RELATIONSHIP_STATUS")
    private RelationshipStatus relationshipStatus;
    
    @JsonIgnore
    @JoinColumn(name = "ID_USER_RELATIONSHIP", referencedColumnName = "ID_USER",foreignKey = @ForeignKey(name = "FK_USER_1"), insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Userprofile userprofile;
    
    @JsonIgnore
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER",foreignKey = @ForeignKey(name = "FK_USER_RELATIONSHIP"), insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Userprofile userprofile1;

    public Relationship() {
    }

    public Relationship(RelationshipPK relationshipPK) {
        this.relationshipPK = relationshipPK;
    }

    public Relationship(RelationshipPK relationshipPK, RelationshipStatus relationshipStatus) {
        this.relationshipPK = relationshipPK;
        this.relationshipStatus = relationshipStatus;
    }

    public Relationship(BigInteger idUser, BigInteger idUserRelationship) {
        this.relationshipPK = new RelationshipPK(idUser, idUserRelationship);
    }

    public RelationshipPK getRelationshipPK() {
        return relationshipPK;
    }

    public void setRelationshipPK(RelationshipPK relationshipPK) {
        this.relationshipPK = relationshipPK;
    }

    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(RelationshipStatus relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public Userprofile getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(Userprofile userprofile) {
        this.userprofile = userprofile;
    }

    public Userprofile getUserprofile1() {
        return userprofile1;
    }

    public void setUserprofile1(Userprofile userprofile1) {
        this.userprofile1 = userprofile1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relationshipPK != null ? relationshipPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationship)) {
            return false;
        }
        Relationship other = (Relationship) object;
        if ((this.relationshipPK == null && other.relationshipPK != null) || (this.relationshipPK != null && !this.relationshipPK.equals(other.relationshipPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entity.Relationship[ relationshipPK=" + relationshipPK + " ]";
    }
    
}
