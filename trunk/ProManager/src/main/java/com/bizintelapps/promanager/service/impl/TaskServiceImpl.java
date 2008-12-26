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

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

//    @Deprecated
//    public List<TaskDto> getCurrentTasks(String requestedBy) {
//        List<Task> list = taskDao.findByTaskStatusAndUserId("Completed", requestedBy);
//        List<TaskDto> tasks = taskConverter.copyAllForDisplay(list);
//        return tasks;
//    }
//
//    /**
//     *  
//     * @param username {all, username}
//     * @param projectName {all, projectName}
//     * @param context {all, context }
//     * @param status { all, status }
//     * @param requestedBy logged in user
//     * @return
//     */
//    @Deprecated
//    public PagingParams<Task> getTasks(String username, String projectName,
//            String context, String status, String requestedBy) {
//        PagingParams pagingParams = null;
//        String ql = "";
//        Users requestedByUser = usersDao.findByUsername(requestedBy);
//        // if requestedByUser is username he can pull everything
//        if (requestedByUser.getUsername().equalsIgnoreCase(username)) {
//            // project could be all or any one
//            if (projectName.equalsIgnoreCase("all")) {
//                // context could be all or any one
//                if (context.equalsIgnoreCase("all")) {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 ";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.status = ?2 ";
//                    }
//                } else {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2 and t.status = ?3 ";
//                    }
//                }
//            } else {
//                // context could be all or any one
//                if (context.equalsIgnoreCase("all")) {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 ";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.status = ?3 ";
//                    }
//                } else {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3 and t.status = ?4 ";
//                    }
//                }
//            }
//        } else // if requestedByUser is username he can pull everything
//        if (requestedByUser.getUsername().equalsIgnoreCase("all")) {
//            Users u = usersDao.findByUsername(username);
//            // project could be all or any one
//            if (projectName.equalsIgnoreCase("all")) {
//                // context could be all or any one
//                if (context.equalsIgnoreCase("all")) {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where " +
//                                "(t.visibility = ?1 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?2))";
//                    } else {
//                        ql = " select t from Task t where t.status = ?1 and " +
//                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?3))";
//                    }
//                } else {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.context = ?1 and " +
//                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?3))";
//                    } else {
//                        ql = " select t from Task t where t.context = ?1 and t.status = ?2 and " +
//                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?4))";
//                    }
//                }
//            } else {
//                // context could be all or any one
//                if (context.equalsIgnoreCase("all")) {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.project.id = ?1 and " +
//                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?3))";
//                    } else {
//                        ql = " select t from Task t where t.project.id = ?1 and t.status = ?2 and " +
//                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?4))";
//                    }
//                } else {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.project.id = ?1 and t.context = ?2 and " +
//                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?4))";
//                    } else {
//                        ql = " select t from Task t where t.project.id = ?1 and t.context = ?2 and t.status = ?3 and " +
//                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?5))";
//                    }
//                }
//            }
//        } else {// if requestedByUser is username he can pull everything {
//            Users u = usersDao.findByUsername(username);
//            // project could be all or any one
//            if (projectName.equalsIgnoreCase("all")) {
//                // context could be all or any one
//                if (context.equalsIgnoreCase("all")) {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and " +
//                                "(t.visibility = ?2 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?3))";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.status = ?2 and " +
//                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?4))";
//                    }
//                } else {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2 and " +
//                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?4))";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.context = ?2 and t.status = ?3 and " +
//                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?5))";
//                    }
//                }
//            } else {
//                // context could be all or any one
//                if (context.equalsIgnoreCase("all")) {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and " +
//                                "(t.visibility = ?3 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?4))";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.status = ?3 and " +
//                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?5))";
//                    }
//                } else {
//                    // status could be all or any one 
//                    if (status.equalsIgnoreCase("all")) {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3 and " +
//                                "(t.visibility = ?4 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?5))";
//                    } else {
//                        ql = " select t from Task t where t.assignedTo.id = ?1 and t.project.id = ?2 and t.context = ?3 and t.status = ?4 and " +
//                                "(t.visibility = ?5 or t.project in (select pu.project from ProjectUsers " +
//                                "where pu.user.id ?6))";
//                    }
//                }
//            }
//        }
//        return pagingParams;
//    }
    @Override
    public void saveTask(TaskDto taskDto, String savedBy) {
        // to create a task user should be part of the project or admin
        // or user can create todo for other users
        Users savedByUser = usersDao.findByUsername(savedBy);
        if (taskDto != null && taskDto.getId() == null) {
            if (taskDto.getProjectId() != null) {
                // user should be either admin or project member
                if (savedByUser.isIsAdministrator() ||
                        (projectUsersDao.findByProjectIdAndUserId(taskDto.getProjectId(), savedByUser.getId()) != null) &&
                        (projectUsersDao.findByProjectIdAndUserId(taskDto.getProjectId(), savedByUser.getId()).getId() != null)) {
                    Task task = taskConverter.copyForCreate(taskDto, new Task());
                    Project project = projectDao.read(taskDto.getProjectId());
                    task.setCreateDate(new Date());
                    task.setOwner(savedByUser);
                    task.setProject(project);
                    taskDao.create(task);
                }
            } else {
                Task task = taskConverter.copyForCreate(taskDto, new Task());
                Project project = projectDao.read(taskDto.getProjectId());
                task.setCreateDate(new Date());
                task.setOwner(savedByUser);
                task.setProject(project);
                taskDao.create(task);
            }
        } else { // only admin, owner, assigned or pm can update task
            Task task = taskDao.read(taskDto.getId());
            if (savedByUser.isIsAdministrator() || task.getOwner().equals(savedByUser) ||
                    (task.getProject() != null && projectUsersDao.findByProjectIdAndUserId(task.getProject().getId(), savedByUser.getId()).getIsManager())) {
                Task task1 = taskConverter.copyForUpdate(taskDto, new Task());
                taskDao.update(task1);
            } else if (task.getAssignedTo().equals(savedByUser)) {
                Task task1 = taskConverter.copyForUpdateForAssignee(taskDto, new Task());
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
        if (users.isIsAdministrator() || task.getOwner().equals(users)) {
            taskDao.delete(task);
        } else {
            ProjectUsers pu = projectUsersDao.findByProjectIdAndUserId(task.getProject().getId(), users.getId());
            if (pu.getIsManager()) {
                taskDao.delete(task);
            } else {
                throw new ServiceRuntimeException("Only Task Owner can delete task!");
            }
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
    public List<TaskDto> searchTasks(String projectIds, Date start, Date end, String userIds, boolean active, String requestedBy) {
        if (start == null) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -WEEK);
            start = c.getTime();
        }
        if (end == null) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, +WEEK);
            end = c.getTime();
        }
        String statuses = "'" + TASK_STATUS_NEW + "'" + ", " + "'" + TASK_STATUS_IN_PROGRESS + "'" + ", " + "'" + TASK_STATUS_ON_HOLD + "'" + ", " + "'" + TASK_STATUS_COMPLETED + "'";
        if (active) {
            statuses = "'" + TASK_STATUS_NEW + "'" + ", " + "'" + TASK_STATUS_IN_PROGRESS + "'";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "'" + sdf.format(start) + "%" + "'";
        String endDate = "'" + sdf.format(end) + "%" + "'";
        if (log.isDebugEnabled()) {
            log.debug("----- " + start.toString() + "--" + end + "--" + startDate + "--" + endDate);
        }
        List<Task> tasks = taskDao.search(statuses, startDate, endDate, userIds, projectIds);
        // requestedBy if admin, pm or owner can udpate lot on task
        Users u = usersDao.findByUsername(requestedBy);
        List<TaskDto> dtos = taskConverter.copyAllForDisplay(tasks, u.isIsAdministrator(), u.getId());
        return dtos;
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
        Project project = task.getProject();
        ProjectUsers projectUsers = null;
        if (project != null) {
            projectUsers = projectUsersDao.findByProjectIdAndUserId(project.getId(), users1.getId());
        }
// admin, owner, assigned, or pm can change
        if (users1.isIsAdministrator() || task.getAssignedTo().equals(users1) || task.getOwner().equals(users1) ||
                (projectUsers != null && projectUsers.getIsManager())) {
            task.setStatus(status);
            taskDao.update(task);
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
