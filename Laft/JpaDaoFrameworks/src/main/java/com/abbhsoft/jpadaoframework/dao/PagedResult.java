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


import java.util.List;

/**
 * 
 * Utility class to store service related pagination result data for front-end consumption.
 * @param <T> - The Class type contained within the List to be returned.
 */
public class PagedResult<T> {

    private long totalResults;
    private List<T> results;

    public PagedResult() {
        super();
    }

    public PagedResult(long totalResults, List<T> results) {
        this.totalResults = totalResults;
        this.results = results;
    }

    /**
     * 
     * @return total no of instances in the database for the executed query
     */
    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return list of instances contained within this object
     */
    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}

