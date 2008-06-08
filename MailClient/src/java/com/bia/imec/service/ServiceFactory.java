/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author intesar
 */
public class ServiceFactory {

    public ServiceFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                    "classpath:context/applicationContext-Dao.xml",
                    //"classpath:ApplicationContext-JpaDaoFramework.xml",
                    "classpath:context/applicationContext-Service.xml",
                    "classpath:context/applicationContext-Transaction.xml"
                });

// an ApplicationContext is also a BeanFactory (via inheritance)
        factory = (BeanFactory) context;
    }
    private BeanFactory factory = null;
    private static ServiceFactory serviceFactory = new ServiceFactory();

    /**
     * 
     * @param name userServiceImpl, contactServiceImpl, emailsServiceImpl
     * @return
     */
    public static Object getService(String name) {
        return serviceFactory.factory.getBean(name);
    }

    public static void main(String[] args) {
        UsersService us = (UsersService) ServiceFactory.getService("usersServiceImpl");
    //us.mailPassword("mdshannan@gmail.com");

    }
}
