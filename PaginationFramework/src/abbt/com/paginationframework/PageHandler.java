/*
 * PageHandler.java
 *
 * Created on May 5, 2007, 10:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package abbt.com.paginationframework;

import java.util.List;

/**
 *
 * @author shannan
 * PageHandler
 * allows to paginate a query result
 * It can be effective used with Hibernate, JPA, JDBC or any other Framework 
 * Pagination is very effective it just pulls that data from any database which the user is looking at.
 * Hence user can see any subset of data without the entire data being pulled and created on the heap.
 * This is very effective and very fast way of pagination
 * This framework is very light and very easy to use
 * Has just few methods to understand like getList() and getPageNos()
 * hardly three four line of code will be used to add such a wonderful feature, into any existing or newly
 * created application
 */
public interface PageHandler {
    /**
     * @param pageNo
     * creates the list for the given page no
     */
    void createList( int pageNo );
    /**
     * @return current pageList
     */
    List getCurrentResultList() ;
    /**
     * @return current page nos
     */
    List getCurrentPageNoList();
    /**
     * @return page no selected
     */
    int getCurrentPageNo();
    
    void setCurrentPageNo(int pageNo);
    /**
     * @return total pages for the given query
     */
    int getTotalPages();
    /**
     * @param pageSize
     */
    void setPageSize( int pageSize );
    /**
     * @return
     */
    int getPageSize();
    
    
}
