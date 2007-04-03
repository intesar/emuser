/*
 * GenericDAO.java
 *
 * Created on April 2, 2007, 8:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.dao;

import java.util.List;

/**
 *
 * @author shannan
 */
public interface GenericDAO {

    List find(String jpaQuery );

}
