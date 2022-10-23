package com.LocationAbstractFactory.factories; 
import com.LocationAbstractFactory.cities.City;
import com.LocationAbstractFactory.taxes.Fee; 


    public interface CityFeeInformFactory {
        City chooseCity();
        Fee createFee();
    }


    

