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
package com.bizintelapps.promanager.service;

import com.bizintelapps.promanager.dao.PagingParams;
import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.dto.TaskDto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface TaskService {

    String TASK_STATUS_NEW = "New";
    String TASK_STATUS_IN_PROGRESS = "In Progress";
    String TASK_STATUS_ON_HOLD = "On Hold";
    String TASK_STATUS_COMPLETED = "Completed";

    /**
     * Creates, updates a given task to DB & should
     * @param taskDto
     * @param savedBy
     */
    public void saveTask(TaskDto taskDto, String savedBy);

    /**
     * Deletes a task from DB,
     * Only a Admin or Owner can delete a task
     * @param taskId
     * @param deletedBy
     */
    public void deleteTask(Integer taskId, String deletedBy);

    /**
     * 
     * @param projectId
     * @param start
     * @param end
     * @param userId
     * @param taskStatus
     * @return
     */
    public List<TaskDto> searchTasks(Integer projectId, Date start, Date end, Integer userId, String taskStatus, String requestedBy);

    /**
     * 
     * @param taskId
     * @param userId
     * @param requestedBy
     */
    public void assignTaskUser(Integer taskId, Integer userId, String requestedBy);

    /**
     *  admin, pm, owner, assignedTo can change status
     * @param taskId
     * @param status
     * @param requestedBy
     */
    public void changeTaskStatus(Integer taskId, String status, String requestedBy);

    /**
     * 
     * @param taskId
     * @param comment
     * @param requestedBy
     */
    public void addTaskComment(Integer taskId, String comment, String requestedBy);

    /**
     * 
     * @param taskId
     * @param description
     * @param requestedBy
     */
    public void udpateTaskDescription(Integer taskId, String description, String requestedBy);

    /**
     * 
     * @param username 
     * @param projectName project of the task
     * @param context we will not use this any more
     * @param status task have only one status at any time
     * @param requestedBy is the user requesting this operation
     * @return
     */
    public PagingParams<Task> getTasks(String username, String projectName, String context, String status, String requestedBy);

    /**
     * 
     * @param status
     * @param requestedBy
     * @return
     */
    public List<TaskDto> getCurrentTasks(String requestedBy);
}
