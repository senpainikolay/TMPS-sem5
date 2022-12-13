package com.TaxAddVisitor;


public abstract class IProduct {
    abstract public void setPrice(double price);
    abstract public double getPrice();
    abstract public void accept(IVisitor price);
}