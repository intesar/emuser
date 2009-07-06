/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.ajax;

import com.cisco.questionbank.entity.Question;
import com.cisco.questionbank.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author inmohamm
 */
public class QuestionServiceAjax {

    public void addQuestion(String questionText, String correctChoice,
            String incorrectChoice1, String incorrectChoice2, String incorrectChoice3,
            String explanation) {

        String user = "inmohamm";
        questionService.addQuestion(questionText, correctChoice, incorrectChoice1,
                incorrectChoice2, incorrectChoice3, explanation, user);
    }

    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }
    // getters and setters

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Autowired
    private QuestionService questionService;
}
