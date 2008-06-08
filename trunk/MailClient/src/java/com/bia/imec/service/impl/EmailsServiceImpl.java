/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.impl;

import com.bia.imec.dao.ContactsDao;
import com.bia.imec.dao.EmailsDao;
import com.bia.imec.dao.MailServersDao;
import com.bia.imec.entity.Contacts;
import com.bia.imec.entity.Emails;
import com.bia.imec.entity.MailServers;
import com.bia.imec.service.DateUtil;
import com.bia.imec.service.EmailsService;
import java.util.List;

/**
 *
 * @author intesar
 */
public class EmailsServiceImpl implements EmailsService {

    public List<MailServers> getAllMailServers() {
        return this.mailServersDao.readAll().getResults();
    }

    public List<Emails> getAllEmails(String status) {
        return this.emailsDao.readAll().getResults();
    }

    public void createEmailserver(MailServers mailServers) {
        this.mailServersDao.create(mailServers);
    }

    public List<Contacts> getAllContacts() {
        return contactsDao.readAll().getResults();
    }

    public void createMailServers(MailServers mailServers) {
        this.mailServersDao.create(mailServers);
    }

    public void updateEmails(Emails emails) {
        this.emailsDao.update(emails);
    }

    public void updateMailServers(MailServers mailServers) {
        this.mailServersDao.update(mailServers);
    }

    public String deleteMailServers(Integer id) {
        mailServersDao.delete(new MailServers(id));
        return " Deleted on " + DateUtil.getDate();
    }

    public void setEmailsDao(EmailsDao emailsDao) {
        this.emailsDao = emailsDao;
    }

    public void setMailServersDao(MailServersDao mailServersDao) {
        this.mailServersDao = mailServersDao;
    }

    public void setContactsDao(ContactsDao contactsDao) {
        this.contactsDao = contactsDao;
    }
    private EmailsDao emailsDao;
    private MailServersDao mailServersDao;
    private ContactsDao contactsDao;
}
