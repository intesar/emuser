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
package com.bizintelapps.proaccounting.dao.impl;

import com.bizintelapps.proaccounting.dao.UsersDao;
import com.bizintelapps.proaccounting.entity.Users;
import org.apache.log4j.Logger;
import org.springframework.test.jpa.AbstractJpaTests;

/**
 *
 * @author intesar
 */
public class UsersDaoImplTest extends AbstractJpaTests {

    private Logger log = Logger.getLogger(getClass());
    private UsersDao usersDao;

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    protected String[] getConfigLocations() {
        return new String[]{
                    "classpath:applicationContext-dao-test.xml",
                    "classpath:applicationContext-service.xml",
                    "classpath:applicationContext-service-transactions.xml"
                };
    }

    protected void onSetUpInTransaction() throws Exception {
        Users user1 = new Users(20, "username", "password", true);
        usersDao.create(user1);
//        jdbcTemplate.execute("insert into users (id, username, password, first_name, last_name, enabled ) values (3000, 'username1', 'na', 'na', 'na', 1)");
//        jdbcTemplate.execute("insert into users (id, username, password, first_name, last_name, enabled ) values (3001, 'username2', 'na', 'na', 'na', 1)");
//        jdbcTemplate.execute("insert into users (id, username, password, first_name, last_name, enabled ) values (3002, 'username3', 'na', 'na', 'na', 1)");

    }

    public void testFindByIdWhereUserExists() {
        Users user = usersDao.read(20);
        log.debug(user.getUsername());
        assertNotNull(user);
    }
}
