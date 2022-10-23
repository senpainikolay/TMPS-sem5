package com.LocationAbstractFactory.app; 
import com.LocationAbstractFactory.cities.City;
import com.LocationAbstractFactory.factories.CityFeeInformFactory;
import com.LocationAbstractFactory.taxes.Fee;


public class Application {
    private City city;
    private Fee fee;

    public Application(CityFeeInformFactory factory) {
        city = factory.chooseCity();
        fee = factory.createFee();
    }

    public void runInformFactory() {
        city.makeCommand();;
        fee.informAboutFee();
    }
}
