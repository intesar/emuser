/*
 * DateUtil.java
 *
 * Created on May 5, 2007, 6:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    
    public static void isDateStartsWith1or16(Date date ) throws IllegalArgumentException {
        
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day =  c.get(Calendar.DAY_OF_MONTH);
        
        if  ( ! (day == 1 || day == 16) ) {
            throw new IllegalArgumentException();
        }
        
    }
    
    public static List<Month> findAllMonths() {
        
        List<Month> list = new ArrayList<Month> ();
        for ( int i = 0; i < months.length; i++ ) {
            Month month = new Month();
            month.setName(months[i]);
            month.setSortNumber(i);
            list.add(month);
        }
        
        return list;
    }
    
    private static String[] months = {
        "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"
    };
    
}
