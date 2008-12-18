/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bizintelapps.mail;

/**
 *
 * @author intesar
 */
public interface MailSender {

    public void sendMail(String[] to, String subject, String body);
}
