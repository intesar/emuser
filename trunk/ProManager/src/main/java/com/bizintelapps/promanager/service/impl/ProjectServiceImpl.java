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
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.ProjectService;
import com.bizintelapps.promanager.service.converters.ProjectConverter;
import com.bizintelapps.promanager.dto.ProjectDto;
import com.bizintelapps.promanager.dto.ProjectUserDto;
import com.bizintelapps.promanager.entity.ProjectUsers;
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
public class ProjectServiceImpl implements ProjectService {

    @Override
    public List<ProjectDto> saveAndGetProjects(ProjectDto projectDto, String savedBy) {
        saveProject(projectDto, savedBy);
        return getProjects(savedBy);
    }

    @Override
    public void saveProject(ProjectDto projectDto, String savedBy) {
        Users savedByUsers = usersDao.findByUsername(savedBy);
        log.debug("----------- project id " + projectDto.getId());
        // create new if id null
        // administrator can create projects
        if (projectDto.getId() == null) {
            if (!savedByUsers.isIsAdministrator()) {
                throw new ServiceRuntimeException("only Administrator can create new Project");
            }
            // project should have unique name
            Project project1 = projectDao.findByNameAndOrganization(projectDto.getName(),
                    savedByUsers.getOrganization().getId());
            if (project1 != null && project1.getId() != null) {
                throw new ServiceRuntimeException(projectDto.getName() + " name is already in use, please provide a different name!");
            }
            // copy usersDto contents to new Users object and persist
            Project project = projectConverter.copyForCreate(projectDto, new Project());
            project.setCreateDate(new Date());
            project.setCreateUser(savedByUsers.getId());
            project.setLastUpdateDate(new Date());
            project.setLastUpdateUser(savedByUsers.getId());
            project.setOrganization(savedByUsers.getOrganization());
            projectDao.create(project);
        } else {
            // copy projectDto contents 
            // user should be either admin or pm
            if (savedByUsers.isIsAdministrator() || projectUsersDao.findByProjectIdAndUserId(projectDto.getId(), savedByUsers.getId()).getIsManager()) {

                Project project = projectDao.read(projectDto.getId());
                projectConverter.copyForUpdate(projectDto, project);
                project.setLastUpdateDate(new Date());
                project.setLastUpdateUser(savedByUsers.getId());
                projectDao.update(project);
            } else {
                throw new ServiceRuntimeException(" Only Administrator or ProjectManagers can update project");
            }
        }

    }

    @Override
    public void deleteProject(Integer projectId, String deletedBy) {
        Users users = usersDao.findByUsername(deletedBy);
        Project project = projectDao.read(projectId);
        // find user is admin then only can delete other even they are administrators
        if (users.isIsAdministrator()) {
            projectDao.delete(project);
        } else {
            throw new ServiceRuntimeException("Only Administrator can delete Project!");
        }
    }

    @Override
    public List<ProjectDto> getProjects(String requestedBy) {
        List<ProjectDto> list = new ArrayList<ProjectDto>();
        Users users = usersDao.findByUsername(requestedBy);
        if (users.isIsAdministrator()) {
            list = projectConverter.copyAllForDisplay(projectDao.findByOrganization(users.getOrganization().getId()));
            return list;
        } else { // users will see all managed projectes                
            List<ProjectUsers> projectUsersList = projectUsersDao.findManagedProjectsByUserId(users.getId());
            ProjectDto projectDto = null;
            for (ProjectUsers projectUsers : projectUsersList) {
                projectDto = projectConverter.copyForDisplay(projectUsers.getProject(), new ProjectDto());
                list.add(projectDto);
            }
        }
        return list;
    }

    @Override
    public List<ProjectUserDto> getProjectsForDropdown(String requestedBy) {
        Users users = usersDao.findByUsername(requestedBy);
        List<ProjectUserDto> projectUserDtos = null;
        if ( users.isIsAdministrator() ) { //return all active projects
            List<Project> projects = projectDao.findByStatusAndOrganization(IN_PROGRESS, users.getOrganization().getId());
            projectUserDtos = projectConverter.copyAllProjectAlongUsers ( projects);            
        } else { // return user projects
            List<ProjectUsers> projectUsers = projectUsersDao.findByProjectStatusAndUserId( IN_PROGRESS, users.getId() );
            projectUserDtos = projectConverter.copyAllProjectAlongUsers1(projectUsers);
            // send to converter
        }
        return projectUserDtos;
    }
    @Override
    public void saveUserToProject(Integer projectId, Integer userId, boolean isManager, String savedBy) {
        Users savedUsers = usersDao.findByUsername(savedBy);
        ProjectUsers savedByProjectUsers = projectUsersDao.findByProjectIdAndUserId(projectId, savedUsers.getId());
        // user should be either admin or project manager to do this operation
        if (!savedUsers.isIsAdministrator() || !savedByProjectUsers.getIsManager()) {
            throw new ServiceRuntimeException("Invalid operation!");
        }
        // user if not assigned to this project then create one else udpate his record
        Users users = usersDao.read(userId);
        Project project = projectDao.read(projectId);
        ProjectUsers projectUsers = projectUsersDao.findByProjectIdAndUserId(projectId, userId);

        if (projectUsers == null || projectUsers.getId() == null) {
            projectUsers = new ProjectUsers(null, isManager, new Date(), project, users, savedUsers);
            projectUsersDao.create(projectUsers);
        } else if (projectUsers.getIsManager() != isManager) {
            projectUsers.setIsManager(isManager);
            projectUsersDao.update(projectUsers);
        }
    }

    @Override
    public List<ProjectUsers> getProjectUsers(Integer projectId, String requestedBy) {
        Users savedUsers = usersDao.findByUsername(requestedBy);
        ProjectUsers savedByProjectUsers = projectUsersDao.findByProjectIdAndUserId(projectId, savedUsers.getId());
        if (!savedUsers.isIsAdministrator() || !savedByProjectUsers.getIsManager()) {
            throw new ServiceRuntimeException("Invalid operation!");
        }
        return projectUsersDao.findByProperty("Users.id", savedUsers.getId(), null).getCurrentList();

    }

    @Override
    public void deleteUserFromProject(Integer userId, Integer projectId, String savedBy) {
        Users savedUsers = usersDao.findByUsername(savedBy);
        ProjectUsers savedByProjectUsers = projectUsersDao.findByProjectIdAndUserId(projectId, savedUsers.getId());
        if (!savedUsers.isIsAdministrator() || !savedByProjectUsers.getIsManager()) {
            throw new ServiceRuntimeException("Invalid operation!");
        }
        projectUsersDao.delete(savedByProjectUsers);
    }

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public ProjectConverter getProjectConverter() {
        return projectConverter;
    }

    public void setProjectConverter(ProjectConverter projectConverter) {
        this.projectConverter = projectConverter;
    }

    public ProjectUsersDao getProjectUsersDao() {
        return projectUsersDao;
    }

    public void setProjectUsersDao(ProjectUsersDao projectUsersDao) {
        this.projectUsersDao = projectUsersDao;
    }
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectUsersDao projectUsersDao;
    @Autowired
    private ProjectConverter projectConverter;
    private final Log log = LogFactory.getLog(getClass());
}
