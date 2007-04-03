/*
 * TaskService.java
 *
 * Created on April 2, 2007, 9:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.services;

import com.abbt.crm.entity.Contact;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface TaskService {
    List<Contact> findRecentEmployeeTask(String username);

}
