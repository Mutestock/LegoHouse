/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Interfaces;

import Logic.Buildingsplan.Building;
import Logic.HelperClasses.UserHelpers.User;
import java.util.ArrayList;

/**
 *
 * @author Henning
 */
public interface Facade {
    
    public Building calculateAllBricksInHouse(int height, int width, int length);
    
    public String timeString();
    
}
