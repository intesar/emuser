/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatroom.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inmohamm
 */
public class Main {

    public static void main(String[] args) {
        try {
            GroupLocalServiceUtil.addGroup(10438L, "com.liferay.portal.model.Group", 20000, "demo", "demo", 1, "/demo", true, null);
        } catch (PortalException ex) {
            ex.printStackTrace();
        } catch (SystemException ex) {
            ex.printStackTrace();
        }
    }
}
