/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cisco.questionbank.service.impl;

import com.cisco.questionbank.service.QuestionService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author inmohamm
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext-dao.xml", "applicationContext-services.xml"});

// an ApplicationContext is also a BeanFactory (via inheritance)
        BeanFactory factory = context;
        QuestionService instance = (QuestionService) context.getBean("qb");
        instance.addQuestion("abc", "a", null, null, null, "exp");
    }
}
