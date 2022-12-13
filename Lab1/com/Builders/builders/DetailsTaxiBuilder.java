package com.Builders.builders; 

import com.Builders.clientTaxiDetails.TaxiDetails;
import com.Builders.services.*;

public class DetailsTaxiBuilder  implements Builder{  

    private TaxiType type;
    private int seats;
    private GPSDestination destination;
    private MaxSpeed maxSpeed; 
    private Conditioner conditioner; 
    @Override 
    public void setCarType(TaxiType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setDestination(GPSDestination destination) {
        this.destination = destination;
    }

    @Override
    public void setMaxSpeed(MaxSpeed maxSpeed) {
        this.maxSpeed = maxSpeed;
    } 

    @Override 
    public void setConditionerDegrees(Conditioner conditioner) { 
        this.conditioner = conditioner; 
    }



    public TaxiDetails getResult() {
        return new TaxiDetails(seats, type,  destination, maxSpeed, conditioner);
    } 

 






    
}
