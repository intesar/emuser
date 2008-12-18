package com.bizintelapps.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 *
 * @author intesar
 */
interface EmailService {

    void sendEmail(String[] to, String subject, String body) throws AddressException, MessagingException;

    public void changeHost();
}
