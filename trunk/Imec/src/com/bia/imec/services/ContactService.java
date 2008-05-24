/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.services;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.imec.entity.Contacts;

/**
 *
 * @author intesar
 */
public interface ContactService {

    public PagedResult<Contacts> getAll(PagingParams pagingParams);
}
