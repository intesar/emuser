/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.payroll.entity.Oraganization;

/**
 *
 * @author intesar
 */
public interface OrganizationDao extends GenericDao<Oraganization, Integer> {

    Oraganization findByName(String name);
}
