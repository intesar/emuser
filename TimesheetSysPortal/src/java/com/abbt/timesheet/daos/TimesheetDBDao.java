/*
 * TimesheetDBDao.java
 *
 * Created on May 2, 2007, 6:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.daos;

import com.abbt.timesheet.exceptions.EntityExistsException;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface TimesheetDBDao {
    void delete(Object object);

    Object findByPrimaryKey(Class clazz, Object key);

    List findResultListByNamedQuery(String namedQuery, Object... obj);

    Object findSingleResultByNamedQuery(String namedQuery, Object... obj);

    void save(Object object) throws EntityExistsException, IllegalArgumentException;

    Object update(Object object);
    
}
