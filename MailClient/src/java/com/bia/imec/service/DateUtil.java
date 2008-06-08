/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author intesar
 */
public class DateUtil {

    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);

    }
}
