/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.service;

import com.cisco.questionbank.entity.Question;
import java.util.List;

/**
 *
 * @author inmohamm
 */
public interface QuestionService {

    /**
     *
     * @param questionText
     * @param correctChoice
     * @param incorrectChoice1
     * @param incorrectChoice2
     * @param incorrectChoice3
     * @param explanation
     * @param user
     */
    void addQuestion(String questionText, String correctChoice, String incorrectChoice1,
            String incorrectChoice2, String incorrectChoice3, String explanation, String user);

    /**
     * admin or owner can update a question
     * @param id
     * @param questionText
     * @param correctChoice
     * @param incorrectChoice1
     * @param incorrectChoice2
     * @param incorrectChoice3
     * @param explanation
     * @param user
     */
    void udpateQuestion(Integer id, String questionText, String correctChoice,
            String incorrectChoice1, String incorrectChoice2, String incorrectChoice3,
            String explanation, String user);

    /**
     * only admin or owner can delete a question
     * @param id
     * @param user
     */
    void deleteQuestion(Integer id, String user);

    /**
     * adding a comment
     * @param questionId
     * @param comment
     * @param user
     */
    void addComment(Integer questionId, String comment, String user);

    /**
     *
     * @param questionId
     * @param user
     */
    void bookmark(Integer questionId, String user);

    /**
     * user can only rank a question once
     * @param questionId
     * @param user
     */
    void incrementRank(Integer questionId, String user);

    /**
     *
     * @param questionId
     * @param duplidateText
     */
    void markDuplicate(Integer questionId, String duplidateText);

    /**
     *
     * @param createdBy
     * @return
     */
    List<Question> getMyQuestions(String createdBy);

    /**
     *
     * @return
     */
    List getHighRankQuestions();

    /**
     *
     * @return
     */
    List getQuestions();

    /**
     *
     * @param txt
     * @return
     */
    List search(String txt);

    Question getRandomQuestion();
}
