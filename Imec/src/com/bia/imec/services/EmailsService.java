/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.services;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.imec.entity.Emails;
import com.bia.imec.entity.MailServers;
import java.util.Date;

/**
 *
 * @author intesar
 */
public interface EmailsService {

    public PagedResult<MailServers> getAllMailServers();

    public PagedResult<Emails> getAll(PagingParams pagingParams);

    public void createEmail(Emails emails);

    public void changeStatus(Integer email, String status);

    public int getEmailCount(Date startdate, Date enddate);

    public int getUserReplyCount(String username, Date dt1, Date dt2);

    public void createEmailserver(MailServers mailServers);

    public void updateEmailServer(MailServers mailServers);
}
