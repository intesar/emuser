/*
 * EntityNotFoundException.java
 *
 * Created on April 29, 2007, 10:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.exceptions;

/**
 *
 * @author shannan
 */
public class EntityNotFoundException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>EntityNotFoundException</code> without detail message.
     */
    public EntityNotFoundException() {
    }
    
    
    /**
     * Constructs an instance of <code>EntityNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
