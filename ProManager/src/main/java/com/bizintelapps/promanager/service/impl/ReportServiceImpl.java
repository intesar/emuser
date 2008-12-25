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

import com.bizintelapps.promanager.dto.ProjectReportDto;
import com.bizintelapps.promanager.dto.UserReportDto;
import com.bizintelapps.promanager.service.ReportService;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author intesar
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public UserReportDto getUserTaskReport(Integer userId, Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProjectReportDto getProjectTaskReport(Integer projectId, Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UserReportDto> getAllUsersTaskReport(Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProjectReportDto> getAllProjectTaskReport(Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UserReportDto> getBusyUsersReport(int noOfUsers, Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProjectReportDto> getBusyProjectsReport(int noOfProjects, Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UserReportDto> getSlowUsersReport(int noOfUsers, Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProjectReportDto> getSlowProjectsReport(int noOfProjects, Date start, Date end, String requestedBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Logger log = Logger.getLogger(getClass());
}
