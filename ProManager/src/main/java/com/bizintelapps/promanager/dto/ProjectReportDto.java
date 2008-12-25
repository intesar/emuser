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
public class ProjectReportDto {

    private String projectName;
    private Date startDate;
    private String startDateFormated;
    private int tasksCreated;
    private int taskCompleted;
    private int taskOpen;
    private int unassignedTask;
    private int totalHoursSpend;
    private int totalHoursPending;
    private int allocatedHours;

    public int getAllocatedHours() {
        return allocatedHours;
    }

    public void setAllocatedHours(int allocatedHours) {
        this.allocatedHours = allocatedHours;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartDateFormated() {
        return startDateFormated;
    }

    public void setStartDateFormated(String startDateFormated) {
        this.startDateFormated = startDateFormated;
    }

    public int getTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(int taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public int getTaskOpen() {
        return taskOpen;
    }

    public void setTaskOpen(int taskOpen) {
        this.taskOpen = taskOpen;
    }

    public int getTasksCreated() {
        return tasksCreated;
    }

    public void setTasksCreated(int tasksCreated) {
        this.tasksCreated = tasksCreated;
    }

    public int getTotalHoursPending() {
        return totalHoursPending;
    }

    public void setTotalHoursPending(int totalHoursPending) {
        this.totalHoursPending = totalHoursPending;
    }

    public int getTotalHoursSpend() {
        return totalHoursSpend;
    }

    public void setTotalHoursSpend(int totalHoursSpend) {
        this.totalHoursSpend = totalHoursSpend;
    }

    public int getUnassignedTask() {
        return unassignedTask;
    }

    public void setUnassignedTask(int unassignedTask) {
        this.unassignedTask = unassignedTask;
    }

    @Override
    public String toString() {
        return projectName + startDateFormated;
    }
}
