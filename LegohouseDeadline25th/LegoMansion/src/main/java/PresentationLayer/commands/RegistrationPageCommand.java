/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import Data.DatamapperImplementation;
import Data.Exceptions.ValidationCollection;
import Logic.HelperClasses.UserHelpers.User;
import PresentationLayer.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henning
 */
public class RegistrationPageCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final DatamapperImplementation dmi = new DatamapperImplementation();
        request.getSession().setAttribute("errormessage", "");
        int useridcheck = 0;
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            ValidationCollection vc = new ValidationCollection();
            vc.validateEmptyInput(email);
            vc.validateEmptyInput(password);
        } catch (Exception e) {
            request.getSession().setAttribute("errormessage", "Empty input in login");
            loadJSP(request, response);
        }

        try {
            if (email != null && password != null) {
                User user = dmi.readUserByEmail(email);
                if (user.getPassword().isEmpty()) {
                    while (!(dmi.readUser(useridcheck).getEmail().isEmpty())) {
                        useridcheck++;
                    }
                    dmi.createUser(new User(useridcheck, email, password, false));
                    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/FailedCreation.jsp").forward(request, response);
                    loadJSP(request, response);
                }
            } else {
                request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
                loadJSP(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }
}
