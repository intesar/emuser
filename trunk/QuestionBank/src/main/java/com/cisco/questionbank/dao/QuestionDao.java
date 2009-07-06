/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.dao;

import com.cisco.questionbank.entity.Question;
import java.util.List;

/**
 *
 * @author inmohamm
 */
public interface QuestionDao {

    public void create(Question question);

    public void update(Question question);

    public void delete (Question question);

    public List<Question> findByCreatedBy(String user);

    public Question findById(Integer id);
}
