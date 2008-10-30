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
package com.bizintelapps.proaccounting.service.impl;

import com.bizintelapps.proaccounting.dao.UsersDao;
import com.bizintelapps.proaccounting.entity.Users;
import com.bizintelapps.proaccounting.service.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author intesar
 */
public class UsersServiceImpl implements UsersService {

    private Logger log = Logger.getLogger(getClass());
    private UsersDao usersDao;

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void saveUser(Users users) {
        usersDao.create(users);
    }

    public void dummy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                    "classpath:applicationContext-dao.xml",
                    "classpath:applicationContext-service.xml",
                    "classpath:applicationContext-service-transactions.xml",
                    "classpath:applicationContext-schedule.xml",
                });

// an ApplicationContext is also a BeanFactory (via inheritance)
        BeanFactory factory = (BeanFactory) context;
        UsersService uas = (UsersService) factory.getBean("usersServiceImpl");
        Users u = new Users(10, "alskdj", "asldjf", true);
        uas.saveUser(u);
    }
}
