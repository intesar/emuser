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

package com.abbhsoft.jpadaoframework.dao.advisor;


import com.abbhsoft.jpadaoframework.dao.BaseModel;
import com.abbhsoft.jpadaoframework.dao.FinderExecutor;
import com.abbhsoft.jpadaoframework.dao.GenericDao;
import com.abbhsoft.jpadaoframework.dao.PagedResult;

import java.util.Date;
import java.util.List;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * Connects the Spring AOP with the Hibernate DAO.
 *
 * For any method beginning with "find" this interceptor will use the FinderExecutor to call a
 * Hibernate named query.
 *
 * 
 *  @author Intesar.Mohammed (Made it possible to work with Proxies)
 */
public class FinderIntroductionInterceptor implements IntroductionInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        FinderExecutor executor = null;
        String methodName = methodInvocation.getMethod().getName();
        if (methodName.startsWith("find")) {
            Object obj = null;
            try {
                obj = methodInvocation.proceed();
                if (methodInvocation.getThis() instanceof FinderExecutor) {
                    if (methodInvocation.getMethod().getReturnType() == List.class) {
                        return ((FinderExecutor) methodInvocation.getThis()).executeFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                    } else if (methodInvocation.getMethod().getReturnType() == PagedResult.class) {
                        return ((FinderExecutor) methodInvocation.getThis()).executePagedResultFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                    }
                    else {
                        return ((FinderExecutor) methodInvocation.getThis()).executeSingleResultFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                    }
                }
            } catch (Exception e) {
                if (methodInvocation.getThis() instanceof FinderExecutor) {
                    if (methodInvocation.getMethod().getReturnType() == List.class) {
                        return ((FinderExecutor) methodInvocation.getThis()).executeFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                    } else if (methodInvocation.getMethod().getReturnType() == PagedResult.class) {
                        return ((FinderExecutor) methodInvocation.getThis()).executePagedResultFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                    } else {
                        return ((FinderExecutor) methodInvocation.getThis()).executeSingleResultFinder(methodInvocation.getMethod(), methodInvocation.getArguments());
                    }
                }
            }
        } else if (methodName.startsWith("create") ||
                methodName.startsWith("update") ||
                methodName.startsWith("delete")) {
            Object obj = null;
            try {
                obj = methodInvocation.proceed();
                if (methodInvocation.getThis() instanceof GenericDao) {
                    Object[] args = methodInvocation.getArguments();
                    BaseModel model = (BaseModel) args[0];
                    Date dt = new Date();
                    model.setLastModifiedDate(dt);
                    model.setLastModifiedUser(23L);
                    if (methodName.startsWith("create")) {
                        model.setCreateDate(dt);
                        model.setCreateUser(22L);
                        model.setLastModifiedDate(dt);
                        model.setLastModifiedUser(22L);
                    }
                }
            } catch (Exception e) {
            //e.printStackTrace();
            }
        }


        if (methodName.startsWith("finds") || methodName.startsWith("list")) {
            Object[] arguments = methodInvocation.getArguments();
            return executor.executeFinder(methodInvocation.getMethod(), arguments);
        } else if (methodName.startsWith("iterate")) {
            Object[] arguments = methodInvocation.getArguments();
            return executor.iterateFinder(methodInvocation.getMethod(), arguments);
        } else {
            return methodInvocation.proceed();
        }
    }

    public boolean implementsInterface(Class intf) {
        return intf.isInterface() && FinderExecutor.class.isAssignableFrom(intf);
    }
}