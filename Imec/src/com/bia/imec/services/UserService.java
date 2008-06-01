/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.services;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.imec.entity.User;

/**
 *
 * @author intesar
 */
public interface UserService {

    public PagedResult<User> getAll(String username, PagingParams pagingParams);
    
    public void createUser(String username, User users);
    
    
    
    
    void mailPassword(String username);
    
}