/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.payroll.entity.Authorities;

import java.util.List;

/**
 *
 * @author intesar
 */
public interface AuthoritiesDao extends GenericDao<Authorities, Integer> {

    public List<Authorities> findByUsername(String name);
    
    public Authorities findByUsernameAndAuthority ( String username, String authority );
    
    public void findAndDeleteByUsernameAndAuthority (String username, String authority );
    
}
