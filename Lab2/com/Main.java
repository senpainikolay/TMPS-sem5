package com;
import com.TaxiFactoryMethod.*;
import com.LocationAbstractFactory.StartApp;

import java.util.Scanner;

public class Main {    
    public static Scanner in = new Scanner(System.in);


    public static void main( String[] args ) {    
        // Get Geo Loctions 
        new StartApp().Run();           
        new TaxiFactoryController(InputTypeOfTaxi()).Main();

    } 

    private static String  InputTypeOfTaxi(){   
        System.out.println("Choose the Type of taxi: \n Type 1 for Simple \n Type 2 for Confort \n Enter: "); 
        int input = in.nextInt();  
        if (input == 1) {  
             return "Simple";
        } else {  

            return "Confort"; 
        }   
    }

    
}

