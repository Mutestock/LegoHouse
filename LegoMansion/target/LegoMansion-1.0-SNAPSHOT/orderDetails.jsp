<%-- 
    Document   : orderDetails
    Created on : 22-Mar-2019, 22:00:28
    Author     : Henning
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Data.DBAccess.DBConnector"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>    
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <form method="post">
            <table id ="uglytable" border = "1">
                <tr>
                   
                    <td>lego house ID</td>
                    <td>height</td>
                    <td>width</td>
                    <td>length</td>
                    <td>order ID</td>
                    <td>order date</td>
                    <td>order status</td>
                    
                </tr>
                <%
                    System.out.println("ENTERING");
                    System.out.println("ENTERING");
                    System.out.println("ENTERING");
                    System.out.println("ENTERING");
                    byte checkSort = 0;
                    try {
                        DBConnector connector = new DBConnector();
                        Connection c = connector.getConnection();
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery(
                                "SELECT * "
                                + "FROM lego_type lt "
                                + "LEFT JOIN orders o "
                                + "ON lt.idordersfk = o.idorders "
                                + "WHERE o.idorders = " + request.getParameter("idorder") + ";");
                        System.out.println("ииииииииииииии");
                        System.out.println("REQUEST PARAM: " + request.getParameter("idorder"));
                        System.out.println("ииииииииииииии");
                        while (rs.next()) {
                            if (checkSort == 0) {
                %>
                <tr>
                    <td><%=rs.getInt("idlego_type")%></td>
                    <td><%=rs.getInt("height")%></td>
                    <td><%=rs.getInt("width")%></td>
                    <td><%=rs.getInt("length")%></td>
                    <td><%=rs.getInt("idorders")%></td>
                    <td><%=rs.getString("order_date")%></td>
                    <td><%=rs.getString("status")%></td>


                </tr>
                <%
                        }
                    }
                %>
            </table>
            <%
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </form>
    </body>
</html>


