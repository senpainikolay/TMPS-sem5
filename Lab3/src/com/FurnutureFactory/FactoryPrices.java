package com.FurnutureFactory;

import com.TaxAddVisitor.*;

public class FactoryPrices {
    private static TaxVisitor addTax;
    private int sale;

    public FactoryPrices() {
        addTax = new TaxVisitor();
        sale = 0;
    }

    public void SetSale( int sale ){
        this.sale = sale;
    }
    public int GetSale(){
       return this.sale;
    }

    public double CalculateChairFinalPrice(int price){
        IProduct chair = new Chair();
        chair.setPrice(price);
        chair.accept(addTax);
        return chair.getPrice() - (chair.getPrice() * this.sale) / 100  ;
    }

    public double CalculateBedFinalPrice(int price ){
        IProduct bed = new Bed();
        bed.setPrice(price);
        bed.accept(addTax);
        return bed.getPrice() - (bed.getPrice() * this.sale) / 100;
    }


}
