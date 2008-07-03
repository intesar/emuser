/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.counsellingapp.services.ajax;

import com.bia.counsellingapp.entity.CollegeDepartment;
import com.bia.counsellingapp.entity.CollegeDepartmentSeatsStatus;
import com.bia.counsellingapp.entity.UserAppliedDepartment;
import com.bia.counsellingapp.entity.Users;
import com.bia.counsellingapp.services.ApplicationService;
import com.bia.counsellingapp.services.ServiceFactory;
import com.bia.counsellingapp.util.AcegiUtil;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class ApplicationAjaxService {

    public List<String> getCollegeNames() {
        String username = AcegiUtil.getUsername();
        List<String> list = this.applicationService.getCollegeNames(username);
        return list;
    }

    public List<String> getDepartmentNames(String collegeName) {
        List<String> list = this.applicationService.getDepartmentNames(collegeName);
        return list;
    }

    public String apply(String college, String department, Integer priority) {
        String successMsg = "Applied Successfully !";
        String username = "shannan";//AcegiUtil.getUsername();
        try {
            this.applicationService.apply(username, college, department, priority, new Date());
        } catch (Exception e) {
            return e.getMessage();
        }
        return successMsg;
    }
    
    public String deleteApplication(Integer id) {
        this.applicationService.deleteApplication(id);
        return "Deleted Successfully!";
    }

    public List<UserAppliedDepartment> getAppliedDetails() {
        String username = "shannan";//AcegiUtil.getUsername();
        return this.applicationService.getAppliedDetails(username);
    }
    
    public void processAdmissions() {
        this.applicationService.processAdmissions();
    }
    public void deleteAllReservationRules(){
        this.applicationService.deleteAllReservationRules();
    }
    public  void createReservationData() {
        this.applicationService.createReservationData();
    }
     public List<Users> getUserApplicationStatus() {
        return this.applicationService.getUserApplicationStatus();
    }
    public List<CollegeDepartment> getCollegeDepartments() {
        return this.applicationService.getCollegeDepartments();
    }
    public List<CollegeDepartmentSeatsStatus> getCollegeReservations() {
        return this.applicationService.getCollegeReservations();
    }
    
    private ApplicationService applicationService = (ApplicationService) ServiceFactory.getService("applicationServiceImpl");

    public static void main(String[] args) {
        ApplicationAjaxService a = new ApplicationAjaxService();
        //System.out.println ( a.getCollegeNames() );
//        a.apply("mj", "eee1", 1);
//        System.out.println ( a.getAppliedDetails() );
        //a.deleteAllReservationRules();
        //a.createReservationData();
        a.processAdmissions();

    }
}
