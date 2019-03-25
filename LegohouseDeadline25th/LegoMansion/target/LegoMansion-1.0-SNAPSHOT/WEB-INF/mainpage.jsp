<%-- 
    Document   : mainpage
    Created on : 22-Mar-2019, 12:56:45
    Author     : Henning
--%>

<%@page import="Logic.HelperClasses.UserHelpers.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <link rel="stylesheet" type="text/css" href="css.css">
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>

    <body>
       
        <%
            User user = (User) request.getSession().getAttribute("User");
            String email = user.getEmail();

            out.println("<h1>Welcome back    : " + email + "</h1>");
        %>
        
        
        
        <p><a href="/LegoMansion/c/ordercreate"> Make an order</a></p>
        <p><a href="/LegoMansion/c/orderhistory"> Browse order history</a></p>
        <p><a href="/LegoMansion/c/adminPage"> Admin page</a></p>
    </body>
</html>
