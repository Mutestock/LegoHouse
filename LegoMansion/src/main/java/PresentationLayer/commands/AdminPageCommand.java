/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import Data.Exceptions.DataException;
import Logic.DBFacadeImplementation;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
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
            int conv = orders.size();
//            int orderListSize = Integer.toString(conv);
            
            request.getSession().setAttribute("listsize",conv);
            
            int listSize = (int)request.getSession().getAttribute("listsize");
            System.out.println(listSize);
            

            for (int i = 0; i < orders.size(); i++) {
                System.out.println("i: " + i);
                String iString = Integer.toString(i);
                Order order = orders.get(i);    
                try
                {
                    String cancelled = request.getParameter("CANCELLED");
                    String received = request.getParameter("ORDER_RECIEVED");
                    String delivered = request.getParameter("DELIVERED");
                    String shipped = request.getParameter("SHIPPED");
                    
                    System.out.println("********GETTING PARAMETERS**********");
                    
                    System.out.println(cancelled);
                    System.out.println(received);
                    System.out.println(delivered);
                    System.out.println(shipped);
                    System.out.println("");
                    
                    String cancelAttribute = (String)request.getSession().getAttribute("CANCELLED"+i);
                    String shippedAttribute = (String)request.getSession().getAttribute("SHIPPED"+i);
                    String receivedAttribute = (String)request.getSession().getAttribute("ORDER_RECIEVED"+i);
                    String deliveredAttribute = (String)request.getSession().getAttribute("DELIVERED"+i);
                    
                    System.out.println("cancel: " + cancelAttribute);
                    System.out.println("shipped: " + shippedAttribute);
                    System.out.println("received: " + receivedAttribute);
                    System.out.println("delivered: " + deliveredAttribute);
                    
                    
                    
                    //request.getSession().setAttribute("button"+i, "HIT!!");
                    String button = (String)request.getSession().getAttribute("button1");
                    System.out.println("Button: " + button+ " i => " + i);
                    
                    //String
                    
                    
                    System.out.println("********GETTING PARAMETERS**********");
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

                String id = Integer.toString(order.getIdorders());
                String date = order.getDate();
                String status = order.getStatus();
                String userEmail = order.getUser().getEmail();
                
                String IDID = id+iString;
                String dateID = date+iString;
                String statusID = status+iString;
                String userEmailID = userEmail+iString;
                
       
                System.out.println(id);
                System.out.println(date);
                System.out.println(status);
                System.out.println(userEmail);
                
                
                System.out.println(IDID);
                System.out.println(dateID);
                System.out.println(statusID);
                System.out.println(userEmailID);
                
                System.out.println("#########PRE SESSION RETRIEVE###########");
                
                request.getSession().setAttribute("id"+i, id);
                request.getSession().setAttribute("date"+i, date);
                request.getSession().setAttribute("status"+i, status);
                request.getSession().setAttribute("email"+i, userEmail);
                
                String testID = (String)request.getSession().getAttribute("id"+i);
                String testDate = (String)request.getSession().getAttribute("date"+i);
                String testStatus = (String)request.getSession().getAttribute("status"+i);
                String testEmail = (String)request.getSession().getAttribute("email"+i);
                
                System.out.println("*******POST TEST***********");
                System.out.println(testID);
                System.out.println(testDate);
                System.out.println(testStatus);
                System.out.println(testEmail);
                
                
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
