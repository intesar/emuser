/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service.ajax;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.entity.Timesheet;
import com.bia.payroll.entity.TimesheetDetail;
import com.bia.payroll.entity.Users;
import com.bia.payroll.model.TimesheetConverter;
import com.bia.payroll.model.TimesheetDto;
import com.bia.payroll.service.ServiceFactory;
import com.bia.payroll.service.TimesheetService;
import com.bia.payroll.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class TimesheetAjaxService {
    
    public void createTimesheet () {
        String username = AcegiUtil.getUsername();
//       Timesheet t =
               timesheetService.createTimesheet(username);
      
//        TimesheetDto timesheetDto = new TimesheetDto();
//        timesheetConverter.copy(t, timesheetDto);
//        return timesheetDto;
    }

    public String createTimesheet(TimesheetDto timesheetDto) {
        Timesheet t = new Timesheet();
        timesheetConverter.copy(timesheetDto, t);
        String username = AcegiUtil.getUsername();
        Users user = userService.getUser(username);
        t.setUser(user);
        t.setId(null);
        t.setLastAction("create");
        t.setLastUser(username);
        Date statusDate = new Date();
        t.setStatusDate(statusDate);
        if (t.getStatus().equalsIgnoreCase("submitted")) {
            Date submisionDate = new Date();
            t.setSubmisionDate(submisionDate);
        }
        try {
            timesheetService.createTimesheet(t);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return " Timesheet Created Successfully ! ";
    }

    public List<TimesheetDto> getTimesheetsByStatus(String status) {
        List<TimesheetDto> timesheetDtos = new ArrayList<TimesheetDto>();

        String username = AcegiUtil.getUsername();

        //String username = "x90";// AcegiUtil.getUsername();

        PagedResult<Timesheet> pagedResult = timesheetService.getAllTimesheetsByStatus(username, status);
        List<Timesheet> timesheets = pagedResult.getResults();
        for (Timesheet timesheet : timesheets) {
            TimesheetDto dto = new TimesheetDto();
            timesheetConverter.copy(timesheet, dto);
            // set all required values
            timesheetDtos.add(dto);
        }

        return timesheetDtos;

    }
    
    public List<TimesheetDto> getMyTimesheetsByStatus ( String status) {
         List<TimesheetDto> timesheetDtos = new ArrayList<TimesheetDto>();
        String username = AcegiUtil.getUsername();
        PagedResult<Timesheet> pagedResult = timesheetService.getAllMyTimesheetsByStatus(username, status);
        List<Timesheet> timesheets = pagedResult.getResults();
        for (Timesheet timesheet : timesheets) {
            TimesheetDto dto = new TimesheetDto();
            timesheetConverter.copy(timesheet, dto);
            // set all required values
            timesheetDtos.add(dto);
        }

        return timesheetDtos;
    }

    public TimesheetDto getTimesheet(Integer timesheetId) {
        TimesheetDto dto = new TimesheetDto();
        Timesheet timesheet = timesheetService.getTimesheet(timesheetId);
        //copy timesheet into dto
        timesheetConverter.copy(timesheet, dto);
        return dto;
    }

    public String updateTimesheet(TimesheetDto dto) {
        Timesheet timesheet = timesheetService.getTimesheet(dto.getId());
        
        
        TimesheetDetail td = timesheetService.getTimesheetDetail(dto.getId(), dto.getMondayDate());
        timesheet.getTimesheetDetailCollection().add(td);
        
         td = timesheetService.getTimesheetDetail(dto.getId(), dto.getTuesdayDate());
        timesheet.getTimesheetDetailCollection().add(td);
        
         td = timesheetService.getTimesheetDetail(dto.getId(), dto.getWednesdayDate());
        timesheet.getTimesheetDetailCollection().add(td);
        
         td = timesheetService.getTimesheetDetail(dto.getId(), dto.getThursdayDate());
        timesheet.getTimesheetDetailCollection().add(td);
        
         td = timesheetService.getTimesheetDetail(dto.getId(), dto.getFridayDate());
        timesheet.getTimesheetDetailCollection().add(td);
        
         td = timesheetService.getTimesheetDetail(dto.getId(), dto.getSaturdayDate());
        timesheet.getTimesheetDetailCollection().add(td);
        
         td = timesheetService.getTimesheetDetail(dto.getId(), dto.getSundayDate());
        timesheet.getTimesheetDetailCollection().add(td);
            
        timesheetConverter.copyToDetail(dto, timesheet);
        
        try {
        timesheetService.updateTimesheet(timesheet);
        } catch ( Exception e) {
            e.printStackTrace();
            return e.getMessage();            
        }
        return " Operational Successful! ";
    //copy input values into timesheet and merge into db
    // handle exceptions if successfull send success message else not successful
    }

    public void setTimesheetService(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }
    private UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");
    private TimesheetConverter timesheetConverter = new TimesheetConverter();
    private TimesheetService timesheetService = (TimesheetService) ServiceFactory.getService("timesheetServiceImpl");
    
   
    public static void main(String []args) {
       //String name = "x90";

        TimesheetAjaxService tas = new TimesheetAjaxService();
      //System.out.println ( tas.getTimesheetsByStatus("saved"));
        tas.userService.mailPassword("mdshannan@gmail.com");
        

                
    }
}
