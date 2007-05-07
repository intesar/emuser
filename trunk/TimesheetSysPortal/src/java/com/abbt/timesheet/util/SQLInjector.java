/*
 * SQLInjector.java
 *
 * Created on May 6, 2007, 8:41 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.util;

/**
 *
 * @author shannan
 */
public class SQLInjector {
    
    /** Creates a new instance of SQLInjector */
    public SQLInjector() {
    }
    
    public static String removeCommentsAndQuotes( String string ) {
        
        String str = string;
        str = str.replaceAll("--", "");
        str = str.replaceAll("'", "");
        str = str.replaceAll("\"", "");
        return str;
        
        
    }
}
