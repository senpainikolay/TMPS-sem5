package com.TaxiFactoryMethod;

import com.TaxiFactoryMethod.factory.ConfortTaxiDialog;
import com.TaxiFactoryMethod.factory.Dialog;
import com.TaxiFactoryMethod.factory.SimpleTaxiDialog;

public class TaxiFactoryController {
    private static Dialog dialog;  
    public  String Choise = "Confort";  

    public TaxiFactoryController( String Choise){ 
        this.Choise = Choise; 
     }
    
    public void Main() {
        configureTypeOfTaxi(); 
        callTheDialog();
    }
    private  void configureTypeOfTaxi() { 
        if  ( Choise == "Confort") {
            dialog = new ConfortTaxiDialog();
        } else {
            dialog = new SimpleTaxiDialog();
        }
    }

    static void callTheDialog() {
        dialog.commandTaxi();
    }
}