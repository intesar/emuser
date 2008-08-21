/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.impl;

import com.bia.ccm.dao.CustomerDao;
import com.bia.ccm.dao.SystemLeaseDao;
import com.bia.ccm.dao.SystemsDao;
import com.bia.ccm.dao.UsersDao;
import com.bia.ccm.entity.Customer;
import com.bia.ccm.entity.SystemLease;
import com.bia.ccm.entity.Systems;
import com.bia.ccm.entity.Users;
import com.bia.ccm.services.WorkService;
import com.bia.ccm.util.AcegiUtil;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class WorkServiceImpl implements WorkService {

    public List<Systems> getActiveSystems(String username) {
        Users u = this.usersDao.findByUsername(username);
        return this.systemsDao.findByOrganization(u.getOrganization());
    }

    public Systems getSystemByNameAndOrganization(int systemNo, String username) {
        Users u = this.usersDao.findByUsername(username);
        return this.systemsDao.findBySystemNameAndOrganization(systemNo, u.getOrganization());
    }

    public String leaseSystem(int id, String leaseHolder) {
        Systems system = this.systemsDao.read(id);
        system.setIsAvailable(false);
        this.systemsDao.update(system);
        SystemLease systemLease = new SystemLease(null, new Date(), AcegiUtil.getUsername(), id, false);
        systemLease.setLeaseHolderName(leaseHolder);
        this.systemLeaseDao.create(systemLease);
        return "Assigned Successfully!";
    }

    public double getPayableAmount(int id) {
        SystemLease systemLease = this.systemLeaseDao.findBySystemAndFinished(id);
        Systems system = this.systemsDao.read(id);
        Double rate = system.getMinuteRate();
        Date endTime = new Date();
        Long totalMinutes = (endTime.getTime() - systemLease.getStartTime().getTime()) / (1000 * 60);

        Double payableAmount = null;
        if (rate > 1.0) {
            NumberFormat nf1 = new DecimalFormat("0.00");
            String rateString = nf1.format(rate);
            int a = rateString.indexOf(".");
            Double rt = Double.parseDouble(rateString.substring(a + 1, a + 2));
            Double minimumMins = Double.parseDouble(rateString.substring(0, a));
            payableAmount = Math.ceil(totalMinutes / minimumMins) * rt;
        } else {
            payableAmount = totalMinutes * rate;
        }
        return payableAmount;
    }

    public String unleaseSystem(int id, double amountPaid) {
        Systems system = this.systemsDao.read(id);
        system.setIsAvailable(true);
        this.systemsDao.update(system);
        SystemLease systemLease = this.systemLeaseDao.findBySystemAndFinished(id);
        systemLease.setEndTime(new Date());
        systemLease.setIsFinished(true);
        systemLease.setAmountPaid(amountPaid);
        Double rate = system.getMinuteRate();
        Date endTime = new Date();
        Long totalMinutes = (endTime.getTime() - systemLease.getStartTime().getTime()) / (1000 * 60);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM HH:mm:ss");
        NumberFormat nf = new DecimalFormat("0.0");
        Double payableAmount = null;
        if (rate > 1.0) {
            NumberFormat nf1 = new DecimalFormat("0.00");
            String rateString = nf1.format(rate);
            int a = rateString.indexOf(".");
            Double rt = Double.parseDouble(rateString.substring(a + 1, a + 2));
            Double minimumMins = Double.parseDouble(rateString.substring(0, a));
            payableAmount = Math.ceil(totalMinutes / minimumMins) * rt;
        } else {
            payableAmount = totalMinutes * rate;
        }
        systemLease.setPayableAmount(payableAmount);
        systemLease.setReturnAgent(AcegiUtil.getUsername());
        systemLease.setTotalMinutesUsed(totalMinutes);
        this.systemLeaseDao.create(systemLease);
        return "Assigned Successfully!";
    }

    /**
     *  0 -error
     *  1 - do nothing
     *  2 - logoff
     *  3 - shutdown
     * @param macAddress
     * @return
     */
    public Integer getSystemStatus(String macAddress) {
        Integer status = new Integer(0);
        try {
            Systems system = this.systemsDao.findByMacAddress(macAddress);
            if (system.getIsShutdown()) {
                status = 3;
            } else if (system.getIsAvailable()) {
                status = 2;
            } else if (!system.getIsAvailable()) {
                status = 1;
            }

        } catch (NullPointerException npe) {
            logger.equals(npe);
        } catch (RuntimeException re) {
            logger.equals(re);
        } catch (Exception e) {
            logger.equals(e);
        }
        return status;
    }

    public void createCutomer(Customer customer) {
        if (customer.getId() == null) {
            this.customerDao.create(customer);
        } else {
            this.customerDao.update(customer);
        }
    }

    public Customer getCustomer(String key) {
        return this.customerDao.findByKey(key);
    }
    
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setSystemsDao(SystemsDao systemsDao) {
        this.systemsDao = systemsDao;
    }

    public void setSystemLeaseDao(SystemLeaseDao systemLeaseDao) {
        this.systemLeaseDao = systemLeaseDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    protected final Log logger = LogFactory.getLog(getClass());
    private CustomerDao customerDao;
    private SystemsDao systemsDao;
    private UsersDao usersDao;
    private SystemLeaseDao systemLeaseDao;
}
