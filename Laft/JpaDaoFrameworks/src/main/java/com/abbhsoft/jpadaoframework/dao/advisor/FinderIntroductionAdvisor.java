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

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 *
 * @author intesar
 */
public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor {
   private static final long serialVersionUID = -8219814032032259554L;

   public FinderIntroductionAdvisor() {
      super(new FinderIntroductionInterceptor());
   }
}
