/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.services;

import com.bia.counsellingapp.entity.CollegeDepartment;
import com.bia.counsellingapp.entity.CollegeDepartmentSeatsStatus;
import com.bia.counsellingapp.entity.UserAppliedDepartment;
import com.bia.counsellingapp.entity.Users;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface ApplicationService {
    void addUser(String name, String username, String password, String fathersName, Integer hallTicketNo, String rank);
    List<String> getCollegeNames(String username);
    List<String> getDepartmentNames (String collegeName);
    public void apply ( String userId, String college, String department, Integer priority, Date dt) ;
    List<UserAppliedDepartment> getAppliedDetails(String username);
    void deleteApplication(Integer id);
    void processAdmissions();
    void deleteAllReservationRules();
    void createReservationData();
    public List<Users> getUserApplicationStatus();
    public List<CollegeDepartment> getCollegeDepartments();
    public List<CollegeDepartmentSeatsStatus> getCollegeReservations();
    
    

}
