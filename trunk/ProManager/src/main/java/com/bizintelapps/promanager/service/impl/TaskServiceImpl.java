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

import com.bizintelapps.promanager.dao.ProjectDao;
import com.bizintelapps.promanager.dao.ProjectUsersDao;
import com.bizintelapps.promanager.dao.TaskDao;
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.entity.ProjectUsers;
import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.TaskService;
import com.bizintelapps.promanager.dtoa.TaskDtoA;
import com.bizintelapps.promanager.dto.TaskDto;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Override
    public void saveTask(TaskDto taskDto, String savedBy) {
        // to create a task user should be part of the project or admin
        // or user can create todo for other users
        Users savedByUser = usersDao.findByUsername(savedBy);
        if (log.isDebugEnabled()) {
            log.debug(taskDto.toString());
        }
        if (taskDto.getId() == null) {
            Task task = taskConverter.copyForCreate(taskDto, new Task());
            task.setCreateDate(new Date());
            task.setOwner(savedByUser);
            Project project = projectDao.findByNameAndOrganization(taskDto.getProjectName(), savedByUser.getOrganization().getId());
            if (savedByUser.isIsAdministrator() || isUserProjectMember(savedByUser.getId(), project)) {
                // user should be either admin or project member                
                task.setProject(project);
            }
            taskDao.create(task);
        } else { // only admin, owner, assigned or pm can update task
            Task task = taskDao.read(taskDto.getId());
            if (savedByUser.isIsAdministrator() || task.getOwner().equals(savedByUser) ||
                    isUserProjectManager(savedByUser.getId(), task.getProject())) {
                Task task1 = taskConverter.copyForUpdate(taskDto, task);
                if (task.getAssignedTo() != null && !task.getAssignedTo().getId().equals(taskDto.getAssignedToId())) {
                    task.setAssignedTo(usersDao.findByUsername(taskDto.getAssignedToUsername()));
                }
                taskDao.update(task1);
            } else if (task.getAssignedTo() != null && task.getAssignedTo().equals(savedByUser)) {
                Task task1 = taskConverter.copyForUpdateForAssignee(taskDto, task);
                taskDao.update(task1);
            } else {
                throw new ServiceRuntimeException("Illegal Action");
            }
        }
    }

    @Override
    public void deleteTask(Integer taskId, String deletedBy) {
        Users users = usersDao.findByUsername(deletedBy);
        Task task = taskDao.read(taskId);
        // admins, owner or pm can delete a task
        if (users.isIsAdministrator() || task.getOwner().equals(users) || isUserProjectManager(users.getId(), task.getProject())) {
            taskDao.delete(task);
        } else {
            throw new ServiceRuntimeException("Only Task Owner can delete task!");
        }
    }

    @Override
    /**
     * 
     * @param projectId can be null, 0 means todo + projects
     * @param start if null then today - 7 days
     * @param end if null then today + 7 days
     * @param userId if null then requestedBy and if 0 all users
     * @param taskStatus if null then searches for New & In Progress
     * @param requestedBy 
     * @return
     */
    public List<TaskDto> searchTasks(String statuses, String requestedBy) {
        Users u = usersDao.findByUsername(requestedBy);
        List<Task> tasks = taskDao.search(statuses, u.getId());
        // requestedBy if admin, pm or owner can udpate lot on task        
        //List<TaskDto> dtos = taskConverter.copyAllForDisplay(tasks, u.isIsAdministrator(), u.getId());
        List<TaskDto> list = new ArrayList<TaskDto>();
        for (Task task : tasks) {
            boolean isAdmin = false;
            if (u.isIsAdministrator() || task.getOwner().equals(u) || task.getAssignedTo().equals(u) || isUserProjectManager(u.getId(), task.getProject())) {
                isAdmin = true;
            }
            TaskDto taskDto = taskConverter.copyForDisplay(task, new TaskDto(), isAdmin, u.getId());
            list.add(taskDto);
        }
        return list;
    }
    // only admin, owner, pm, assign-to can see task
    @Override
    public TaskDto getTask(Integer taskId, String requestedBy) {
        Users u = usersDao.findByUsername(requestedBy);
        Task task = taskDao.read(taskId);
        if (u.isIsAdministrator() || task.getOwner().equals(u) || task.getAssignedTo().equals(u) || isUserProjectManager(u.getId(), task.getProject())) {
            TaskDto taskDto = taskConverter.copyForDisplay(task, new TaskDto(), u.isIsAdministrator(), u.getId());
            return taskDto;
        }
        throw new ServiceRuntimeException("Only Admin, Task Owner, Project Manager or Assigned-To can view task");
    }

    /**
     *  helper method finds given user is a project manager
     * @param userId
     * @param projectId
     * @return
     */
    private boolean isUserProjectManager(Integer userId, Project project) {
        try {
            if (project == null) {
                return false;
            }
            ProjectUsers pu = projectUsersDao.findByProjectIdAndUserId(project.getId(), userId);
            return pu.getIsManager();
        } catch (RuntimeException re) {
        }
        return false;
    }

    /**
     *  helper method finds given user is a project member
     * @param userId
     * @param projectId
     * @return
     */
    private boolean isUserProjectMember(Integer userId, Project project) {
        try {
            if (project == null) {
                return false;
            }
            ProjectUsers pu = projectUsersDao.findByProjectIdAndUserId(project.getId(), userId);
            if (pu != null && pu.getId() != null) {
                return true;
            }
        } catch (RuntimeException re) {
        }
        return false;
    }

    @Override
    public void assignTaskUser(Integer taskId, Integer userId, String requestedBy) {
        Users users = usersDao.read(userId);
        Users users1 = usersDao.findByUsername(requestedBy);
        Task task = taskDao.read(taskId);
        Project project = task.getProject();
        ProjectUsers projectUsers = null;
        ProjectUsers projectUsers1 = null;
        if (project != null) {
            projectUsers = projectUsersDao.findByProjectIdAndUserId(project.getId(), userId);
            projectUsers1 =
                    projectUsersDao.findByProjectIdAndUserId(project.getId(), users1.getId());
        }

// * user can only be assigned if its todo or a project member        
        if (project != null && projectUsers == null) {
            throw new ServiceRuntimeException("Invalid Operation!");
        }
// * only admin, owner, pm can assign others
        if (!users1.isIsAdministrator() || !task.getOwner().equals(users1) || !(projectUsers1 != null && projectUsers1.getIsManager()) ||
                task.getAssignedTo() != null) {
            throw new ServiceRuntimeException("Invalid Operation!");
        }

        task.setAssignedTo(users);
        taskDao.update(task);

    }

    @Override
    public void changeTaskStatus(Integer taskId, String status, String requestedBy) {
        Users users1 = usersDao.findByUsername(requestedBy);
        Task task = taskDao.read(taskId);
        // admin, owner, assigned, or pm can change
        if (users1.isIsAdministrator() || task.getAssignedTo().equals(users1) || task.getOwner().equals(users1) || isUserProjectManager(users1.getId(), task.getProject())) {
            task.setStatus(status);
            if (status.equals(TASK_STATUS_COMPLETED)) {
                task.setSpendHours(task.getEstimatedHours());
            }
            taskDao.update(task);
        } else {
            throw new ServiceRuntimeException("Only Admin, Task Owner, Project Manager or Assigned-To can change task status");
        }
    }

    @Override
    public void changeTaskPriority(Integer taskId, String priority, String requestedBy) {
        Users users1 = usersDao.findByUsername(requestedBy);
        Task task = taskDao.read(taskId);
        // admin, owner, assigned, or pm can change
        if (users1.isIsAdministrator() || task.getAssignedTo().equals(users1) || task.getOwner().equals(users1) || isUserProjectManager(users1.getId(), task.getProject())) {
            task.setPriority(priority);
            taskDao.update(task);
        } else {
            throw new ServiceRuntimeException("Only Admin, Task Owner, Project Manager or Assigned-To can change task priority");
        }
    }

    @Override
    public void addTaskComment(Integer taskId, String comment, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//----------------------- getters & setters--------------------------
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

    public TaskDtoA getTaskConverter() {
        return taskConverter;
    }

    public void setTaskConverter(TaskDtoA taskConverter) {
        this.taskConverter = taskConverter;
    }
    @Autowired
    private TaskDtoA taskConverter;
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
