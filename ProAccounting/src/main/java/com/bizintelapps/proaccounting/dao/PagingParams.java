/*
 *  Copyright 2008 intesar.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.bizintelapps.proaccounting.dao;

/**
 *
 * @author intesar
 */
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

