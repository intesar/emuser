/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.services.ajax;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *
 * @author intesar
 */
public class ReportEngine {
    
    public void processReport() {
        logger.debug("inside processReport ***************** ");
        System.out.println ( " Hello ********* ");
    }
    
    protected final Log logger = LogFactory.getLog(getClass());

}
