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
 * This class holds input parameters for service level calls. These params are for pagination
 * efforts needed on the front end.
 */
public class PagingParams {

    private long start;
    private int limit;
    private String sortBy;

    public PagingParams() {
        super();
    }

    /**
     * 
     * @param start database start element to return
     * @param limit total no of objects to return
     * @param sortBy entity field name
     */
    public PagingParams(long start, int limit, String sortBy) {
        super();
        this.start = start;
        this.limit = limit;
        this.sortBy = sortBy;
    }
    // etc ?

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
