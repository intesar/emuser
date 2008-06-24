/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.services.ajax;

import com.bia.accountmanager.services.PayeeService;

/**
 *
 * @author intesar
 */
public class PayeeAjaxService {

    public void setPayeeservice(PayeeService payeeservice) {
        this.payeeservice = payeeservice;
    }
    
    private PayeeService payeeservice;

}
