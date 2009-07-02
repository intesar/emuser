/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.dao.impl;

import com.cisco.questionbank.dao.QuestionDao;
import com.cisco.questionbank.entity.Question;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author inmohamm
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {

    public void create(Question question) {
        entityManager.persist(question);
    }
    //private final Log log = LogFactory.getLog(getClass());
    // default FinderNamingStrategy can be overriden in Spring config
    private EntityManager entityManager;

    // ****************************** constructors ******************************
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
