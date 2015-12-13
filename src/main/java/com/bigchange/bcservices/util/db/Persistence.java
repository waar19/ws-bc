/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigchange.bcservices.util.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author wilmeralzate
 */
public class Persistence {

    private EntityManagerFactory emf;
    private Query query;

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("com.bigchange_BCServices_war_1.0-SNAPSHOTPU");
        return emf;
    }

    /**
     * @param aEmf the emf to set
     */
    public void setEmf(EntityManagerFactory aEmf) {
        emf = aEmf;
    }
    

    public EntityManagerFactory getEntityManagerFactory() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("com.bigchange_BCServices_war_1.0-SNAPSHOTPU");
        return emf;
    }

    /**
     * @return the query
     */
    public Query getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(Query query) {
        this.query = query;
    }
}
