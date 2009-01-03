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
package com.bizintelapps.promanager.dtoa;

import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.dto.TaskDto;
import com.bizintelapps.promanager.entity.ProjectUsers;
import com.bizintelapps.promanager.service.TaskService;
import java.util.Collection;
import org.springframework.stereotype.Component;

/**
 *
 * @author intesar
 */
@Component
public class TaskDtoA {

    public TaskDto copyForDisplay(Task task, TaskDto taskDto, boolean isAdmin, Integer requestedUserId) {
        if (task.getAssignedTo() != null) {
            taskDto.setId(task.getAssignedTo().getId());
            if (task.getAssignedTo().getId().equals(requestedUserId)) {
                taskDto.setAssignedToUsername("me");
            } else {
                taskDto.setAssignedToUsername(task.getAssignedTo().getUsername());
            }
        }
        taskDto.setCompletedDate(task.getCompletedDate());
        taskDto.setCreateDate(task.getCreateDate());
        taskDto.setDeadline(task.getDeadline());
        taskDto.setEstimatedHours(task.getEstimatedHours());
        taskDto.setSpendHours(task.getSpendHours());
        taskDto.setDescription(task.getDescription());
        taskDto.setNotificationEmails(task.getNotificationEmails());
        taskDto.setDescription(task.getDescription());
        taskDto.setId(task.getId());
        taskDto.setLastStatusChangedDate(task.getLastStatusChangedDate());
        if (task.getOwner() != null) {
            if (task.getOwner().getId().equals(requestedUserId)) {
                taskDto.setOwnerUsername("me");
            } else {
                taskDto.setOwnerUsername(task.getOwner().getUsername());
            }
        }
        taskDto.setPriority(task.getPriority());
        if (task.getProject() != null) {
            taskDto.setProjectName(task.getProject().getName());
        }
        taskDto.setStatus(task.getStatus());
        taskDto.setTitle(task.getTitle());
        if (isAdmin || task.getOwner().getId().equals(requestedUserId)) {
            taskDto.setIsOwner(true);
        } else {
            if (task.getProject() != null) {
                Collection<ProjectUsers> pus = task.getProject().getProjectUsersCollection();
                for (ProjectUsers pu : pus) {
                    if (pu.getIsManager() && pu.getUsers().getId().equals(requestedUserId)) {
                        taskDto.setIsOwner(true);
                        break;
                    }
                }
            }
        }
        return taskDto;
    }

    /**
     * copies everything from userDto to users
     * @param usersDto
     * @param users
     * @return
     */
    public Task copyForCreate(TaskDto taskDto, Task task) {
        return task;
    }

    /**
     * only copies fields that can be changed from client side
     * Owner: title, assigned, end date, estimated hours, status, priority,
     * complete date, hours spend, description, add comment, listeners
     * @param usersDto
     * @param users
     * 
     */
    public Task copyForUpdate(TaskDto taskDto, Task task) {
        task.setTitle(taskDto.getTitle());        
        task.setDeadline(taskDto.getCompletedDate());
        task.setEstimatedHours(taskDto.getEstimatedHours());
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        if (!task.getStatus().equals(TaskService.TASK_STATUS_COMPLETED) && taskDto.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) {
            task.setCompletedDate(taskDto.getCompletedDate());
        }
        task.setSpendHours(taskDto.getSpendHours());
        task.setDescription(taskDto.getDescription());
        task.setNotificationEmails(taskDto.getNotificationEmails());
        return task;
    }

    /**
     * Assigned: status, complete date, hours spend, add comment
     * @param taskDto
     * @param task
     * @return
     */
    public Task copyForUpdateForAssignee(TaskDto taskDto, Task task) {
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        if (!task.getStatus().equals(TaskService.TASK_STATUS_COMPLETED) && taskDto.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) {
            task.setCompletedDate(taskDto.getCompletedDate());
        }
        task.setSpendHours(taskDto.getSpendHours());
        task.setDescription(taskDto.getDescription());
        return task;
    }
}
