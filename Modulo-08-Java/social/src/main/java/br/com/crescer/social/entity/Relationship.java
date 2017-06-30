/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Barizon
 */
@Entity
@Table(name = "relationship", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id_user"),
		@UniqueConstraint(columnNames = "id_user_relationship") })
public class Relationship implements Serializable{
    
    private static final String SQ_NAME = "SEQ_Relationship";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME)
    @Column(name = "id")
    @javax.persistence.Id
    private Long id;   
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    public Profile getUser() {
        return user;
    }
    private Profile user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_relationship")
    public Profile getUserRelationship() {
        return user_relationship;
    }
    private Profile user_relationship;
    
    @Column(name = "relationshipStatus")
    @Basic(optional = false)
    private RelationshipStatus relationshipStatus;

    
}
