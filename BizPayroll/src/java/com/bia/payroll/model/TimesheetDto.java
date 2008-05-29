/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author intesar
 */
public class TimesheetDto {
    private Integer id;
    private String status;
    private Double paidAmount;
    private String comment;
    private Date mondayDate;
    private Double mondayRegularHours;
    private Double mondayOverTimeHours;
    private Date tuesdayDate;
    private Double tuesdayRegularHours;
    private Double tuesdayOverTimeHours;
    private Date wednesdayDate;
    private Double wednesdayRegularHours;
    private Double wednesdayOverTimeHours;
    private Date thursdayDate;
    private Double thursdayRegularHours;
    private Double thursdayOverTimeHours;
    private Date fridayDate;
    private Double fridayRegularHours;
    private Double fridayOverTimeHours;
    private Date saturdayDate;
    private Double saturdayRegularHours;
    private Double saturdayOverTimeHours;
    private Date sundayDate;
    private Double sundayRegularHours;
    private Double sundayOverTimeHours;
    
    private String mondayDateString;
    private String tuesdayDateString;
    private String wednesdayDateString;
    private String thursdayDateString;
    private String fridayDateString;
    private String saturdayDateString;
    private String sundayDateString;
    
    
    
    

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFridayDate() {
        return fridayDate;
    }

    public void setFridayDate(Date fridayDate) {
        this.fridayDate = fridayDate;
    }

    public Double getFridayOverTimeHours() {
        return fridayOverTimeHours;
    }

    public void setFridayOverTimeHours(Double fridayOverTimeHours) {
        this.fridayOverTimeHours = fridayOverTimeHours;
    }

    public Double getFridayRegularHours() {
        return fridayRegularHours;
    }

    public void setFridayRegularHours(Double fridayRegularHours) {
        this.fridayRegularHours = fridayRegularHours;
    }

    public Date getMondayDate() {
        return mondayDate;
    }

    public void setMondayDate(Date mondayDate) {
        this.mondayDate = mondayDate;
    }

    public Double getMondayOverTimeHours() {
        return mondayOverTimeHours;
    }

    public void setMondayOverTimeHours(Double mondayOverTimeHours) {
        this.mondayOverTimeHours = mondayOverTimeHours;
    }

    public Double getMondayRegularHours() {
        return mondayRegularHours;
    }

    public void setMondayRegularHours(Double mondayRegularHours) {
        this.mondayRegularHours = mondayRegularHours;
    }

    public Date getSaturdayDate() {
        return saturdayDate;
    }

    public void setSaturdayDate(Date saturdayDate) {
        this.saturdayDate = saturdayDate;
    }

    public Double getSaturdayOverTimeHours() {
        return saturdayOverTimeHours;
    }

    public void setSaturdayOverTimeHours(Double saturdayOverTimeHours) {
        this.saturdayOverTimeHours = saturdayOverTimeHours;
    }

    public Double getSaturdayRegularHours() {
        return saturdayRegularHours;
    }

    public void setSaturdayRegularHours(Double saturdayRegularHours) {
        this.saturdayRegularHours = saturdayRegularHours;
    }

    public Date getSundayDate() {
        return sundayDate;
    }

    public void setSundayDate(Date sundayDate) {
        this.sundayDate = sundayDate;
    }

    public Double getSundayOverTimeHours() {
        return sundayOverTimeHours;
    }

    public void setSundayOverTimeHours(Double sundayOverTimeHours) {
        this.sundayOverTimeHours = sundayOverTimeHours;
    }

    public Double getSundayRegularHours() {
        return sundayRegularHours;
    }

    public void setSundayRegularHours(Double sundayRegularHours) {
        this.sundayRegularHours = sundayRegularHours;
    }

    public Date getThursdayDate() {
        return thursdayDate;
    }

    public void setThursdayDate(Date thursdayDate) {
        this.thursdayDate = thursdayDate;
    }

    public Double getThursdayOverTimeHours() {
        return thursdayOverTimeHours;
    }

    public void setThursdayOverTimeHours(Double thursdayOverTimeHours) {
        this.thursdayOverTimeHours = thursdayOverTimeHours;
    }

    public Double getThursdayRegularHours() {
        return thursdayRegularHours;
    }

    public void setThursdayRegularHours(Double thursdayRegularHours) {
        this.thursdayRegularHours = thursdayRegularHours;
    }

    public Date getTuesdayDate() {
        return tuesdayDate;
    }

    public void setTuesdayDate(Date tuesdayDate) {
        this.tuesdayDate = tuesdayDate;
    }

    public Double getTuesdayOverTimeHours() {
        return tuesdayOverTimeHours;
    }

    public void setTuesdayOverTimeHours(Double tuesdayOverTimeHours) {
        this.tuesdayOverTimeHours = tuesdayOverTimeHours;
    }

    public Double getTuesdayRegularHours() {
        return tuesdayRegularHours;
    }

    public void setTuesdayRegularHours(Double tuesdayRegularHours) {
        this.tuesdayRegularHours = tuesdayRegularHours;
    }

    public Date getWednesdayDate() {
        return wednesdayDate;
    }

    public void setWednesdayDate(Date wednesdayDate) {
        this.wednesdayDate = wednesdayDate;
    }

    public Double getWednesdayOverTimeHours() {
        return wednesdayOverTimeHours;
    }

    public void setWednesdayOverTimeHours(Double wednesdayOverTimeHours) {
        this.wednesdayOverTimeHours = wednesdayOverTimeHours;
    }

    public Double getWednesdayRegularHours() {
        return wednesdayRegularHours;
    }

    public void setWednesdayRegularHours(Double wednesdayRegularHours) {
        this.wednesdayRegularHours = wednesdayRegularHours;
    }

   
     public String getMondayDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        return sdf.format(mondayDate);
     }
        
         public String getTuesdayDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        return sdf.format(tuesdayDate);
         }
        
         public String getWednesdayDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        return sdf.format(wednesdayDate);
         }
        
         public String getThursdayDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        return sdf.format(thursdayDate);
         }
        
         public String getFridayDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        return sdf.format(fridayDate);
         }
        
         public String getSaturdayDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        return sdf.format(saturdayDate);
         }
        
    
    
    public String toString0() {
        return this.status + " " + this.mondayDate;
    }
    public String toString1() {
               return this.status + " " + this.tuesdayDate;
    }
    
    public String toString2() {
               return this.status + " " + this.wednesdayDate;
    }
    
    public String toString3() {
               return this.status + " " + this.thursdayDate;
    }
    
    public String toString4() {
               return this.status + " " + this.fridayDate;
    }
    
    public String toString5() {
               return this.status + " " + this.saturdayDate;
    }
    
    public String toString6() {
               return this.status + " " + this.sundayDate;
    }
    
}
