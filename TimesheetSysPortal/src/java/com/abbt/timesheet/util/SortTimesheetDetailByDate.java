/*
 * SortTimesheetDetailByDate.java
 *
 * Created on May 6, 2007, 9:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.util;

import com.abbt.timesheet.entities.TimesheetDetail;
import java.util.Comparator;

/**
 *
 * @author shannan
 */
public class SortTimesheetDetailByDate implements Comparator {
    
    public int compare(Object f, Object s) {
        TimesheetDetail o1 = (TimesheetDetail) f;
        TimesheetDetail o2 = (TimesheetDetail) s;
        if (o1.getTimesheetDetailDate().before(o2.getTimesheetDetailDate())) {
            return -1;
        } else if (o2.getTimesheetDetailDate().before(o1.getTimesheetDetailDate())) {
            return 0;
        }
        return 1;
    }
    
    
    /** Creates a new instance of SortTimesheetDetailByDate */
    public SortTimesheetDetailByDate() {
    }
    
}
