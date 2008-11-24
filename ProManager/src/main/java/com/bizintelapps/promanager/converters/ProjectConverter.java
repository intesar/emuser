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
package com.bizintelapps.promanager.converters;

import com.bizintelapps.promanager.entity.Project;
import com.bizintelapps.promanager.dto.ProjectDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author intesar
 */
public class ProjectConverter {

    public List<ProjectDto> copyAllForDisplay(Collection<Project> projectCollection) {
        List<ProjectDto> list = new ArrayList<ProjectDto>();
        for (Project project : projectCollection) {
            ProjectDto projectDto = copyForDisplay(project, new ProjectDto());
            list.add(projectDto);
        }
        return list;
    }

    public ProjectDto copyForDisplay(Project project, ProjectDto projectDto) {
        projectDto.setCreateDate(project.getCreateDate());
        projectDto.setCreateUser(project.getCreateUser());
        projectDto.setDescription(project.getDescription());
        projectDto.setId(project.getId());
        projectDto.setLastUpdateUser(project.getLastUpdateUser());
        projectDto.setLastUpdateDate(project.getLastUpdateDate());
        projectDto.setName(project.getName());
        projectDto.setStatus(project.getStatus());
        projectDto.setVisibility(project.getVisibility());
        return projectDto;
    }

    public Project copyForCreate(ProjectDto projectDto, Project project) {
        project.setDescription(projectDto.getDescription());
        project.setName(projectDto.getName());
        project.setStatus(projectDto.getStatus());
        project.setVisibility(projectDto.getVisibility());
        return project;
    }

    public Project copyForUpdate(ProjectDto projectDto, Project project) {
        project.setId(projectDto.getId());
        project.setDescription(projectDto.getDescription());
        project.setName(projectDto.getName());
        project.setStatus(projectDto.getStatus());
        project.setVisibility(projectDto.getVisibility());
        return project;
    }
}
