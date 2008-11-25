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
package com.bizintelapps.promanager.dao.impl;

import com.bizintelapps.promanager.dao.ProjectUsersDao;
import com.bizintelapps.promanager.entity.ProjectUsers;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class ProjectUsersDaoImpl extends GenericDaoImpl<ProjectUsers, Integer> implements ProjectUsersDao {

    private final Log log = LogFactory.getLog(getClass());
    public ProjectUsersDaoImpl() {
        super(ProjectUsers.class);
    }

    @Override
    public ProjectUsers findByProjectAdministratorByProjectNameAndUserId(String projectName, Integer userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

    @Override
    public List<ProjectUsers> findByAdministratorUserId(Integer userId) {
        return executeNamedQueryList("ProjectUsers.findByAdministratorUserId", null, userId);
    }

    @Override
    public ProjectUsers findByProjectIdAndUserId(Integer projectId, Integer ownerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
