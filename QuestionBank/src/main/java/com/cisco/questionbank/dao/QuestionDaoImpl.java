/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.dao;

import com.cisco.questionbank.dao.QuestionDao;
import com.cisco.questionbank.entity.Question;
import java.util.List;
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

    public void update(Question question) {
        entityManager.merge(question);
    }

    public void delete(Question question) {
        entityManager.remove(question);
    }

    public List<Question> findByCreatedBy(String user) {
        return entityManager.createNamedQuery("Question.findByCreatedBy").setParameter("createdBy", user).getResultList();
    }

    public Question findById(Integer id) {
        return (Question) entityManager.createNamedQuery("Question.findById").setParameter("id", id).getSingleResult();

    }

    public Long findCount() {
        return (Long) entityManager.createNamedQuery("Question.findCount").getSingleResult();
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
