/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services;

/**
 *
 * @author mdshannan
 */
public interface EMailService {

    String airtel = "@airtelap.com";
    String idea = "@ideacellular.net";
    String hutch = "@south.hutch.co.in";
    String bsnl = "@bsnlumS.com";
    String _160BY2 = "@160by2.com";
    static final String SMTP_HOST_NAME = "smtp.gmail.com";
    static final String SMTP_PORT = "465";
    static final String EMAIL_MESSAGE_TEXT = "";
    static final String EMAIL_SUBJECT_TEXT = " BizIntelApps FaceGuard Accounts Status Report ";
    static final String EMAIL_SUBJECT_TEXT_160BY2 = "bizintelapps1";
    static final String EMAIL_FROM_ADDRESS = "faceguard2@bizintelapps.com";
    static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    static final String[] SEND_TO = {"mohdshannan@yahoo.com"};
    static final String SEND_FROM_USERNAME = "faceguard2@bizintelapps.com";
    static final String SEND_FROM_PASSWORD = "Abbh1234";
    static final String EMAIL_CONTENT_TYPE = "text/html";
    static final String EMAIL_SIGNATURE = " <br><br> Users have often told us that the more " +
            "they use FaceGuard, the more they discover its benefits. " +
            " We'll keep working on making FaceGuard the best Application for your business, " +
            
            " <br/> <br/> <br/> For any queries reach us at info@bizintelapps.com " +
            "<br/> <br/>Thanks , <br/>The BizIntelApps, FaceGuard Team ";

    void SendMail(String[] sendTo);

    void sendEmail(String toAddress, String body);

    void sendEmail(String[] toAddress, String body);

    void sendEmail(String toAddress, String subject, String body);

    void sendEmail(String[] toAddress, String subject, String body);
}