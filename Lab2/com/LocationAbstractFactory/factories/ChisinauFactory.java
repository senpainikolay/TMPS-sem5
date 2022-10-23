package com.LocationAbstractFactory.factories; 

import com.LocationAbstractFactory.cities.*;
import com.LocationAbstractFactory.taxes.*;

public class ChisinauFactory implements CityFeeInformFactory {

    @Override
    public City chooseCity() {
        return new ChisinauCity();
    }

    @Override
    public Fee createFee() {
        return new ChisinauCityFee();
    }
}
