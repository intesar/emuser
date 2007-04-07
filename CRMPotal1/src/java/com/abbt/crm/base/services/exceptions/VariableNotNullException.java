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
public class VariableNotNullException extends Throwable {

    /** Creates a new instance of UniqueEntityException */
    public VariableNotNullException() {
        super("VariableNotNullException: Some Variables Cannot be null!");
    }

    public VariableNotNullException( String msg ) {
        super(msg);
    }
    
}
