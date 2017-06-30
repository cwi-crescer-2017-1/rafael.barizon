/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rafael.barizon
 */
@Embeddable
public class RelationshipPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USER")
    private BigInteger idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USER_RELATIONSHIP")
    private BigInteger idUserRelationship;

    public RelationshipPK() {
    }

    public RelationshipPK(BigInteger idUser, BigInteger idUserRelationship) {
        this.idUser = idUser;
        this.idUserRelationship = idUserRelationship;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public BigInteger getIdUserRelationship() {
        return idUserRelationship;
    }

    public void setIdUserRelationship(BigInteger idUserRelationship) {
        this.idUserRelationship = idUserRelationship;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        hash += (idUserRelationship != null ? idUserRelationship.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationshipPK)) {
            return false;
        }
        RelationshipPK other = (RelationshipPK) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        if ((this.idUserRelationship == null && other.idUserRelationship != null) || (this.idUserRelationship != null && !this.idUserRelationship.equals(other.idUserRelationship))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entity.RelationshipPK[ idUser=" + idUser + ", idUserRelationship=" + idUserRelationship + " ]";
    }
    
}
