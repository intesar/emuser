/*
 * UserNotAdminException.java
 *
 * Created on May 6, 2007, 3:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.exceptions;

/**
 *
 * @author shannan
 */
public class UserNotAdminException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>UserNotAdminException</code> without detail message.
     */
    public UserNotAdminException() {
    }
    
    
    /**
     * Constructs an instance of <code>UserNotAdminException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public UserNotAdminException(String msg) {
        super(msg);
    }
}
