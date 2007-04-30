/*
 * NonUniqueResultException.java
 *
 * Created on April 29, 2007, 10:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.exceptions;

/**
 *
 * @author shannan
 */
public class NonUniqueResultException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>NonUniqueResultException</code> without detail message.
     */
    public NonUniqueResultException() {
    }
    
    
    /**
     * Constructs an instance of <code>NonUniqueResultException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NonUniqueResultException(String msg) {
        super(msg);
    }
}
