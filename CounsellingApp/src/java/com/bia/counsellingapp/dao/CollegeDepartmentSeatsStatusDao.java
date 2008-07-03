/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.counsellingapp.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.counsellingapp.entity.CollegeDepartmentSeatsStatus;
import com.bia.counsellingapp.entity.CollegeDepartmentSeatsStatusPK;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface CollegeDepartmentSeatsStatusDao extends GenericDao<CollegeDepartmentSeatsStatus, CollegeDepartmentSeatsStatusPK> {

    CollegeDepartmentSeatsStatus findByCollegeAndDepartmentAndName(String colg, String dept, String name);
    List<CollegeDepartmentSeatsStatus> findByCollegeName(String colg);
    //void findAndDeleteAll();
}
