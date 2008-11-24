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

/**
 *
 * @author intesar
 */
public interface TaskService {

    public void saveTask ( TaskDto taskDto, String savedBy );
    public void deleteTask ( Integer taskId, String deletedBy);
    public PagingParams<Task> getTasks ( String username, String projectName, String context, String status, String requestedBy);
}
