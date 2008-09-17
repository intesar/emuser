/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.impl;

import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.ccm.dao.ServicesDao;

import com.bia.ccm.dao.SystemLeaseDao;
import com.bia.ccm.dao.SystemsDao;
import com.bia.ccm.dao.UsersDao;
import com.bia.ccm.entity.Services;

import com.bia.ccm.entity.SystemLease;
import com.bia.ccm.entity.Systems;
import com.bia.ccm.entity.UsageDetail;
import com.bia.ccm.entity.Users;
import com.bia.ccm.services.EMailService;
import com.bia.ccm.services.WorkService;
import com.bia.ccm.util.AcegiUtil;
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

    public void leaseSystem(int id, String leaseHolder) {
        Systems system = this.systemsDao.read(id);
        system.setIsAvailable(false);
        system.setCurrentUserEmail(leaseHolder);
        system.setStartTime(new Date());
        this.systemsDao.update(system);
        SystemLease systemLease = new SystemLease(null, new Date(), AcegiUtil.getUsername(), system.getId(), false);
        systemLease.setService("Computer " + system.getName());
        systemLease.setLeaseHolderName(leaseHolder);
        systemLease.setSystemNo(system.getName());
        this.systemLeaseDao.create(systemLease);
    //return "Assigned Successfully!";
    }

    /**
     * 
     * @param id
     * @return
     *   total minues
     *   Start Time
     *   End Time
     *   Lease Holder Name
     *   Payable Amount
     *   System Name
     */
    public List<SystemLease> getSystemLease(int id) {
        List<SystemLease> list = this.systemLeaseDao.findBySystemIdAndFinished(id);
        for (SystemLease s : list) {
            if (s.getTotalMinutesUsed() == null || s.getService().startsWith("Computer")) {
                update(s);
            }
        }
        return list;
    }

    public void chargePayment(int systemId, String agent) {
        List<SystemLease> list = getSystemLease(systemId);
        for (SystemLease sl : list) {
            if (sl.getPayableAmount() != null) {
                sl.setAmountPaid(sl.getPayableAmount());
            }
            sl.setEndTime(new Date());
            sl.setReturnAgent(agent);
            sl.setIsFinished(true);
            Date endTime = new Date();
            if (sl.getService().startsWith("Computer")) {
                Long totalMinutes = (endTime.getTime() - sl.getStartTime().getTime()) / (1000 * 60);
                sl.setTotalMinutesUsed(totalMinutes);
            }
            this.systemLeaseDao.update(sl);
        }
        Systems system = this.systemsDao.read(systemId);
        system.setIsAvailable(true);
        system.setCurrentUserEmail("");
        system.setStartTime(null);
        this.systemsDao.update(system);
    }

    private void update(SystemLease systemLease) {
        Systems system = this.systemsDao.read(systemLease.getSystem());
        Double rate = system.getMinuteRate();
        Date endTime = new Date();
        Long totalMinutes = (endTime.getTime() - systemLease.getStartTime().getTime()) / (1000 * 60);
        Double payableAmount = null;
        logger.debug("rate ******** : " + rate);
//        if (rate >= 1.0) {
        if (system.getLowerMinuteRate() != null && system.getLowerMinuteRate() > 0.0 &&
                system.getLowerMinimumMinutes() != null && system.getLowerMinimumMinutes() > 0) {
            // apply pattern for dual rate
            Double amt = 0.0;
            long quotient = totalMinutes / system.getMinimumMinutes();
            long reminder = totalMinutes % system.getMinimumMinutes();
            if (reminder <= system.getLowerMinimumMinutes()) {
                amt = system.getLowerMinuteRate();
            } else {
                amt = system.getMinuteRate();
            }

            payableAmount = amt + quotient * system.getMinuteRate();

        } else {
            Integer minimumMins = system.getMinimumMinutes();//Double.parseDouble(rateString.substring(0, a));
            logger.debug("minimumMins ******** : " + minimumMins);
            payableAmount = Math.ceil((double) totalMinutes / minimumMins) * rate;
            logger.debug("Math.ceil((double)totalMinutes / minimumMins) ******** : " + Math.ceil(totalMinutes / minimumMins));
            logger.debug("payableAmount ******** : " + payableAmount);
        }
//        } else {
//            payableAmount = totalMinutes * rate;
//        }
        systemLease.setTotalMinutesUsed(totalMinutes);
        systemLease.setPayableAmount(payableAmount);

    }

    public void addService(String service, long units, String user, double payableAmount,
            String comments, double paidAmount, String agent) {
        int u = 0;
        try {
            u = Integer.parseInt(user.trim());
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        if (u == 0) {
            Users user1 = usersDao.findByUsername(agent);
            Systems s = systemsDao.findBySystemNameAndOrganization(1, user1.getOrganization());
            SystemLease sl = new SystemLease(null, new Date(), agent, s.getId(), true);
            sl.setAmountPaid(paidAmount);
            sl.setEndTime(new Date());
            sl.setLeaseHolderName(user);
            sl.setPayableAmount(payableAmount);
            sl.setReturnAgent(agent);
            sl.setService(service);
            sl.setTotalMinutesUsed(units);
            this.systemLeaseDao.create(sl);
        } else {
            Users user1 = usersDao.findByUsername(agent);
            Systems s = systemsDao.findBySystemNameAndOrganization(u, user1.getOrganization());
            SystemLease sl = new SystemLease(null, new Date(), agent, s.getId(), false);
            //sl.setAmountPaid(paidAmount);
            sl.setEndTime(new Date());
            sl.setLeaseHolderName(s.getCurrentUserEmail());
            sl.setPayableAmount(payableAmount);
            //sl.setReturnAgent(agent);
            sl.setService(service);
            sl.setTotalMinutesUsed(units);
            this.systemLeaseDao.create(sl);
        }

    }

    public UsageDetail getPayableAmount(int id) {
        SystemLease systemLease = null;//this.systemLeaseDao.findBySystemAndFinished(id);
        System.out.println(systemLease);
        Systems system = this.systemsDao.read(id);
        Double rate = system.getMinuteRate();
        Date endTime = new Date();
        Long totalMinutes = (endTime.getTime() - systemLease.getStartTime().getTime()) / (1000 * 60);

        Double payableAmount = null;
        logger.debug("rate ******** : " + rate);
        if (rate >= 1.0) {

//            NumberFormat nf1 = new DecimalFormat("0.00");
//            String rateString = nf1.format(rate);
//            int a = rateString.indexOf(".");
            //Double rt = system.getMinuteRate();//Double.parseDouble(rateString.substring(a + 1, a + 2));
            Integer minimumMins = system.getMinimumMinutes();//Double.parseDouble(rateString.substring(0, a));
            logger.debug("minimumMins ******** : " + minimumMins);
            payableAmount = Math.ceil((double) totalMinutes / minimumMins) * rate;
            logger.debug("Math.ceil((double)totalMinutes / minimumMins) ******** : " + Math.ceil(totalMinutes / minimumMins));
            logger.debug("payableAmount ******** : " + payableAmount);
        } else {
            payableAmount = totalMinutes * rate;
        }
        String pattern = "hh:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);


        String str = " User : " + systemLease.getLeaseHolderName() + " \n" +
                " System : " + system.getName() + " \n" +
                " Start Time : " + sdf.format(systemLease.getStartTime()) + " \n" +
                " End Time : " + sdf.format(endTime) + " \n" +
                " Total Minutes : " + totalMinutes + " \n" +
                " Payable Amount : " + payableAmount;
        UsageDetail ud = new UsageDetail(str, payableAmount);
        return ud;
    }

    public void unleaseSystem(int id, double amountPaid) {
        Systems system = this.systemsDao.read(id);
        system.setIsAvailable(true);
        this.systemsDao.update(system);
        SystemLease systemLease = null;//this.systemLeaseDao.findBySystemAndFinished(id);
        systemLease.setEndTime(new Date());
        systemLease.setIsFinished(true);
        systemLease.setAmountPaid(amountPaid);
        Double rate = system.getMinuteRate();
        Date endTime = new Date();
        Long totalMinutes = (endTime.getTime() - systemLease.getStartTime().getTime()) / (1000 * 60);
//        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM HH:mm:ss");
//        NumberFormat nf = new DecimalFormat("0.0");
        Double payableAmount = null;
        if (rate >= 1.0) {
//            NumberFormat nf1 = new DecimalFormat("0.00");
//            String rateString = nf1.format(rate);
//            int a = rateString.indexOf(".");
            Double rt = system.getMinuteRate();//Double.parseDouble(rateString.substring(a + 1, a + 2));
            Integer minimumMins = system.getMinimumMinutes();//Double.parseDouble(rateString.substring(0, a));
            payableAmount = Math.ceil((double) totalMinutes / minimumMins) * rt;
        } else {
            payableAmount = totalMinutes * rate;
        }
        systemLease.setPayableAmount(payableAmount);
        systemLease.setReturnAgent(AcegiUtil.getUsername());
        systemLease.setTotalMinutesUsed(totalMinutes);
        this.systemLeaseDao.create(systemLease);
    //return "Assigned Successfully!";
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
            if (system == null || system.getOrganization() == null || system.getOrganization().length() <= 0) {
                return 0;
            }
            String org = system.getOrganization();
            Long count = this.systemsDao.findNoOfActiveSystemsByOrganization(org);
            if (count >= 1) {
                return 3;
            }

            if (system.getIsShutdown()) {
                status = 3;
            } else if (system.getIsAvailable()) {
                status = 2;
            } else if (!system.getIsAvailable()) {
                status = 1;
            }

        } catch (NullPointerException npe) {
            logger.equals(npe);
            npe.printStackTrace();
        } catch (RuntimeException re) {
            logger.equals(re);
            re.printStackTrace();
        } catch (Exception e) {
            logger.equals(e);
            e.printStackTrace();
        }
        return status;
    }

    public void createCutomer(Users customer, Users createUser) {

        if (customer.getId() == null) {
            if (customer.getPic() == null) {
                customer.setComments(customer.getComments().trim() + " No Picture Available");
            }
            customer.setUsername(customer.getEmail());
            customer.setPassword(new Date().getTime() + "");
            customer.setEnabled(true);
            customer.setCreateDate(new Date());
            if (createUser != null) {
                customer.setOrganization(createUser.getOrganization());
                customer.setCreateUser(createUser.getUsername());
            }
            logger.debug("__________________________________ " + "inside save customer");
            this.usersDao.create(customer);
        } else {
            // get img then update
            if (customer.getPic() == null) {
                Users c = this.usersDao.read(customer.getId());
                customer.setPic(c.getPic());
            }
            if (customer.getPic() == null) {
                customer.setComments(customer.getComments() + " No Picture Available");
            }

            this.usersDao.update(customer);
        }
    }

    public List<Services> getAllServices(String username) {
        Users u = this.usersDao.findByUsername(username);
        return this.servicesDao.findByOrganization(u.getOrganization());
    }

    public void notifyCustomersAtContractStart() {
        long start = 0;
        int limit = 100;
        for (; true; start += limit) {
            List<SystemLease> list = this.systemLeaseDao.findByIsStartContractNotified(true, new PagingParams(start, limit, null));
            logger.debug("********* list ");
            if (list == null || list.size() <= 0) {
                break;
            }
            logger.debug("********* before iteration");
            for (SystemLease sl : list) {
                try {
                    logger.debug("********* before method1 " + sl.getService());
                    this.eMailService.sendEmail(sl.getLeaseHolderName(), sl.toString());
                    sl.setIsStartContractNotified(true);
                    this.systemLeaseDao.update(sl);
                } catch (RuntimeException re) {
                    re.printStackTrace();
                    logger.debug(re);
                }
            }
        }

    }

    public void notifyCustomersAtContractEnd() {
        long start = 0;
        int limit = 100;
        for (; true; start += limit) {
            List<SystemLease> list = this.systemLeaseDao.findByIsEndContractNotified(true, new PagingParams(start, limit, null));
            logger.debug("********* list ");
            if (list == null || list.size() <= 0) {
                break;
            }
            logger.debug("********* before iteration");
            for (SystemLease sl : list) {
                try {
                    logger.debug("********* before method1 " + sl.getService());
                    this.eMailService.sendEmail(sl.getLeaseHolderName(), sl.toString());
                    sl.setIsEndContractNotified(true);
                    this.systemLeaseDao.update(sl);
                } catch (RuntimeException re) {
                    re.printStackTrace();
                    logger.debug(re);
                }
            }
        }
    }

    public Users getCustomer(String key) {
        return this.usersDao.findByKey(key);
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

//    public void setCustomerDao(CustomerDao customerDao) {
//        this.customerDao = customerDao;
//    }
   

    public void setServicesDao(ServicesDao servicesDao) {
        this.servicesDao = servicesDao;
    }
    protected final Log logger = LogFactory.getLog(getClass());
    //private CustomerDao customerDao;
    private SystemsDao systemsDao;
    private UsersDao usersDao;
    private SystemLeaseDao systemLeaseDao;
    
    private ServicesDao servicesDao;
    private EMailService eMailService = new EMailServiceImpl();
}
