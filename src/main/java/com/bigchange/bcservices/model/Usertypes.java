/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wilmeralzate
 */
@Entity
@Table(name = "usertypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertypes.findAll", query = "SELECT u FROM Usertypes u"),
    @NamedQuery(name = "Usertypes.findById", query = "SELECT u FROM Usertypes u WHERE u.id = :id"),
    @NamedQuery(name = "Usertypes.findByDescription", query = "SELECT u FROM Usertypes u WHERE u.description = :description"),
    @NamedQuery(name = "Usertypes.findByActive", query = "SELECT u FROM Usertypes u WHERE u.active = :active"),
    @NamedQuery(name = "Usertypes.findByCode", query = "SELECT u FROM Usertypes u WHERE u.code = :code")})
public class Usertypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @Size(max = 4)
    @Column(name = "code")
    private String code;

    public Usertypes() {
    }

    public Usertypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        if (!(object instanceof Usertypes)) {
            return false;
        }
        Usertypes other = (Usertypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bigchange.bcservices.model.Usertypes[ id=" + id + " ]";
    }
    
}
