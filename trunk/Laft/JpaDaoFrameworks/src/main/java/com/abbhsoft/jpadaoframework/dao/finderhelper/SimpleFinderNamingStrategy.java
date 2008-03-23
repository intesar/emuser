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
public class SimpleFinderNamingStrategy implements FinderNamingStrategy {

    public String queryNameFromMethod(Class findTargetType, Method finderMethod) {
        return findTargetType.getSimpleName() + "." + finderMethod.getName();
    }

    public String countQueryNameFromMethod(Class findTargetType, Method finderMethod) {
        return findTargetType.getSimpleName() + "." + finderMethod.getName() + "Count";
    }
}
