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
