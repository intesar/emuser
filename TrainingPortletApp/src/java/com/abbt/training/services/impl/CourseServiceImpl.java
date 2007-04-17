/*
 * CourseServiceImpl.java
 *
 * Created on April 15, 2007, 1:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.services.impl;

import com.abbt.training.persistence.CourseDetail;
import com.abbt.training.persistence.CourseOffered;
import com.abbt.training.services.ICourseService;
import java.util.List;
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
public class CourseServiceImpl implements ICourseService{

    /** Creates a new instance of CourseServiceImpl */
    public CourseServiceImpl() {
    }

    public List<CourseOffered> getAllCourses() {
        EntityManager em = null;
        List<CourseOffered> list  = null;
        try {
           em = emf.createEntityManager();           
           Query query = em.createNamedQuery("CourseOffered.findAll");           
           list = query.getResultList();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);           
        } finally {
            em.close();
        }
        return list;
    }

    public List<CourseDetail> findByCourseName(String name) {
        EntityManager em = null;
        List<CourseDetail> courseDetail  = null;
        try {
           em = emf.createEntityManager();      
           System.out.println("inside findByCourseName..");
           Query query = em.createNamedQuery("CourseDetail.findByCourseName");
           query.setParameter("courseName", name);
           courseDetail = query.getResultList();
        } catch(Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);           
            e.printStackTrace();
        } finally {
            em.close();
        }
        return courseDetail;
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainingPortletAppPU");
}
