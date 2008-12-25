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
package com.bizintelapps.promanager.dtoa;

import com.bizintelapps.promanager.dto.ProjectUserDto;
import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.dto.ProjectDto;
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.dto.UsersMinDto;
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
public class ProjectDtoA {

    public List<ProjectDto> copyAllForDisplay(Collection<Project> projectCollection) {
        List<ProjectDto> list = new ArrayList<ProjectDto>();
        for (Project project : projectCollection) {
            ProjectDto projectDto = copyForDisplay(project, new ProjectDto());
            list.add(projectDto);
        }
        return list;
    }

    public ProjectUserDto copyAllProjectAlongUsers1(List<ProjectUsers> projectUsers) {
        Project project = null;
        List<UsersMinDto> users = new ArrayList<UsersMinDto>();
        for (ProjectUsers pu : projectUsers) {
            project = pu.getProject();
            if (pu.getUsers().getEnabled()) {
                Users user = pu.getUsers();
                UsersMinDto usersMinDto = new UsersMinDto(user.getId(),
                        user.getUsername(), user.getFirstname(), user.getLastname(), false,
                        pu.getIsManager());
                users.add(usersMinDto);
            }
        }
        ProjectUserDto dto = new ProjectUserDto(project.getId(), project.getName(), users);
        return dto;
    }

     public List<ProjectUserDto> copyAllProjectAlongUsers2(List<ProjectUsers> projectUsers) {
        return null;
    }
     
    public List<ProjectUserDto> copyAllProjectAlongUsers(List<Project> projects) {
        List<ProjectUserDto> list = new ArrayList<ProjectUserDto>();
        for (Project p : projects) {
            List<UsersMinDto> users = new ArrayList<UsersMinDto>();
            Collection<ProjectUsers> projectUserses = p.getProjectUsersCollection();
            for (ProjectUsers pu : projectUserses) {
                Users user = pu.getUsers();
                if (pu.getUsers().getEnabled()) {
                    UsersMinDto usersDto = new UsersMinDto(user.getId(),
                            user.getUsername(), user.getFirstname(), user.getLastname(), false,
                            pu.getIsManager());
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
