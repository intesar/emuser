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
package com.bizintelapps.promanager.service.impl;

import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.converters.UsersConverter;
import com.bizintelapps.promanager.service.UsersService;
import com.bizintelapps.promanager.service.dto.UsersDto;
import com.bizintelapps.promanager.service.validator.UsersValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class UsersServiceImpl implements UsersService {

    

    public void createUser(UsersDto usersDto) {
        usersValidator.validate(usersDto);
        Users users = usersConverter.convert ( usersDto );
        usersDao.create(users);
        
    }
    
    // getter & setters

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setUsersValidator(UsersValidator usersValidator) {
        this.usersValidator = usersValidator;
    }

    public void setUsersConverter(UsersConverter usersConverter) {
        this.usersConverter = usersConverter;
    }
    
    private UsersConverter usersConverter;
    private UsersValidator usersValidator;
    private UsersDao usersDao;
    private final Log log = LogFactory.getLog(getClass());
}
