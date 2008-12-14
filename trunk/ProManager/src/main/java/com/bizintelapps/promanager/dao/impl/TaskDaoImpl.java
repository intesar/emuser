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
package com.bizintelapps.promanager.dao.impl;

import com.bizintelapps.promanager.dao.TaskDao;
import com.bizintelapps.promanager.entity.Task;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 *
 * @author intesar
 */
@Repository
public class TaskDaoImpl extends GenericDaoImpl<Task, Integer> implements TaskDao {

    public TaskDaoImpl() {
        super(Task.class);
    }

    @Override
    public List<Task> findByTaskStatusAndUserId(String status, String username) {
        return executeNamedQueryList("Task.findByStatusAndUser", null, status, username, username);
    }
}
