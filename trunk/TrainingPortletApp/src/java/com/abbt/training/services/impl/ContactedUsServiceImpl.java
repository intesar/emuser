/*
 * ContactedUsServiceImpl.java
 *
 * Created on April 15, 2007, 1:41 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.services.impl;

import com.abbt.training.persistence.ContactedUs;
import com.abbt.training.services.IContactedUsService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shannan
 */
public class ContactedUsServiceImpl implements IContactedUsService {    

    /** Creates a new instance of ContactedUsServiceImpl */
    public ContactedUsServiceImpl() {
    }

    public void save(ContactedUs contactUs) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(contactUs);
            em.getTransaction().commit();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainingPortletAppPU");
}
