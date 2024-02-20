package com.daywid.Spring.Studies.Math;

/*
 * Utility class for numeric operations
 */
public class NumberConverter 
{
    /*
     * Converts a string to a Double.
     * 
     * @param strNumber the string to be converted
     * @@return the Double value of the string, or 0D if the input is null or not numeric
     */
    public static Double convertToDouble(String strNumber) 
    {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }
    /*
     * Checks if a string is numeric
     * 
     * @param strNumber the string to be checked
     * @return true if the string is numeric, false otherwise
     */
    public static boolean isNumeric(String strNumber) 
    {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");   
        return number.matches("[-+]?[0-9]*\\.?[0-9]+") ;
    }
}
