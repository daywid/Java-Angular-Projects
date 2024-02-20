package com.daywid.Spring.Studies.Math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daywid.Spring.Studies.exceptions.UnsupportedMathOperationException;

/*
 * Controller for mathematical operations
 */
@RestController
public class MathController 
{

    private SimpleMath math = new SimpleMath();
    /*
     * Endpoint for sum operation
     * 
     * @param numberOne First number
     * @param numberTwo Second number
     * @return the sum of the two numbers
     * @throws Exception if the input is not numeric
     */
    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum( 
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo 
        ) 
        throws Exception {
            
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }   
        
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    /*
     * Endpoint for subtraction operation
     * 
     * @param numberOne First number
     * @param numberTwo Second number
     * @return the subtraction of the two numbers
     * @throws Exception if the input is not numeric
     */
    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction( 
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo 
        ) throws Exception {
            
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }   
        
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    /*
     * Endpoint for multiplication operation
     * 
     * @param numberOne First number
     * @param numberTwo Second number
     * @return the multiplication of the two numbers
     * @throws Exception if the input is not numeric
     */
    @GetMapping(value = "/multiply/{numberOne}/{numberTwo}")
    public Double multiplication( 
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo 
        ) throws Exception {
            
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }   
        
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    /*
     * Endpoint for division operation
     * 
     * @param numberOne First number
     * @param numberTwo Second number
     * @return the division of the two numbers
     * @throws Exception if the input is not numeric
     */
    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division( 
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo 
        ) throws Exception {
            
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }   
        
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    /*
     * Endpoint for mean operation
     * 
     * @param numberOne First number
     * @param numberTwo Second number
     * @return the mean of the two numbers
     * @throws Exception if the input is not numeric
     */
    @GetMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean( 
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo 
        ) throws Exception {
            
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }   
        
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    /*
     * Endpoint for square root operation
     * 
     * @param numberOne First number
     * @return the square root of the number
     * @throws Exception if the input is not numeric
     */
    @GetMapping(value = "/squareroot/{numberOne}")
    public Double squareRoot( 
        @PathVariable(value = "numberOne") String numberOne 
        ) throws Exception {
            
        if(!NumberConverter.isNumeric(numberOne)) { 
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }   
       
        return math.squareRoot(NumberConverter.convertToDouble(numberOne));
    }
}
 