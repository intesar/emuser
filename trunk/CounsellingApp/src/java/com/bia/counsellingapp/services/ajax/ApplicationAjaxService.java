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

    public String applyRegistration(String ids, Integer hallTicketNo) {
        String successMsg = "Applied Successfully !";
        try {
            String[] id = ids.split(",");
            Integer[] nos = new Integer[id.length];
            int k = 0;
            for (String s : id) {
                nos[k++] = Integer.parseInt(s.trim());
            }

            this.applicationService.apply(hallTicketNo, nos);
        } catch (NullPointerException npe) {
            npe.printStackTrace();            
            return "Plase check HallTicketNo and other inputs and or user may have already applied";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return successMsg;
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

    public void processAdmissions(int startRank, int endRank) {
        this.applicationService.processAdmissions(startRank, endRank);
    }

    public void deleteAllReservationRules() {
        this.applicationService.deleteAllReservationRules();
    }

    public void createReservationData() {
        this.applicationService.createReservationData();
    }

    public List<Users> getUserApplicationStatus(String hallTicketNos) {
        return this.applicationService.getUserApplicationStatus(hallTicketNos);
    }

    public List<CollegeDepartment> getCollegeDepartments(String college) {
        return this.applicationService.getCollegeDepartments(college);
    }

    public List<CollegeDepartmentSeatsStatus> getCollegeReservations(String collegeName) {
        return this.applicationService.getCollegeReservations(collegeName);
    }

    public String registerUser(String name, String username, String password, String fathersName, String hallTicketNo, String rank) {
        try {
            System.out.println(" inside register ****** ");
            this.applicationService.addUser(name, username, password, fathersName, Integer.parseInt(hallTicketNo), rank);
            return " Success, pleae login  with your username and password!";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    private ApplicationService applicationService = (ApplicationService) ServiceFactory.getService("applicationServiceImpl");

    public static void main(String[] args) {
        ApplicationAjaxService a = new ApplicationAjaxService();
        //System.out.println ( a.getCollegeNames() );
//        a.apply("mj", "eee1", 1);
//        System.out.println ( a.getAppliedDetails() );
//        a.deleteAllReservationRules();
//        a.createReservationData();
        // a.processAdmissions();
        System.out.println(a.applyRegistration("1,  4,2", 2999));

    }
}
