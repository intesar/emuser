/*
 * Contact.java
 *
 * Created on April 4, 2007, 9:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import java.util.List;

/**
 *
 * @author Osman
 */
public interface Contact {
 
    List<Contact> findRecentContacts();
 
}
