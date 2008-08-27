/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services;

import com.bia.ccm.entity.EmailPreference;
import com.bia.ccm.entity.EmailTimePreference;
import com.bia.ccm.entity.Organization;
import com.bia.ccm.entity.Services;
import com.bia.ccm.entity.SystemLease;
import com.bia.ccm.entity.Systems;
import com.bia.ccm.entity.Users;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface AdminService {
    // Systems
    public void deleteEmail(int id);

    public void updateRentalPrice(int mims, double rate, String username);

    public List<Systems> getAllSystems(String username);

    public String saveSystem(Systems systems, String username);

    //Users
    public List<Users> getAllUsers(String username);

    public String saveUser(Users users, String username);

    public Users getUserByUsername(String username);
    //Email
    public List<EmailPreference> getAllEmailPreference(String username);

    public String saveEmailPreference(EmailPreference emailPreference, String username);
    //EmailTimePreference
    public List<EmailTimePreference> getAllEmailTimePreference(String username);

    public String saveEmailTimePreference(EmailTimePreference emailTimePreference, String username);
    //SystemLease
    public List<SystemLease> getAllSystemLease(String username);
    // lease history
    public List<SystemLease> getSystemLease(Date startDate, Date endDate, String org);

    public List getReport(Date startDate, Date endDate, String org);

    public Organization getOrganization(String username);

    public String saveOrganization(Organization organization, String username);

    public void saveService(Services service);

    public void deleteService(Integer id);

    public List<Services> getAllServices(String org);
}
