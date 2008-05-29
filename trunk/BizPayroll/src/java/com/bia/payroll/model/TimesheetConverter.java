/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.model;

import com.bia.payroll.entity.Timesheet;
import com.bia.payroll.entity.TimesheetDetail;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author intesar
 */
public class TimesheetConverter {

    public void copy(TimesheetDto timesheetDto, Timesheet timesheet) {

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
        
    }

    public void copy(Timesheet timesheet, TimesheetDto timesheetDto) {
        if (timesheet != null) {
            timesheetDto.setId(timesheet.getId());
            timesheetDto.setPaidAmount(timesheet.getPaidAmount());
            timesheetDto.setStatus(timesheet.getStatus());

            Collection<TimesheetDetail> details = timesheet.getTimesheetDetailCollection();

            for (TimesheetDetail d : details) {
                if (d.getDay().equalsIgnoreCase("mon")) {
                    timesheetDto.setMondayDate(d.getCurDate());
                    timesheetDto.setMondayRegularHours(d.getRegularHour());
                    timesheetDto.setMondayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("tue")) {
                    timesheetDto.setTuesdayDate(d.getCurDate());
                    timesheetDto.setTuesdayRegularHours(d.getRegularHour());
                    timesheetDto.setTuesdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("wed")) {
                    timesheetDto.setWednesdayDate(d.getCurDate());
                    timesheetDto.setWednesdayRegularHours(d.getRegularHour());
                    timesheetDto.setWednesdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("thu")) {
                    timesheetDto.setThursdayDate(d.getCurDate());
                    timesheetDto.setThursdayRegularHours(d.getRegularHour());
                    timesheetDto.setThursdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("fri")) {
                    timesheetDto.setFridayDate(d.getCurDate());
                    timesheetDto.setFridayRegularHours(d.getRegularHour());
                    timesheetDto.setFridayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("sat")) {
                    timesheetDto.setSaturdayDate(d.getCurDate());
                    timesheetDto.setSaturdayRegularHours(d.getRegularHour());
                    timesheetDto.setSaturdayOverTimeHours(d.getOverTimeHour());
                } else if (d.getDay().equalsIgnoreCase("sun")) {
                    timesheetDto.setSundayDate(d.getCurDate());
                    timesheetDto.setSundayRegularHours(d.getRegularHour());
                    timesheetDto.setSundayOverTimeHours(d.getOverTimeHour());
                }

            }
        }
        
    }

    public void copyToDetail(TimesheetDto timesheetDto, Timesheet timesheet) {
        if (timesheetDto != null) {
            timesheet.setId(timesheetDto.getId());
            //timesheet.setPaidAmount(timesheetDto.getPaidAmount());
            timesheet.setStatus(timesheetDto.getStatus());

            TimesheetDetail td1 = new TimesheetDetail();
            TimesheetDetail td2 = new TimesheetDetail();
            TimesheetDetail td3 = new TimesheetDetail();
            TimesheetDetail td4 = new TimesheetDetail();
            TimesheetDetail td5 = new TimesheetDetail();
            TimesheetDetail td6 = new TimesheetDetail();
            TimesheetDetail td7 = new TimesheetDetail();

            Iterator<TimesheetDetail> iterator = timesheet.getTimesheetDetailCollection().iterator();
            while (iterator.hasNext()) {
                TimesheetDetail d = iterator.next();
                if (d.getDay().equalsIgnoreCase("monday")) {
                    td1 = d;
                } else if (d.getDay().equalsIgnoreCase("monday")) {
                    td2 = d;
                } else if (d.getDay().equalsIgnoreCase("monday")) {
                    td3 = d;
                } else if (d.getDay().equalsIgnoreCase("monday")) {
                    td4 = d;
                } else if (d.getDay().equalsIgnoreCase("monday")) {
                    td5 = d;
                } else if (d.getDay().equalsIgnoreCase("monday")) {
                    td6 = d;
                } else {
                    td7 = d;
                }
            }
            td1.setDay("monday");
            td1.setRegularHour(timesheetDto.getMondayRegularHours());
            td1.setOverTimeHour(timesheetDto.getMondayOverTimeHours());
            timesheet.getTimesheetDetailCollection().add(td1);

            
            td2.setDay("tuesday");
            td2.setRegularHour(timesheetDto.getTuesdayRegularHours());
            td2.setOverTimeHour(timesheetDto.getTuesdayOverTimeHours());
            

            
            td3.setDay("wednesday");
            td3.setRegularHour(timesheetDto.getWednesdayRegularHours());
            td3.setOverTimeHour(timesheetDto.getWednesdayOverTimeHours());
            

            
            td4.setDay("thursday");
            td4.setRegularHour(timesheetDto.getThursdayRegularHours());
            td4.setOverTimeHour(timesheetDto.getThursdayOverTimeHours());
            

            
            td5.setDay("friday");
            td5.setRegularHour(timesheetDto.getFridayRegularHours());
            td5.setOverTimeHour(timesheetDto.getFridayOverTimeHours());
            

            
            td6.setDay("saturday");
            td6.setRegularHour(timesheetDto.getSaturdayRegularHours());
            td6.setOverTimeHour(timesheetDto.getSaturdayOverTimeHours());
            

            
            td7.setDay("sunday");
            td7.setRegularHour(timesheetDto.getSundayRegularHours());
            td7.setOverTimeHour(timesheetDto.getSundayOverTimeHours());
            

        }

    }
}
