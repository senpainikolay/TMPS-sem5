package com.LocationAbstractFactory.taxes;

public class ChisinauCityFee implements Fee {

    @Override
    public void informAboutFee() {
        System.out.println("Starting from 50 lei");
    }
}
