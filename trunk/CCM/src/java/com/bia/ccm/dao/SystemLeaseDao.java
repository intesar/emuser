/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.ccm.entity.SystemLease;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface SystemLeaseDao extends GenericDao<SystemLease, Integer> {

    public List<SystemLease> findByOrganization(String organization);

    public List<SystemLease> findBySystemAndFinished(int id);
    public List<SystemLease> findBySystemIdAndFinished(int id);

    public List<SystemLease> findByStartAndEndDates(Date sd, Date ed, String org);
    
    public List findReportBetweenDates(Date sd, Date ed, String org);
}
