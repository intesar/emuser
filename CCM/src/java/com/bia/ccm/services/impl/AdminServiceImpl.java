/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.impl;

import com.bia.ccm.dao.EmailPreferenceDao;
import com.bia.ccm.dao.EmailTimePreferenceDao;
import com.bia.ccm.dao.OrganizationDao;
import com.bia.ccm.dao.SystemLeaseDao;
import com.bia.ccm.dao.SystemsDao;
import com.bia.ccm.dao.UsersDao;
import com.bia.ccm.entity.EmailPreference;
import com.bia.ccm.entity.EmailTimePreference;
import com.bia.ccm.entity.Organization;
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
            } else if (users != null && users.getId() != null) {
                this.usersDao.update(users);

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

    public String saveEmailPreference(EmailPreference emailPreference, String username) {
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

    public String saveEmailTimePreference(EmailTimePreference emailTimePreference, String username) {
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

    public String saveSystemLease(SystemLease systemLease, String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Organization getOrganization(String username) {
        Users u = this.getUserByUsername(username);
        return this.organizationDao.findByOrganization(u.getOrganization());
    }

    public String saveOrganization(Organization organization, String username) {
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

    public List<SystemLease> getSystemLease(String startDate, String endDate) {
        return this.systemLeaseDao.findByStartAndEndDates(endDate, endDate);
    }

    public Users getUserByUsername(String username) {
        return this.usersDao.findByUsername(username);
    }

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
    private UsersDao usersDao;
    private SystemsDao systemsDao;
    private EmailPreferenceDao emailPreferenceDao;
    private EmailTimePreferenceDao emailTimePreferenceDao;
    private SystemLeaseDao systemLeaseDao;
    private OrganizationDao organizationDao;
}
