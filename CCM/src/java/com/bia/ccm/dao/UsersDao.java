/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.ccm.entity.Users;

/**
 *
 * @author imran
 */
public interface UsersDao extends GenericDao<Users,Integer>{
    public Users findByUsername(String username);

}
