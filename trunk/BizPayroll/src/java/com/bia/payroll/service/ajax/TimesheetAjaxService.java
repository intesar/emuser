/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.service.ajax;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.entity.Timesheet;
import com.bia.payroll.model.TimesheetDto;
import com.bia.payroll.service.TimesheetService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intesar
 */
public class TimesheetAjaxService {

    public List<TimesheetDto> getAllTimesheets(Integer userId, String status) {
        List<TimesheetDto> timesheetDtos = new ArrayList<TimesheetDto>();
        PagedResult<Timesheet> pagedResult = timesheetService.getAllTimesheetsByStatus(userId, status);
        List<Timesheet> timesheets = pagedResult.getResults();
        for ( Timesheet timesheet : timesheets ) {
            TimesheetDto dto = new TimesheetDto();
            // set all required values
            timesheetDtos.add(dto);
        }
        
        return timesheetDtos;
        
    }
    public TimesheetDto getTimesheet (Integer timesheetId) {
        TimesheetDto dto = new TimesheetDto();
        Timesheet timesheet = timesheetService.getTimesheet(timesheetId);
        //copy timesheet into dto
        return dto;
    }
    public void updateTimesheet ( ) {
        Timesheet timesheet = new Timesheet();
        //copy input values into timesheet and merge into db
        // handle exceptions if successfull send success message else not successful
    }
    
    public void setTimesheetService(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    
    private TimesheetService timesheetService;
    
}
