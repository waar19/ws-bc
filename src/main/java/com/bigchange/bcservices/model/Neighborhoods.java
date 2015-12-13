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
@Table(name = "neighborhoods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Neighborhoods.findAll", query = "SELECT n FROM Neighborhoods n"),
    @NamedQuery(name = "Neighborhoods.findById", query = "SELECT n FROM Neighborhoods n WHERE n.id = :id"),
    @NamedQuery(name = "Neighborhoods.findByDescription", query = "SELECT n FROM Neighborhoods n WHERE n.description = :description"),
    @NamedQuery(name = "Neighborhoods.findByActive", query = "SELECT n FROM Neighborhoods n WHERE n.active = :active"),
    @NamedQuery(name = "Neighborhoods.findByCity", query = "SELECT n FROM Neighborhoods n WHERE n.city = :city"),
    @NamedQuery(name = "Neighborhoods.findByCode", query = "SELECT n FROM Neighborhoods n WHERE n.code = :code")})
public class Neighborhoods implements Serializable {

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
    @Column(name = "city")
    private Integer city;
    @Size(max = 4)
    @Column(name = "code")
    private String code;

    public Neighborhoods() {
    }

    public Neighborhoods(Integer id) {
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

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
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
        if (!(object instanceof Neighborhoods)) {
            return false;
        }
        Neighborhoods other = (Neighborhoods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bigchange.bcservices.model.Neighborhoods[ id=" + id + " ]";
    }
    
}
