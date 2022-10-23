package com.TaxiFactoryMethod.factory;

import com.TaxiFactoryMethod.taxi.ConfortTaxi;
import com.TaxiFactoryMethod.taxi.Taxi;

public class ConfortTaxiDialog extends Dialog {

    @Override
    public Taxi createTaxi() {
        return new ConfortTaxi();
    }
}