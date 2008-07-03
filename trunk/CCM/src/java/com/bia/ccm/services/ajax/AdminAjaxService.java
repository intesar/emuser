/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.ajax;

import com.bia.ccm.services.AdminService;
import com.bia.ccm.util.ServiceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class AdminAjaxService {

    protected final Log logger = LogFactory.getLog(getClass());
    private AdminService adminService = (AdminService) ServiceFactory.getService("adminServiceImpl");
}
