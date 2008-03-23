/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.jpadaoframework.dao;

import com.abbhsoft.jpadaoframework.dao.finderhelper.FinderNamingStrategy;
import com.abbhsoft.jpadaoframework.dao.finderhelper.SimpleFinderNamingStrategy;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;

import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;

/**
 * Hibernate implementation of GenericDao. A typesafe implementation of CRUD and finder methods
 * based on Hibernate and Spring AOP. The finders are implemented through the executeFinder method.
 * Normally called by the FinderIntroductionInterceptor.
 *
 * 
 */
public class GenericDaoJPAImpl<T, PK extends Serializable> extends JpaTemplate implements GenericDao<T, PK>, FinderExecutor {

    static final Log log = LogFactory.getLog(GenericDaoJPAImpl.class);
    // default FinderNamingStrategy can be overriden in Spring config
    private FinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategy();
    private Class<T> type;
    // ****************************** ctors ******************************
    public GenericDaoJPAImpl(Class<T> type) {
        this.type = type;
    }
    // ****************************** methods ******************************
    @SuppressWarnings(value = "unchecked")
    public PK create(T o) {
        this.persist(o);
        return null;
    }

    @SuppressWarnings(value = "unchecked")
    public T read(PK id) {
        System.out.println(type);
        return this.find(type, id);
    }

    public void update(T o) {
        System.out.println(" Inside update ");
        this.merge(o);
    }

    public void delete(T o) {
        System.out.println(" Inside Delete ");
        this.remove(o);

    }

    @SuppressWarnings(value = "unchecked")
    public PagedResult<T> findAll(final PagingParams... pagingParams) {
        String ql = " select o from " + type.getSimpleName() + " o ";
        if (pagingParams != null && pagingParams.length > 0 && pagingParams[0] != null && pagingParams[0].getSortBy() != null && pagingParams[0].getSortBy().length() > 0) {
            ql = " select o from " + type.getSimpleName() + " o " + pagingParams[0].getSortBy();
        }
        final String jpql = ql;
        List list = executeQueryReturnList(jpql, pagingParams);
        String jpqlCount = " select count(o) from " + type.getSimpleName() + " o ";
        @SuppressWarnings("unchecked")
        PagedResult pagedResult = new PagedResult(executeQueryReturnint(jpqlCount).intValue(), list);
        return pagedResult;

    }

