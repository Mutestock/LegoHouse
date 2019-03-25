<%-- 
    Document   : ordercreate
    Created on : 22-Mar-2019, 12:57:06
    Author     : Henning
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Creation</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="/LegoMansion/css.css">
        <link rel="stylesheet" type="text/css" href="/WEB-INF/LegoMansion/background.css">
    </head>

    <body>    
        <h1> Order Creation </h1>
        <h6> please be patient </h6>
        <form action="/LegoMansion/c/ordercreate" method=POST>
            Height <br> <input type=text name=height style="color: black"> <br> 
            Width <br> <input type=text name=width style="color: black"> <br> 
            Length <br> <input type=text name=length style="color: black"> <br> 
            <div id="submitbutton1">
                <br> <input type=submit>
            </div>
        </form>
        
        <%
            String errormessage = (String) request.getSession().getAttribute("errormessage");
            if (errormessage == null || errormessage.isEmpty()) {
                errormessage = "";
            }
            out.println(errormessage);

        %>
    </body>
</html>

