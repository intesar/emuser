/*
 *  Copyright 2008 intesar.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package com.bizintelapps.promanager.dto;

import java.util.Date;

/**
 *
 * @author intesar
 */
public class UserReportDto {

    private String username;
    private String firstname;
    private String lastname;
    private Date startDate;
    private String startDateFomated;
    private int totalOpenTask;
    private int recentlyAssignedTask;
    private int recentlyCompletedTask;
    private int recentlyAllocatedHours;
    private int recentlySpendHours;
    private int hoursToFinish;
    private double efficiency;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getHoursToFinish() {
        return hoursToFinish;
    }

    public void setHoursToFinish(int hoursToFinish) {
        this.hoursToFinish = hoursToFinish;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getRecentlyAllocatedHours() {
        return recentlyAllocatedHours;
    }

    public void setRecentlyAllocatedHours(int recentlyAllocatedHours) {
        this.recentlyAllocatedHours = recentlyAllocatedHours;
    }

    public int getRecentlyAssignedTask() {
        return recentlyAssignedTask;
    }

    public void setRecentlyAssignedTask(int recentlyAssignedTask) {
        this.recentlyAssignedTask = recentlyAssignedTask;
    }

    public int getRecentlyCompletedTask() {
        return recentlyCompletedTask;
    }

    public void setRecentlyCompletedTask(int recentlyCompletedTask) {
        this.recentlyCompletedTask = recentlyCompletedTask;
    }

    public int getRecentlySpendHours() {
        return recentlySpendHours;
    }

    public void setRecentlySpendHours(int recentlySpendHours) {
        this.recentlySpendHours = recentlySpendHours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartDateFomated() {        
        return startDateFomated;
    }

    public void setStartDateFomated(String startDateFomated) {
        this.startDateFomated = startDateFomated;
    }

    public int getTotalOpenTask() {
        return totalOpenTask;
    }

    public void setTotalOpenTask(int totalOpenTask) {
        this.totalOpenTask = totalOpenTask;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
    
    

    @Override
    public String toString() {
        return username + startDateFomated;
    }
    
    
    
            
            
}
