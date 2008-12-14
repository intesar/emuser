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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author intesar
 */
public class AjaxTaskService {

    // saveTask create|update task
    // saveTaskComment create|update comments
    // deleteTask 
    // getTaskList ( user, context, project, task status ) 
    
    public List<TaskDto> getCurrentTask() {
        return taskService.getCurrentTasks(SecurityUtil.getUsername());
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @Autowired
    private TaskService taskService;
}
