/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.counsellingapp.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.counsellingapp.entity.College;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface CollegeDao extends GenericDao<College, String> {
    public List<String> findAllCollegeNames(String gender);
}