    private Integer executeQueryReturnint(final String jpql) throws DataAccessException {
        return (Integer) execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery(jpql);
                Long result = (Long) query.getSingleResult();
                return result.intValue();
            }
        });
    }

    private List<T> executeQueryReturnList(final String jpql, final PagingParams[] pagingParams) throws DataAccessException {
        return (List<T>) execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery(jpql);
                if (pagingParams != null && pagingParams.length > 0 && pagingParams[0] != null) {
                    query.setFirstResult((int) pagingParams[0].getStart());
                    query.setMaxResults(pagingParams[0].getLimit());
                }
                List result = query.getResultList();
                return result;
            }
        });
    }

    @SuppressWarnings(value = "unchecked")
    public Iterator<T> iterateFinder(Method method, final Object[] queryArgs) {
        return null;
    }

    @SuppressWarnings(value = "unchecked")
    public T executeSingleResultFinder(Method method, final Object[] queryArgs) {
        return prepareSingleResultQuery(method, queryArgs);
    }

    @SuppressWarnings("unchecked")
    private T prepareSingleResultQuery(final Method method, final Object[] queryArgs) {
        final String queryName = getNamingStrategy().queryNameFromMethod(type, method);
        return (T) execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query namedQuery = em.createNamedQuery(queryName);
                setPositionalParams(queryArgs, namedQuery);
                Object obj = null;
                try {
                    obj = namedQuery.getSingleResult();
                } catch (Exception e) {
                    // logger
                }
                return obj;
            }
        });
    }

    @SuppressWarnings(value = "unchecked")
    public List<T> executeFinder(Method method, final Object[] queryArgs) {
        return prepareQuery(method, queryArgs);
    }

    @SuppressWarnings(value = "unchecked")
    public PagedResult<T> executePagedResultFinder(Method method, final Object[] queryArgs) {
        PagedResult pagedResult = new PagedResult();
        pagedResult.setResults(prepareQuery(method, queryArgs));
        pagedResult.setTotalResults(prepareCountQuery(method, queryArgs));
        return pagedResult;
    }

    private List prepareQuery(final Method method, final Object[] queryArgs) {
        final String queryName = getNamingStrategy().queryNameFromMethod(type, method);
        return (List) execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                PagingParams pagingParams = getPagingParams(queryArgs);
                String queryString = null;
                Query query = em.createNamedQuery(queryName);
                if (pagingParams != null) {
                    if (pagingParams.getSortBy() != null && pagingParams.getSortBy().length() > 0) {
                        queryString = buildQueryUsingReflection(queryName, pagingParams.getSortBy());
                        if (queryString != null) {
                            query = em.createQuery(queryString);
                        }
                    }
                    query.setFirstResult((int) pagingParams.getStart());
                    query.setMaxResults(pagingParams.getLimit());
                }
                setPositionalParams(queryArgs, query);
                return query.getResultList();
            }
        });
    }

    private String buildQueryUsingReflection(String queryName, String orderyByField) {

        String query = null;
        String alias = this.type.getSimpleName().charAt(0) + ".";
        NamedQueries namedQueries = this.type.getAnnotation(NamedQueries.class);
        for (NamedQuery namedQuery : namedQueries.value()) {
            if (namedQuery.name().equals(queryName)) {
                query = namedQuery.query() + " order by " + alias + orderyByField;
            }
        }
        return query;
    }

    private Long prepareCountQuery(final Method method, final Object[] queryArgs) {
        final String queryName = getNamingStrategy().countQueryNameFromMethod(type, method);
        return (Long) execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                Long count = 0L;
                try {
                    Query namedQuery = em.createNamedQuery(queryName);
                    setPositionalParams(queryArgs, namedQuery);
                    count = (Long) namedQuery.getSingleResult();
                } catch (RuntimeException r) {
                    // logger
                }
                return count;
            }
        });
    }

    private void setPositionalParams(Object[] queryArgs, Query namedQuery) {
        // Set parameter. Use custom Hibernate Type if necessary
        if (queryArgs != null) {
            for (int i = 1; i <= queryArgs.length; i++) {
                Object arg = queryArgs[i - 1];
                if (!(arg instanceof PagingParams[])) {
                    namedQuery.setParameter(i, arg);
                }
            }
        }
    }

    private PagingParams getPagingParams(Object[] queryArgs) {

        if (queryArgs != null) {
            for (int i = 1; i <= queryArgs.length; i++) {
                Object arg = queryArgs[i - 1];
                if (arg instanceof PagingParams[]) {
                    PagingParams[] pagingParams = (PagingParams[]) arg;
                    if (pagingParams != null && pagingParams.length > 0 && pagingParams[0] != null) {
                        return pagingParams[0];
                    }
                }
            }
        }
        return null;
    }

    //    private void setNamedParams(String[] namedParameters, Object[] queryArgs, Query namedQuery) {
//        // Set parameter. Use custom Hibernate Type if necessary
//        if (queryArgs != null) {
//            for (int i = 0; i < queryArgs.length; i++) {
//                Object arg = queryArgs[i];
//
//                if (arg instanceof Collection) {
//                    namedQuery.setParameterList(namedParameters[i], (Collection) arg);
//                } else {
//                    namedQuery.setParameter(namedParameters[i], arg);
//                }
//            }
//        }
//    }
    // ****************************** getters & setters ******************************
    public FinderNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }

    public void setNamingStrategy(FinderNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }
}
