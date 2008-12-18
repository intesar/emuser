package com.bizintelapps.mail;

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

/**
 *
 * @author mdshannan
 */
class EmailServiceImpl implements EmailService {

    private EmailHostWrapper[] emailHostWrappers;
    private EmailHostWrapper emailHostWrapper;
    private int count = 0;
    private String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private String EMAIL_CONTENT_TYPE = "text/html";

    EmailServiceImpl(EmailHostWrapper[] emailHostWrappers) {
        this.emailHostWrappers = emailHostWrappers;
        emailHostWrapper = this.emailHostWrappers[count];
    }

    public void changeHost() {
        if (count == this.emailHostWrappers.length) {
            throw new RuntimeException("No Host available");
        }
        this.emailHostWrapper = this.emailHostWrappers[++count];
    }

    @Override
    public void sendEmail(String[] to, String subject,
            String message) throws AddressException, MessagingException {

        log.debug("inside sendEmail");
        if (to == null || (subject == null && message == null)) {
            throw new RuntimeException("Invalid input to:" + to + " title:" + subject + " message:" + message);
        }
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        InternetAddress[] addressTO = null;
        addressTO = new InternetAddress[to.length];
        for (int i = 0; i < to.length; i++) {
            if (to[i] != null && to[i].length() > 0) {
                addressTO[i] = new InternetAddress(to[i]);
            }
        }

        log.debug("before props");
        Properties props = new Properties();
        props.put("mail.smtp.host", emailHostWrapper.getHost());
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", emailHostWrapper.getPort());
        props.put("mail.smtp.socketFactory.port", emailHostWrapper.getPort());
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailHostWrapper.getFrom(), emailHostWrapper.getPassword());
                    }
                });

        log.debug("before debug");
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        log.debug("session");
        InternetAddress addressFrom = new InternetAddress(emailHostWrapper.getFrom());
        log.debug("addressFrom");
        msg.setFrom(addressFrom);
        msg.setRecipients(Message.RecipientType.TO, addressTO);
        log.debug("To");
        msg.setSubject(subject);
        log.debug("Subject");
        log.debug("message : " + message + " content type " + EMAIL_CONTENT_TYPE);
        msg.setContent(message, EMAIL_CONTENT_TYPE);
        log.debug("before send");
        Transport.send(msg);
        log.debug("after send");

    }
    private Logger log = Logger.getLogger(getClass());
}
