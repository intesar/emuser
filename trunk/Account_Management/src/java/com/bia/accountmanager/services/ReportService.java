/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.services;

import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface ReportService {
    List accountSummary(double Account,Date start_date,Date end_date);
}
