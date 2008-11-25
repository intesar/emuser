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

import com.bizintelapps.promanager.dao.PagingParams;
import com.bizintelapps.promanager.service.UsersService;
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.service.validator.ValidationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
     *  every method should copy same pattern
     *  msg for success
     *  should catch exceptions exactly the same way
     * @param usersDto
     * @return
     */
    public String saveUser(UsersDto usersDto) {
        String msg = " User Created Successfully! ";
        try {
            // this should handle create/update
            usersService.saveUser(usersDto, SecurityUtil.getUsername());
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
    public PagingParams<UsersDto> getUserList() {
        try {
            return usersService.getUsers(SecurityUtil.getUsername());
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

    
    private UsersService usersService;
    private final String ERROR_MESSAGE = "Error, Please change input and try again!";
    private final Log log = LogFactory.getLog(getClass());
}
