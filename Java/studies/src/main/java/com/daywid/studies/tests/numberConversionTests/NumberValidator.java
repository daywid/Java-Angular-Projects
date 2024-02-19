package com.daywid.studies.tests.numberConversionTests;
/*
 * Author: @daywid
 * Date: 10.04.2023
 * Description: Utility class for validating and converting numbers.
 */

public class NumberValidator 
{
    /*
     * Checks if the given string is a valid number.
     * 
     * @Param input the string to be checked.
     * 
     * @Return true if the string is a valid number, false otherwise.
     */
    public static boolean isNumeric(String input) 
    {
        try 
        {
            Integer.parseInt(input);
            return true;
        } 
        catch (NumberFormatException ex) 
        {
            return false;
        }
    }

    /*
     * Validates and converts the given string to a number.
     * 
     * @Param numberString the input string to be validated and converted.
     * 
     * @Return the validated and converted number as a string, or the original input string if it is not a valid number.
     */
    public String validateNumber(String numberString) 
    {
        try 
        {
            if (isNumeric(numberString)) 
            {
                int number = Integer.parseInt(numberString);
                return String.valueOf(number);
            } 
            else 
            {
                return numberString;
            }
        }
        catch (NumberFormatException e) 
        {
            return numberString;
        }
    }
}