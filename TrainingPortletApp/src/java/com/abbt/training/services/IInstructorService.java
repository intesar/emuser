/*
 * IInstructorService.java
 *
 * Created on April 15, 2007, 1:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.services;

import com.abbt.training.persistence.Instructor;

/**
 *
 * @author shannan
 */
public interface IInstructorService {
    Instructor findByEmail(String email) ;
}
