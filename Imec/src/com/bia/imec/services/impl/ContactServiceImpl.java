/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.services.impl;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.imec.dao.ContactsDao;
import com.bia.imec.entity.Contacts;
import com.bia.imec.services.ContactService;

/**
 *
 * @author intesar
 */
public class ContactServiceImpl implements ContactService {

    public PagedResult<Contacts> getAll(PagingParams pagingParams) {
        return contactsDao.readAll(pagingParams);
    }

    public void setContactsDao(ContactsDao contactsDao) {
        this.contactsDao = contactsDao;
    }
    
    
    private ContactsDao contactsDao;
}
