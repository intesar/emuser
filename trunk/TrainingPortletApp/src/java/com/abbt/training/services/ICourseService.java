/*
 * ICourseService.java
 *
 * Created on April 15, 2007, 1:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.services;

import com.abbt.training.persistence.CourseDetail;
import com.abbt.training.persistence.CourseOffered;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface ICourseService {
    List<CourseOffered> getAllCourses() ;
    List<CourseDetail> findByCourseName(String name ) ;
}
