/*
 * TimesheetDetailUtil.java
 *
 * Created on May 6, 2007, 9:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.util;

import com.abbt.timesheet.entities.TimesheetDetail;
import java.util.List;

/**
 *
 * @author shannan
 */
public class TimesheetDetailUtil {
    
    /** Creates a new instance of TimesheetDetailUtil */
    public TimesheetDetailUtil() {
    }
    
    public TimesheetDetailTotalHourWrapper calculate( List<TimesheetDetail> list ) {
        TimesheetDetailTotalHourWrapper wrapper = null;
        double regH = 0.0;
        double oH = 0.0;
        double total = 0.0;
        for ( TimesheetDetail td : list ) {
            regH += td.getRegularHours();
            oH += td.getOverTimeHours();
            total = total + ( regH + oH );
        }
        wrapper = new TimesheetDetailTotalHourWrapper( regH, oH, total );
        return wrapper;
    }
}
