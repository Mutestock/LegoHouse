<%-- 
    Document   : changeStatusPage
    Created on : 24-Mar-2019, 22:21:09
    Author     : Henning
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <input type="submit" value="CANCELLED" onclick="<% request.getSession().setAttribute("statuschange", "cancelled"); %>">
        <input type="submit" value="SHIPPED" onclick="<% request.getSession().setAttribute("statuschange", "shipped"); %>">
        <input type="submit" value="ORDER_RECIEVED" onclick="<% request.getSession().setAttribute("statuschange", "received"); %>">
        <input type="submit" value="DELIVERED" onclick="<% request.getSession().setAttribute("statuschange", "delivered"); %>">     
        
    </body>
</html>
