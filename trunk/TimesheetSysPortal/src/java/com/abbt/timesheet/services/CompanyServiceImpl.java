/*
 * CompanyServiceImpl.java
 *
 * Created on May 9, 2007, 10:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import abbt.com.paginationframework.PageHandler;
import abbt.com.paginationframework.PageHandlerDao;
import abbt.com.paginationframework.PageHandlerFactory;
import com.abbt.timesheet.daos.TimesheetDBDao;
import com.abbt.timesheet.entities.Company;

/**
 *
 * @author shannan
 */
public class CompanyServiceImpl implements CompanyService {
    
    /** Creates a new instance of CompanyServiceImpl */
    public CompanyServiceImpl() {
    }
    
    public PageHandler findRecent() {
        
        PageHandler pageHandler = PageHandlerFactory.getInstance(this.getPageHandlerDao(),
                "Company.findCountAllOrderByCreatedDate",
                "Company.findAllOrderByCreatedDate" );
        return pageHandler;
        
    }
    
    public PageHandler search(String key) {
        
        key = "%" + key + "%";
        key = key.toUpperCase();
        
        PageHandler pageHandler = PageHandlerFactory.getInstance(this.getPageHandlerDao(),
                "Company.searchCountByKey",
                "Company.searchByKey", key, key );
        
        return pageHandler;
    }
    
    public Company findByName(String name) {
        
        return (Company) this.getTimesheetDBDao().findByPrimaryKey(Company.class, name);
        
    }
    
    
    
    public PageHandlerDao getPageHandlerDao() {
        return pageHandlerDao;
    }
    
    public void setPageHandlerDao(PageHandlerDao pageHandlerDao) {
        this.pageHandlerDao = pageHandlerDao;
    }
    
    public TimesheetDBDao getTimesheetDBDao() {
        return timesheetDBDao;
    }
    
    public void setTimesheetDBDao(TimesheetDBDao timesheetDBDao) {
        this.timesheetDBDao = timesheetDBDao;
    }
    private PageHandlerDao pageHandlerDao;
    private TimesheetDBDao timesheetDBDao;
}
