package com.daywid.studies.tests;

public class Validations 
{
    
    public static boolean isNumeric(String input) 
    {
        try 
        {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) 
        {
            return false;
        }
    }

    public String validation(String numberString) 
    {
        try 
        {
            if (isNumeric(numberString)) 
            {
                int number = Integer.parseInt(numberString);
                System.out.println("number after conversion: " + number);
                return String.valueOf(number);
            } else 
            {
                System.out.println("not a number");
                return numberString;
            }
        }
        catch (NumberFormatException e) 
        {
            System.out.println("Error converting to number: " + e.getMessage());
            return numberString;
        }
    }
}
