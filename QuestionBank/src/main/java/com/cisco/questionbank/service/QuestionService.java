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

    void addComment(Integer questionId, String comment, String user);

    void addQuestion(String questionText, String correctChoice, String incorrectChoice1, String incorrectChoice2, String incorrectChoice3, String explanation);

    void bookmark(Integer questionId, String user);

    void deleteQuestion(Integer id);

    List getHighRankQuestions();

    List<Question> getMyQuestions(String createdBy);

    List getQuestions();

    void incrementRank(Integer questionId, String user);

    void markDuplicate(Integer questionId, String duplidateText);

    List search(String txt);

    void udpateQuestion(Integer id, String questionText, String correctChoice, String incorrectChoice1, String incorrectChoice2, String incorrectChoice3, String explanation);

}
