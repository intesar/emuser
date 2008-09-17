/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.services.soa;

import com.bia.ccm.services.WorkService;
import com.bia.ccm.util.ServiceFactory;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author intesar
 */
@WebService()
public class ClientService {

    /**
     *  0 -error
     *  1 - do nothing
     *  2 - logoff
     *  3 - shutdown
     * Web service operation
     */
    @WebMethod(operationName = "getStatus")
    public Integer getStatus(@WebParam(name = "macAddress")
    String macAddress) {        
        return this.workService.getSystemStatus(macAddress);        
    }
    
    public static void main(String []args) {
        ClientService clientService = new ClientService();
        System.out.println ( clientService.getStatus("90erw") );
    }
    private WorkService workService = (WorkService) ServiceFactory.getService("workServiceImpl");

}
