<%-- 
    Document   : orderDetails
    Created on : 22-Mar-2019, 22:00:28
    Author     : Henning
--%>

<%@page import="Data.Exceptions.InvalidOutputException"%>
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
            <table border = "1">
                <tr>
                    <td>Height</td>
                    <td>Width</td>
                    <td>Length</td>
                </tr>

                <tr>
                    <td><%out.print(session.getAttribute("height"));
                        if ((int) session.getAttribute("height") < 6) {
                        %> Value below minimum. Error<%
                            System.out.println("height below minimum");
                               throw new InvalidOutputException();
                           }
                        %></td>
                    <td><%out.print(session.getAttribute("width"));

                        if ((int) session.getAttribute("width") < 11) {
                        %> Value below minimum. Error<%
                            System.out.println("width below minimum");
                                throw new InvalidOutputException();
                            }
                        %></td>
                    %></td>
                    <td><%out.print(session.getAttribute("length"));
                        if ((int) session.getAttribute("length") < 11) {
                        %> Value below minimum. Error<%
                            System.out.println("length below minimum");
                                throw new InvalidOutputException();
                            }
                        %></td>

                </tr>
            </table>

        </form>
        <form method="post">
            <table border = "1">
                <tr>
                    <td>Type</td>
                    <td>Side 1 line 0</td>
                    <td>Side 2 line 0</td>
                    <td>Side 3 line 0</td>
                    <td>Side 4 line 0</td>
                    <td>Total line 0</td>
                    <td>Total side 1</td>
                    <td>Total side 2</td>
                    <td>Total side 3</td>
                    <td>Total side 4</td>
                    <td>Side x Height</td>
                </tr>

                <tr>
                    <td>1x2</td>
                    <td><%out.print(session.getAttribute("frontline01x2"));%></td>
                    <td><%out.print(session.getAttribute("backline01x2"));%></td>
                    <td><%out.print(session.getAttribute("rightline01x2"));%></td>
                    <td><%out.print(session.getAttribute("leftline01x2"));%></td>
                    <td><%out.print(session.getAttribute("total01x2"));%></td>
                    <td><%out.print(session.getAttribute("frontSide1x2"));%></td>
                    <td><%out.print(session.getAttribute("backSide1x2"));%></td>
                    <td><%out.print(session.getAttribute("rightSide1x2"));%></td>
                    <td><%out.print(session.getAttribute("leftSide1x2"));%></td>
                    <td><%out.print(session.getAttribute("total1x2"));%></td>
                </tr>
                <tr>
                    <td>2x2</td>
                    <td><%out.print(session.getAttribute("frontline02x2"));%></td>
                    <td><%out.print(session.getAttribute("backline02x2"));%></td>
                    <td><%out.print(session.getAttribute("rightline02x2"));%></td>
                    <td><%out.print(session.getAttribute("leftline02x2"));%></td>
                    <td><%out.print(session.getAttribute("total02x2"));%></td>
                    <td><%out.print(session.getAttribute("frontSide2x2"));%></td>
                    <td><%out.print(session.getAttribute("backSide2x2"));%></td>
                    <td><%out.print(session.getAttribute("rightSide2x2"));%></td>
                    <td><%out.print(session.getAttribute("leftSide2x2"));%></td>
                    <td><%out.print(session.getAttribute("total2x2"));%></td>
                </tr>
                <tr>
                    <td>4x2</td>
                    <td><%out.print(session.getAttribute("frontline04x2"));%></td>
                    <td><%out.print(session.getAttribute("backline04x2"));%></td>
                    <td><%out.print(session.getAttribute("rightline04x2"));%></td>
                    <td><%out.print(session.getAttribute("leftline04x2"));%></td>
                    <td><%out.print(session.getAttribute("total04x2"));%></td>
                    <td><%out.print(session.getAttribute("frontSide4x2"));%></td>
                    <td><%out.print(session.getAttribute("backSide4x2"));%></td>
                    <td><%out.print(session.getAttribute("rightSide4x2"));%></td>
                    <td><%out.print(session.getAttribute("leftSide4x2"));%></td>
                    <td><%out.print(session.getAttribute("total4x2"));%></td>
                </tr>


            </table>
        </form>
    </body>
</html>


