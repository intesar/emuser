/*
 * PageHandlerFactory.java
 *
 * Created on May 5, 2007, 10:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package abbt.com.paginationframework;

/**
 *
 * @author shannan
 */
public class PageHandlerFactory {
    
/*
 * @param dao is implementation of ValueListHandlerDAO ( cannot be null )
 * @param countQuery ( eg in jpa it could be a named query which says select count(c) from C c ) ( cannot be null )
 * @param query it could be any query ( cannot be null )
 * @return ValueListHandler
 */
    public static final PageHandler getInstance( PageHandlerDao dao, String countQuery, String query, Object... parameters ) {
        
        if ( dao instanceof PageHandlerDao && countQuery instanceof String && query instanceof String ) {
            return new PageHandlerImpl( dao, countQuery, query, parameters );
        }
        throw new IllegalArgumentException();
    }
    
    /** Creates a new instance of PageHandlerFactory */
    private PageHandlerFactory() {
    }
    
}
