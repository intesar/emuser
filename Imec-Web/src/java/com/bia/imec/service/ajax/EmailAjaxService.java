/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.ajax;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.imec.converter.EmailsConverter;
import com.bia.imec.converter.MailServersConverter;
import com.bia.imec.dto.EmailsDto;
import com.bia.imec.dto.MailServersDto;
import com.bia.imec.entity.Emails;
import com.bia.imec.entity.MailServers;
import com.bia.imec.service.ajax.util.DateUtil;
import com.bia.imec.services.EmailsService;
import com.bia.imec.services.ServiceFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class EmailAjaxService {

    public List<EmailsDto> getAll(String status) {
        List<Emails> emails = emailsService.getAll(null).getResults();
        List<EmailsDto> dtos = new ArrayList<EmailsDto>();
        for (Emails e : emails) {
            EmailsDto dto = new EmailsDto();
            emailsConverter.copy(e, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    public String createEmail(EmailsDto emailsDto) {
        Emails emails = new Emails();
        emailsConverter.copy(emailsDto, emails);
        try {
            emailsService.createEmail(emails);
            return " Created User on " + DateUtil.getDate();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String changeStatus(Integer emailDto, String status) {
        try {
            emailsService.changeStatus(emailDto, status);
            return " Updated User on " + DateUtil.getDate();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public int getEmailCount(Date startdate, Date enddate) {

        return 0;
    }

    public int getUserReplyCount(String username, Date dt1, Date dt2) {
        return 0;

    }

    public String createEmailservers(MailServersDto es) {
        MailServers emails = new MailServers();
        mailServersConverter.copy(es, emails);
        try {
            emailsService.createEmailserver(emails);
            return " Created MailServer on " + DateUtil.getDate();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
    public String updateEmailServer(MailServersDto mailServersDto) {
        MailServers emails = new MailServers();
        mailServersConverter.copy(mailServersDto, emails);
        try {
            emailsService.createEmailserver(emails);
            return " Updated MailServer info on " + DateUtil.getDate();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
    public List<MailServersDto> getAllMailServers () {
        PagedResult<MailServers> pg = emailsService.getAllMailServers();
        List<MailServers> list = pg.getResults();
        List<MailServersDto> dtos = new ArrayList<MailServersDto>();
        for ( MailServers m : list ) {
            MailServersDto dto = new MailServersDto();
            mailServersConverter.copy(m, dto);
            dtos.add(dto);            
        }
        return dtos;
    }
    
    private MailServersConverter mailServersConverter = new MailServersConverter();
    private EmailsConverter emailsConverter = new EmailsConverter();
    private EmailsService emailsService = (EmailsService) ServiceFactory.getService("emailsServiceImpl");
}
