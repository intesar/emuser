/*
 * Month.java
 *
 * Created on May 5, 2007, 8:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.util;

/**
 *
 * @author shannan
 */
public class Month {
    
    /** Creates a new instance of Month */
    public Month() {
    }
    
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(int sortNumber) {
        this.sortNumber = sortNumber;
    }
    
    private String name;
    private int sortNumber;
}
