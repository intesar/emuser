/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.payroll.entity.Timesheet;
import java.util.Date;


/**
 *
 * @author intesar
 */
public interface TimesheetDao extends GenericDao<Timesheet, Integer> {

    public PagedResult<Timesheet> findByStatus(String status, PagingParams... pagingParamses );
    public PagedResult<Timesheet> findByUserIdAndStatus(Integer userId, String status, PagingParams... pagingParamses );
    public Date findMaxStartDate(Integer userId);
    public Timesheet findByStartDateAndUserId ( Date dt, Integer userId );
    public Integer findMaxOfId ();
}
