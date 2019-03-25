<%-- 
    Document   : orderhistory
    Created on : 22-Mar-2019, 12:56:54
    Author     : Henning
--%>

<%@page import="Logic.HelperClasses.UserHelpers.User"%>
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
        <form method="post">
            <table id ="uglytable" border = "1">
                <tr>
                    <td>Idorders</td>
                    <td>Date</td>
                    <td>Status</td>
                    <td>...</td>
                </tr>
                <%
                    int i = 0;
                    try {
                        DatamapperImplementation dmi = new DatamapperImplementation();
                        ArrayList<Order> ordersPreUser = dmi.getAllOrders();
                        User user = (User) session.getAttribute("User");

                        ArrayList<Order> orders = new ArrayList<Order>();
                        int userId = user.getID();
                        System.out.println("userid: " + userId);
//                        System.out.println("FOUND USER ID IN ORDERHISTORY: " + userIDEmail);
//                        System.out.println("ORDERS PRE: " + ordersPreUser);

                        for (Order o : ordersPreUser) {
                            o.getUser().getID();
                            if (o.getUser().getID() == user.getID()) {
                                System.out.println("ack");
                                orders.add(o);
                            }
                        }
                        System.out.println("ORDERS POST: " + orders);
                        session.setAttribute("orderTableSize", orders.size());

                        for (Order o : orders) {
                            System.out.println(o.getDate());
                            String dateconv = o.getDate();
                            i++;
                            String iToString = Integer.toString(i);
                %>
                <tr>
                    <td><%=o.getIdorders()%></td>
                    <td><%=dateconv%></td>
                    <td><%=o.getStatus()%></td>


                    <td><a href="/LegoMansion/c/orderDetails?orderID=<%=o.getIdorders()%>"> view</a></p>


                        <div style="height:100%;width:100%">

                        </div>
                    </td>
                </tr>
                <%                    }
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
