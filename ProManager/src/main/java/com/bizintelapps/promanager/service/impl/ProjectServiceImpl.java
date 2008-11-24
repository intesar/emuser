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
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.entity.ProjectUsers;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.ProjectService;
import com.bizintelapps.promanager.converters.ProjectConverter;
import com.bizintelapps.promanager.dto.ProjectDto;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class ProjectServiceImpl implements ProjectService {

    @Override
    public void saveProject(ProjectDto projectDto, String savedBy) {
        // create new if id null
        // administrator can create projects
        Users savedByUsers = usersDao.findByUsername(savedBy);
        if (projectDto.getId() == null) {
            if (!savedByUsers.getRole().equalsIgnoreCase("adminstrator")) {
                throw new ServiceRuntimeException("only administrators can create new Project");
            }
            // project should have unique name
            Project project1 = projectDao.findByNameAndOrganization(projectDto.getName(),
                    savedByUsers.getOrganization().getId());
            if (project1 != null && project1.getId() != null) {
                throw new ServiceRuntimeException(projectDto.getName() + " name is already in use");
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
            ProjectUsers projectUsers = projectUsersDao.findByProjectAdministratorByProjectNameAndUserId(projectDto.getName(), savedByUsers.getId());
            if (!savedByUsers.getRole().equalsIgnoreCase("adminstrator") || projectUsers == null ||
                    projectUsers.getId() == null) {
                throw new ServiceRuntimeException("only Org Administrators or Project Administrator can update Project");
            }
            // project should have unique name
            Project project1 = projectDao.read(projectDto.getId());
            if (!project1.getName().equals(projectDto.getName())) {
                Project p1 = projectDao.findByNameAndOrganization(projectDto.getName(), savedByUsers.getOrganization().getId());
                if (p1 != null && p1.getId() != null) {
                    throw new ServiceRuntimeException(projectDto.getName() + " name is already in use");
                }
            }
            // copy usersDto contents to new Users object and persist
            Project project = projectConverter.copyForUpdate(projectDto, new Project());
            project.setLastUpdateDate(new Date());
            project.setLastUpdateUser(savedByUsers.getId());
            projectDao.create(project);
        }

    }

    @Override
    public void deleteProject(Integer projectId, String deletedBy) {
        Users users = usersDao.findByUsername(deletedBy);
        Project project = projectDao.read(projectId);
        // find user is admin then only can delete other even they are administrators
        if (users.getRole().equalsIgnoreCase("adminstrator")) {
            projectDao.delete(project);
        } else {
            throw new ServiceRuntimeException("Only Administrator can delete Project!");
        }
    }

    @Override
    public PagingParams<ProjectDto> getProjects(String requestedBy) {
        PagingParams<ProjectDto> pagingParams = new PagingParams<ProjectDto>();
        Users users = usersDao.findByUsername(requestedBy);
        if (users.getRole().equalsIgnoreCase("administrator")) {
            List<ProjectDto> list = projectConverter.copyAllForDisplay(users.getOrganization().getProjectCollection());
            pagingParams.setCurrentList(list);
        } else {
            List<ProjectDto> list = new ArrayList<ProjectDto>();
            List<ProjectUsers> projectUsersList = projectUsersDao.findByAdministratorUserId(users.getId());
            ProjectDto projectDto = null;
            for (ProjectUsers projectUsers : projectUsersList) {
                projectDto = projectConverter.copyForDisplay(projectUsers.getProject(), new ProjectDto());
            }
            list.add(projectDto);
        }
        return pagingParams;
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
    private UsersDao usersDao;
    private ProjectDao projectDao;
    private ProjectUsersDao projectUsersDao;
    private ProjectConverter projectConverter;
}
