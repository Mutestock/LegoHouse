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

//Specialized exception


public class EmptySessionException extends Exception{
    
     public EmptySessionException() {
    }

    public EmptySessionException(String string) {
        super(string);
    }

    public EmptySessionException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public EmptySessionException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
