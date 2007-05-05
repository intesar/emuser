/*
 * DateUtil.java
 *
 * Created on May 5, 2007, 6:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services.util;

import java.util.Calendar;

/**
 *
 * @author shannan
 */
public class DateUtil {
    
    /** Creates a new instance of DateUtil */
    public DateUtil() {
    }
    /*
     *  return "SUN", "MON", ... depending on the day of the week passed
     */
    public static String getDay( int day ) {
        
        if ( day == Calendar.SUNDAY ) {
            return "SUN";
        } else if ( day == Calendar.MONDAY ) {
            return "MON";
        } else if ( day == Calendar.TUESDAY ) {
            return "TUE";
        } else if ( day == Calendar.WEDNESDAY ) {
            return "WED";
        } else if ( day == Calendar.THURSDAY ) {
            return "THU";
        } else if ( day == Calendar.FRIDAY ) {
            return "FRI";
        } else  {
            return "SAT";
        }
        
    }
}
