package com.bizintelapps.proaccounting.dao.impl;

import com.bizintelapps.proaccounting.dao.GenericDao;
import com.bizintelapps.proaccounting.dao.PagedResult;
import com.bizintelapps.proaccounting.dao.PagingParams;
import java.io.Serializable;
import javax.persistence.EntityManagerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * Hibernate implementation of GenericDao. A typesafe implementation of CRUD and finder methods
 * based on Hibernate and Spring AOP. The finders are implemented through the executeFinder method.
 * Normally called by the FinderIntroductionInterceptor.
 *
 * 
 */
public class GenericDaoJPAImpl<T, PK extends Serializable> extends JpaDaoSupport implements GenericDao<T, PK> {
    
    

    static final Log log = LogFactory.getLog(GenericDaoJPAImpl.class);
    // default FinderNamingStrategy can be overriden in Spring config
    private Class<T> type;
    // ****************************** ctors ******************************
    public GenericDaoJPAImpl(Class<T> type) {
        this.type = type;
    }
    // ****************************** methods ******************************
    @SuppressWarnings(value = "unchecked")
    public PK create(T o) {
        getJpaTemplate().persist(o);
        return null;
    }

    @SuppressWarnings(value = "unchecked")
    public T read(PK id) {        
        return getJpaTemplate().find(type, id);
    }

    public void update(T o) {        
        getJpaTemplate().merge(o);
    }

    public void delete(T o) {        
        getJpaTemplate().remove(o);

    }

    @SuppressWarnings(value = "unchecked")
    public PagedResult<T> findAll(final PagingParams... pagingParams) {
        
        String ql = " select o from " + type.getSimpleName() + " o ";
        if (pagingParams != null && pagingParams.length > 0 && pagingParams[0] != null && pagingParams[0].getSortBy() != null && pagingParams[0].getSortBy().length() > 0) {
            ql = " select o from " + type.getSimpleName() + " o " + pagingParams[0].getSortBy();
        }
        return null;
    }
}