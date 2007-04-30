/*
 * EntityExistsException.java
 *
 * Created on April 29, 2007, 10:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.exceptions;

/**
 *
 * @author shannan
 */
public class EntityExistsException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>EntityExistsException</code> without detail message.
     */
    public EntityExistsException() {
    }
    
    
    /**
     * Constructs an instance of <code>EntityExistsException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EntityExistsException(String msg) {
        super(msg);
    }
}
