<%-- 
    Document   : adminPage
    Created on : 24-Mar-2019, 16:02:55
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
        <form method="post">
            <table border = "1">
                <tr>
                    <td>idorders</td>
                    <td>date</td>
                    <td>status</td>
                    <td>userEmail</td>
                    <td>change status</td>
                </tr>

                <%
                    int listSize = (int) session.getAttribute("listsize");

                    int i = 0;
                    for (i = 0; i < listSize; i++) {

                        String testID = (String) request.getSession().getAttribute("id" + i);
                        String testDate = (String) request.getSession().getAttribute("date" + i);
                        String testStatus = (String) request.getSession().getAttribute("status" + i);
                        String testEmail = (String) request.getSession().getAttribute("email" + i);

                        System.out.println("*******DEFINED VALUES INSIDE TABLE TR ******");

                %>
                <tr>
                    <td><%out.print(testID);%> </td>
                    <td><%out.print(testDate);%> </td>
                    <td><%out.print(testStatus);%> </td>
                    <td><%out.print(testEmail);%> </td>
                    <td><a href="/LegoMansion/c/changestatus"> view</a></p>
                        <%session.setAttribute("tablenr", i);%>
                        <div style="height:100%;width:100%">

                        </div>
                    </td>
                </tr>
                <%}%>
            </table>
        </form>
    </body>
</html>
