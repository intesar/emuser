/*
 * PageHandlerImpl.java
 *
 * Created on May 5, 2007, 10:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package abbt.com.paginationframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author shannan
 */
public class PageHandlerImpl implements PageHandler {
    
    /** Creates a new instance of PageHandlerImpl */
    
    /**
     * @param dao
     * @param countQuery
     * @param query
     */
    PageHandlerImpl(PageHandlerDao dao, String countQuery, String query, Object... parameters) {
        this.dao = dao;
        this.querySQL = query;
        this.countSQL = countQuery;
        this.parameters = parameters;        
    }
    
        /* (non-Javadoc)
         * @see com.fruit.framework.valueListHandler.ValueListHandler#createList(int)
         */
    public void createList(int pageNo) {
        this.getList(pageNo);
    }
    
    
        /* (non-Javadoc)
         * @see com.fruit.framework.valueListHandler.ValueListHandler#getCurrentPageNo()
         */
    public int getCurrentPageNo() {
        return this.currentPage;
    }
    
    
        /* (non-Javadoc)
         * @see com.fruit.framework.valueListHandler.ValueListHandler#getCurrentPageNoList()
         */
    public List getCurrentPageNoList() {
        return pageNoList;
    }
    
    
        /* (non-Javadoc)
         * @see com.fruit.framework.valueListHandler.ValueListHandler#getCurrentResultList()
         */
    public List getCurrentResultList() {
        return this.list;
    }
    
    
        /* (non-Javadoc)
         * @see com.fruit.framework.valueListHandler.ValueListHandler#getTotalPages()
         */
    public int getTotalPages() {
        return this.totalPages;
    }
    
        /*
         * no. of objects in a page
         *
         * @see com.fruit.framework.listhandler.ValueListHandler#getPageSize()
         */
    public int getPageSize() {
        return this.pageSize;
    }
    
        /*
         *
         * @see com.fruit.framework.listhandler.ValueListHandler#setPageSize(int)
         */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    
        /*
         * returns the current List of objects
         *
         * @see com.fruit.framework.listhandler.ValueListHandler#getList(int)
         */
    private List getList(int pageNo) {
        
        // if pageNo is less than 1 then pageNo is equated to 1
        if (pageNo < 1)
            pageNo = 1;
        this.currentPage= pageNo;//current page is the passed value.
        this.totalPages = dao.findResultSize(countSQL, parameters);
        
                /*
                 * dayer1: 21-Feb-2007 By returning null, the application using a VLH must explicitly check
                 * for null lists returned, which is not natural to list processing of queries. A query
                 * should return zero or more results thus avoiding the amiguity between what constitutes no
                 * records, null AND 0 or simply 0. I think a "null" value should be reserved for
                 * exceptions/errors in the code and should be handled in such a way that returning null
                 * would be natural to typical applications, and expected. Therefore, instead of returning
                 * "null records" I have modified the code to return an empty list.
                 *
                 * Note: possible revisions may want to provide default values for member variables
                 */
        if (this.totalPages < 1) {
            // this.list = null;
            // this.pageNoList = null;
            // return null;
            
            this.list = new ArrayList(); // empty list
            this.pageNoList = new ArrayList(); // empty list
            return list;
        }
        
        int x = (int) Math.ceil((double) this.totalPages / this.pageSize);
        
        if (pageNo > x)
            pageNo = x;
        
        this.startIndex = ((pageNo - 1) * this.pageSize);// + 1;
        this.endIndex = pageNo * this.pageSize;
        
        createList();
        createPageNos(pageNo);
        return list;
        
    }
    
    
    
    /**
     * queries the dao and get the list of objects
     */
    private void createList() {
        list = new ArrayList();
        list = dao.executeQuery(this.querySQL, this.startIndex, this.pageSize, parameters);
    }
    
    /**
     *
     * create page nos depending on the page no passed
     *
     * @param selectPage
     */
    private void createPageNos(int selectPage) {
        this.pageNoList = new ArrayList();
        // changes
        int x = (int) Math.ceil((double) this.totalPages / this.pageSize);
        // changes
        int limit = (int) Math.ceil((double) this.paginationSize / 2);
        
        if (selectPage > x)
            selectPage = x;
        
        // int limit = this.pageSize/2;
        if (selectPage == 1) {
            for (int i = 1; i <= x && i <= this.paginationSize; i++) {
                pageNoList.add(new Integer(i));
                // System.out.println( "i--" + i + "--totalPages--" + totalPages
                // + "--pageSize--" + pageSize + " x--" + x);
            }
            
        } else {
            
            pageNoList.add(new Integer(1));
            for (int i = selectPage; (i >= selectPage - limit && i > 1); i--) {
                pageNoList.add(new Integer(i));
                // System.out.println( "i=" + i + " limit=" + limit + " x=" +
                // x);
            }
            for (int i = selectPage + 1; (i < selectPage + limit && i < x); i++) {
                pageNoList.add(new Integer(i));
                // System.out.println( "i=" + i + " limit=" + limit + " x=" +
                // x);
            }
            
        }
        if (!this.pageNoList.contains(new Integer(x)))
            pageNoList.add(new Integer(x));
        Collections.sort(pageNoList);
        
    }

    public void setCurrentPageNo(int pageNo) {
        this.currentPage = pageNo;
    }
    
    
    // variables
    private PageHandlerDao dao;
    
    private Object[] parameters;
    
    private int totalPages;
    
    private List pageNoList;
    
    private List list;
    
    private int pageSize = 5;
    
    private int paginationSize = 8;   
    
    private String countSQL;
    
    private String querySQL;
          
    private String lSQL;
    
    private String selectCount = " SELECT COUNT(*) ";
    
    private int startIndex;
    
    private int endIndex;
    
    private int currentPage;
    
    private int nextPage;
    
    private int prevPage;
    
    private int noOfPages;
    
}
