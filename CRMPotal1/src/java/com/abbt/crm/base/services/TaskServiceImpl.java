/*
 * TaskServiceImpl.java
 *
 * Created on April 2, 2007, 8:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import com.abbt.crm.base.dao.GenericDAO;
import com.abbt.crm.base.dao.GenericDAOImpl;
import com.abbt.crm.base.entity.Tasks;
import java.util.List;

/**
 *
 * @author shannan
 */
public class TaskServiceImpl implements TaskService {
    private GenericDAO dao = new GenericDAOImpl();
    /**
     * Creates a new instance of TaskServiceImpl
     */
    public TaskServiceImpl() {
    }
    
    /*
     *  Retrieves most recent task for the given Recruiter
     */

    public List<Tasks> findRecentEmployeeTask ( String username ) {
        String jpaQuery = " select task from Tasks task where " +
            "task.assignedTo = '" + username + "' order by task.lastModifiedDate";
        return dao.find(jpaQuery);
    }

    public void setGenericDAO( GenericDAO dao) {
        this.dao = dao;
    }
}
