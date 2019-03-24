/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import Data.DatamapperImplementation;
import Logic.DBFacadeImplementation;
import PresentationLayer.Command;
import java.io.IOException;
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

//        <input type="submit" value="CANCELLED" onclick="<%= request.getSession().setAttribute("CANCELLED", "cancelled") %>">
//        <input type="submit" value="SHIPPED" onclick="<%= request.getSession().setAttribute("SHIPPED", "shipped") %>">
//        <input type="submit" value="ORDER_RECIEVED" onclick="<%= request.getSession().setAttribute("ORDER_RECIEVED", "received") %>">
//        <input type="submit" value="DELIVERED" onclick="<%= request.getSession().setAttribute("DELIVERED", "delivered!!") %>">     
        request.getSession().getAttribute("tablenr");
        String cancel = (String) request.getSession().getAttribute("statuschange");
        
        DBFacadeImplementation dbfi = new DBFacadeImplementation();
        
        int orderid= (int)request.getSession().getAttribute("tablenr");
        
        dbfi.readOrder(0);

        if (request.getParameter("cancelbutton") != null) {
            dbfi.updateOrder(order);
        } else if (request.getParameter("shippedbutton") != null) {
            dbfi.updateOrder(order);
        } else if (request.getParameter("recievedbutton") != null) {
            dbfi.updateOrder(order);
        } else if (request.getParameter("recievedbutton") != null){
            dbfi.updateOrder(order);
        }
        else
        {
            System.out.println("error occured in changestatus.");
        }

        System.out.println(cancel);

        loadJSP(request, response);
    }

    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/changeStatusPage.jsp").forward(request, response);
    }

}
