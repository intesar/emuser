/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.services.impl;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.imec.dao.EmailsDao;
import com.bia.imec.dao.MailServersDao;
import com.bia.imec.entity.Emails;
import com.bia.imec.entity.MailServers;
import com.bia.imec.services.EmailsService;
import java.util.Date;

/**
 *
 * @author intesar
 */
public class EmailsServiceImpl implements EmailsService {

    public void setEmailsDao(EmailsDao emailsDao) {
        this.emailsDao = emailsDao;
    }

    public void setMailServersDao(MailServersDao mailServersDao) {
        this.mailServersDao = mailServersDao;
    }
    private MailServersDao mailServersDao;
    private EmailsDao emailsDao;

    public PagedResult<Emails> getAll(PagingParams pagingParams) {
        return emailsDao.readAll(pagingParams);
    }

    public void createEmail(Emails emails) {
        emailsDao.create(emails);
    }

    public void changeStatus(Integer email, String status) {
        Emails emails = emailsDao.read(email);
        emails.setStatus(status);
        emailsDao.update(emails);
    }

    public int getEmailCount(Date startdate, Date enddate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getUserReplyCount(String username, Date dt1, Date dt2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createEmailserver(MailServers mailServers) {
        mailServersDao.create(mailServers);
    }

    public void updateEmailServer(MailServers mailServers) {
        mailServersDao.update(mailServers);
    }
}
