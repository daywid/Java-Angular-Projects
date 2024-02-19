package com.daywid.studies.tests.MathTests;
import java.util.Scanner;

/**
 * Author: @daywid
 * Date: 10.04.2023
 * Description: This is the main class for the MathTests package. 
 * It allows the user to perform basic arithmetic operations on two input numbers.
 */

public class Main {
    
    /*
     * The main method of the program.
     * It creates an instance of the Operations class and a Scanner object to read user input.
     * It then prompts the user to enter two numbers and an operation to perform
     * and passes them to the Operations class for processing.
     * 
     * @param args the command-line arguments passed to the program.
     */

    public static void main(String[] args) 
    {
        // Create an instance of the Operations class
        Operations operations = new Operations();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input the first number
        System.out.println("type a number:");
        String number1 = scanner.nextLine();

        // Prompt the user to input the second number
        System.out.println("type another number:");
        String number2 = scanner.nextLine();

        // Prompt the user to input the operation
        System.out.println("type an operation: sum, sub, mult, div, mod");
        String operation = scanner.nextLine();

        //Pass the operation and numbers to the Operations class for processing
        operations.performOperation(operation, number1, number2);
    }

}
