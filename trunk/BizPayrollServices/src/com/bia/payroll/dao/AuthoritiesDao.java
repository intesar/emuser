/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.payroll.entity.Authorities;
import com.bia.payroll.entity.AuthoritiesPK;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface AuthoritiesDao extends GenericDao<Authorities, AuthoritiesPK> {
    public List<Authorities> findByUsername(String name) ;
}
