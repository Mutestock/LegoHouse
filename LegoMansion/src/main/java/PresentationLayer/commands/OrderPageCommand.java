/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import Data.DatamapperImplementation;
import Logic.HelperClasses.UserHelpers.User;
import PresentationLayer.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Henning
 */
public class OrderPageCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final DatamapperImplementation dmi = new DatamapperImplementation();
//
        String heightString = request.getParameter("height");
        String widthString = request.getParameter("width");
        String lengthString = request.getParameter("length");

        try {

            int height = Integer.parseInt(heightString);
            int width = Integer.parseInt(widthString);
            int length = Integer.parseInt(lengthString);

            System.out.println(height);
            System.out.println(width);
            System.out.println(length);
            loadJSP(request, response);
        } catch (Exception e) {
            System.out.println("Caught.............!");
            loadJSP(request, response);
        }
//        
//   

//        try {
//            if (email != null && password != null) {
//                User user = dmi.readUserByEmail(email);
//                if (user == null) {
//                    request.setAttribute("errormessage", "<p style=\"color:red\">User doesn't exist.</p>");
//                    loadJSP(request, response);
//                } else if (!user.getPassword().equals(password)) {
//                    request.setAttribute("errormessage", "<p style=\"color:red\">Incorrect password</p>");
//                    loadJSP(request, response);
//                } else {
//                    HttpSession session = request.getSession();
//                    session.removeAttribute("User");
////                    session.setAttribute("User", dao.getUser(username));
//                    session.setAttribute("User", dmi.readUserByEmail(email));
//                    response.sendRedirect("mainpage");
//                }
//            } else {
//                loadJSP(request, response);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ordercreate.jsp").forward(request, response);
    }
}
