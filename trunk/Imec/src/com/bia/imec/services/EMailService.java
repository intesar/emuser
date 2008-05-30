/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.services;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author mdshannan
 */
public interface EMailService {

    static final String SMTP_HOST_NAME = "smtp.gmail.com";
    static final String SMTP_PORT = "465";
    static final String EMAIL_MESSAGE_TEXT = " BizIntelApps ";
    static final String EMAIL_SUBJECT_TEXT = " Password Request ";
    static final String EMAIL_FROM_ADDRESS = "mdshannan1@gmail.com";
    static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    static final String[] SEND_TO = {"mohdshannan@yahoo.com"};
    static final String SEND_FROM_USERNAME = "mdshannan1";
    static final String SEND_FROM_PASSWORD = "Abbh1234";
    static final String EMAIL_CONTENT_TYPE = "text/html";

    void SendMail(String[] sendTo);

    void sendEmail(String toAddress, String body);

    void sendEmail(String[] toAddress, String body);
}