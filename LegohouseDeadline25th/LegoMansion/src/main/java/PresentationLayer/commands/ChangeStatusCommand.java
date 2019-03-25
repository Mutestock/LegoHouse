/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import Data.DatamapperImplementation;
import Data.Exceptions.DataException;
import Logic.DBFacadeImplementation;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
import PresentationLayer.Command;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henning
 */
public class ChangeStatusCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      
        try {
            //        <input type="submit" value="CANCELLED" onclick="<%= request.getSession().setAttribute("CANCELLED", "cancelled") %>">
//        <input type="submit" value="SHIPPED" onclick="<%= request.getSession().setAttribute("SHIPPED", "shipped") %>">
//        <input type="submit" value="ORDER_RECIEVED" onclick="<%= request.getSession().setAttribute("ORDER_RECIEVED", "received") %>">
//        <input type="submit" value="DELIVERED" onclick="<%= request.getSession().setAttribute("DELIVERED", "delivered!!") %>">
            request.getSession().getAttribute("tablenr");
            String cancel = (String) request.getSession().getAttribute("statuschange");

            DBFacadeImplementation dbfi = new DBFacadeImplementation();

            int orderid = (int) request.getSession().getAttribute("tablenr");
            System.out.println("ORDERIDFROMTABLE: " + orderid + "***************");
            Order order = dbfi.readOrder(orderid);
            System.out.println(order);

            if (request.getParameter("cancelbutton") != null) {
                Order updateOrder = new Order(orderid, order.getDate(), "CANCELLED", order.getUser());
                order = updateOrder;
                dbfi.updateOrder(order);
                System.out.println("Cancel");
            } else if (request.getParameter("shippedbutton") != null) {
                Order updateOrder = new Order(orderid, order.getDate(), "SHIPPED", order.getUser());
                order = updateOrder;
                dbfi.updateOrder(order);
                System.out.println("Shipped");
                } else if (request.getParameter("recievedbutton") != null) {
                Order updateOrder = new Order(orderid, order.getDate(), "ORDER_RECIEVED", order.getUser());
                order = updateOrder;
                dbfi.updateOrder(order);
                System.out.println("recieved");
            } else if (request.getParameter("deliveredbutton") != null) {
                 Order updateOrder = new Order(orderid, order.getDate(), "DELIVERED", order.getUser());
                order = updateOrder;
                dbfi.updateOrder(order);
                System.out.println("deliveredbutton");
            } else {
                System.out.println("error occured in changestatus.");
            }

            System.out.println(cancel);

            loadJSP(request, response);
        } catch (DataException ex) {
            Logger.getLogger(ChangeStatusCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeStatusCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/changeStatusPage.jsp").forward(request, response);
    }

}
