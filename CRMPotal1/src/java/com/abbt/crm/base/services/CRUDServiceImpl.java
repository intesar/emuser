/*
 * CRUDServiceImpl.java
 *
 * Created on April 6, 2007, 10:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import com.abbt.crm.base.services.exceptions.InvalidEntityException;
import com.abbt.crm.base.services.exceptions.UniqueEntityException;
import com.abbt.crm.base.services.exceptions.VariableNotNullException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author shannan
 */
public class CRUDServiceImpl implements ICRUDService {

    private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("CRMPotal1PU");

    private EntityManager em = emf.createEntityManager();

    /** Creates a new instance of CRUDServiceImpl */
    public CRUDServiceImpl() {
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
        em.close();
    }

    public void rollback() {
        em.getTransaction().rollback();
        em.close();
    }

    public void save(Object entity)  throws UniqueEntityException, VariableNotNullException{
        try {
            em.persist(entity);
        } catch( Exception e) {
            this.rollback();
            throw new UniqueEntityException();
        }
    }

    public void update(Object entity)  throws InvalidEntityException, VariableNotNullException{
        try {
            em.merge(entity);        
        } catch (Exception e) {
            this.rollback();
            throw new VariableNotNullException();
        }
    }

    public void delete(Object entity)  throws InvalidEntityException, VariableNotNullException{
        try {
            em.merge(entity);
            em.remove(entity);
        } catch (Exception e) {
            this.rollback();
            throw new VariableNotNullException();
        }
    }

}
