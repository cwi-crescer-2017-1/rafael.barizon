/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
//import oracle.jdbc.proxy.annotation.Post;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Barizon
 */
@Entity
@Table(name="like")
public class Like implements Serializable{
    @EmbeddedId
    private LikeId id;

    @MapsId("id")
    @JoinColumns({
        @JoinColumn(name="id_user", referencedColumnName="id_user"),
        @JoinColumn(name="id_content", referencedColumnName="id")
    })
    @ManyToOne
    public Profile profile;
}
