<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%    
    try {
        
        java.util.List list = (java.util.List) request.getAttribute("RecentAccount");
        java.util.Iterator iter = list.iterator();
        while ( iter.hasNext() ) {
            com.abbt.crm.base.entity.Account account = (com.abbt.crm.base.entity.Account) iter.next();
            out.print(account.getAccountId() + "  ");
            out.println(account.getCreatedUser()+" ");
            
            
        }
        
    } catch ( Exception e) {
        e.printStackTrace();
    }
%>   
