/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.model;

import com.bia.payroll.entity.Timesheet;
import com.bia.payroll.entity.TimesheetDetail;
import java.util.Collection;

/**
 *
 * @author intesar
 */
public class TimesheetConverter {

    public Timesheet copy(TimesheetDto timesheetDto, Timesheet timesheet) {
        
        if (timesheetDto != null) {
            timesheet.setId(timesheetDto.getId());
            timesheet.setPaidAmount(timesheetDto.getPaidAmount());
            timesheet.setStatus(timesheetDto.getStatus());
            TimesheetDetail td1 = new TimesheetDetail();
            td1.setDay("monday");
            td1.setRegularHour(timesheetDto.getMondayRegularHours());
            td1.setOverTimeHour(timesheetDto.getMondayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

            td1 = new TimesheetDetail();
            td1.setDay("tuesday");
            td1.setRegularHour(timesheetDto.getTuesdayRegularHours());
            td1.setOverTimeHour(timesheetDto.getTuesdayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

            td1 = new TimesheetDetail();
            td1.setDay("wednesday");
            td1.setRegularHour(timesheetDto.getWednesdayRegularHours());
            td1.setOverTimeHour(timesheetDto.getWednesdayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

            td1 = new TimesheetDetail();
            td1.setDay("thursday");
            td1.setRegularHour(timesheetDto.getThursdayRegularHours());
            td1.setOverTimeHour(timesheetDto.getThursdayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

            td1 = new TimesheetDetail();
            td1.setDay("friday");
            td1.setRegularHour(timesheetDto.getFridayRegularHours());
            td1.setOverTimeHour(timesheetDto.getFridayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

            td1 = new TimesheetDetail();
            td1.setDay("saturday");
            td1.setRegularHour(timesheetDto.getSaturdayRegularHours());
            td1.setOverTimeHour(timesheetDto.getSaturdayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

            td1 = new TimesheetDetail();
            td1.setDay("sunday");
            td1.setRegularHour(timesheetDto.getSundayRegularHours());
            td1.setOverTimeHour(timesheetDto.getSundayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

        }
        return timesheet;
    }

    public TimesheetDto copy(Timesheet timesheet, TimesheetDto timesheetDto) {        
        if (timesheet != null) {
            timesheetDto.setId(timesheet.getId());
            timesheetDto.setPaidAmount(timesheet.getPaidAmount());
            timesheetDto.setStatus(timesheet.getStatus());

            Collection<TimesheetDetail> details = timesheet.getTimesheetDetailCollection();

            for (TimesheetDetail d : details) {
                if (d.getDay().equalsIgnoreCase("monday")) {
                    timesheetDto.setMondayDate(d.getCurrentDate());
                    timesheetDto.setMondayRegularHours(d.getRegularHour());
                    timesheetDto.setMondayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("tuesday")) {
                    timesheetDto.setTuesdayDate(d.getCurrentDate());
                    timesheetDto.setTuesdayRegularHours(d.getRegularHour());
                    timesheetDto.setTuesdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("wednesday")) {
                    timesheetDto.setWednesdayDate(d.getCurrentDate());
                    timesheetDto.setWednesdayRegularHours(d.getRegularHour());
                    timesheetDto.setWednesdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("thursday")) {
                    timesheetDto.setThursdayDate(d.getCurrentDate());
                    timesheetDto.setThursdayRegularHours(d.getRegularHour());
                    timesheetDto.setThursdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("friday")) {
                    timesheetDto.setFridayDate(d.getCurrentDate());
                    timesheetDto.setFridayRegularHours(d.getRegularHour());
                    timesheetDto.setFridayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("saturday")) {
                    timesheetDto.setSaturdayDate(d.getCurrentDate());
                    timesheetDto.setSaturdayRegularHours(d.getRegularHour());
                    timesheetDto.setSaturdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("sunday")) {
                    timesheetDto.setSundayDate(d.getCurrentDate());
                    timesheetDto.setSundayRegularHours(d.getRegularHour());
                    timesheetDto.setSundayOverTimeHours(d.getOverTimeHour());
                }

            }
        }
        return timesheetDto;
    }
}
