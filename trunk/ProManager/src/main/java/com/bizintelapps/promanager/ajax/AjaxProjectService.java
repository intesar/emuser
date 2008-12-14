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
package com.bizintelapps.promanager.ajax;

import com.bizintelapps.promanager.dto.ProjectDto;
import com.bizintelapps.promanager.service.ProjectService;
import com.bizintelapps.promanager.service.validator.ValidationException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author intesar
 */
public class AjaxProjectService {

    // saveProject should handle create|update
    /**
     *  every method should copy same pattern
     *  msg for success
     *  should catch exceptions exactly the same way
     * @param usersDto
     * @return
     */
    public List<ProjectDto> saveProject(ProjectDto projectDto) {
        try {
            // this should handle create/update
            projectService.saveProject(projectDto, SecurityUtil.getUsername());
            return projectService.getProjects( SecurityUtil.getUsername()).getCurrentList();
        } catch (ValidationException e) {
            log.error(e);
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
        }
        throw new RuntimeException("Error, Please try again! ");
    }
    // getProjectList should get all projects visible ot user with brief summary
    /**
     * 
     * @return
     */
    public List<ProjectDto> getProjectList() {
        try {
            return projectService.getProjects(SecurityUtil.getUsername()).getCurrentList();
        } catch (ValidationException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
        //return ERROR_MESSAGE;
        }
        return null;
    }

    public void deleteProject(Integer projectId) {
        try {
            this.projectService.deleteProject(projectId, SecurityUtil.getUsername());
        } catch (RuntimeException re) {
            // log re
            throw new RuntimeException("Project cannot be deleted!");
        }
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }    // getProjectInfo should get Project with its member list
    // deleteProject should delete project
    private final Log log = LogFactory.getLog(getClass());
    @Autowired
    private ProjectService projectService;
}
