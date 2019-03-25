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
public class ValidationCollection {
    
    public void validateSizes(int height, int width, int length) throws UnderMinimumValuesException
    {
        if (height < 6 || width < 11 || length < 11)
        {
            throw new UnderMinimumValuesException("Height/width/length was below minimum somewhere");
        }
    }
    
     public void validateEmptyInput(String input) throws EmptyInputException
    {
        if (input.isEmpty() || input == null)
        {
            throw new EmptyInputException("Input field was empty or null");
        }
    }
    
    
}
