/*
 * TimesheetDetailTotalHourWrapper.java
 *
 * Created on May 6, 2007, 9:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.util;

/**
 *
 * @author shannan
 */
public class TimesheetDetailTotalHourWrapper {
    
    /**
     * Creates a new instance of TimesheetDetailTotalHourWrapper
     */
    public TimesheetDetailTotalHourWrapper( double totalRegularHours, double totalOvertimeHours, double totalHours) {
        this.totalRegularHours = totalRegularHours;
        this.totalOvertimeHours  = totalOvertimeHours;
        this.totalHours = totalHours;
    }
    
    
    
    public double getTotalRegularHours() {
        return totalRegularHours;
    }
    
    public void setTotalRegularHours(double totalRegularHours) {
        this.totalRegularHours = totalRegularHours;
    }
    
    public double getTotalOvertimeHours() {
        return totalOvertimeHours;
    }
    
    public void setTotalOvertimeHours(double totalOvertimeHours) {
        this.totalOvertimeHours = totalOvertimeHours;
    }
    
    public double getTotalHours() {
        return totalHours;
    }
    
    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }
    
    private double totalRegularHours;
    private double totalOvertimeHours;
    private double totalHours;
}
