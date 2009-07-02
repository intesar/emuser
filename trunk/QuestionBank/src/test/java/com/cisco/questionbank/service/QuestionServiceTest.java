/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.questionbank.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author inmohamm
 */
public class QuestionServiceTest {

    static QuestionService instance;

    public QuestionServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //ApplicationContext context = new ClassPathXmlApplicationContext(
        //        new String[]{"applicationContext-dao.xml", "applicationContext-services.xml"});

// an ApplicationContext is also a BeanFactory (via inheritance)
        //BeanFactory factory = context;
        //instance = (QuestionService) context.getBean("questionServiceAjax"); // ---
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addQuestion method, of class QuestionService.
     */
    @Test
    public void testAddQuestion() {
        System.out.println("addQuestion");
        String questionText = "abc";
        String correctChoice = "a";
        String incorrectChoice1 = "";
        String incorrectChoice2 = "";
        String incorrectChoice3 = "";
        String explanation = "no explanation";

        //instance.addQuestion(questionText, correctChoice, incorrectChoice1, incorrectChoice2, incorrectChoice3, explanation);


    }
}
