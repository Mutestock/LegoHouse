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
public class UnderMinimumValuesException extends Exception {

    public UnderMinimumValuesException(String string) {
        super(string);
    }

    public UnderMinimumValuesException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public UnderMinimumValuesException(Throwable thrwbl) {
        super(thrwbl);
    }

}
