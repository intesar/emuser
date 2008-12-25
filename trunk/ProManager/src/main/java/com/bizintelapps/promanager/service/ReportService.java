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

import com.bizintelapps.promanager.dto.ProjectReportDto;
import com.bizintelapps.promanager.dto.UserReportDto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface ReportService {

    /**
     * report includes 
     * current open task for the user
     * task assigned during start & end dates
     * task completed during start & end dates
     * total estimated hours for task during start & end dates for the user
     * total spend time for completed task during start & end dates for the user
     * total hours remaining on the non-completed task
     *
     * 
     * @param userId
     * @param requestedBy
     * @param start  if null then current month 1st
     * @param end if null then current month 31st
     * @return
     */
    public UserReportDto getUserTaskReport(Integer userId, Date start, Date end, String requestedBy);

    /**
     * report includes
     * total tasks created
     * total task completed
     * task open
     * unassigned task
     * total hours spend
     * total hours pending
     * allocated hours
     *  
     * @param projectId
     * @param start if null then current month 1st
     * @param end if null then current month 31st
     * @param requestedBy
     * @return
     */
    public ProjectReportDto getProjectTaskReport(Integer projectId, Date start, Date end, String requestedBy);

    /**
     * report includes 
     * current open task for the user
     * task assigned during start & end dates
     * task completed during start & end dates
     * total estimated hours for task during start & end dates for the user
     * total spend time for completed task during start & end dates for the user
     * total hours remaining on the non-completed task
     *
     * @param start  if null then current month 1st
     * @param end if null then current month 31st
     * @param requestedBy
     * @return
     */
    public List<UserReportDto> getAllUsersTaskReport(Date start, Date end, String requestedBy);

    /**
     * report includes
     * total tasks created
     * total task completed
     * task open
     * unassigned task
     * total hours spend
     * total hours pending
     * allocated hours
     * 
     * @param start if null then current month 1st
     * @param end  if null then current month 31st
     * @param requestedBy
     * @return
     */
    public List<ProjectReportDto> getAllProjectTaskReport(Date start, Date end, String requestedBy);

    /**
     * 
     * @param noOfUsers min 2 max 10
     * @param start if null then current month 1st
     * @param end if null then current month 31st
     * @param requestedBy
     * @return
     */
    public List<UserReportDto> getBusyUsersReport(int noOfUsers, Date start, Date end, String requestedBy);

    /**
     * 
     * @param noOfProjects min 2 max 10
     * @param start if null then current month 1st
     * @param end if null then current month 31st
     * @param requestedBy
     * @return
     */
    public List<ProjectReportDto> getBusyProjectsReport(int noOfProjects, Date start, Date end, String requestedBy);

    /**
     * 
     * @param noOfUsers  min 2 max 10
     * @param start if null then current month 1st
     * @param end if null then current month 31st
     * @param requestedBy
     * @return
     */
    public List<UserReportDto> getSlowUsersReport(int noOfUsers, Date start, Date end, String requestedBy);

    /**
     * 
     * @param noOfProjects min 2 max 10
     * @param start if null then current month 1st
     * @param end if null then current month 31st
     * @param requestedBy
     * @return
     */
    public List<ProjectReportDto> getSlowProjectsReport(int noOfProjects, Date start, Date end, String requestedBy);
}
