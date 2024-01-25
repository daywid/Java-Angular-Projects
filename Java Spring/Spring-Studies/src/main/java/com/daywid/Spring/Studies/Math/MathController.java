package com.daywid.Spring.Studies.Math;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daywid.Spring.Studies.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    private final AtomicLong counter  = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum( 
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo 
        ) throws Exception {
            
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }   
        
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

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
 