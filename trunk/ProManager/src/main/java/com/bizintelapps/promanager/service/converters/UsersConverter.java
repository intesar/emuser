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

package com.bizintelapps.promanager.service.converters;

import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.dto.UsersDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author intesar
 */
public class UsersConverter {

    public List<UsersDto> copyAllForDisplay(Collection<Users> usersCollection) {
        List<UsersDto> list = new ArrayList<UsersDto> ();
        for ( Users users : usersCollection ) {
            UsersDto usersDto = copyForDisplay(users, new UsersDto() );
            list.add(usersDto);
        }
        return list;
    }
    
    public UsersDto copyForDisplay ( Users users, UsersDto usersDto ) {
        usersDto.setCity(users.getCity());
        usersDto.setCountry(users.getCountry());
        usersDto.setEmail(users.getEmail());
        usersDto.setEnabled(users.getEnabled());
        usersDto.setExpirationDate(users.getExpirationDate());
        usersDto.setFirstname(users.getFirstname());
        usersDto.setId(users.getId());
        usersDto.setLastname(users.getLastname());
        usersDto.setAdministrator(users.isIsAdministrator());
        usersDto.setUsername(users.getUsername());
        return usersDto;
    }

    /**
     * copies everything from userDto to users
     * @param usersDto
     * @param users
     * @return
     */
    public Users copyForCreate(UsersDto usersDto, Users users) {        
        users.setCity(usersDto.getCity());
        users.setCountry(usersDto.getCountry());
        users.setEmail(usersDto.getEmail());
        users.setEnabled(usersDto.isEnabled());
        users.setExpirationDate(usersDto.getExpirationDate());
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(usersDto.getLastname());
        users.setIsAdministrator(usersDto.isAdministrator());
        users.setCreateDate(usersDto.getCreateDate());
        users.setCreateUser(usersDto.getCreateUser());
        users.setPassword(usersDto.getPassword());
        users.setUsername(usersDto.getUsername());
        return users;
    }

    public Users copyForSignUp(UsersDto usersDto, Users users) {
        users.setCity(usersDto.getCity());
        users.setCountry(usersDto.getCountry());
        users.setEmail(usersDto.getEmail());
        users.setEnabled(true);
        users.setExpirationDate(null);
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(usersDto.getLastname());
        users.setIsAdministrator(true);
        users.setPassword(usersDto.getPassword());
        users.setUsername(usersDto.getUsername());        
        return users;
    }

    /**
     * only copies fields that can be changed from client side
     * @param usersDto
     * @param users
     * 
     */
    public Users copyForUpdate(UsersDto usersDto, Users users) {
        users.setCity(usersDto.getCity());
        users.setCountry(usersDto.getCountry());
        users.setEmail(usersDto.getEmail());
        users.setEnabled(usersDto.isEnabled());
        users.setExpirationDate(usersDto.getExpirationDate());
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(usersDto.getLastname());
        users.setIsAdministrator(usersDto.isAdministrator());
        return users;        
    }

}
