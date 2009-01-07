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

import com.bizintelapps.promanager.dto.ProjectReportDto;
import com.bizintelapps.promanager.dto.UserReportDto;
import com.bizintelapps.promanager.service.ReportService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author intesar
 */
public class AjaxReportService {

    /**
     * return list all all user reports
     * @param user if null then get for requestedBy
     * @param requestedBy
     * @return
     */
    public List<UserReportDto> getUserReports(Integer user) {
        return reportService.getUserReports(user, SecurityUtil.getUsername());
    }

    /**
     * return summary of all user report
     * @param user is null then get for requestedBy
     * @param requestedBy
     * @return
     */
    public UserReportDto getCurrentUserReport(Integer user) {
        return reportService.getCurrentUserReport(user, SecurityUtil.getUsername());
    }

    public UserReportDto getUserReportSummary ( Integer user ) {
        return reportService.getUserSummary(user, SecurityUtil.getUsername());
    }
    /**
     *  return list of reports for all users for the time period
     * @param month
     * @param year
     * @param requestedBy
     * @return
     */
    public List<UserReportDto> getAllUserReport(int month, int year) {
        return reportService.getAllUserReport(month, year, SecurityUtil.getUsername());
    }

    /**
     * return list of reports for given project or todo
     * @param project
     * @param requestedBy
     * @return
     */
    public List<ProjectReportDto> getProjectReports(Integer project) {
        return reportService.getProjectReports(project, SecurityUtil.getUsername());
    }

    /**
     * 
     * return summary of project or todo 
     * @param project
     * @param requestedBy
     * @return
     */
    public ProjectReportDto getProjectReportSummary(Integer project) {
        return reportService.getProjectReportSummary(project, SecurityUtil.getUsername());
    }

    /**
     * current project summary
     * @param project
     * @param requestedBy
     * @return
     */
    public ProjectReportDto getCurrentProjectReport(Integer project) {
        return reportService.getCurrentProjectReport(project, SecurityUtil.getUsername());
    }

    // --------------------------------------- setters --------------------- //
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }
    @Autowired
    private ReportService reportService;
    private Logger log = Logger.getLogger(getClass());
}
