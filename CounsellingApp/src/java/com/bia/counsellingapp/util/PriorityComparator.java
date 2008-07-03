/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.util;

import com.bia.counsellingapp.entity.UserAppliedDepartment;
import java.util.Comparator;

/**
 *
 * @author intesar
 */
public class PriorityComparator implements Comparator{

    public int compare(Object o1, Object o2) {
        if ( o1 instanceof UserAppliedDepartment && o2 instanceof UserAppliedDepartment ) {
            UserAppliedDepartment u1 = (UserAppliedDepartment) o1;
            UserAppliedDepartment u2 = (UserAppliedDepartment) o2;
            return u1.getPriority().compareTo(u2.getPriority());
        } else {
            return 0;
        }
    }

}
