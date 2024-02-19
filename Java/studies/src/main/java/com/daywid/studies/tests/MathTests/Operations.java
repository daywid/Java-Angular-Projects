package com.daywid.studies.tests.MathTests;
/*
 * Author: @daywid
 * Date: 10.04.2023
 * Description: This class performs basic math operations such as addition, subtraction, multiplication, division, and modulus. * 
 */

public class Operations 
{
    /*
     * Performs the specified mathematical operation on the given numbers and prints the result.
     * 
     * @Param operation the operation to perform
     * @Param number1 the first number
     * @Param number2 the second number
     */
    public void performOperation(String operation, String number1String, String number2String)
    {
        double number1 = Double.parseDouble(number1String);
        double number2 = Double.parseDouble(number2String);

        switch (operation) 
        {
            case "sum":
                sum(number1, number2);
                break;
            case "sub":
                sub(number1, number2);
                break;
            case "mult":
                mult(number1, number2);
                break;
            case "div":
                div(number1, number2);
                break;
            case "mod":
                mod(number1, number2);
                break;
            default:
                System.out.println("invalid operation");
                break;
        }
    }

    /*
     * Adds two given numbers and prints the result.
     * 
     * @Param number1 the first number
     * @Param number2 the second number
     * 
     * @Return the sum of the two numbers
     */
    public double sum(double number1, double number2) 
    {
        double result =  number1 + number2;
        System.out.println("result: " + result);
        return result;
    }

    /*
     * Subtracts two given numbers and prints the result.
     * 
     * @Param number1 the first number
     * @Param number2 the second number
     * 
     * @Return the difference of the two numbers
     */  
    public double sub(double number1, double number2) 
    {
        double result = number1 - number2;
        System.out.println("result: " + result);
        return result;
    }
    
    /*
     * Multiplies two given numbers and prints the result.
     * 
     * @Param number1 the first number
     * @Param number2 the second number
     * 
     * @Return the product of the two numbers
     */
    public double mult(double number1, double number2) 
    {
        double result = number1 * number2;
        System.out.println("result: " + result);
        return result;
    }
    
    /*
     * Divides two given numbers and prints the result.
     * 
     * @Param number1 the first number
     * @Param number2 the second number
     * 
     * @Return the quotient of the two numbers
     */
    public double div(double number1, double number2) 
    {
        double result = number1 / number2;
        System.out.println("result: " + result);
        return result;
    }
    
    /*
     * Calculates the remainder of two given numbers and prints the result.
     * 
     * @Param number1 the first number
     * @Param number2 the second number
     * 
     * @Return the remainder of the two numbers
     */

    public double mod(double number1, double number2) 
    {
        double result = number1 % number2;
        System.out.println("result: " + result);
        return result;
    }
}