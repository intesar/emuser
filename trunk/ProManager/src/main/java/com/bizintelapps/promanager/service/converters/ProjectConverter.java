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
package com.bizintelapps.promanager.service.converters;

import com.bizintelapps.promanager.dto.ProjectUserDto;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.dto.ProjectDto;
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.entity.ProjectUsers;
import com.bizintelapps.promanager.entity.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author intesar
 */
@Service
public class ProjectConverter {

    public List<ProjectDto> copyAllForDisplay(Collection<Project> projectCollection) {
        List<ProjectDto> list = new ArrayList<ProjectDto>();
        for (Project project : projectCollection) {
            ProjectDto projectDto = copyForDisplay(project, new ProjectDto());
            list.add(projectDto);
        }
        return list;
    }

    public List<ProjectUserDto> copyAllProjectAlongUsers1(List<ProjectUsers> projectUsers) {
        List<ProjectUserDto> list = new ArrayList<ProjectUserDto>();
        for (ProjectUsers u : projectUsers) {
            List<UsersDto> users = new ArrayList<UsersDto>();
            for (ProjectUsers pu : u.getProject().getProjectUsersCollection()) {
                if (pu.getUsers().getEnabled()) {
                    UsersDto usersDto = new UsersDto();
                    usersDto.setId(pu.getUsers().getId());
                    usersDto.setFirstname(pu.getUsers().getFirstname());
                    usersDto.setLastname(pu.getUsers().getLastname());
                    usersDto.setUsername(pu.getUsers().getUsername());
                    users.add(usersDto);
                }
            }
            ProjectUserDto dto = new ProjectUserDto(u.getProject().getId(), u.getProject().getName(), users);
            list.add(dto);
        }
        return list;
    }

    public List<ProjectUserDto> copyAllProjectAlongUsers(List<Project> projects) {
        List<ProjectUserDto> list = new ArrayList<ProjectUserDto>();
        for (Project p : projects) {
            List<UsersDto> users = new ArrayList<UsersDto>();
            Collection<ProjectUsers> projectUserses = p.getProjectUsersCollection();
            for (ProjectUsers pu : projectUserses) {
                if (pu.getUsers().getEnabled()) {
                    UsersDto usersDto = new UsersDto();
                    usersDto.setId(pu.getUsers().getId());
                    usersDto.setFirstname(pu.getUsers().getFirstname());
                    usersDto.setLastname(pu.getUsers().getLastname());
                    usersDto.setUsername(pu.getUsers().getUsername());
                    users.add(usersDto);
                }
            }
            ProjectUserDto dto = new ProjectUserDto(p.getId(), p.getName(), users);
            list.add(dto);
        }
        return list;
    }

    public ProjectDto copyForDisplay(Project project, ProjectDto projectDto) {
        projectDto.setCreateDate(project.getCreateDate());
        projectDto.setCreateUser(project.getCreateUser());
        projectDto.setDescription(project.getDescription());
        projectDto.setId(project.getId());
        //projectDto.setLastUpdateUser(project.getLastUpdateUser());
        //String pattern = "yyyy.MM.dd hh:mm";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //projectDto.setLastUpdateDate(simpleDateFormat.format(project.getLastUpdateDate()));
        projectDto.setName(project.getName());
        projectDto.setStatus(project.getStatus());
        projectDto.setVisibility(project.getVisibility());
        return projectDto;
    }

    public Project copyForCreate(ProjectDto projectDto, Project project) {
        project.setDescription(projectDto.getDescription());
        project.setName(projectDto.getName());
        project.setStatus(projectDto.getStatus());
        return project;
    }

    public Project copyForUpdate(ProjectDto projectDto, Project project) {
        project.setDescription(projectDto.getDescription());
        project.setStatus(projectDto.getStatus());
        return project;
    }
}
