/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.imec.entity.User;

/**
 *
 * @author intesar
 */
public interface UsersDao extends GenericDao<User, String> {
    User findByUsersname(String username);
}
