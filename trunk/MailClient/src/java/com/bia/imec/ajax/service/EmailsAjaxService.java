/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.ajax.service;

import com.bia.imec.entity.Contacts;
import com.bia.imec.entity.Emails;
import com.bia.imec.entity.MailServers;
import com.bia.imec.service.EmailsService;
import com.bia.imec.service.ServiceFactory;
import java.util.List;

/**
 *
 * @author intesar
 */
public class EmailsAjaxService {

    public List<MailServers> getAllMailServers() {
        return emailsService.getAllMailServers();
    }

    public List<Emails> getAllEmails(String status) {
        return emailsService.getAllEmails(status);
    }

    public void createEmailserver(MailServers mailServers) {
        emailsService.createMailServers(mailServers);
    }

    public List<Contacts> getAllContacts() {
        return emailsService.getAllContacts();
    }

    public void createMailServers(MailServers mailServers) {
        if (mailServers.getId() > 0) {
            emailsService.updateMailServers(mailServers);            
        } else {
            emailsService.createMailServers(mailServers);
        }
    }

    public void updateEmails(Emails emails) {
        emailsService.updateEmails(emails);
    }
    private EmailsService emailsService = (EmailsService) ServiceFactory.getService("emailsServiceImpl");
}
