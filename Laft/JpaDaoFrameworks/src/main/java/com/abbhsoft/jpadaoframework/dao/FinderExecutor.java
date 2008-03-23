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

package com.abbhsoft.jpadaoframework.dao;

/**
 *
 * @author intesar
 */
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;



/**
 * Execute a finder method with the appropriate arguments.
 * 
 * 
 */
public interface FinderExecutor<T> {
   List<T> executeFinder(Method method, Object[] queryArgs);
   
   PagedResult<T> executePagedResultFinder(Method method, Object[] queryArgs);
   
   T executeSingleResultFinder(Method method, Object[] queryArgs);

   Iterator<T> iterateFinder(Method method, Object[] queryArgs);

   //ScrollableResults scrollFinder(Method method, Object[] queryArgs);
}

