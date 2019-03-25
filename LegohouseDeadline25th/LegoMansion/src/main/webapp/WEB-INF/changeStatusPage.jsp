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
        <form action="changestatus">
            <input type="submit" name="cancelbutton" value="CANCELLED">
            <input type="submit" name="shippedbutton" value="SHIPPED">
            <input type="submit" name="recievedbutton"value="ORDER_RECIEVED">
            <input type="submit" name="deliveredbutton"value="DELIVERED">     
        </form>
        <p><a href="/LegoMansion/c/adminPage"> go back</a></p>
    </body>
</html>
