<%-- 
    Document   : orderhistory
    Created on : 22-Mar-2019, 12:56:54
    Author     : Henning
--%>

<%@page import="Logic.HelperClasses.OrderHelper.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="Data.DatamapperImplementation"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        -->
        <jsp:include page="siteheader.jsp" />
        <jsp:include page="UserInfoBox.jsp" />
        <--
        <form method="post">
            <table id ="uglytable" border = "1">
                <tr>
                    <td>Idorders</td>
                    <td>Date</td>
                    <td>Status</td>
                    <td>User</td>
                    <td>...</td>
                </tr>
                <%
                    try {
                        DatamapperImplementation dmi = new DatamapperImplementation();
                        ArrayList<Order> orders = dmi.getAllOrders();
                        for (Order o : orders) {
                %>
                <tr>
                    <td><%=o.getIdorders()%></td>
                    <td><%=o.getDate()%></td>
                    <td><%=o.getStatus()%></td>
                    <td><%=o.getUser()%></td>

                <a href="/Cupcake/AdminPageOrderDetails.jsp?idorder=<%=o.getIdorders()%>" >
                    <div style="height:100%;width:100%">
                        <!--<input type="radio" name="radio1" onclick="handleClick(this.id);" id="customerId" />-->
                        view
                    </div>
                    </td>
                    </tr>
                    <%
                        }
                    %>
            </table>
            <%
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </form>
    </body>
</html>
