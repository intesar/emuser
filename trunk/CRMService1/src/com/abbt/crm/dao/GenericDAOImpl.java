/*
 * GenericDAOImpl.java
 *
 * Created on April 2, 2007, 8:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shannan
 */
public class GenericDAOImpl implements GenericDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRMService1PU");

    /** Creates a new instance of GenericDAOImpl */
    public GenericDAOImpl() {
    }

    /*
     *  executes jpq query and returns a list of objects
     */

    public List find(String jpaQuery) {
        EntityManager em = emf.createEntityManager();
        List list = null;
        try {
            list = em.createQuery(jpaQuery).getResultList();
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

}
