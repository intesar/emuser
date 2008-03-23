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

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Base class for all persisitent domain objects.
 * 
 * @author Intesar Shannan Mohammed
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "create_user")
    protected Long createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    protected Date createDate;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    protected Date lastModifiedDate;
    @Column(name = "last_modified_user")
    protected Long lastModifiedUser;
    @Column(name = "last_viewed_date")
    @Temporal(TemporalType.DATE)
    protected Date lastViewedDate;
    @Column(name = "last_viewed_user")
    protected Long lastViewedUser;
    // ****************************** constructors ******************************

    protected BaseModel() {
    // for hibernate
    }

    // ****************************** methods ******************************

    public String getKey() {
        return Long.toString(id);
    }

    // ****************************** getter & setters ******************************

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(Long lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public Long getLastViewedUser() {
        return lastViewedUser;
    }

    public void setLastViewedUser(Long lastViewedUser) {
        this.lastViewedUser = lastViewedUser;
    }
    
}
