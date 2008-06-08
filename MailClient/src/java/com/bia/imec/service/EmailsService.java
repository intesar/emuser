/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service;

import com.bia.imec.entity.Contacts;
import com.bia.imec.entity.Emails;
import com.bia.imec.entity.MailServers;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface EmailsService {

    public List<MailServers> getAllMailServers();

    public List<Emails> getAllEmails(String status);

    public List<Contacts> getAllContacts();

    public void createMailServers(MailServers mailServers);

    public void updateEmails(Emails emails);//    public void createEmail(Emails emails);
    
    public void updateMailServers ( MailServers mailServers);
//
//    public void changeStatus(Integer email, String status);
//
//    public int getEmailCount(Date startdate, Date enddate);
//
//    public int getUserReplyCount(String username, Date dt1, Date dt2);
}
