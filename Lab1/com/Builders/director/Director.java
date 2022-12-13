package com.Builders.director; 

import com.Builders.services.*; 
import com.Builders.builders.*;

public class Director { 

    public void constructSimpleTaxi(Builder builder) {
        builder.setCarType(TaxiType.SIMPLE);
        builder.setSeats(2);
        builder.setMaxSpeed(new MaxSpeed("60")); 
        builder.setConditionerDegrees(new Conditioner("10"));
    }
    public void constructConfortTaxi(Builder builder) {
        builder.setCarType(TaxiType.CONFORTABLE);
        builder.setSeats(4);
        builder.setMaxSpeed(new MaxSpeed("90")); 
        builder.setConditionerDegrees(new Conditioner("You can ask for changing!"));

    }
    
}
