/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Exceptions;

/**
 *
 * @author Henning
 */
public class EmptyInputException extends Exception{


    public EmptyInputException(String string) {
        super(string);
    }

    public EmptyInputException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public EmptyInputException(Throwable thrwbl) {
        super(thrwbl);
    }
    
    
}
