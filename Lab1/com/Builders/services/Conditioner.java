package com.Builders.services; 


public class Conditioner { 

    private String degrees; 
    public Conditioner() {
        this.degrees = "10"; 
    }

    public Conditioner(String degrees) {
        this.degrees = degrees;
    }

    public String getDegrees() {
        return degrees;
    }
    
}
