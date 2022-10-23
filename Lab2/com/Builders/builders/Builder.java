package com.Builders.builders; 


import com.Builders.services.*;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(TaxiType type);
    void setSeats(int seats);
    void setDestination(GPSDestination destination);
    void setMaxSpeed(MaxSpeed maxSpeed); 
    void setConditionerDegrees(Conditioner conditioner); 
}