/*
 * DateValidator.java
 *
 * Created on May 2, 2007, 6:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.portlets.timesheetCreator;

import java.util.Date;

/**
 *
 * @author shannan
 */
public class DateValidator {
    
    /** Creates a new instance of DateValidator */
    public DateValidator() {
    }
    
    public static void validate (Date date ) throws IllegalArgumentException {
        
        if  ( date.getDate() == 1 || date.getDate() == 16 ) {
            // to nothing
            ;
        }
        else {
            throw new IllegalArgumentException();
        }
        
    }
}
