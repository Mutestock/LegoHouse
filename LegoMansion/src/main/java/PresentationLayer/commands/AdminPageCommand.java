/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import Data.Exceptions.DataException;
import Logic.DBFacadeImplementation;
import Logic.HelperClasses.OrderHelper.Order;
import PresentationLayer.Command;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henning
 */
public class AdminPageCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("ENTERED ADKIN PAGE COMMAND");
            DBFacadeImplementation dbfi = new DBFacadeImplementation();
            ArrayList<Order> orders = dbfi.getAllOrders();
            System.out.println("ORDERS: " + orders);
            int orderListSize = orders.size();

            for (int i = 0; i < orders.size(); i++) {
                System.out.println("i: " + i);
                String iString = Integer.toString(i);
                Order order = orders.get(i);
//                
//                order.getIdorders();
//                order.getDate();
//                order.getStatus();
//                order.getUser();
//                
//                

                System.out.println("LONG SHIET: " + Integer.toString(order.getIdorders()) + iString);
//                request.getSession().setAttribute("cake", "long");

                System.out.println(request.getSession().getAttribute("cake"));
                request.getSession().setAttribute("cake", "This is a test with i :" + iString);
                System.out.println(request.getSession().getAttribute("cake"));
                request.getSession().removeAttribute("cake");

                String acc = iString;
                System.out.println("acc pre: " + acc);

                request.getSession().setAttribute(iString, iString);

                acc = (String) request.getSession().getAttribute(iString);

                System.out.println("acc post: " + acc);
            }

            loadJSP(request, response);
        } catch (DataException ex) {
            System.out.println("ENTERED CATCH. BOO");
            ex.printStackTrace();
        } catch (SQLException ex) {

            System.out.println("ENTERED CATCH. BOO");
            ex.printStackTrace();
        }
    }

    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/adminPage.jsp").forward(request, response);
    }

}
