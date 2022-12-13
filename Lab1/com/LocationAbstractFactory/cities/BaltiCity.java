package com.LocationAbstractFactory.cities;

public class BaltiCity implements City {

    @Override
    public void makeCommand () {
        System.out.println("Searching a taxi around Balti");
    }
}