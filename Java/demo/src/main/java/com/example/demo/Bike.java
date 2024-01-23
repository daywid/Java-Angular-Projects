package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bikeBean")
public class Bike implements VehicleInterface{

    @Override
    public void start() {
        System.out.println("Iniciando moto");

    }

    @Override
    public void stop() {
        System.out.println("Iniciando moto");

    }
    
}
