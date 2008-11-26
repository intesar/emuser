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
package com.bizintelapps.promanager.service.impl;

import com.bizintelapps.promanager.dao.PagingParams;
import com.bizintelapps.promanager.dao.ProjectDao;
import com.bizintelapps.promanager.dao.ProjectUsersDao;
import com.bizintelapps.promanager.dao.TaskDao;
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.entity.ProjectUsers;
import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.TaskService;
import com.bizintelapps.promanager.service.converters.TaskConverter;
import com.bizintelapps.promanager.dto.TaskDto;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author intesar
 */
@Service
public class TaskServiceImpl implements TaskService {

    /**
     *  
     * @param username {all, username}
     * @param projectName {all, projectName}
     * @param context {all, context }
     * @param status { all, status }
     * @param requestedBy logged in user
     * @return
     */
    @Override
    public PagingParams<Task> getTasks(String username, String projectName,
            String context, String status, String requestedBy) {
        PagingParams pagingParams = null;
        String ql = "";
        Users requestedByUser = usersDao.findByUsername(requestedBy);
        // if requestedByUser is username he can pull everything
        if (requestedByUser.getUsername().equalsIgnoreCase(username)) {
            // project could be all or any one
            if (projectName.equalsIgnoreCase("all")) {
                // context could be all or any one
                if (context.equalsIgnoreCase("all")) {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 ";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.status = ?2 ";
                    }
                } else {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2 and t.status = ?3 ";
                    }
                }
            } else {
                // context could be all or any one
                if (context.equalsIgnoreCase("all")) {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 ";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.status = ?3 ";
                    }
                } else {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3 and t.status = ?4 ";
                    }
                }
            }
        } else // if requestedByUser is username he can pull everything
        if (requestedByUser.getUsername().equalsIgnoreCase("all")) {
            Users u = usersDao.findByUsername(username);
            // project could be all or any one
            if (projectName.equalsIgnoreCase("all")) {
                // context could be all or any one
                if (context.equalsIgnoreCase("all")) {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where " +
                                "(t.visibility = ?1 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?2))";
                    } else {
                        ql = " select t from Task t where t.status = ?1 and " +
                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?3))";
                    }
                } else {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.context = ?1 and " +
                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?3))";
                    } else {
                        ql = " select t from Task t where t.context = ?1 and t.status = ?2 and " +
                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?4))";
                    }
                }
            } else {
                // context could be all or any one
                if (context.equalsIgnoreCase("all")) {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.project.id = ?1 and " +
                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?3))";
                    } else {
                        ql = " select t from Task t where t.project.id = ?1 and t.status = ?2 and " +
                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?4))";
                    }
                } else {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.project.id = ?1 and t.context = ?2 and " +
                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?4))";
                    } else {
                        ql = " select t from Task t where t.project.id = ?1 and t.context = ?2 and t.status = ?3 and " +
                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?5))";
                    }
                }
            }
        } else {// if requestedByUser is username he can pull everything {
            Users u = usersDao.findByUsername(username);
            // project could be all or any one
            if (projectName.equalsIgnoreCase("all")) {
                // context could be all or any one
                if (context.equalsIgnoreCase("all")) {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and " +
                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?3))";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.status = ?2 and " +
                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?4))";
                    }
                } else {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2 and " +
                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?4))";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2 and t.status = ?3 and " +
                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?5))";
                    }
                }
            } else {
                // context could be all or any one
                if (context.equalsIgnoreCase("all")) {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and " +
                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?4))";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.status = ?3 and " +
                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?5))";
                    }
                } else {
                    // status could be all or any one 
                    if (status.equalsIgnoreCase("all")) {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3 and " +
                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?5))";
                    } else {
                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3 and t.status = ?4 and " +
                                "(t.visibility = ?5 or t.project in (select pu.project from ProjectUsers " +
                                "where pu.user.id ?6))";
                    }
                }
            }
        }
        return pagingParams;
    }

    @Override
    public void saveTask(TaskDto taskDto, String savedBy) {
        // to create a task user should be part of the project
        // or user can create todo for other users
        Users savedByUser = usersDao.findByUsername(savedBy);
        Project project = projectDao.read(taskDto.getProjectId());
        if (taskDto.getId() == null) {
            Task task = taskConverter.copyForCreate(taskDto, new Task());
            if (taskDto.getProjectId() == null) {
                taskDao.create(task);
            } else {
                ProjectUsers projectUsers = projectUsersDao.findByProjectIdAndUserId(
                        taskDto.getProjectId(), savedByUser.getId());
                if (projectUsers != null || projectUsers.getId() != null) {
                    task.setCreateDate(new Date());
                    task.setOwner(savedByUser);
                    task.setProject(project);
                    taskDao.create(task);
                }

            }
        } // to update task user should be owner or project admiinistrator
        else {
            Task task = taskDao.read(taskDto.getId());
            ProjectUsers projectUsers = projectUsersDao.findByProjectAdministratorByProjectNameAndUserId(
                    project.getName(), savedByUser.getId());
            if (task.getOwner().equals(savedByUser) ||
                    (projectUsers != null && projectUsers.getId() != null)) {
                Task task1 = taskConverter.copyForUpdate(taskDto, new Task());
                taskDao.update(task1);
            } else {
                throw new ServiceRuntimeException("Task can by only updated by Owner or Administrator");
            }
        }
    }

    @Override
    public void deleteTask(Integer taskId, String deletedBy) {
        Users users = usersDao.findByUsername(deletedBy);
        Task task = taskDao.read(taskId);
        // find user is admin then only can delete other even they are administrators
        if (task.getOwner().equals(users)) {
            taskDao.delete(task);
        } else {
            throw new ServiceRuntimeException("Only Task Owner can delete task!");
        }
    }

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public ProjectUsersDao getProjectUsersDao() {
        return projectUsersDao;
    }

    public void setProjectUsersDao(ProjectUsersDao projectUsersDao) {
        this.projectUsersDao = projectUsersDao;
    }

    public TaskConverter getTaskConverter() {
        return taskConverter;
    }

    public void setTaskConverter(TaskConverter taskConverter) {
        this.taskConverter = taskConverter;
    }
    @Autowired
    private TaskConverter taskConverter;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectUsersDao projectUsersDao;    
    private final Log log = LogFactory.getLog(getClass());
}
