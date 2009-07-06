/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.service;

import com.cisco.questionbank.dao.QuestionDao;

import com.cisco.questionbank.entity.Question;
import com.cisco.questionbank.entity.QuestionComment;
import com.cisco.questionbank.entity.QuestionRank;
import com.cisco.questionbank.entity.UserBookmarks;
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

        System.out.println(" inside addQuestion....");
        // create a new question and add to db
        Question question = new Question();
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

    public List<Question> getMyQuestions(String createdBy) {
        List<Question> list = null;
        list = questionDao.findByCreatedBy(createdBy);
        return list;
    }

    public void deleteQuestion(Integer id) {
        Question question = questionDao.findById(id);
        questionDao.delete(question);
    }

    public void udpateQuestion(Integer id, String questionText, String correctChoice,
            String incorrectChoice1, String incorrectChoice2, String incorrectChoice3,
            String explanation) {
        Question question = questionDao.findById(id);
        // update question with new values
        // todo check user is createdBy
        question.setQuestionText(questionText);
        question.setCorrectChoice(correctChoice);
        question.setIncorrectChoice1(incorrectChoice1);
        question.setIncorrectChoice2(incorrectChoice2);
        question.setIncorrectChoice3(incorrectChoice3);
        question.setExplanation(explanation);
        questionDao.update(question);
    }

    public List getQuestions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addComment(Integer questionId, String comment, String user) {
        QuestionComment questionComment = new QuestionComment();
        questionComment.setCommentText(comment);
        questionComment.setCommentedUser(user);
        Question question = questionDao.findById(questionId);
        question.getQuestionCommentList().add(questionComment);
        questionDao.update(question);
    }

    public void incrementRank(Integer questionId, String user) {
        QuestionRank questionRank = new QuestionRank();
        questionRank.setRankedUser(user);
        Question question = questionDao.findById(questionId);
        question.getQuestionRankList().add(questionRank);
        // update rank in pre update
        questionDao.update(question);
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

    public void bookmark(Integer questionId, String user) {
        UserBookmarks userBookmarks = new UserBookmarks();
        Question question = questionDao.findById(questionId);
        userBookmarks.setQuestionId(question);
        userBookmarks.setUser(user);
        question.getUserBookmarksList().add(userBookmarks);
        questionDao.update(question);
    }

    // getter and setters
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
    @Autowired
    private QuestionDao questionDao;
}
