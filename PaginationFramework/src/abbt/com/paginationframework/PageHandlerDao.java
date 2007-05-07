/*
 * PageHandlerDao.java
 *
 * Created on May 5, 2007, 10:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package abbt.com.paginationframework;

/**
 *
 * @author shannan
 * This interface should be imlemented by application which wants to use pagination framework
 * This is very important interface since the ValueListHandler Framework depends on its implementation to
 * connect, query, and get results from any database system
 *
 */
public interface PageHandlerDao {
    /**
     *
     * This method is used for knowing how many
     * records the query will return not the records itself.
     *
     *
     * @param query any Query ( Hibernate-QL, JPA-QL, SQL )
     *
     * @return int value 
     * 
     */
    
    int findResultSize(String nameQuery, Object... parameters );
    
    
    /**
     * @param query  any Query ( Hibernate-QL, JPA-QL, SQL )
     * @param startIndex, endIndex of result List
     * @return java.util.List list contains objects of type className
     */
    java.util.List executeQuery( String nameQuery, int startIndex, int maxObjects, Object... parameters);
}
