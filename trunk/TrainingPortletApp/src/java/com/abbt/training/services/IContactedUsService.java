/*
 * IContactedUsService.java
 *
 * Created on April 15, 2007, 1:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.services;

import com.abbt.training.persistence.ContactedUs;

/**
 *
 * @author shannan
 */
public interface IContactedUsService {
    void save(ContactedUs contactUs) throws Exception ;
}
