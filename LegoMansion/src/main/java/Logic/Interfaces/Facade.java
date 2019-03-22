/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Interfaces;

import Logic.HelperClasses.UserHelpers.User;
import java.util.ArrayList;

/**
 *
 * @author Henning
 */
public interface Facade {
    
    public void calculator(int height, int length, int width);
    
    public String timeString();
    
}
