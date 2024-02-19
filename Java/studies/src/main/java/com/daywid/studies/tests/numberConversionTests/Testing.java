package com.daywid.studies.tests.numberConversionTests;
import java.util.Scanner;
//testing codeium extension to do simple number conversion and check if it is a number

public class Testing 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type a number:");
        String numberString = scanner.nextLine();
        NumberValidator validator = new NumberValidator();
        validator.validateNumber(numberString);
    }
}
 