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
import com.bizintelapps.promanager.dao.ProjectUsersDao;
import com.bizintelapps.promanager.dao.UserReportDao;
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.dto.ProjectReportDto;
import com.bizintelapps.promanager.dto.TaskDto;
import com.bizintelapps.promanager.dto.UserReportDto;
import com.bizintelapps.promanager.dtoa.ProjectReportDtoA;
import com.bizintelapps.promanager.dtoa.UserReportDtoA;
import com.bizintelapps.promanager.entity.ProjectReport;
import com.bizintelapps.promanager.entity.ProjectUsers;
import com.bizintelapps.promanager.entity.Task;
import com.bizintelapps.promanager.entity.UserReport;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.ReportService;
import com.bizintelapps.promanager.service.TaskService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
        try {
            processTaskOwner(task, dto); // updates user_report task_created (when new task is added or removed)
            //processTaskProject(task, dto); // udpates project_report task_created, estimated_time, time_spend (when new task is added or removed)
            processProjectReport(task, dto);
            processTaskAssignee(task, dto); // updates user_report task_assigned, self_assigned, estimated_time, time_spend (when assignee added or removed)
            processTaskCompletion(task, dto); // updates project_report total_completed, user_report's total_completed (when task completed)
        //processTaskUpdate(dto);// updates project_report's estimated_time, time_spend and user_report's estimated_time, time_spend (when task is updated)
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException();
        }
    }

    @Override
    public List<UserReportDto> getUserReports(Integer user, Integer maxReports, String requestedBy) {
        if (maxReports == null || maxReports < 1) {
            maxReports = 3;
        }
        Users requestedUser = usersDao.findByUsername(requestedBy);
        List<UserReportDto> dtos = new ArrayList<UserReportDto>();
        if (user == null || user.equals(0)) {
            user = requestedUser.getId();
        }
        // only admin, self can see graph
        if (user.equals(requestedUser.getId()) || requestedUser.isIsAdministrator()) {
            List<UserReport> list = userReportDao.findByUser(user, maxReports);
            if (list == null || list.size() == 0) {
                Calendar c = Calendar.getInstance();
                UserReport up = new UserReport(user, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
                up.setUser(user);
                list.add(up);
            }
            // copy for display
            for (UserReport ur : list) {
                dtos.add(userReportDtoA.copyForDisplay(ur));
            }
        }
        return dtos;
    }

    @Override
    public List<UserReportDto> getRandomUserReports(Integer maxReports, String requestedBy) {
        if (maxReports == null || maxReports < 1) {
            maxReports = 3;
        }
        Users requestedUser = usersDao.findByUsername(requestedBy);
        List<UserReportDto> dtos = new ArrayList<UserReportDto>();
        Integer userId = null;
        // if admin get any user        
        // else get self        
        if (requestedUser.isIsAdministrator()) {
            List<Users> users = usersDao.findByOrganizationId(requestedUser.getOrganization().getId());
            Random r = new Random();
            int randmonUser = r.nextInt(users.size());
            userId = users.get(randmonUser).getId();
        } else {
            userId = requestedUser.getId();
        }
        return getUserReports(userId, maxReports, requestedBy);
    }

    @Override
    public UserReportDto getCurrentUserReport(Integer user, String requestedBy) {
        Users requestedUser = usersDao.findByUsername(requestedBy);
        UserReportDto dto = null;
        if (user == null || user.equals(0)) {
            user = requestedUser.getId();
        }
        // only admin, self can see graph
        if (user.equals(requestedUser.getId()) || requestedUser.isIsAdministrator()) {
            Calendar c = Calendar.getInstance();
            int month = c.get(Calendar.MONTH);
            int year = c.get(Calendar.YEAR);
            UserReport userReport = userReportDao.findByUserMonthAndYear(user, month, year);
            // copy for display
            dto = userReportDtoA.copyForDisplay(userReport);
        }
        return dto;
    }

    @Override
    public UserReportDto getUserSummary(Integer user, String requestedBy) {
        Users requestedUser = usersDao.findByUsername(requestedBy);
        UserReportDto dto = null;
        if (user == null || user.equals(0)) {
            user = requestedUser.getId();
        }
        // only admin, self can see graph
        if (user.equals(requestedUser.getId()) || requestedUser.isIsAdministrator()) {
            dto = (UserReportDto) userReportDao.findUserSummary(user);
        }
        return dto;
    }

    @Override
    public List<UserReportDto> getAllUserReport(int month, int year, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProjectReportDto> getProjectReports(Integer project, Integer maxReports, String requestedBy) {
        if (maxReports == null || maxReports < 1) {
            maxReports = 3;
        }
        Users requestedUser = usersDao.findByUsername(requestedBy);
        Integer org = null;
        List<ProjectReport> list = null;
        List<ProjectReportDto> dtos = new ArrayList<ProjectReportDto>();
        if (project == null || project.equals(0)) {
            org = requestedUser.getOrganization().getId();
            list = projectReportDao.findByOrganizationForTodo(org, maxReports);
        } else {
            list = projectReportDao.findByProject(project, maxReports);
        }
        // copy for display
        for (ProjectReport pr : list) {
            dtos.add(projectReportDtoA.copyForDisplay(pr));
        }
        return dtos;
    }

    @Override
    public List<ProjectReportDto> getRandomProjectReports(Integer maxReports, String requestedBy) {
        Integer project = null;
        Users requestedUser = usersDao.findByUsername(requestedBy);
        List<ProjectUsers> projectUserses = projectUsersDao.findByUserId(requestedUser.getId());
        Random r = new Random();
        int randmonProject = r.nextInt(projectUserses.size() + 1); // +1 for TODO
        if (randmonProject < projectUserses.size()) { // if randomProject >= size then its TODO
            project = projectUserses.get(randmonProject).getProject().getId();
        }
        return getProjectReports(project, maxReports, requestedBy);
    }

    @Override
    public ProjectReportDto getProjectReportSummary(Integer project, String requestedBy) {
        Users requestedUser = usersDao.findByUsername(requestedBy);
        ProjectReportDto dto = null;
        Integer org = null;
        if (project == null || project.equals(0)) {
            org = requestedUser.getOrganization().getId();
        //list = projectReportDao.findByOrganizationForTodo(org);
        } else {
            dto = (ProjectReportDto) projectReportDao.findProjectSummary(project);
        }
        return dto;
    }

    @Override
    public ProjectReportDto getCurrentProjectReport(Integer project, String requestedBy) {
        Users requestedUser = usersDao.findByUsername(requestedBy);
        Integer org = null;
        ProjectReport list = null;
        ProjectReportDto dto = null;
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        if (project == null || project.equals(0)) {
            org = requestedUser.getOrganization().getId();
            list = projectReportDao.findByOrganizationMonthAndYear(org, month, year);
        } else {
            list = projectReportDao.findByProjectMonthAndYear(project, month, year);
        }
        // copy for display
        dto = projectReportDtoA.copyForDisplay(list);
        return dto;
    }
    // ------------------------------- private methods ---------------------//

    /**
     * owner report is effected only when task is added or deleted
     * @param t
     * @param dto
     *
     *  if task is null then its a new task
     *  if dto.id is null then delete task
     *  this function only effects underlying instance when task is either created or deleted
     */
    private void processTaskOwner(Task t, TaskDto dto) {
        Calendar c = Calendar.getInstance();
        if (t == null && dto != null) { // new task if t is null and dto is not null
            UserReport userReport = userReportDao.findByUserMonthAndYear(dto.getOwnerId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport == null) { // create new entity if null
                userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
                userReport.setTotalCreated(1);
                userReport.setUser(dto.getOwnerId());
                userReportDao.create(userReport);
            } else { // update entity
                userReport.setTotalCreated(userReport.getTotalCreated() + 1);
                userReportDao.update(userReport);
            }
        } else if (t != null && t.getId() != null && (dto.getId() == null)) { //  task deleted
            c.setTime(t.getCreateDate());
            UserReport userReport = userReportDao.findByUserMonthAndYear(t.getOwner().getId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            userReport.setTotalCreated(userReport.getTotalCreated() - 1);
            userReportDao.update(userReport);
        }
    }

    /**
     * project report is efected only when task is added, deleted or changed
     * task added if t == null & dto != null
     * @param t
     * @param dto
     */
    private void processTaskProject(Task t, TaskDto dto) {
        if (t == null && (dto != null && dto.getOwnerId() != null)) { // new task       
            taskSavedForProjectReport(dto, true);
        } else if (t != null && t.getId() != null && (dto.getId() == null)) { //  task deleted
            taskDeletedForProjectReport(t);
        } else if (t != null && t.getId() != null && dto != null) { //  project change
            taskSavedForProjectReport(dto, false);
        }
    }

    /**
     *
     * @param dto
     */
    private void taskSavedForProjectReport(TaskDto dto, boolean incrementTaskCount) {
        Calendar c = Calendar.getInstance();// new task
        Integer org = usersDao.read(dto.getOwnerId()).getOrganization().getId();
        ProjectReport projectReport = projectReportDao.findByOrganizationProjectMonthAndYear(org, dto.getProjectId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        if (projectReport == null) {// create new entity
            projectReport = new ProjectReport(null, org, dto.getProjectId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            projectReportDao.create(projectReport);
        }
        if (incrementTaskCount) {
            projectReport.setTaskCreated(projectReport.getTaskCreated() + 1);
        }
//        projectReport.setEstimatedTime(projectReport.getEstimatedTime() + dto.getEstimatedHours());
//        projectReport.setTimeSpend(projectReport.getTimeSpend() + dto.getSpendHours());
        projectReportDao.update(projectReport);
    }

    /**
     * 
     * @param t
     */
    private void taskDeletedForProjectReport(Task t) {
        Calendar c = Calendar.getInstance();
        c.setTime(t.getCreateDate());
        Integer org = t.getOwner().getOrganization().getId();
        Integer projectId = null;
        if (t.getProject() != null) {
            projectId = t.getProject().getId();
        }
        ProjectReport projectReport = projectReportDao.findByOrganizationProjectMonthAndYear(org, projectId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        projectReport.setTaskCreated(projectReport.getTaskCreated() - 1);
        projectReport.setEstimatedTime(projectReport.getEstimatedTime() - t.getSpendHours());
        projectReportDao.update(projectReport);
    }

    /**
     * efects user_report on assineee added, removed or changed
     * @param t
     * @param dto
     */
    private void processTaskAssignee(Task t, TaskDto dto) {
        if ((t != null && t.getAssignedTo() == null && dto != null && dto.getAssignedToId() != null) || (t == null && (dto != null && dto.getAssignedToId() != null))) { // new task  assigned     
            addTaskAssigned(dto.getAssignedToId(), dto.getOwnerId(), dto.getAssignedById(), dto.getSpendHours(), dto.getEstimatedHours());
        } else if (t != null && t.getAssignedTo() != null && (dto == null || dto != null && dto.getAssignedToId() == null)) {
            removeTaskAssigned(t.getAssignedTo().getId(), t.getOwner().getId(), t.getAssignedBy().getId(), t.getAssignedDate(), t.getEstimatedHours());
        } else if (t != null && dto != null && t.getAssignedTo() != null && dto.getAssignedToId() != null) {
            if (t.getAssignedTo().getId().equals(dto.getAssignedToId())) {
                updateEffort(t.getAssignedTo().getId(), dto.getEstimatedHours(), dto.getSpendHours());
            } else {
                removeTaskAssigned(t.getAssignedTo().getId(), t.getOwner().getId(), t.getAssignedBy().getId(), t.getAssignedDate(), t.getEstimatedHours());
                addTaskAssigned(dto.getAssignedToId(), dto.getOwnerId(), dto.getAssignedById(), t.getSpendHours(), t.getEstimatedHours());
            }

        }
    }

    private void updateEffort(Integer userId, double eh, double sh) {
        Calendar c = Calendar.getInstance();
        UserReport userReport = userReportDao.findByUserMonthAndYear(userId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        if (userReport == null) { // new entity
            userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
            userReport.setUser(userId);
            userReportDao.create(userReport);
        }
        userReport.setEstimatedHours(userReport.getEstimatedHours() + eh);
        userReport.setHoursSpend(userReport.getHoursSpend() + sh);
        userReportDao.update(userReport);
    }

    /**
     *
     * @param userId
     * @param ownerId
     * @param assignedBy
     * @param assignDate
     * @param eh
     */
    private void addTaskAssigned(Integer userId, Integer ownerId, Integer assignedBy, double hoursSpend, double eh) { //, boolean isNew, Date dt) {
        Calendar c = Calendar.getInstance();
        UserReport userReport1 = userReportDao.findByUserMonthAndYear(userId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        if (userReport1 == null) { // new entity
            userReport1 = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
            userReport1.setUser(userId);
            userReportDao.create(userReport1);
        }
//        if (ownerId.equals(userId) && assignedBy.equals(userId)) {
//            userReport1.setCreatedSelfAssigned(userReport1.getCreatedSelfAssigned() + 1);
//        } else if (assignedBy.equals(userId)) {
//            userReport1.setSelfAssigned(userReport1.getSelfAssigned() + 1);
//        } else {
//            userReport1.setAssigned(userReport1.getAssigned() + 1);
//        }
        userReport1.setTotalAssigned(userReport1.getTotalAssigned() + 1);
        userReport1.setEstimatedHours(userReport1.getEstimatedHours() + eh);
        userReport1.setHoursSpend(userReport1.getHoursSpend() + hoursSpend);
        userReportDao.update(userReport1);
    }

    /**
     *
     * @param userId
     * @param ownerId
     * @param assignedBy
     * @param assignDate
     * @param eh
     */
    private void removeTaskAssigned(Integer userId, Integer ownerId, Integer assignedBy, Date assignDate, double eh) {
        Calendar c = Calendar.getInstance();
        c.setTime(assignDate);
        UserReport userReport1 = userReportDao.findByUserMonthAndYear(userId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
//        if (ownerId.equals(userId) && assignedBy.equals(userId)) {
//            userReport1.setCreatedSelfAssigned(userReport1.getCreatedSelfAssigned() - 1);
//        } else if (assignedBy.equals(userId)) {
//            userReport1.setSelfAssigned(userReport1.getSelfAssigned() - 1);
//        } else {
//            userReport1.setAssigned(userReport1.getAssigned() - 1);
//        }
        userReport1.setTotalAssigned(userReport1.getTotalAssigned() - 1);
        userReport1.setEstimatedHours(userReport1.getEstimatedHours() - eh);
        userReportDao.update(userReport1);
    }

    /**
     * 
     * @param t
     * @param dto
     */
    private void processTaskCompletion(Task t, TaskDto dto) {
        Calendar c = Calendar.getInstance();
        //Integer org = usersDao.read(dto.getOwnerId()).getOrganization().getId();
        if ((t == null || !t.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) &&
                dto.getStatus() != null && dto.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) {
            UserReport userReport = null;
            //if (dto.getAssignedToId() != null) {
            Integer assignedTo = dto.getAssignedToId();
            if (assignedTo == null) {
                assignedTo = t.getAssignedTo().getId();
            }
            userReport = userReportDao.findByUserMonthAndYear(assignedTo, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            if (userReport == null) { // add entity to db
                userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
                userReport.setUser(dto.getAssignedToId());
                userReportDao.create(userReport);
            }
//            else {
//                userReport = userReportDao.findByUserMonthAndYear(dto.getOwnerId(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
//                if (userReport == null) { // add entity to db this will happen on new month startups
//                    userReport = new UserReport(null, c.get(Calendar.MONTH), c.get(Calendar.YEAR), 0);
//                    userReport.setUser(dto.getOwnerId());
//                    userReportDao.create(userReport);
//                }
//                userReport.setCreatedSelfAssigned(userReport.getCreatedSelfAssigned() + 1);
//                userReport.setTotalAssigned(userReport.getTotalAssigned() + 1);
//            }
            //userReport = getUserReport(userReport, c, dto);
            userReport.setTotalCompleted(userReport.getTotalCompleted() + 1);
            //userReport.setEstimatedHours(userReport.getEstimatedHours() + dto.getEstimatedHours());
            //userReport.setHoursSpend(userReport.getHoursSpend() + dto.getSpendHours());
            userReportDao.update(userReport);
//            ProjectReport projectReport = null;
//            projectReport = getProjectReport(dto, c, projectReport, org);
//            projectReport.setTaskFinished(projectReport.getTaskFinished() + 1);
//            //projectReport.setTimeSpend(projectReport.getTimeSpend() + dto.getSpendHours());
        //projectReport.setEstimatedTime(projectReport.getEstimatedTime() + dto.getEstimatedHours());
//            projectReportDao.update(projectReport);

//        } else if ((t != null && t.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) &&
//                !dto.getStatus().equals(TaskService.TASK_STATUS_COMPLETED)) {
//            UserReport userReport = userReportDao.findByUserMonthAndYear(dto.getAssignedById(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
//            ProjectReport projectReport = null;
//            userReport = getUserReport(userReport, c, dto);
//            projectReport = getProjectReport(dto, c, projectReport, org);
//            projectReport.setTaskFinished(projectReport.getTaskFinished() - 1);
//            //projectReport.setTimeSpend(projectReport.getTimeSpend() - t.getSpendHours());
//            //projectReport.setEstimatedTime(projectReport.getEstimatedTime() - dto.getEstimatedHours());
//            projectReportDao.update(projectReport);
//            userReport.setTotalCompleted(userReport.getTotalCompleted() - 1);
//            //userReport.setEstimatedHours(userReport.getEstimatedHours() - t.getEstimatedHours());
//            //userReport.setHoursSpend(userReport.getHoursSpend() - t.getSpendHours());
//            userReportDao.update(userReport);
        }
    }

    /**
     *  gets the projectReport by org, projectId and udpates it accordingly
     *
     *  if ( newTask) then increment taskCreated
     *  if ( taskCompleted ) then increment taskFinsihed
     *
     *
     * @param organizationId
     * @param projectId
     * @param isNewTaskCreated
     * @param isTaskCompleted
     * @param estimatedHours
     * @param hoursSpend
     */
    private void updateProjectReport(Integer organizationId, Integer projectId, boolean isNewTaskCreated, boolean isTaskCompleted, double estimatedHours, double hoursSpend) {
        Calendar c = Calendar.getInstance();
        ProjectReport projectReport = projectReportDao.findByOrganizationProjectMonthAndYear(organizationId, projectId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        if (projectReport == null) {// create new entity
            projectReport = new ProjectReport(null, organizationId, projectId, c.get(Calendar.MONTH), c.get(Calendar.YEAR));
            projectReportDao.create(projectReport);
        }
        if (isNewTaskCreated) {
            projectReport.setTaskCreated(projectReport.getTaskCreated() + 1);
        }
        if (isTaskCompleted) {
            projectReport.setTaskFinished(projectReport.getTaskFinished() + 1);
        }
        projectReport.setEstimatedTime(projectReport.getEstimatedTime() + estimatedHours);
        projectReport.setTimeSpend(projectReport.getTimeSpend() + hoursSpend);
        projectReportDao.update(projectReport);
    }

    private void processProjectReport(Task t, TaskDto dto) {
        Integer org = usersDao.read(dto.getOwnerId()).getOrganization().getId();
        Integer projectId = null;
        boolean isNewTaskCreated = false;
        boolean isTaskCompleted = false;
        double estimatedHours = dto.getEstimatedHours();
        double hoursSpend = dto.getSpendHours();

        if (t == null && (dto != null && dto.getOwnerId() != null)) {
            isNewTaskCreated = true;
        }
        if (dto.getStatus() != null && dto.getStatus().equals(TaskService.TASK_STATUS_COMPLETED) && (t == null || !t.getStatus().equals(TaskService.TASK_STATUS_COMPLETED))) {
            isTaskCompleted = true;
        }
        if (dto.getProjectId() != null && dto.getProjectId() > 0) {
            projectId = dto.getProjectId();
        } else if (t != null && t.getProject() != null) {
            projectId = t.getProject().getId();
        }
        updateProjectReport(org, projectId, isNewTaskCreated, isTaskCompleted, estimatedHours, hoursSpend);
    }

    /**
     * get userreport & projectreport and udpate est_hours, time_spend
     * @param dto
     */
    private void processTaskUpdate(TaskDto dto) {
        if (dto != null && (dto.getEstimatedHours() > 0 || dto.getSpendHours() > 0)) {
            Calendar c = Calendar.getInstance();
            Integer month = c.get(Calendar.MONTH);
            Integer year = c.get(Calendar.YEAR);
            Integer org = usersDao.read(dto.getOwnerId()).getOrganization().getId();
            Integer user = dto.getOwnerId();
            if (dto.getAssignedToId() != null) {
                user = dto.getAssignedById();
            }

            UserReport userReport = userReportDao.findByUserMonthAndYear(user, month, year);
            ProjectReport projectReport = projectReportDao.findByOrganizationProjectMonthAndYear(org, dto.getProjectId(), month, year);
            userReport.setEstimatedHours(userReport.getEstimatedHours() + dto.getEstimatedHours());
            userReport.setHoursSpend(userReport.getHoursSpend() + dto.getSpendHours());
            userReportDao.update(userReport);
            projectReport.setEstimatedTime(projectReport.getEstimatedTime() + dto.getEstimatedHours());
            projectReport.setTimeSpend(projectReport.getTimeSpend() + dto.getSpendHours());
            projectReportDao.update(projectReport);
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

    public void setProjectReportDtoA(ProjectReportDtoA projectReportDtoA) {
        this.projectReportDtoA = projectReportDtoA;
    }

    public void setUserReportDtoA(UserReportDtoA userReportDtoA) {
        this.userReportDtoA = userReportDtoA;
    }

    public void setProjectUsersDao(ProjectUsersDao projectUsersDao) {
        this.projectUsersDao = projectUsersDao;
    }
    @Autowired
    private ProjectUsersDao projectUsersDao;
    @Autowired
    private ProjectReportDao projectReportDao;
    @Autowired
    private UserReportDao userReportDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private UserReportDtoA userReportDtoA;
    @Autowired
    private ProjectReportDtoA projectReportDtoA;
    private Logger log = Logger.getLogger(getClass());
}
