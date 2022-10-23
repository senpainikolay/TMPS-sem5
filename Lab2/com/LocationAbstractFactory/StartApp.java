package com.LocationAbstractFactory; 

import com.LocationAbstractFactory.app.Application;
import com.LocationAbstractFactory.factories.*; 

public class StartApp {

    private static Application configureApplication() {
        Application app;
        CityFeeInformFactory factory; 
        String GetLocationFromUserIp = "Chisinau"; 
        if (GetLocationFromUserIp.contains("Chisinau")) {
            factory = new ChisinauFactory();
        } else if (GetLocationFromUserIp.contains("Balti")) {
            factory = new BaltiFeeFactory();
        } else {  
        System.out.print("City not found by Geo Location!"); 
        System.exit(0);  
          factory = new ChisinauFactory(); 
        }
        app = new Application(factory);
        return app; 
    }

    public  void Run() {
        Application app = configureApplication();
        app.runInformFactory();
    } 

} 
