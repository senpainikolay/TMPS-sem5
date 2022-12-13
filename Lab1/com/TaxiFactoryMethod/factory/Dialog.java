package com.TaxiFactoryMethod.factory;

import com.TaxiFactoryMethod.taxi.Taxi;

public abstract class Dialog {

    public void commandTaxi() {

        Taxi taxi  = createTaxi();
        taxi.Command();
    }

    public abstract Taxi createTaxi();
}