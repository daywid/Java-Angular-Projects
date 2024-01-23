package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("carBean")
public class Car implements VehicleInterface{

    @Override
    public void start() {
       System.out.println("Iniciando carro");
    }

    @Override
    public void stop() {
        System.out.println("Parando carro");

    }
    
}
