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

package com.bizintelapps.promanager.dao;

import com.bizintelapps.promanager.entity.Users;
import java.util.List;


/**
 *
 * @author intesar
 */
public interface UsersDao extends GenericDao<Users, Integer> {
    public List<Users> findByOrganizationId(Integer organizationId);
    /**
     * 
     * @param username
     * @return Users Object if finds 
     */
    public Users findByUsername ( String username );
    
    /**
     * email is unique
     * @param email
     * @return
     */
    public Users findByEmail ( String email );

}
