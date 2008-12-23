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
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;
import com.bizintelapps.promanager.service.TaskService;
import com.bizintelapps.promanager.service.UsersService;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author intesar
 */
public class AjaxTaskService {

    /**
     * creates or updates a task
     * @param taskDto
     * @return
     */
    public String saveTask(TaskDto taskDto) {
        try {
            taskService.saveTask(taskDto, SecurityUtil.getUsername());
            return "task created successfully";
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException(ERROR_MESSAGE);
        }
    }

    /**
     * Start And End Dates shouldn't be more than 30days
     * @param projectId can be null or should look like this "'2', '3', '55'"
     * @param start can be null
     * @param end can be null
     * @param userId cannot be null should look like this "'22', '2342', '3'";
     * @param taskStatus true or false
     * @return
     */
    public List<TaskDto> searchTasks(String projectIds, Date start, Date end, String userIds, boolean isActiveTask) {
        try {
            return taskService.searchTasks(projectIds, start, end, userIds, isActiveTask, SecurityUtil.getUsername());
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException("No results, change input and try again!");
        }
    }

    /**
     * 
     * @param taskId
     * @param userId
     */
    public void assignTaskUser(Integer taskId, Integer userId) {
        try {
            taskService.assignTaskUser(taskId, userId, SecurityUtil.getUsername());
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException(ERROR_MESSAGE);
        }
    }

    /**
     * 
     * @param taskId
     */
    public void deleteTask(Integer taskId) {
        try {
            taskService.deleteTask(taskId, SecurityUtil.getUsername());
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException(ERROR_MESSAGE);
        }
    }

    /**
     * 
     * @param taskId
     * @param status
     */
    public void changeTaskStatus(Integer taskId, String status) {
        try {
            taskService.changeTaskStatus(taskId, status, SecurityUtil.getUsername());
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException(ERROR_MESSAGE);
        }
    }

    /**
     * 
     * @param taskId
     * @param comment
     */
    public void addTaskComment(Integer taskId, String comment) {
        try {
            //
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException(ERROR_MESSAGE);
        }
    }

    /**
     * 
     * @param taskId
     * @param description
     */
    public void udpateTaskDescription(Integer taskId, String description) {
        try {
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException(ERROR_MESSAGE);
        }

    }

    /**
     * 
     * @return
     */
    public List<TaskDto> getCurrentTask() {
        try {
            UsersDto dto = usersService.getUserByUsername(SecurityUtil.getUsername());
            return taskService.searchTasks(null, null, null, "'"+ dto.getId() +"'", true, SecurityUtil.getUsername());
        } catch (ServiceRuntimeException se) {
            log.error(se);
            throw se;
        } catch (Exception e) {
            log.error(e);
            throw new ServiceRuntimeException(ERROR_MESSAGE);
        }
    }
    //------------------------ getters & setters -----------------------------//
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    @Autowired
    private TaskService taskService;
    @Autowired
    private UsersService usersService;
    private final String ERROR_MESSAGE = "Error, Please change input and try again!";
    private Logger log = Logger.getLogger(getClass());
}
