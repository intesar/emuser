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
package com.bizintelapps.promanager.ajax;

import com.bizintelapps.promanager.dto.TaskDto;
import com.bizintelapps.promanager.service.TaskService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author intesar
 */
public class AjaxTaskService {

    /**
     * 
     * @param taskDto
     * @return
     */
    public String saveTask(TaskDto taskDto) {
        return "task created successfully";
    }

    /**
     * 
     * @param projectId
     * @param start
     * @param end
     * @param userId
     * @param taskStatus
     * @return
     */
    public List<TaskDto> searchTasks(Integer projectId, Date start, Date end, Integer userId, String taskStatus) {
        return null;
    }

    /**
     * 
     * @param taskId
     * @param userId
     */
    public void assignTaskUser(Integer taskId, Integer userId) {
    }

    /**
     * 
     * @param taskId
     */
    public void deleteTask(Integer taskId) {
    }

    /**
     * 
     * @param taskId
     * @param status
     */
    public void changeTaskStatus(Integer taskId, String status) {
    }

    /**
     * 
     * @param taskId
     * @param comment
     */
    public void addTaskComment(Integer taskId, String comment) {
    }

    /**
     * 
     * @param taskId
     * @param description
     */
    public void udpateTaskDescription(Integer taskId, String description) {
    }

    /**
     * 
     * @return
     */
    public List<TaskDto> getCurrentTask() {
        return taskService.getCurrentTasks(SecurityUtil.getUsername());
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    @Autowired
    private TaskService taskService;
}
