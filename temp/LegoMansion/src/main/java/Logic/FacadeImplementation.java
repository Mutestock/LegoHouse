/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Interfaces.Facade;
import java.time.LocalDate;

/**
 *
 * @author Henning
 */
public class FacadeImplementation implements Facade{

    @Override
    public void calculator(int height, int length, int width) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String timeString() {
        LocalDate localdate = LocalDate.now();
        return localdate.toString();
    } 
}
