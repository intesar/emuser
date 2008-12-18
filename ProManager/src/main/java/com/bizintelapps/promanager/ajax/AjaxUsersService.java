/*
 *  Copyright 2008 intesar.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.bizintelapps.promanager.ajax;

import com.bizintelapps.mail.MailSender;
import com.bizintelapps.promanager.service.UsersService;
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.service.validator.ValidationException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author intesar
 */
public class AjaxUsersService {

    public String signUp(UsersDto usersDto) {
        String msg = " You have Successfully Signed Up! ";
        try {
            // this should handle create/update
            usersService.signUp(usersDto);
            mailSender.sendMail(new String[]{}, "Welcome to Pro-Task-Management, Here's what you need to know.", "");
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return e.getMessage();
        }
        return msg;
    }

    /**
     *  every method should copy same pattern
     *  msg for success
     *  should catch exceptions exactly the same way
     * @param usersDto
     * @return
     */
    public List<UsersDto> saveUser(UsersDto usersDto) {
        try {
            // this should handle create/update
            return usersService.saveAndGetUser(usersDto, SecurityUtil.getUsername());
        } catch (ValidationException e) {
            log.error(e);
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
        }
        throw new RuntimeException("Error, Please try again! ");
    }

    /**
     * 
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public String changePassword(Integer userId, String oldPassword, String newPassword) {
        String msg = " Password Changed Successfully! ";
        try {
            usersService.changePassword(userId, oldPassword, newPassword, SecurityUtil.getUsername());
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return ERROR_MESSAGE;
        }

        return msg;
    }

    /**
     * 
     * @param userId
     * @return
     */
    public UsersDto getUserDetails(Integer userId) {

        try {
            // FIXME
            throw new RuntimeException("Not Supported");
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
        //return ERROR_MESSAGE;
        }

        return null;
    }

    /**
     * 
     * @return
     */
    public List<UsersDto> getUserList() {
        try {
            return usersService.getUsers(SecurityUtil.getUsername()).getCurrentList();
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
        //return ERROR_MESSAGE;
        }
        return null;
    }

    /**
     * 
     * @param userId
     * @param enabled
     * @return
     */
    public String enableDisalbeUser(Integer userId, boolean enabled) {
        String msg = " User Status Changed Successfully! ";
        try {
            usersService.enableDisableUser(userId, enabled, SecurityUtil.getUsername());
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return ERROR_MESSAGE;
        }

        return msg;
    }

    /**
     * 
     * @param userId
     * @return
     */
    public String deleteeUser(Integer userId) {
        String msg = " User Deleted Successfully! ";
        try {
            usersService.deleteUser(userId, SecurityUtil.getUsername());
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return ERROR_MESSAGE;
        }

        return msg;
    }

    /**
     * 
     * @param usersService
     */
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Autowired
    private MailSender mailSender;
    @Autowired
    private UsersService usersService;
    private final String ERROR_MESSAGE = "Error, Please change input and try again!";
    private final Log log = LogFactory.getLog(getClass());
}
