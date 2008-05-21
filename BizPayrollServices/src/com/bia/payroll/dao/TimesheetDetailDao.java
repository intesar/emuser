/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.dao;

import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.bia.payroll.entity.TimesheetDetail;
import java.util.Date;

/**
 *
 * @author intesar
 */
public interface TimesheetDetailDao extends GenericDao<TimesheetDetail, Integer> {
    public TimesheetDetail findByTimesheetIdAndDate ( Integer id, Date dt);

}
