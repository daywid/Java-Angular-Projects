package com.example.demo;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String hello(){

        System.err.println("entrei nesse metodo");

        return "hello";
    }
}
