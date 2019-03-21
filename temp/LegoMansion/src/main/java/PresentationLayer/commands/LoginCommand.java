/*
 */
package PresentationLayer.commands;

import PresentationLayer.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Command class for logging into your account.
 * Necessary redirecting to the main menu.
 * Retrieves username and password parameters from the current session.
 * Grants access to the other pages of the webpage.
 * Used by Front Controller.
 * @author Simon Asholt Norup
 */
public class LoginCommand extends Command {
    /**
     * Basic login functionality, checks the username and password. 
     * Prints out errormessages if either username or password is wrong.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }
    
}
