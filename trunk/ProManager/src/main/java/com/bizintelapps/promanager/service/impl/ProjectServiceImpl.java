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
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.ProjectService;
import com.bizintelapps.promanager.service.converters.ProjectConverter;
import com.bizintelapps.promanager.dto.ProjectDto;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;


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
        return getProjects(savedBy).getCurrentList();
    }

    @Override
    public void saveProject(ProjectDto projectDto, String savedBy) {
        Users savedByUsers = usersDao.findByUsername(savedBy);
        if (!savedByUsers.isIsAdministrator()) {
            throw new ServiceRuntimeException("only administrators can create new Project");
        }

        log.debug("----------- project id " + projectDto.getId());
        // create new if id null
        // administrator can create projects
        if (projectDto.getId() == null) {
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
            // copy usersDto contents to new Users object and persist
            Project project = projectDao.read(projectDto.getId());
            projectConverter.copyForUpdate(projectDto, project);
            project.setLastUpdateDate(new Date());
            project.setLastUpdateUser(savedByUsers.getId());
            projectDao.update(project);
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
    public PagingParams<ProjectDto> getProjects(String requestedBy) {
        PagingParams<ProjectDto> pagingParams = new PagingParams<ProjectDto>();
        Users users = usersDao.findByUsername(requestedBy);
        if (users.isIsAdministrator()) {
            List<ProjectDto> list = projectConverter.copyAllForDisplay(projectDao.findByOrganization(users.getOrganization().getId()));
            pagingParams.setCurrentList(list);
        }
//        } else {
//            List<ProjectDto> list = new ArrayList<ProjectDto>();
//            List<ProjectUsers> projectUsersList = projectUsersDao.findByAdministratorUserId(users.getId());
//            ProjectDto projectDto = null;
//            for (ProjectUsers projectUsers : projectUsersList) {
//                projectDto = projectConverter.copyForDisplay(projectUsers.getProject(), new ProjectDto());
//            }
//            list.add(projectDto);
//        }
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
