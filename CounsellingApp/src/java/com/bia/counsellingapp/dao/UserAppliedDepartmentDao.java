/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.counsellingapp.entity.UserAppliedDepartment;

import java.util.List;

/**
 *
 * @author intesar
 */
public interface UserAppliedDepartmentDao extends GenericDao<UserAppliedDepartment, Integer>{

    public List<UserAppliedDepartment> findByUserId(Integer userId);

    public List<UserAppliedDepartment> findByUserIdAndPriority(Integer userId, Integer priority);
    
    public UserAppliedDepartment findByUserIdAndCollegeAndDepartment(Integer userId, String college, String department);
    
    public UserAppliedDepartment findByUserIdAndTopPriority(Integer userid, Integer userId);
    
    public List<UserAppliedDepartment> findByIdOrderByPriority (Integer userId);

}
