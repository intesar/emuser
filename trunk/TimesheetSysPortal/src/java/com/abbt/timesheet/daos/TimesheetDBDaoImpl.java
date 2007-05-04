/*
 * TimesheetDBDaoImpl.java
 *
 * Created on April 29, 2007, 9:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.daos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author shannan
 */
public class TimesheetDBDaoImpl implements TimesheetDBDao {
    
    
    
    /** Creates a new instance of TimesheetDBDaoImpl */
    public TimesheetDBDaoImpl() {
         emf = Persistence.createEntityManagerFactory("TimesheetSysPortalPU");    
    }
    
    public void save(Object object) throws com.abbt.timesheet.exceptions.EntityExistsException, IllegalArgumentException {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (EntityExistsException eee ) {
            em.getTransaction().rollback();
            // use log4j to print
            throw new com.abbt.timesheet.exceptions.EntityExistsException(eee.getMessage());
        } catch (IllegalArgumentException iae ) {
            em.getTransaction().rollback();
            // use log4j to print
            throw iae;
        } finally {
            em.close();
        }
        
    }
    
    public Object update(Object object) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            object = em.merge(object);
            em.getTransaction().commit();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return object;
    }
  
    public void delete(Object object) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }
    
    public Object findByPrimaryKey(Class clazz, Object key ) {
        EntityManager em = null;
        Object obj = null;
        try {
            em = emf.createEntityManager();
            obj = em.find(clazz, obj);
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
        } finally {
            em.close();
        }
        return obj;
    }
    
    public Object findSingleResultByNamedQuery( String namedQuery, Object... obj ) {
        Object resultObj = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query q = em.createNamedQuery(namedQuery);
            for ( int i = 0; i < obj.length; i++) {
                q.setParameter(i, obj[i]);
            }
            resultObj = q.getSingleResult();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
        } finally {
            em.close();
        }
        return resultObj;
    }
    
    public List findResultListByNamedQuery( String namedQuery, Object... obj)  {
        List list = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query q = em.createNamedQuery(namedQuery);
            for ( int i = 0; i < obj.length; i++) {
                q.setParameter(i, obj[i]);
            }
            list = q.getResultList();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
        } finally {
            em.close();
        }
        return list;
    }
    
    public Object findSingleResultByNamedQuery( String namedQuery, Map map ) {
        Object resultObj = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query q = em.createNamedQuery(namedQuery);
            Set<Object> keys = map.keySet();
            for ( Object o : keys ) {
                q.setParameter((String)o, map.get(o));
            }
            resultObj = q.getSingleResult();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
        } finally {
            em.close();
        }
        return resultObj;
    }
    
    public List findResultListByNamedQuery( String namedQuery,  Map map)  {
        List list = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query q = em.createNamedQuery(namedQuery);
            Set<Object> keys = map.keySet();
            for ( Object o : keys ) {
                q.setParameter((String)o, map.get(o));
            }
            list = q.getResultList();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
        } finally {
            em.close();
        }
        return list;
    }

    
    private EntityManagerFactory emf;

}
