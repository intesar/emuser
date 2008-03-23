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

import com.abbhsoft.jpadaoframework.dao.finderhelper.FinderNamingStrategy;
import java.lang.reflect.Method;

/**
 *
 * @author intesar
 */
public class ExtendedFinderNamingStrategy implements FinderNamingStrategy {

   // Always look for queries that start with findBy (even if method is iterateBy... or scrollBy...)
   public String queryNameFromMethod(Class findTargetType, Method finderMethod) {
      String methodName = finderMethod.getName();
      String methodPart = methodName;
      if (methodName.startsWith("find")) {
         // No-op
      } else if (methodName.startsWith("listBy")) {
         methodPart = "findBy" + methodName.substring("listBy".length());
      } else if (methodName.startsWith("iterateBy")) {
         methodPart = "findBy" + methodName.substring("iterateBy".length());
      } else if (methodName.startsWith("scrollBy")) {
         methodPart = "findBy" + methodName.substring("scrollBy".length());
      }
      return findTargetType.getSimpleName() + "." + methodPart;
   }

    public String countQueryNameFromMethod(Class findTargetType, Method finderMethod) {
        return queryNameFromMethod(findTargetType, finderMethod) + "Count";
    }


}
