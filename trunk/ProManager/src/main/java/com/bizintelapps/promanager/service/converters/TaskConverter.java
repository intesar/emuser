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
package com.bizintelapps.promanager.service.converters;

import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.dto.TaskDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author intesar
 */
@Service
public class TaskConverter {

    public List<TaskDto> copyAllForDisplay(Collection<Task> usersCollection) {
        List<TaskDto> list = new ArrayList<TaskDto>();
        for (Task task : usersCollection) {
            TaskDto taskDto = copyForDisplay(task, new TaskDto());
            list.add(taskDto);
        }
        return list;
    }

    public TaskDto copyForDisplay(Task users, TaskDto usersDto) {

        return usersDto;
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
     * @param usersDto
     * @param users
     * 
     */
    public Task copyForUpdate(TaskDto taskDto, Task task) {
        return task;

    }
}
