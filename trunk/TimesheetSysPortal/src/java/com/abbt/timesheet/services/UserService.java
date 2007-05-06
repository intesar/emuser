/*
 * UserService.java
 *
 * Created on May 5, 2007, 8:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import com.abbt.timesheet.entities.User;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface UserService {
    List<User> findAllUserEmails();
    
}
