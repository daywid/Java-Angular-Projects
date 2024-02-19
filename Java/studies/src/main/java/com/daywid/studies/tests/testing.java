package com.daywid.studies.tests;
import java.util.Scanner;

//testing codeium extension to do simple number conversion and check if it is a number

public class testing {

    public static boolean isNumeric(String input) {
        try 
        {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) 
        {
            return false;
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type a number:");
        String numberString = scanner.nextLine();

        if (isNumeric(numberString)) 
        {
            System.out.println("string number:" + numberString);
            System.out.println("object class before conversion:" + numberString.getClass());
            int number = Integer.parseInt(numberString);
            System.out.println("number:" + number);
            System.out.println("number after conversion:" + number);
            System.out.println("object class after conversion:" + number);
        }
        else
        {
            System.out.println("not a number");
        }        
    }
}
