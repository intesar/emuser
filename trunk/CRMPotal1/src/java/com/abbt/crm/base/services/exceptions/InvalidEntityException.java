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
public class InvalidEntityException extends Throwable {

    /** Creates a new instance of UniqueEntityException */
    public InvalidEntityException() {
        super("InvalidEntityException: Entity Deosn't exists!");
    }

    public InvalidEntityException( String msg ) {
        super(msg);
    }
    
}
