/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.converter;

import com.bia.imec.dto.*;
import com.bia.imec.dto.EmailsDto;
import com.bia.imec.entity.Emails;

/**
 *
 * @author imran
 */
public class EmailsConverter {

    public void copy(EmailsDto emailsDto, Emails emails) {

        if (emailsDto != null) {
            emails.setId(emailsDto.getId());
            emails.setFrom(emailsDto.getFrom());
            emails.setTo(emailsDto.getTo());
            emails.setCc(emailsDto.getCc());
            emails.setBcc(emailsDto.getBcc());
            emails.setSubject(emailsDto.getSubject());
            emails.setContextText(emailsDto.getContextText());
            emails.setEmailDate(emailsDto.getEmailDate());
            emails.setStatus(emailsDto.getStatus());
            emails.setAgent(emailsDto.getAgent());
            emails.setStatusDate(emailsDto.getStatusDate());
            emails.setReplyOf(emailsDto.getReplyOf());
        }
    }

    public void copy(Emails emails, EmailsDto emailsDto) {

        if (emails != null) {
            emailsDto.setId(emails.getId());
            emailsDto.setFrom(emails.getFrom());
            emailsDto.setTo(emails.getTo());
            emailsDto.setCc(emails.getCc());
            emailsDto.setBcc(emails.getBcc());
            emailsDto.setSubject(emails.getSubject());
            emailsDto.setContextText(emails.getContextText());
            emailsDto.setEmailDate(emails.getEmailDate());
            emailsDto.setStatus(emails.getStatus());
            emailsDto.setAgent(emails.getAgent());
            emailsDto.setStatusDate(emails.getStatusDate());
            emailsDto.setReplyOf(emails.getReplyOf());
        }
    }
}
