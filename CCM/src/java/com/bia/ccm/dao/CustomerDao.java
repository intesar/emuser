/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.ccm.entity.Customer;

/**
 *
 * @author intesar
 */
public interface CustomerDao extends GenericDao<Customer, Integer> {

    public Customer findByKey(String key);
    

}
