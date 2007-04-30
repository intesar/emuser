/*
 * NoResultException.java
 *
 * Created on April 29, 2007, 10:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.exceptions;

/**
 *
 * @author shannan
 */
public class NoResultException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>NoResultException</code> without detail message.
     */
    public NoResultException() {
    }
    
    
    /**
     * Constructs an instance of <code>NoResultException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoResultException(String msg) {
        super(msg);
    }
}
