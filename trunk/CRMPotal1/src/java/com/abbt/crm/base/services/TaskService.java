/*
 * TaskService.java
 *
 * Created on April 2, 2007, 9:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import com.abbt.crm.base.entity.Tasks;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface TaskService {
    List<Tasks> findRecentEmployeeTask(String username);

}
