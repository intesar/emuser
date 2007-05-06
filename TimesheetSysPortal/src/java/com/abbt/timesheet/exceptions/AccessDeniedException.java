/*
 * AccessDeniedException.java
 *
 * Created on May 6, 2007, 3:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.exceptions;

/**
 *
 * @author shannan
 */
public class AccessDeniedException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>AccessDeniedException</code> without detail message.
     */
    public AccessDeniedException() {
    }
    
    
    /**
     * Constructs an instance of <code>AccessDeniedException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public AccessDeniedException(String msg) {
        super(msg);
    }
}
