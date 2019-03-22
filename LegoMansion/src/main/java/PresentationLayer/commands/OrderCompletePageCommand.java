/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.commands;

import PresentationLayer.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henning
 */
public class OrderCompletePageCommand extends Command{
    
     @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ordercomplete.jsp").forward(request, response);
    }
    
}
