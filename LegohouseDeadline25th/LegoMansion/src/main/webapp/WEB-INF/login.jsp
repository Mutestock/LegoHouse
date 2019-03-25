<%-- 
    Document   : login
    Created on : 22-Mar-2019, 13:46:45
    Author     : Henning
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="/WEB-INF/LegoMansion/css.css">
        <link rel="stylesheet" type="text/css" href="/WEB-INF/LegoMansion/background.css">
    </head>

    <body>
        <div id="topmenu">
            <select onChange="window.location.href = this.value">
                <option value = "/LegoMansion/c/login"> Login </option>
                <option value = "/LegoMansion/c/registration"> Create new user </option>
            </select>
        </div>
        <h1> Login </h1>
        <form action="/LegoMansion/c/login" method=POST>
            Email <br> <input type=text name=email style="color: black"> <br> 
            Password: <br> <input type= password name=password style="color: black"> <br> 
            <div id="submitbutton1">
                <br> <input type=submit>
            </div>
        </form>
        <%
            String errormessage = (String) request.getAttribute("errormessage");
            if (errormessage == null || errormessage.isEmpty()) {
                errormessage = "";
            }
            out.println(errormessage);
        %>
    </body>
</html>
