package com.TaxiFactoryMethod.factory;

import com.TaxiFactoryMethod.taxi.SimpleTaxi;
import com.TaxiFactoryMethod.taxi.Taxi;

public class SimpleTaxiDialog extends Dialog {

    @Override
    public Taxi createTaxi() {
        return new SimpleTaxi();
   
}
}