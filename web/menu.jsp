<%-- 
    Document   : menu
    Created on : 15 janv. 2010, 16:40:56
    Author     : vincentb
--%>
<%@page import="iut.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

                <%
            CategoryHelper helper = new CategoryHelper();
            List<Category> categories = helper.getFirstLevelCategories();

           out.print("<ul class=\"navigation\">");
            for ( Category category : categories)
            {
               out.print("<li class=\"toggleSubMenu\"><span>"+category.getName() +"</span>");
               List<Category> secondLevelCategories = helper.getSecondLevelCategories(category.getId());
               if ( secondLevelCategories.size() > 0 )
               {
                   out.print("<ul class=\"subMenu\">");
                   for ( Category secondCategory : secondLevelCategories )
                   {
                       out.print("<li><a href=\"#\" title=\"iut\">> "+secondCategory.getName()+"</a></li>");

                   }
                   out.print("</ul>");
               }

               out.print("</li>");
            }
            out.print("</ul>");

        %>
