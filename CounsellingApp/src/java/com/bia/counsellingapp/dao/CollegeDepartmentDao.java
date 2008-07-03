/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.counsellingapp.entity.CollegeDepartment;
import com.bia.counsellingapp.entity.CollegeDepartmentPK;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface CollegeDepartmentDao extends GenericDao<CollegeDepartment, CollegeDepartmentPK>{
    
    public List<String> findByCollege(String college) ;
    CollegeDepartment findByCollegeAndDepartment(String college, String department);

}
