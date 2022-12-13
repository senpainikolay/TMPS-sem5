package com.Builders.services;

public class MaxSpeed { 

    private String maxSpeedAsked; 
    public MaxSpeed() {
        this.maxSpeedAsked = "50"; 
    }

    public MaxSpeed(String maxSpeedAsked) {
        this.maxSpeedAsked = maxSpeedAsked;
    }

    public String askSpeed() {
        return maxSpeedAsked;
    }
    
}
