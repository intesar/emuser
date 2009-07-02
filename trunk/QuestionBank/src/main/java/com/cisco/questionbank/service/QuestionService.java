/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.service;

import java.util.List;

/**
 *
 * @author inmohamm
 */
public interface QuestionService {


    /**
     * adding new question
     *
     * @param questionText
     * @param correctChoice
     * @param incorrectChoice1
     * @param incorrectChoice2
     * @param incorrectChoice3
     * @param explanation
     */
    public void addQuestion(String questionText, String correctChoice,
            String incorrectChoice1, String incorrectChoice2, String incorrectChoice3,
            String explanation);

    /**
     * returns instructor created questions
     */
    public List getMyQuestions();

    /**
     *  deletes instructor created question
     */
    public void deleteQuestion(Integer questionId);

    /**
     *  updates existing question
     */
    public void udpateQuestion();

    /**
     *
     */
    public List getQuestions();

    /**
     *
     */
    public void addComment(Integer questionId, String comment);

    /**
     *
     */
    public void incrementRank(Integer questionId);

    /**
     *
     */
    public void markDuplicate(Integer questionId, String duplidateText);

    /**
     *
     */
    public List getHighRankQuestions();

    /**
     *
     *
     */
    public List search(String txt);
}
