/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.ajax;

import com.bia.ccm.entity.EmailPreference;
import com.bia.ccm.services.EMailService;
import com.bia.ccm.services.impl.EMailServiceImpl;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class ReportEngine {

    public void processReport() {
        logger.debug("inside processReport ***************** ");
        
        
    }

//    public void process() {
//        List<EmailPreference> emailPreferences = emailReportService.getAllEmailPreference();
//        if (emailPreferences != null && emailPreferences.size() > 0) {
//            System.out.println(" inside ");
//            ReportModel reportModel = reportServiceImpl.getTodays();
//            String[] toAddress = new String[emailPreferences.size()];
//            int count = 0;
//            String subject = null;
//            for (EmailPreference ep : emailPreferences) {
//                String email = null;
//                String emailOrPhone = ep.getEmailOrPhone();
//                String serviceProvider = ep.getServiceProvider();
//                email = EmailUtil.buildEmailAddress(emailOrPhone, serviceProvider);
//
//                if (email.contains(EMailService._160BY2)) {
//                    subject = EMailService.EMAIL_SUBJECT_TEXT_160BY2;
//                }
//                toAddress[count++] = email;
//            }
//
//            eMailService.sendEmail(toAddress, subject, reportModel.toString());
//        }
//    }
   
    private EMailService eMailService = new EMailServiceImpl();
    protected final Log logger = LogFactory.getLog(getClass());
}
