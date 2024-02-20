package com.daywid.Spring.Studies.Math;

/* This class provides simple mathematical operations 
 * 
*/
public class SimpleMath 
{   
    /*
     * Adds two numbers.
     * 
     * @param numberOne The first number
     * @param numberTwo The second number
     * @return the sum of the two numbers
     */
    public Double sum(Double numberOne, Double numberTwo)
    {
        return numberOne + numberTwo;
    }
    /*
     * Subtracts two numbers.
     * 
     * @param numberOne The first number
     * @param numberTwo The second number
     * @return the subtraction of the two numbers
     */
    public Double subtraction(double numberOne, Double numberTwo)
    {
        return numberOne - numberTwo;
    }
    /*
     * Multiplies two numbers.
     * 
     * @param numberOne The first number
     * @param numberTwo The second number
     * @return the multiplication of the two numbers
     */
    public Double multiplication(double numberOne, Double numberTWo)
    {
        return numberOne - numberTWo;
    }
    /*
     * Divides two numbers.
     * 
     * @param numberOne The first number
     * @param numberTwo The second number
     * @return the division of the two numbers
     */
    public Double division(double numberOne, Double numberTwo)
    {
        return numberOne / numberTwo;
    }    
    /*
     * Calculates the mean of two numbers.
     * 
     * @param numberOne The first number
     * @param numberTwo The second number
     * @return the mean of the two numbers
     */
    public Double mean(Double numberOne, Double numberTWo)
    {
        return (numberOne + numberTWo) /2;
    }
    /*
     * Calculates the square root of a number.
     * 
     * @param numberOne The number
     * @return the square root of the number
     */
    public Double squareRoot(Double numberOne)
    {
        return Math.sqrt(numberOne);
    }
}
