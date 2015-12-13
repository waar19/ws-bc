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
@Table(name = "quotes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quotes.findAll", query = "SELECT q FROM Quotes q"),
    @NamedQuery(name = "Quotes.findById", query = "SELECT q FROM Quotes q WHERE q.id = :id"),
    @NamedQuery(name = "Quotes.findByValuesold", query = "SELECT q FROM Quotes q WHERE q.valuesold = :valuesold"),
    @NamedQuery(name = "Quotes.findByAvailable", query = "SELECT q FROM Quotes q WHERE q.available = :available"),
    @NamedQuery(name = "Quotes.findByTotalquote", query = "SELECT q FROM Quotes q WHERE q.totalquote = :totalquote"),
    @NamedQuery(name = "Quotes.findByActive", query = "SELECT q FROM Quotes q WHERE q.active = :active"),
    @NamedQuery(name = "Quotes.findByCode", query = "SELECT q FROM Quotes q WHERE q.code = :code")})
public class Quotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "valuesold")
    private Integer valuesold;
    @Column(name = "available")
    private Integer available;
    @Column(name = "totalquote")
    private Integer totalquote;
    @Column(name = "active")
    private Boolean active;
    @Size(max = 4)
    @Column(name = "code")
    private String code;

    public Quotes() {
    }

    public Quotes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValuesold() {
        return valuesold;
    }

    public void setValuesold(Integer valuesold) {
        this.valuesold = valuesold;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getTotalquote() {
        return totalquote;
    }

    public void setTotalquote(Integer totalquote) {
        this.totalquote = totalquote;
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
        if (!(object instanceof Quotes)) {
            return false;
        }
        Quotes other = (Quotes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bigchange.bcservices.model.Quotes[ id=" + id + " ]";
    }
    
}
