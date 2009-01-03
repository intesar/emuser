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

import com.bizintelapps.mail.MailSender;
import com.bizintelapps.promanager.dao.ProjectDao;
import com.bizintelapps.promanager.dao.ProjectReportDao;
import com.bizintelapps.promanager.dao.ProjectUsersDao;
import com.bizintelapps.promanager.dao.TaskDao;
import com.bizintelapps.promanager.dao.UserReportDao;
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.entity.ProjectUsers;
import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.TaskService;
import com.bizintelapps.promanager.dtoa.TaskDtoA;
import com.bizintelapps.promanager.dto.TaskDto;
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.entity.ProjectReport;
import com.bizintelapps.promanager.entity.UserReport;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;

import java.util.ArrayList;
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
            updateReportForTaskInsert(task);
            if (task.getStatus().equals(TASK_STATUS_COMPLETED)) {
                updateReportForTaskComplete(task);
            }
            sendTaskAlert(task);
        } else { // only admin, owner, assigned or pm can update task
            Task task = taskDao.read(taskDto.getId());
            udpateReportForTaskUpdate(task, taskDto);
            if (!task.getStatus().equals(TASK_STATUS_COMPLETED) && taskDto.getStatus().equals(TASK_STATUS_COMPLETED)) {
                updateReportForTaskComplete(task);
            }
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
                sendTaskAlert(task1);
            } else {
                throw new ServiceRuntimeException("Illegal Action");
            }
        }
    }

    private void sendTaskAlert(Task task) {
        String[] tos = new String[]{};
        String subject = "Task : " + task.getId() + " alert!";
        String body = "";
        mailSender.sendMail(tos, subject, body);
    }

    @Override
    public void deleteTask(Integer taskId, String deletedBy) {
        Users users = usersDao.findByUsername(deletedBy);
        Task task = taskDao.read(taskId);
        // admins, owner or pm can delete a task
        if (users.isIsAdministrator() || task.getOwner().equals(users) || isUserProjectManager(users.getId(), task.getProject())) {
            taskDao.delete(task);
            TaskDto dto = new TaskDto();
            dto.setAssignedToId(null);
            dto.setOwnerId(task.getOwner().getId());
            dto.setEstimatedHours(task.getEstimatedHours());
            udpateReportForTaskUpdate(task, dto);
        } else {
            throw new ServiceRuntimeException("Only Task Owner can delete task!");
        }
    }

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
    @Override
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
        TaskDto dto = new TaskDto();
        dto.setAssignedToId(userId);
        dto.setOwnerId(task.getOwner().getId());
        dto.setEstimatedHours(task.getEstimatedHours());
        udpateReportForTaskUpdate(task, dto);
        // * only admin, owner, pm can assign others
        if (users1.isIsAdministrator() || users.equals(users1) || task.getOwner().equals(users1) ||
                isUserProjectManager(users1.getId(), task.getProject())) {
        } else {
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
                updateReportForTaskComplete(task);
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
    //---------------------- private helper methods -------------------------//
    /**
     * when task is created update or insert an instance into UserReport & ProjectReport entity
     * for the creator, assigned, project
     * @param t
     */
    private void updateReportForTaskInsert(Task t) {
        Calendar c = Calendar.getInstance();
        UserReport userReport = userReportDao.findByUserMonthAndYear(t.getOwner().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        if (userReport == null) { // create new entity
            userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
            userReport.setTotalCreated(1);
            userReport.setUser(t.getOwner().getId());
            userReportDao.create(userReport);
        } else { // update entity
            userReport.setTotalCreated(userReport.getTotalCreated() + 1);
            userReportDao.update(userReport);
        }
        if (t.getAssignedTo() != null && t.getAssignedTo().getId() != null) {
            UserReport userReport1 = userReportDao.findByUserMonthAndYear(t.getAssignedTo().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport1 == null) { // new entity
                userReport1 = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
                userReport1.setUser(t.getAssignedTo().getId());
                if (t.getOwner().equals(t.getAssignedTo())) {
                    userReport1.setSelfAssigned(userReport1.getSelfAssigned() + 1);
                } else {
                    userReport1.setAssigned(userReport1.getAssigned() + 1);
                }
                userReport1.setTotalAssigned(userReport1.getTotalAssigned() + 1);
                userReport1.setEstimatedHours(userReport1.getEstimatedHours() + t.getEstimatedHours());
                userReportDao.create(userReport1);
            } else { //update entity
                userReport1.setUser(t.getAssignedTo().getId());
                if (t.getOwner().equals(t.getAssignedTo())) {
                    userReport1.setSelfAssigned(userReport1.getSelfAssigned() + 1);
                } else {
                    userReport1.setAssigned(userReport1.getAssigned() + 1);
                }
                userReport1.setTotalAssigned(userReport1.getTotalAssigned() + 1);
                userReport1.setEstimatedHours(userReport1.getEstimatedHours() + t.getEstimatedHours());
                userReportDao.update(userReport1);
            }
        }

        if (t.getStatus().equals(TASK_STATUS_COMPLETED)) {
            UserReport userReport1 = userReportDao.findByUserMonthAndYear(t.getAssignedTo().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            userReport1.setTotalCompleted(userReport1.getTotalCompleted() + 1);
            userReport1.setHoursSpend(userReport1.getHoursSpend() + t.getSpendHours());
            userReportDao.update(userReport1);
        }
        updateProjectReportOnTaskInsert(t);
    }

    private void updateProjectReportOnTaskInsert(Task t) {
        Calendar c = Calendar.getInstance();
        if (t.getProject() != null && t.getProject().getId() != null) {
            ProjectReport projectReport = projectReportDao.findByProjectMonthAndYear(t.getProject().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (projectReport == null) {
                // create new entity
                projectReport = new ProjectReport(null, 1, t.getEstimatedHours(), c.get(Calendar.MONTH), c.get(Calendar.YEAR), t.getProject().getId());
                if (t.getStatus().equals(TASK_STATUS_COMPLETED)) {
                    projectReport.setTaskFinished(1);
                    projectReport.setTimeSpend(t.getSpendHours());
                }
                projectReport.setEstimatedTime(t.getEstimatedHours());
                projectReportDao.create(projectReport);
            } else {
                // update entity
                if (t.getStatus().equals(TASK_STATUS_COMPLETED)) {
                    projectReport.setTaskFinished(projectReport.getTaskFinished() + 1);
                    projectReport.setTimeSpend(projectReport.getTimeSpend() + t.getSpendHours());
                }
                projectReport.setEstimatedTime(projectReport.getEstimatedTime() + t.getEstimatedHours());
                projectReportDao.update(projectReport);
            }
        } else {
            // todo
            ProjectReport projectReport = projectReportDao.findByOrganizationMonthAndYear(t.getOwner().getOrganization().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (projectReport == null) {
                // create new entity
                projectReport = new ProjectReport(null, 1, t.getEstimatedHours(), c.get(Calendar.MONTH), c.get(Calendar.YEAR), null);
                if (t.getStatus().equals(TASK_STATUS_COMPLETED)) {
                    projectReport.setTaskFinished(1);
                    projectReport.setTimeSpend(t.getSpendHours());
                }
                projectReport.setOrganization(t.getOwner().getOrganization().getId());
                projectReport.setEstimatedTime(t.getEstimatedHours());
                projectReportDao.create(projectReport);
            } else {
                // update entity
                if (t.getStatus().equals(TASK_STATUS_COMPLETED)) {
                    projectReport.setTaskFinished(projectReport.getTaskFinished() + 1);
                    projectReport.setTimeSpend(projectReport.getTimeSpend() + t.getSpendHours());
                }
                projectReport.setEstimatedTime(projectReport.getEstimatedTime() + t.getEstimatedHours());
                projectReportDao.update(projectReport);
            }
        }
    }

    private void udpateReportForTaskUpdate(Task oldTask, TaskDto newTask) {
        Calendar c = Calendar.getInstance();
        if (oldTask.getAssignedTo() == null && newTask.getAssignedToId() != null) {
            UserReport userReport = userReportDao.findByUserMonthAndYear(newTask.getAssignedToId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport != null) {
                if (newTask.getOwnerId().equals(newTask.getAssignedToId())) {
                    userReport.setCreatedSelfAssigned(userReport.getCreatedSelfAssigned() + 1);
                } else {
                    userReport.setAssigned(userReport.getAssigned() + 1);
                }
                userReport.setTotalAssigned(userReport.getTotalAssigned() + 1);
                userReport.setEstimatedHours(userReport.getEstimatedHours() + newTask.getEstimatedHours());
                userReportDao.update(userReport);
            } else {
                userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
                userReport.setUser(newTask.getAssignedToId());
                if (newTask.getOwnerId().equals(newTask.getAssignedToId())) {
                    userReport.setCreatedSelfAssigned(userReport.getCreatedSelfAssigned() + 1);
                } else {
                    userReport.setAssigned(userReport.getAssigned() + 1);
                }
                userReport.setTotalAssigned(userReport.getTotalAssigned() + 1);
                userReport.setEstimatedHours(userReport.getEstimatedHours() + newTask.getEstimatedHours());
                userReportDao.update(userReport);
            }
        } else if (oldTask.getAssignedTo() != null && newTask.getAssignedToId() == null) {
            UserReport userReport = userReportDao.findByUserMonthAndYear(oldTask.getAssignedTo().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport != null) {
                if (newTask.getOwnerId().equals(newTask.getAssignedToId())) {
                    userReport.setCreatedSelfAssigned(userReport.getCreatedSelfAssigned() - 1);
                } else {
                    userReport.setAssigned(userReport.getAssigned() - 1);
                }
                userReport.setTotalAssigned(userReport.getTotalAssigned() - 1);
                userReport.setEstimatedHours(userReport.getEstimatedHours() - newTask.getEstimatedHours());
                userReportDao.update(userReport);
            }
        } else if (oldTask.getAssignedTo() != null && newTask.getAssignedToId() != null && !oldTask.getAssignedTo().getId().equals(newTask.getAssignedToId())) {
            UserReport userReport = userReportDao.findByUserMonthAndYear(newTask.getAssignedToId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport != null) {
                if (newTask.getOwnerId().equals(newTask.getAssignedToId())) {
                    userReport.setCreatedSelfAssigned(userReport.getCreatedSelfAssigned() + 1);
                } else {
                    userReport.setAssigned(userReport.getAssigned() + 1);
                }
                userReport.setTotalAssigned(userReport.getTotalAssigned() + 1);
                userReport.setEstimatedHours(userReport.getEstimatedHours() + newTask.getEstimatedHours());
                userReportDao.update(userReport);
            } else {
                userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
                userReport.setUser(newTask.getAssignedToId());
                if (newTask.getOwnerId().equals(newTask.getAssignedToId())) {
                    userReport.setCreatedSelfAssigned(userReport.getCreatedSelfAssigned() + 1);
                } else {
                    userReport.setAssigned(userReport.getAssigned() + 1);
                }
                userReport.setTotalAssigned(userReport.getTotalAssigned() + 1);
                userReport.setEstimatedHours(userReport.getEstimatedHours() + newTask.getEstimatedHours());
                userReportDao.update(userReport);
            }
            userReport = userReportDao.findByUserMonthAndYear(oldTask.getAssignedTo().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport != null) {
                if (newTask.getOwnerId().equals(newTask.getAssignedToId())) {
                    userReport.setCreatedSelfAssigned(userReport.getCreatedSelfAssigned() - 1);
                } else {
                    userReport.setAssigned(userReport.getAssigned() - 1);
                }
                userReport.setTotalAssigned(userReport.getTotalAssigned() - 1);
                userReport.setEstimatedHours(userReport.getEstimatedHours() - newTask.getEstimatedHours());
                userReportDao.update(userReport);
            }
        }
    }

    private void updateReportForTaskComplete(Task t) {
        Calendar c = Calendar.getInstance();
        UserReport userReport = userReportDao.findByUserMonthAndYear(t.getAssignedTo().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        userReport.setTotalCompleted(userReport.getTotalCompleted() + 1);
        userReport.setHoursSpend(userReport.getHoursSpend() + t.getSpendHours());
        userReportDao.update(userReport);
        ProjectReport pr = null;
        if (t.getProject() != null && t.getProject().getId() != null) {
            pr = projectReportDao.findByProjectMonthAndYear(t.getProject().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        } else {
            pr = projectReportDao.findByOrganizationMonthAndYear(t.getOwner().getOrganization().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        }
        pr.setTaskFinished(pr.getTaskFinished() + 1);
        pr.setTimeSpend(pr.getTimeSpend() + t.getSpendHours());
        projectReportDao.update(pr);
    }
    //----------------------- getters & setters--------------------------//
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setProjectUsersDao(ProjectUsersDao projectUsersDao) {
        this.projectUsersDao = projectUsersDao;
    }

    public void setTaskConverter(TaskDtoA taskConverter) {
        this.taskConverter = taskConverter;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setProjectReportDao(ProjectReportDao projectReportDao) {
        this.projectReportDao = projectReportDao;
    }

    public void setUserReportDao(UserReportDao userReportDao) {
        this.userReportDao = userReportDao;
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
    @Autowired
    private MailSender mailSender;
    @Autowired
    private ProjectReportDao projectReportDao;
    @Autowired
    private UserReportDao userReportDao;
}
