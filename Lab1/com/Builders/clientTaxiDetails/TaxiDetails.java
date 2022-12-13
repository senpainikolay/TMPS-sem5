package com.Builders.clientTaxiDetails; 


import com.Builders.services.*;




public class TaxiDetails {
    private final int seats;
    private final TaxiType carType;
    private final GPSDestination destination;
    private final MaxSpeed maxSpeed; 
    private final Conditioner conditioner; 

    public TaxiDetails( int seats, TaxiType carType, GPSDestination destination, MaxSpeed maxSpeed, Conditioner conditioner) {
        this.carType = carType;
        this.seats = seats;
        this.destination = destination;       
        this.maxSpeed = maxSpeed; 
        this.conditioner = conditioner; 
    }

    public TaxiType getCarType() {
        return carType;
    }

    public int getSeats() {
        return seats;
    }


    public GPSDestination getDestination() {
        return destination;
    }

    public MaxSpeed getMaxSpeed() {
        return maxSpeed;
    } 

    public Conditioner getConditioner() { 
        return conditioner; 
    }  

    public void  printInfo() { 
        System.out.println( String.format( 
        "\n Taxi type: %s \n Number of seats: %s \n Dest: %s \n MaxSpeed: %s \n Degrees at Conditioner: %s \n", 
        carType, 
        seats, 
        destination.getRoute(),
        maxSpeed.askSpeed(), 
        conditioner.getDegrees())
        );
    }

}