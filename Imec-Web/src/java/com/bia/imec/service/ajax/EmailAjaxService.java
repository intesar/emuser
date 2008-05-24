/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.ajax;

import com.bia.imec.dto.EmailsDto;
import com.bia.imec.dto.MailServersDto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class EmailAjaxService {

    public List<EmailsDto> getAll(String status) {
        return null;
    }

    public void createEmail(Integer emailDto) {
    }

    public void changeStatus(Integer emailDto, String status) {
    }

    public int getEmailCount(Date startdate, Date enddate) {

        return 0;
    }

    public int getUserReplyCount(String username, Date dt1, Date dt2) {
        return 0;

    }

    public void addEmailservice(MailServersDto es) {
    }
}
