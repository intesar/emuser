/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.payroll.entity.Users;

/**
 *
 * @author intesar
 */
public interface UsersDao extends GenericDao<Users, Integer>{
    Users findByUsername ( String username );
}
