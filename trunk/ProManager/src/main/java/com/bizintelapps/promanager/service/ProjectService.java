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
package com.bizintelapps.promanager.service;

import com.bizintelapps.promanager.dto.ProjectDto;
import com.bizintelapps.promanager.entity.ProjectUsers;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface ProjectService {

    public List<ProjectDto> saveAndGetProjects(ProjectDto projectDto, String savedBy);

    /**
     *  saves or updates a project to db
     *  only admin can create new project
     *  admin or project manager can change status (update)
     * @param projectDto
     * @param savedBy
     */
    public void saveProject(ProjectDto projectDto, String savedBy);

    /**
     *  tries to delete project
     * @param projectId
     * @param deletedBy
     */
    public void deleteProject(Integer projectId, String deletedBy);

    /**
     * returns projects for client display                   
     * @param requestedBy
     * @return
     */
    public List<ProjectDto> getProjects(String requestedBy);

    /**
     * creates or updates user to project
     * @param projectId
     * @param userId
     * @param isManager if true user can manage this project
     * @param savedBy 
     */
    public void saveUserToProject(Integer projectId, Integer userId, boolean isManager, String savedBy);

    /**
     * only admin or pm can execute this
     * @param projectId
     * @param requestedBy
     */
    public List<ProjectUsers> getProjectUsers(Integer projectId, String requestedBy);

    /**
     * removes user from project
     * @param userId
     * @param projectId
     * @param savedBy
     */
    public void deleteUserFromProject(Integer userId, Integer projectId, String savedBy);
    String IN_PROGRESS = "In Progess";
    String ON_HOLD = "On Hold";
    String COMPLETED = "Completed";
}
