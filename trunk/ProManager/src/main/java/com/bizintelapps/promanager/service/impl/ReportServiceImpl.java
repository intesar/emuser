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

import com.bizintelapps.promanager.dao.ProjectReportDao;
import com.bizintelapps.promanager.dao.UserReportDao;
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.dto.TaskDto;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.entity.ProjectReport;
import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.entity.UserReport;
import com.bizintelapps.promanager.service.ReportService;
import com.bizintelapps.promanager.service.TaskService;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author intesar
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public void processTask(Task task, TaskDto dto) {
        processTaskOwner(task, dto);
        processTaskProject(task, dto);
        processTaskAssignee(task, dto);
        processTaskCompletion(task, dto);
    }

    private void processTaskOwner(Task t, TaskDto dto) {
        Calendar c = Calendar.getInstance();
        if (t == null && (dto != null && dto.getOwnerId() != null)) { // new task            
            UserReport userReport = userReportDao.findByUserMonthAndYear(dto.getOwnerId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport == null) { // create new entity
                userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
                userReport.setTotalCreated(1);
                userReport.setUser(dto.getOwnerId());
                userReportDao.create(userReport);
            } else { // update entity
                userReport.setTotalCreated(userReport.getTotalCreated() + 1);
                userReportDao.update(userReport);
            }
        } else if (t != null && t.getId() != null && (dto == null)) { //  task deleted
            c.setTime(t.getCreateDate());
            UserReport userReport = userReportDao.findByUserMonthAndYear(t.getOwner().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            userReport.setTotalCreated(userReport.getTotalCreated() - 1);
            userReportDao.update(userReport);
        }
    }

    private void processTaskProject(Task t, TaskDto dto) {
        if (t == null && (dto != null && dto.getOwnerId() != null)) { // new task       
            taskCreatedForProjectReport(dto);
        } else if (t != null && t.getId() != null && (dto == null)) { //  task deleted
            taskDeletedForProjectReport(t);
        } else if (t != null && t.getId() != null && dto != null) { //  project change
            Project p = t.getProject();
            Integer pId = dto.getProjectId();
            // p && Pid should not be same
            if ((p == null && pId == null) || (p != null && pId != null && p.getId().equals(pId))) {
            } else {
                taskCreatedForProjectReport(dto);
                taskDeletedForProjectReport(t);
            }
        }
    }

    private void processTaskAssignee(Task t, TaskDto dto) {
        if ((t != null && t.getAssignedTo() == null && dto.getAssignedToId() != null) || (t == null && (dto != null && dto.getAssignedToId() != null))) { // new task  assigned     
            addTaskAssigned(dto.getAssignedToId(), dto.getOwnerId(), dto.getAssignedById(), dto.getAssignedDate(), dto.getEstimatedHours());
        } else if (t != null && t.getAssignedTo() != null && (dto == null || dto != null && dto.getAssignedToId() == null)) {
            removeTaskAssigned(t.getAssignedTo().getId(), t.getOwner().getId(), t.getAssignedBy().getId(), t.getAssignedDate(), t.getEstimatedHours());
        } else if (t != null && dto != null && t.getAssignedTo() != null && dto.getAssignedToId() != null && (!t.getAssignedTo().getId().equals(dto.getAssignedToId()))) {
            removeTaskAssigned(t.getAssignedTo().getId(), t.getOwner().getId(), t.getAssignedBy().getId(), t.getAssignedDate(), t.getEstimatedHours());
            addTaskAssigned(dto.getAssignedToId(), dto.getOwnerId(), dto.getAssignedById(), dto.getAssignedDate(), dto.getEstimatedHours());
        }
    }

    private void processTaskCompletion(Task t, TaskDto dto) {
        Calendar c = Calendar.getInstance();
        Integer org = usersDao.read(dto.getOwnerId()).getOrganization().getId();
        if ((t == null || !t.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) &&
                dto.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) {
            UserReport userReport = userReportDao.findByUserMonthAndYear(dto.getAssignedById(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            ProjectReport projectReport = null;
            userReport = getUserReport(userReport, c, dto);
            projectReport = getProjectReport(dto, c, projectReport, org);
            projectReport.setTaskFinished(projectReport.getTaskFinished() + 1);
            projectReport.setTimeSpend(projectReport.getTimeSpend() + dto.getSpendHours());
            projectReport.setEstimatedTime(projectReport.getEstimatedTime() + dto.getEstimatedHours());
            projectReportDao.update(projectReport);
            userReport.setTotalCompleted(userReport.getTotalCompleted() + 1);
            userReport.setEstimatedHours(userReport.getEstimatedHours() + dto.getEstimatedHours());
            userReport.setHoursSpend(userReport.getHoursSpend() + dto.getSpendHours());
            userReportDao.update(userReport);
        } else if ((t != null && t.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) &&
                !dto.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) {
            UserReport userReport = userReportDao.findByUserMonthAndYear(dto.getAssignedById(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            ProjectReport projectReport = null;
            userReport = getUserReport(userReport, c, dto);
            projectReport = getProjectReport(dto, c, projectReport, org);
            projectReport.setTaskFinished(projectReport.getTaskFinished() - 1);
            projectReport.setTimeSpend(projectReport.getTimeSpend() - dto.getSpendHours());
            projectReport.setEstimatedTime(projectReport.getEstimatedTime() - dto.getEstimatedHours());
            projectReportDao.update(projectReport);
            userReport.setTotalCompleted(userReport.getTotalCompleted() - 1);
            userReport.setEstimatedHours(userReport.getEstimatedHours() - dto.getEstimatedHours());
            userReport.setHoursSpend(userReport.getHoursSpend() - dto.getSpendHours());
            userReportDao.update(userReport);
        }

    }

    private ProjectReport getProjectReport(TaskDto dto, Calendar c, ProjectReport projectReport, Integer org) {
        if (dto.getProjectId() != null) {
            projectReport = projectReportDao.findByProjectMonthAndYear(dto.getProjectId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (projectReport == null) {
                // create new entity
                projectReport = new ProjectReport(null, 1, 0.0, c.get(Calendar.MONTH), c.get(Calendar.YEAR), dto.getProjectId());
                projectReportDao.create(projectReport);
            }
        } else {
            projectReport = projectReportDao.findByOrganizationMonthAndYear(org, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (projectReport == null) {
                // create new entity
                projectReport = new ProjectReport(null, 1, 0.0, c.get(Calendar.MONTH), c.get(Calendar.YEAR), null);
                projectReport.setOrganization(org);
                projectReportDao.create(projectReport);
            }
        }
        return projectReport;
    }

    private UserReport getUserReport(UserReport userReport, Calendar c, TaskDto dto) {
        if (userReport == null) {
            // new entity
            userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
            userReport.setUser(dto.getAssignedById());
            userReportDao.create(userReport);
        }
        return userReport;
    }

    private void addTaskAssigned(Integer userId, Integer ownerId, Integer assignedBy, Date assignDate, double eh) {
        Calendar c = Calendar.getInstance();
        System.out.println(" AssignDate" + assignDate);
        c.setTime(assignDate);
        UserReport userReport1 = userReportDao.findByUserMonthAndYear(userId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        if (userReport1 == null) { // new entity
            userReport1 = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
            userReport1.setUser(userId);
            userReportDao.create(userReport1);
        }
        if (ownerId.equals(userId) && assignedBy.equals(userId)) {
            userReport1.setCreatedSelfAssigned(userReport1.getCreatedSelfAssigned() + 1);
        } else if (assignedBy.equals(userId)) {
            userReport1.setSelfAssigned(userReport1.getSelfAssigned() + 1);
        } else {
            userReport1.setAssigned(userReport1.getAssigned() + 1);
        }
        userReport1.setTotalAssigned(userReport1.getTotalAssigned() + 1);
        userReport1.setEstimatedHours(userReport1.getEstimatedHours() + eh);
        userReportDao.update(userReport1);
    }

    private void removeTaskAssigned(Integer userId, Integer ownerId, Integer assignedBy, Date assignDate, double eh) {
        Calendar c = Calendar.getInstance();
        c.setTime(assignDate);
        UserReport userReport1 = userReportDao.findByUserMonthAndYear(userId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        if (ownerId.equals(userId) && assignedBy.equals(userId)) {
            userReport1.setCreatedSelfAssigned(userReport1.getCreatedSelfAssigned() - 1);
        } else if (assignedBy.equals(userId)) {
            userReport1.setSelfAssigned(userReport1.getSelfAssigned() - 1);
        } else {
            userReport1.setAssigned(userReport1.getAssigned() - 1);
        }
        userReport1.setTotalAssigned(userReport1.getTotalAssigned() - 1);
        userReport1.setEstimatedHours(userReport1.getEstimatedHours() - eh);
        userReportDao.update(userReport1);
    }

    private void taskCreatedForProjectReport(TaskDto dto) {
        Calendar c = Calendar.getInstance();// new task
        if (dto.getProjectId() != null) {
            ProjectReport projectReport = projectReportDao.findByProjectMonthAndYear(dto.getProjectId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (projectReport == null) {
                // create new entity
                projectReport = new ProjectReport(null, 1, dto.getEstimatedHours(), c.get(Calendar.MONTH), c.get(Calendar.YEAR), dto.getProjectId());
                projectReportDao.create(projectReport);
            } else {
                // update entity
                projectReport.setTaskCreated(projectReport.getTaskCreated() + 1);
                projectReportDao.update(projectReport);
            }
        } else {
            Integer org = usersDao.findByUsername(dto.getOwnerUsername()).getOrganization().getId();
            ProjectReport projectReport = projectReportDao.findByOrganizationMonthAndYear(org, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (projectReport == null) {
                // create new entity
                projectReport = new ProjectReport(null, 1, dto.getEstimatedHours(), c.get(Calendar.MONTH), c.get(Calendar.YEAR), null);
                projectReport.setOrganization(org);
                projectReportDao.create(projectReport);
            } else {
                // update entity
                projectReport.setTaskCreated(projectReport.getTaskCreated() + 1);
                projectReportDao.update(projectReport);
            }
        }
    }

    private void taskDeletedForProjectReport(Task t) {
        Calendar c = Calendar.getInstance();//  task deleted
        c.setTime(t.getCreateDate());
        ProjectReport projectReport = null;
        if (t.getProject() != null) {
            Integer p = t.getProject().getId();
            projectReport = projectReportDao.findByProjectMonthAndYear(p, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        }
        if (projectReport == null) {
            Integer org = usersDao.findByUsername(t.getOwner().getUsername()).getOrganization().getId();
            projectReport = projectReportDao.findByOrganizationMonthAndYear(org, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        }
        if (projectReport != null) {
            projectReport.setTaskCreated(projectReport.getTaskCreated() - 1);
            projectReportDao.update(projectReport);
        }
    }
    // ------------------------- setters -------------------------------------//
    public void setProjectReportDao(ProjectReportDao projectReportDao) {
        this.projectReportDao = projectReportDao;
    }

    public void setUserReportDao(UserReportDao userReportDao) {
        this.userReportDao = userReportDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    @Autowired
    private ProjectReportDao projectReportDao;
    @Autowired
    private UserReportDao userReportDao;
    @Autowired
    private UsersDao usersDao;
    private Logger log = Logger.getLogger(getClass());
}
