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
import com.bizintelapps.promanager.service.dto.UsersDto;
import com.bizintelapps.promanager.service.validator.ValidationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class AjaxUsersService {

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
            usersService.createUser(usersDto);
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return ERROR_MESSAGE;
        }

        return msg;
    }

    public String changePassword(UsersDto usersDto) {
        String msg = " Password Changed Successfully! ";
        try {
            // FIXME create method in service
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return ERROR_MESSAGE;
        }

        return msg;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public UsersDto getUserDetails(Integer userId) {

        try {
            //FIXME
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
        //return ERROR_MESSAGE;
        }

        return null;
    }
    
    public PagingParams<UsersDto> getUserList() {

        try {
            //FIXME
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
        //return ERROR_MESSAGE;
        }

        return null;
    }

    public String enableDisalbeUser(Integer userId, boolean enabled) {
        String msg = " User Status Changed Successfully! ";
        try {
            //FIXME
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return ERROR_MESSAGE;
        }

        return msg;
    }

    public String deleteeUser(Integer userId) {
        String msg = " User Deleted Successfully! ";
        try {
            //FIXME
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
            return ERROR_MESSAGE;
        }

        return msg;
    }
    private UsersService usersService;
    private final String ERROR_MESSAGE = "Error, Please change input and try again!";
    private final Log log = LogFactory.getLog(getClass());
}
