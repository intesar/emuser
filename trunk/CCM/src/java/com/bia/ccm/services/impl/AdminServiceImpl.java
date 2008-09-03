/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.impl;

import com.bia.ccm.dao.AuthoritiesDao;
import com.bia.ccm.dao.EmailPreferenceDao;
import com.bia.ccm.dao.EmailTimePreferenceDao;
import com.bia.ccm.dao.OrganizationDao;
import com.bia.ccm.dao.ServicesDao;
import com.bia.ccm.dao.SystemLeaseDao;
import com.bia.ccm.dao.SystemsDao;
import com.bia.ccm.dao.UsersDao;
import com.bia.ccm.entity.Authorities;
import com.bia.ccm.entity.AuthoritiesPK;
import com.bia.ccm.entity.EmailPreference;
import com.bia.ccm.entity.EmailTimePreference;
import com.bia.ccm.entity.Organization;
import com.bia.ccm.entity.Services;
import com.bia.ccm.entity.SystemLease;
import com.bia.ccm.entity.Systems;
import com.bia.ccm.entity.Users;
import com.bia.ccm.services.AdminService;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class AdminServiceImpl implements AdminService {

    protected final Log logger = LogFactory.getLog(getClass());

    public void deleteEmail(int id) {
        EmailPreference email = this.emailPreferenceDao.read(id);
        this.emailPreferenceDao.delete(email);
    }

    public void updateRentalPrice(int mims, double rate, String username) {
        Users u = this.usersDao.findByUsername(username);
        String org = u.getOrganization();
        List<Systems> list = this.systemsDao.findByOrganization(org);
        for (Systems s : list) {
            s.setMinimumMinutes(mims);
            s.setMinuteRate(rate);
            this.systemsDao.update(s);
        }
    }

    public List<Systems> getAllSystems(String username) {
        Users u = this.getUserByUsername(username);
        return this.systemsDao.findByOrganization(u.getOrganization());
    }

    public String saveSystem(Systems systems, String username) {
        Users u = this.getUserByUsername(username);
        try {
            if (systems != null && systems.getId() == null) {
                systems.setOrganization(u.getOrganization());
                systems.setCreateDate(new Date());
                systems.setCreateUser(username);
                systems.setIsAvailable(true);
                systems.setIsShutdown(false);
                this.systemsDao.create(systems);
            } else if (systems != null && systems.getId() != null) {
                this.systemsDao.update(systems);

            } else {
                return "Please check inputs";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Operation succesful!";
    }

    public List<Users> getAllUsers(String username) {
        Users u = this.getUserByUsername(username);
        return this.usersDao.findByOrganization(u.getOrganization());
    }

    public String saveUser(Users users, String username) {
        Users u = this.getUserByUsername(username);
        try {
            if (users != null && users.getId() == null) {
                users.setOrganization(u.getOrganization());
                users.setCreateDate(new Date());
                users.setCreateUser(username);
                this.usersDao.create(users);
                if (users.getRole().equalsIgnoreCase("admin")) {
                    Authorities a1 = new Authorities(users.getUsername(), "ROLE_ADMIN");
                    this.authoritiesDao.create(a1);
                }
                Authorities a2 = new Authorities(users.getUsername(), "ROLE_USER");
                this.authoritiesDao.create(a2);
            } else if (users != null && users.getId() != null) {
                this.usersDao.update(users);
                if (users.getRole().equalsIgnoreCase("employee")) {
                    Authorities a1 = this.authoritiesDao.read(new AuthoritiesPK(users.getUsername(), "ROLE_ADMIN"));
                    if (a1 != null) {
                        this.authoritiesDao.delete(a1);
                    }
                } else if (users.getRole().equalsIgnoreCase("admin")) {
                    AuthoritiesPK authPK = new AuthoritiesPK(users.getUsername(), "ROLE_ADMIN");
                    Authorities a2 = this.authoritiesDao.read(authPK);
                    if (a2 == null) {
                        a2 = new Authorities(authPK);
                        this.authoritiesDao.create(a2);
                    }
                }
            } else {
                return "Please check inputs";
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Operation succesful!";
    }

    public List<EmailPreference> getAllEmailPreference(String username) {
        Users u = this.getUserByUsername(username);
        return this.emailPreferenceDao.findByOrganization(u.getOrganization());
    }

    public String saveEmailPreference(
            EmailPreference emailPreference, String username) {
        Users u = this.getUserByUsername(username);
        try {
            if (emailPreference != null && emailPreference.getId() == null) {
                emailPreference.setOrganization(u.getOrganization());

                this.emailPreferenceDao.create(emailPreference);
            } else if (emailPreference != null && emailPreference.getId() != null) {
                this.emailPreferenceDao.update(emailPreference);

            } else {
                return "Please check inputs";
            }

        } catch (Exception e) {
            return e.getMessage();
        }

        return "Operation succesful!";
    }

    public List<EmailTimePreference> getAllEmailTimePreference(String username) {
        Users u = this.getUserByUsername(username);
        return this.emailTimePreferenceDao.findByOrganization(u.getOrganization());
    }

    public String saveEmailTimePreference(
            EmailTimePreference emailTimePreference, String username) {
        Users u = this.getUserByUsername(username);
        try {
            if (emailTimePreference != null && emailTimePreference.getId() == null) {
                emailTimePreference.setOrganization(u.getOrganization());

                this.emailTimePreferenceDao.create(emailTimePreference);
            } else if (emailTimePreference != null && emailTimePreference.getId() != null) {
                this.emailTimePreferenceDao.update(emailTimePreference);

            } else {
                return "Please check inputs";
            }

        } catch (Exception e) {
            return e.getMessage();
        }

        return "Operation succesful!";
    }

    public List<SystemLease> getAllSystemLease(String username) {
        Users u = this.getUserByUsername(username);
        return this.systemLeaseDao.findByOrganization(u.getOrganization());
    }

    public String saveSystemLease(
            SystemLease systemLease, String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Organization getOrganization(
            String username) {
        Users u = this.getUserByUsername(username);
        return this.organizationDao.findByOrganization(u.getOrganization());
    }

    public String saveOrganization(
            Organization organization, String username) {
        Users u = this.getUserByUsername(username);
        try {
            if (organization != null) {
                this.organizationDao.update(organization);
            } else {
                return "Please check inputs";
            }

        } catch (Exception e) {
            return e.getMessage();
        }

        return "Operation succesful!";
    }

    public List<SystemLease> getSystemLease(Date startDate, Date endDate, String org) {
        endDate.setHours(23);
        endDate.setMinutes(59);
        return this.systemLeaseDao.findByStartAndEndDates(startDate, endDate, org);
    }

    public List getReport(
            Date startDate, Date endDate, String org) {
        endDate.setHours(23);
        endDate.setMinutes(59);
        return this.systemLeaseDao.findReportBetweenDates(startDate, endDate, org);
    }

    public Users getUserByUsername(
            String username) {
        return this.usersDao.findByUsername(username);
    }

    public void saveService(Services service) {
        if (service.getId() == null) {
            this.servicesDao.create(service);
        } else {
            this.servicesDao.update(service);
        }
    }

    public void deleteService(Integer id) {
        Services services = this.servicesDao.read(id);
        this.servicesDao.delete(services);
    }

    public List<Services> getAllServices(String org) {
        return this.servicesDao.findByOrganization(org);
    }
    // getters & setters
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setSystemsDao(SystemsDao systemsDao) {
        this.systemsDao = systemsDao;
    }

    public void setEmailPreferenceDao(EmailPreferenceDao emailPreferenceDao) {
        this.emailPreferenceDao = emailPreferenceDao;
    }

    public void setEmailTimePreferenceDao(EmailTimePreferenceDao emailTimePreferenceDao) {
        this.emailTimePreferenceDao = emailTimePreferenceDao;
    }

    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    public void setSystemLeaseDao(SystemLeaseDao systemLeaseDao) {
        this.systemLeaseDao = systemLeaseDao;
    }

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }

    public void setServicesDao(ServicesDao servicesDao) {
        this.servicesDao = servicesDao;
    }
    private UsersDao usersDao;
    private SystemsDao systemsDao;
    private EmailPreferenceDao emailPreferenceDao;
    private EmailTimePreferenceDao emailTimePreferenceDao;
    private SystemLeaseDao systemLeaseDao;
    private OrganizationDao organizationDao;
    private AuthoritiesDao authoritiesDao;
    private ServicesDao servicesDao;
}
