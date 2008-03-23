/*
 * 
 *
 * Author: Intesar Shannan Mohammed
 *
 * Copyright 2008 Abbhsoft. All Rights Reserved.
 *
 * This software is the proprietary information of Abbhsoft.
 * Use is subject to license terms.
 *
 */

package com.abbhsoft.jpadaoframework.dao.finderhelper;

import java.lang.reflect.Method;

/**
 *
 * @author intesar
 */
public interface FinderNamingStrategy {
 public String queryNameFromMethod(Class findTargetType, Method finderMethod);
   
   public String countQueryNameFromMethod(Class findTargetType, Method finderMethod);

}