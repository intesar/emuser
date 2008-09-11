/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services;

import com.bia.ccm.entity.Customer;
import com.bia.ccm.entity.Services;
import com.bia.ccm.entity.Suggestion;
import com.bia.ccm.entity.SystemLease;
import com.bia.ccm.entity.Systems;
import com.bia.ccm.entity.UsageDetail;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface WorkService {

    public List<Services> getAllServices(String org);

    public void chargePayment(int systemId, String agent);

    public void addService(String service, long units, String user, double payableAmount,
            String comments, double paidAmount, String agent);

    public List<SystemLease> getSystemLease(int id);

    public List<Systems> getActiveSystems(String username);

    public Systems getSystemByNameAndOrganization(int systemNo, String username);

    public void leaseSystem(int id, String leaseHolder);

    public void unleaseSystem(int id, double amountPaid);

    public UsageDetail getPayableAmount(int id);

    public Integer getSystemStatus(String macAddress);

    public void createCutomer(Customer customer);

    public Customer getCustomer(String key);

    public void createSuggestion(Suggestion suggestion);
    
    public void notifyCustomersAtContractEnd();
    
    public void notifyCustomersAtContractStart();
}
