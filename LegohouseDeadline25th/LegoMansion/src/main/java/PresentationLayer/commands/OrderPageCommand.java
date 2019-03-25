/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import Data.DatamapperImplementation;
import Logic.Buildingsplan.Building;
import Logic.Buildingsplan.BuildingCalculator;
import Logic.FacadeImplementation;
import Logic.HelperClasses.LegoHelper.Lego;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
import PresentationLayer.Command;
import java.io.IOException;
import java.util.ArrayList;
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

        int idLegoCheck = 0;
        int idOrderCheck = 0;

        try {
            int height = Integer.parseInt(heightString);
            int width = Integer.parseInt(widthString);
            int length = Integer.parseInt(lengthString);

            if (height > 0 && width > 0 && length > 0) {

                while (dmi.readLego(idLegoCheck).getHeight() != 0) {
                    idLegoCheck++;
                }
                while (!(dmi.readOrder(idOrderCheck).getStatus().isEmpty())) {
                    idOrderCheck++;
                }

                FacadeImplementation fi = new FacadeImplementation();
                User user = (User) request.getSession().getAttribute("User");
                Order order = new Order(idOrderCheck, fi.timeString(), "ORDER_RECIEVED", user);
                dmi.createOrder(order);

                Lego lego = new Lego(idLegoCheck, height, width, length, order);
                dmi.createLego(lego);

                BuildingCalculator bc = new BuildingCalculator();
                Building building = bc.createBulding(height, width, length);
                System.out.println(building);

                LoginCommand lc = new LoginCommand();
                HttpSession session = request.getSession();

                request.getSession().setAttribute("building", building);
                request.getSession().setAttribute("height", height);
                request.getSession().setAttribute("width", width);
                request.getSession().setAttribute("length", length);

                int frontEnumNr = BuildingCalculator.getSideNrByEnum("FRONT");
                int backEnumNr = BuildingCalculator.getSideNrByEnum("BACK");
                int leftEnumNr = BuildingCalculator.getSideNrByEnum("LEFT");
                int rightEnumNr = BuildingCalculator.getSideNrByEnum("RIGHT");

                //***************
                int frontline01x2 = BuildingCalculator.getBrickCount1x2BySideLine0(building, frontEnumNr);
                int backline01x2 = BuildingCalculator.getBrickCount1x2BySideLine0(building, backEnumNr);
                int rightline01x2 = BuildingCalculator.getBrickCount1x2BySideLine0(building, rightEnumNr);
                int leftline01x2 = BuildingCalculator.getBrickCount1x2BySideLine0(building, leftEnumNr);

                int frontline02x2 = BuildingCalculator.getBrickCount2x2BySideLine0(building, frontEnumNr);
                int backline02x2 = BuildingCalculator.getBrickCount2x2BySideLine0(building, backEnumNr);
                int rightline02x2 = BuildingCalculator.getBrickCount2x2BySideLine0(building, rightEnumNr);
                int leftline02x2 = BuildingCalculator.getBrickCount2x2BySideLine0(building, leftEnumNr);

                int frontline04x2 = BuildingCalculator.getBrickCount4x2BySideLine0(building, frontEnumNr);
                int backline04x2 = BuildingCalculator.getBrickCount4x2BySideLine0(building, backEnumNr);
                int rightline04x2 = BuildingCalculator.getBrickCount4x2BySideLine0(building, rightEnumNr);
                int leftline04x2 = BuildingCalculator.getBrickCount4x2BySideLine0(building, leftEnumNr);

                //***************
                int frontSide1x2 = BuildingCalculator.getBrickCount1x2BySide(building, frontEnumNr);
                int backSide1x2 = BuildingCalculator.getBrickCount1x2BySide(building, backEnumNr);
                int rightSide1x2 = BuildingCalculator.getBrickCount1x2BySide(building, rightEnumNr);
                int leftSide1x2 = BuildingCalculator.getBrickCount1x2BySide(building, leftEnumNr);

                int frontSide2x2 = BuildingCalculator.getBrickCount2x2BySide(building, frontEnumNr);
                int backSide2x2 = BuildingCalculator.getBrickCount2x2BySide(building, backEnumNr);
                int rightSide2x2 = BuildingCalculator.getBrickCount2x2BySide(building, rightEnumNr);
                int leftSide2x2 = BuildingCalculator.getBrickCount2x2BySide(building, leftEnumNr);

                int frontSide4x2 = BuildingCalculator.getBrickCount4x2BySide(building, frontEnumNr);
                int backSide4x2 = BuildingCalculator.getBrickCount4x2BySide(building, backEnumNr);
                int rightSide4x2 = BuildingCalculator.getBrickCount4x2BySide(building, rightEnumNr);
                int leftSide4x2 = BuildingCalculator.getBrickCount4x2BySide(building, leftEnumNr);

                //**************
                int total01x2 = frontline01x2 + backline01x2 + rightline01x2 + leftline01x2;
                int total02x2 = frontline02x2 + backline02x2 + rightline02x2 + leftline02x2;
                int total04x2 = frontline04x2 + backline04x2 + rightline04x2 + leftline04x2;

                int total1x2 = BuildingCalculator.getBrickType1x2Total(building);
                int total2x2 = BuildingCalculator.getBrickType2x2Total(building);
                int total4x2 = BuildingCalculator.getBrickType4x2Total(building);
                
                // ********************

                request.getSession().setAttribute("frontline01x2", frontline01x2);
                request.getSession().setAttribute("backline01x2", backline01x2);
                request.getSession().setAttribute("rightline01x2", rightline01x2);
                request.getSession().setAttribute("leftline01x2", leftline01x2);

                request.getSession().setAttribute("frontline02x2", frontline02x2);
                request.getSession().setAttribute("backline02x2", backline02x2);
                request.getSession().setAttribute("rightline02x2", rightline02x2);
                request.getSession().setAttribute("leftline02x2", leftline02x2);

                request.getSession().setAttribute("frontline04x2", frontline04x2);
                request.getSession().setAttribute("backline04x2", backline04x2);
                request.getSession().setAttribute("rightline04x2", rightline04x2);
                request.getSession().setAttribute("leftline04x2", leftline04x2);

                // **********
                request.getSession().setAttribute("frontSide1x2", frontSide1x2);
                request.getSession().setAttribute("backSide1x2", backSide1x2);
                request.getSession().setAttribute("rightSide1x2", rightSide1x2);
                request.getSession().setAttribute("leftSide1x2", leftSide1x2);

                request.getSession().setAttribute("frontSide2x2", frontSide2x2);
                request.getSession().setAttribute("backSide2x2", backSide2x2);
                request.getSession().setAttribute("rightSide2x2", rightSide2x2);
                request.getSession().setAttribute("leftSide2x2", leftSide2x2);

                request.getSession().setAttribute("frontSide4x2", frontSide4x2);
                request.getSession().setAttribute("backSide4x2", backSide4x2);
                request.getSession().setAttribute("rightSide4x2", rightSide4x2);
                request.getSession().setAttribute("leftSide4x2", leftSide4x2);

                //************
                request.getSession().setAttribute("total01x2", total01x2);
                request.getSession().setAttribute("total02x2", total02x2);
                request.getSession().setAttribute("total04x2", total04x2);

                request.getSession().setAttribute("total1x2", total1x2);
                request.getSession().setAttribute("total2x2", total2x2);
                request.getSession().setAttribute("total4x2", total4x2);

                System.out.println("__:_:_:_:_:_:_::::::::::_:");
                System.out.println(request.getSession().getAttribute("total1x2"));

//                request.getSession().setAttribute("SideXHeight", ());
                System.out.println("***********************************************");
                System.out.println("***********************************************");
                System.out.println("***********************************************");
                System.out.println(request.getSession().getAttribute("building"));
                System.out.println("***********************************************");
                if (user == null) {
                    request.setAttribute("errormessage", "<p style=\"color:red\">User doesn't exist.</p>");
                    loadJSP(request, response);

                } else {
//                    session.removeAttribute("User");
////                    session.setAttribute("User", dao.getUser(username));
//                    session.setAttribute("User", dmi.readUserByEmail(email));
                    response.sendRedirect("ordercomplete");
                }
            } else {
                loadJSP(request, response);
            }

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
