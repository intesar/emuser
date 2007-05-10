/*
 * CompanyService.java
 *
 * Created on May 9, 2007, 10:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import abbt.com.paginationframework.PageHandler;
import com.abbt.timesheet.entities.Company;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface CompanyService {
    
    PageHandler findRecent();
    PageHandler search ( String key);
    Company findByName(String name);
    
}
