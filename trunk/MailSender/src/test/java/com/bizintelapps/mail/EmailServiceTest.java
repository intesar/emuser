/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bizintelapps.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author intesar
 */
//@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "/base-context.xml" in the root of the classpath
@ContextConfiguration()
public class EmailServiceTest extends AbstractDependencyInjectionSpringContextTests {

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:applicationContext-mail.xml"};
    }
    private MailSender mailSender;

    public EmailServiceTest() {
    }

    @Required
    @Autowired
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of sendEmail method, of class EmailService.
     */
    @org.junit.Test
    public void testSendEmail() throws Exception {
        System.out.println("sendEmail");
        String[] to = {"intesar.mohammed@bizintelapps.com"};
        String subject = "test";
        String body = "test";
        try {
            this.mailSender.sendMail(to, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
    }

    /**
     * Test of sendEmail method, of class EmailService.
     */
    @org.junit.Test
    public void testSendEmail1() throws Exception {
        System.out.println("sendEmail");
        String[] to = {"intesar.mohammed@bizintelapps.com","mdshannan@gmail.com"};
        String subject = "test";
        String body = "test";
        try {
            this.mailSender.sendMail(to, subject, body);
            this.mailSender.sendMail(to, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
    }
}