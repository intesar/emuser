/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.ccm.entity.SystemLease;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface SystemLeaseDao extends GenericDao<SystemLease, Integer> {

    public List<SystemLease> findByOrganization(String organization);

    SystemLease findBySystemAndFinished(int id);

    public List<SystemLease> findByStartAndEndDates(String sd, String ed);
}
