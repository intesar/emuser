package com.bizintelapps.mail;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;

/**
 *
 * @author intesar
 * 
 * <bean id="" class="com.bizintelapps.mail.MailSenderImpl">
 *     <property name="emailHostWrapper">
 *        <list>
 *          <bean ref="emailHostWrapper1" />
 *          <bean ref="emailHostWrapper1" />
 *        </list>
 *     </property>
 * </bean>
 * 
 * <bean id="emailHostWrapper1" class="com.bizintelapps.mail.EmailHostWrapper">
 *     <prperty name="host" value="smtp.gmail.com" />
 *     <prperty name="port" value="465" />
 *     <prperty name="from" value="abc1@bizintelapps.com" />
 *     <prperty name="password" value="secret" />
 * </bean>
 * 
 * <bean id="emailHostWrapper2" class="com.bizintelapps.mail.EmailHostWrapper">
 *     <prperty name="host" value="smtp.gmail.com" />
 *     <prperty name="port" value="465" />
 *     <prperty name="from" value="abc2@bizintelapps.com" />
 *     <prperty name="password" value="secret" />
 * </bean>
 */
public class MailSenderImpl implements MailSender {

    private Logger log = Logger.getLogger(getClass());
    private EmailService emailService;
    private ExecutorService executorService;
    private EmailHostWrapper[] emailHostWrappers;

    public MailSenderImpl() {
        executorService = Executors.newCachedThreadPool();
    }

    public void setEmailHostWrappers(EmailHostWrapper[] emailHostWrappers) {
        this.emailHostWrappers = emailHostWrappers;
        emailService = new EmailServiceImpl(emailHostWrappers);
    }

    /**
     * 
     * @param to
     * @param cc
     * @param bcc
     * @param subject
     * @param body
     * 
     */
    @Override
    public void sendMail(String[] to, String subject, String body) {
        log.debug("added to executor " + new Date());
        try {
            executorService.execute(new EmailSenderRunnable(emailService, to, subject, body));
        } catch (AuthenticationException re) {
            sendMail(to, subject, body);
        }
    }

    class EmailSenderRunnable implements Runnable {

        private EmailService emailService;
        private String[] to;
        private String subject;
        private String body;

        public EmailSenderRunnable(EmailService emailService, String[] to, String subject, String body) {
            this.emailService = emailService;
            this.to = to;
            this.subject = subject;
            this.body = body;
        }

        @Override
        public void run() {
            try {
                try {
                    log.debug("run executed " + new Date());
                    emailService.sendEmail(to, subject, body);
                    log.debug("run exiting " + new Date());
                } catch (javax.mail.AuthenticationFailedException afe) {
                    log.error(afe);
                    this.emailService.changeHost();
                    emailService.sendEmail(to, subject, body);
                }
            } catch (AddressException ex) {
                ex.printStackTrace();
                log.error(ex);
            } catch (MessagingException ex) {
                ex.printStackTrace();
                log.error(ex);
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error(ex);
            }
        }
        private Logger log = Logger.getLogger(getClass());
    }
}

class AuthenticationException extends RuntimeException {
}

