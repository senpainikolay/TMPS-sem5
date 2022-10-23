package com.LocationAbstractFactory.factories; 
import com.LocationAbstractFactory.cities.*;
import com.LocationAbstractFactory.taxes.*;

public class BaltiFeeFactory implements CityFeeInformFactory {

    @Override
    public City chooseCity() {
        return new BaltiCity();
    }

    @Override
    public Fee createFee() {
        return new BaltiCityFee();
    }
}
