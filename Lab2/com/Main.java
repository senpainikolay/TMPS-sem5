package com;
import com.TaxiFactoryMethod.*;
import com.LocationAbstractFactory.StartApp;
import com.Builders.builders.DetailsTaxiBuilder;
import com.Builders.clientTaxiDetails.TaxiDetails;
import com.Builders.director.Director;
import com.Builders.services.GPSDestination; 

import java.util.Scanner;

public class Main {    
    public static Scanner in = new Scanner(System.in); 
    private static Director director = new Director();  
    static String  typeOfTaxi; 


    public static void main( String[] args ) {    
        // Get Geo Loctions 
        new StartApp().Run();    
        DetailsTaxiBuilder builder = new DetailsTaxiBuilder();         
        new TaxiFactoryController(InputTypeOfTaxi(builder )).Main();   

        TaxiDetails car = builder.getResult();  
        car.printInfo();

    } 

    private static String  InputTypeOfTaxi(DetailsTaxiBuilder builder ){   
        System.out.println("Choose the Type of taxi: \n Type 1 for Simple \n Type 2 for Confort \n Enter: "); 
        int input = in.nextInt();    
        in.nextLine(); 
        System.out.println("Choose your Destination:");  
        String des = in.nextLine();   
        builder.setDestination(new GPSDestination(des));

        if (input == 1) {  
             typeOfTaxi =  "Simple"; 
             director.constructSimpleTaxi(builder);
        } else {  

            typeOfTaxi =  "Confort";   
            director.constructConfortTaxi(builder);
        }    

        return  typeOfTaxi; 
    }

    
}

