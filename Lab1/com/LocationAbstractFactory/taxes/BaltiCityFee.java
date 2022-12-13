package com.LocationAbstractFactory.taxes;

public class BaltiCityFee  implements Fee{ 
    @Override
    public void informAboutFee() {
        System.out.println("Starting from 30 lei.");
    }
    
}
