package com.TaxiFactoryMethod.taxi;

import com.Main; 


public class ConfortTaxi implements Taxi {  
    private int conditionerDegree;   
    private void InformAboutConditioner() { 
     System.out.printf("Conditioner set at %s ", conditionerDegree);       
    }  

    private void SetConditionerTaxi ( int dg )  { 
        this.conditionerDegree = dg;  
        InformAboutConditioner(); 
    }
    public void Command() {    
        System.out.println("\n Please choose the degree of the conditioner: ");
        int input = Main.in.nextInt();  
        Main.in.close(); 
        SetConditionerTaxi(input);  

    } 

    }