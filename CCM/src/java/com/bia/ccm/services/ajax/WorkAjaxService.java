/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.ajax;

import com.bia.ccm.entity.Systems;
import com.bia.ccm.services.WorkService;
import com.bia.ccm.util.AcegiUtil;
import com.bia.ccm.util.ServiceFactory;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class WorkAjaxService {

    public List<Systems> getActiveSystems() {
        String username = AcegiUtil.getUsername();
        return workService.getActiveSystems(username);
    }

    public Systems getSystemByNameAndOrganization(int systemNo) {
        String username = AcegiUtil.getUsername();
        return this.workService.getSystemByNameAndOrganization(systemNo, username);
    }

    public String leaseSystem(int systemId) {
        try {
            return this.workService.leaseSystem(systemId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.equals(e);
            return e.getMessage();
        }

    }

    public double getPayableAmount(int id) {
        return this.workService.getPayableAmount(id);
    }

    public String unleaseSystem(int systemId, double paidAmount) {
        try {
            return this.workService.unleaseSystem(systemId, paidAmount);
        } catch (Exception e) {
            e.printStackTrace();
            logger.equals(e);
            return e.getMessage();
        }
    }
    protected final Log logger = LogFactory.getLog(getClass());
    private WorkService workService = (WorkService) ServiceFactory.getService("workServiceImpl");
}
