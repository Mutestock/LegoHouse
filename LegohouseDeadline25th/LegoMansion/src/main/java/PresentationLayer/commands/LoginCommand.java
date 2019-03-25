/*
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
import javax.servlet.http.HttpSession;

/**
 * Command class for logging into your account. Necessary redirecting to the
 * main menu. Retrieves username and password parameters from the current
 * session. Grants access to the other pages of the webpage. Used by Front
 * Controller.
 *
 * @author Simon Asholt Norup
 */
public class LoginCommand extends Command {

    /**
     * Basic login functionality, checks the username and password. Prints out
     * errormessages if either username or password is wrong.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final DatamapperImplementation dmi = new DatamapperImplementation();
        request.getSession().setAttribute("errormessage", "");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            ValidationCollection vc = new ValidationCollection();
            vc.validateEmptyInput(email);
            vc.validateEmptyInput(password);
        } catch (Exception e) {
            request.getSession().setAttribute("errormessage", "Empty input in login");
        }

        System.out.println(email);

        try {
            if (email != null && password != null) {
                User user = dmi.readUserByEmail(email);
                if (user == null) {
                    request.setAttribute("errormessage", "<p style=\"color:red\">User doesn't exist.</p>");
                    loadJSP(request, response);
                } else if (!user.getPassword().equals(password)) {
                    request.setAttribute("errormessage", "<p style=\"color:red\">Incorrect password</p>");
                    loadJSP(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.removeAttribute("User");
//                    session.setAttribute("User", dao.getUser(username));
                    session.setAttribute("User", dmi.readUserByEmail(email));
                    response.sendRedirect("mainpage");
                }
            } else {
                loadJSP(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
