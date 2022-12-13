package com.TaxAddVisitor;

public class Bed extends IProduct{
    private double price;
    @Override
    public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void accept(IVisitor visitorObj) {
        visitorObj.visit(this);
    }
}
