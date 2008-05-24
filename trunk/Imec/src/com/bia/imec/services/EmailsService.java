/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.services;

import com.bia.imec.entity.Emails;
import com.bia.imec.entity.MailServers;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface EmailsService {

    public List<Emails> getAll(String status);
    
    public void createEmail(Integer email);
    
    public void changeStatus(Integer email, String status);

    public int getEmailCount(Date startdate, Date enddate);
    
    public  int getUserReplyCount(String username, Date dt1, Date dt2);
    
    public void addEmailservice(MailServers es);
    }
