/*
 * PageHandlerDaoImpl.java
 *
 * Created on May 5, 2007, 11:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.daos;

import abbt.com.paginationframework.PageHandlerDao;
import java.util.ArrayList;
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
public class PageHandlerDaoImpl implements PageHandlerDao {   
    
    
    /** Creates a new instance of PageHandlerDaoImpl */
    public PageHandlerDaoImpl() {
        emf = Persistence.createEntityManagerFactory("TimesheetSysPortalPU");
    }
    
    public int findResultSize(String string) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Long size = (Long) em.createNamedQuery(string).getSingleResult();
            return size.intValue();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List executeQuery(String string, int i, int i0) {
        EntityManager em = null;
        List list = new ArrayList();
        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery(string);
            query.setFirstResult(i);
            query.setMaxResults(i0);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    private EntityManagerFactory emf;
    
    
}
