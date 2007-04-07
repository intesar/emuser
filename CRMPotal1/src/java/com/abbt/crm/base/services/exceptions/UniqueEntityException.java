/*
 * UniqueEntityException.java
 *
 * Created on April 6, 2007, 10:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services.exceptions;

/**
 *
 * @author shannan
 */
public class UniqueEntityException extends Throwable {

    /** Creates a new instance of UniqueEntityException */
    public UniqueEntityException() {
        super("UniqueEntityException: Entity already exists!");
    }

    public UniqueEntityException( String msg ) {
        super(msg);
    }
    
}
