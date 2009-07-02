/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.service.impl;

import com.cisco.questionbank.dao.QuestionDao;
import com.cisco.questionbank.dao.UserBookmarksDao;
import com.cisco.questionbank.entity.Question;
import com.cisco.questionbank.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmohamm
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    public void addQuestion(String questionText, String correctChoice,
            String incorrectChoice1, String incorrectChoice2, String incorrectChoice3,
            String explanation) {

        System.out.println ( " inside addQuestion....");
        // create a new question and add to db
        Question question = new Question ();
        question.setQuestionText(questionText);
        question.setCorrectChoice(correctChoice);
        question.setIncorrectChoice1(incorrectChoice1);
        question.setIncorrectChoice2(incorrectChoice2);
        question.setIncorrectChoice3(incorrectChoice3);
        question.setExplanation(explanation);
        //question.setCreateDate(new Date());
        question.setCreatedBy("inmohamm");
        //question.setModifiedDate(new Date());
        questionDao.create(question);

    }

    public List getMyQuestions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteQuestion(Integer questionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void udpateQuestion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List getQuestions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addComment(Integer questionId, String comment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void incrementRank(Integer questionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void markDuplicate(Integer questionId, String duplidateText) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List getHighRankQuestions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List search(String txt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void setUserBookmarksDao(UserBookmarksDao userBookmarksDao) {
        this.userBookmarksDao = userBookmarksDao;
    }

    @Autowired
    private QuestionDao questionDao;
    private UserBookmarksDao userBookmarksDao;
}
