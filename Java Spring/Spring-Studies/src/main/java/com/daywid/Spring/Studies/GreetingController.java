package com.daywid.Spring.Studies;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final AtomicLong counter  = new AtomicLong();

    @GetMapping(value = "/sum{numberOne}/{numberTwo}")
    public Double sum( 
        @PathVariable(value = "numberOne") String numberTwo,
        @PathVariable(value = "numberTwo") String numberOne 
        ) throws Exception {
            
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) { 
            throw new Exception(); 
        }   
        
        return convertToDouble(numberOne) + convertToDouble(numberOne);
    }

    private Double convertToDouble(String strNumber) {

        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        
        if(isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    
    }

    private boolean isNumeric(String strNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNumeric'");
    }
    
}
 