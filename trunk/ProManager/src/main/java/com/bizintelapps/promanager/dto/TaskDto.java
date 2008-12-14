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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author intesar
 */
public class TaskDto {

    private Integer id;
    private String title;
    private String description;
    private Date deadline;
    private String deadlineFormat;
    private Date createDate;
    private String createDateFormat;
    private String visibility;
    private int percentageCompleted;
    private String status;
    private String priority;
    private Integer parentTask;
    private Double sequenceNumber;
    private Date completedDate;
    private String completedDateFormat;
    private Date lastStatusChangedDate;
    private String lastStatusChangedDateFormat;
    private Integer ownerId;
    private String ownerUsername;
    private Integer projectId;
    private String projectName;
    private Integer assignedToId;
    private String assignedToUsername;
    private SimpleDateFormat simpleDateFormat;
    public TaskDto() {
        String pattern = "MMM d, ''yy";
        simpleDateFormat = new SimpleDateFormat(pattern);
    }

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getAssignedToUsername() {
        return assignedToUsername;
    }

    public void setAssignedToUsername(String assignedToUsername) {
        this.assignedToUsername = assignedToUsername;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastStatusChangedDate() {
        return lastStatusChangedDate;
    }

    public void setLastStatusChangedDate(Date lastStatusChangedDate) {
        this.lastStatusChangedDate = lastStatusChangedDate;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public Integer getParentTask() {
        return parentTask;
    }

    public void setParentTask(Integer parentTask) {
        this.parentTask = parentTask;
    }

    public int getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(int percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Double sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getCompletedDateFormat() {
        if (completedDate != null) {
            return simpleDateFormat.format(completedDate);
        }
        return completedDateFormat;
    }

    public void setCompletedDateFormat(String completedDateFormat) {
        this.completedDateFormat = completedDateFormat;
    }

    public String getCreateDateFormat() {
        if (createDateFormat != null) {
            return simpleDateFormat.format(createDateFormat);
        }
        return createDateFormat;
    }

    public void setCreateDateFormat(String createDateFormat) {
        this.createDateFormat = createDateFormat;
    }

    public String getDeadlineFormat() {
        if (deadlineFormat != null) {
            return simpleDateFormat.format(deadlineFormat);
        }
        return deadlineFormat;
    }

    public void setDeadlineFormat(String deadlineFormat) {
        this.deadlineFormat = deadlineFormat;
    }

    public String getLastStatusChangedDateFormat() {
        if (lastStatusChangedDateFormat != null) {
            return simpleDateFormat.format(lastStatusChangedDateFormat);
        }
        return lastStatusChangedDateFormat;
    }

    public void setLastStatusChangedDateFormat(String lastStatusChangedDateFormat) {
        this.lastStatusChangedDateFormat = lastStatusChangedDateFormat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaskDto other = (TaskDto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
