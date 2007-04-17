/*
 * InstructorServiceImpl.java
 *
 * Created on April 15, 2007, 1:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.services.impl;

import com.abbt.training.persistence.Instructor;
import com.abbt.training.services.IInstructorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author shannan
 */
public class InstructorServiceImpl implements IInstructorService{

   

   

    /** Creates a new instance of InstructorServiceImpl */
    public InstructorServiceImpl() {
    }

    public Instructor findByEmail(String email) {
        EntityManager em = null;
        Instructor instructor  = null;
        try {
           em = emf.createEntityManager();           
           Query query = em.createNamedQuery("Instructor.findByEmail");
           query.setParameter("email", email);
           instructor = (Instructor) query.getSingleResult();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);           
        } finally {
            em.close();
        }
        return instructor;
    }

   private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainingPortletAppPU");
}
