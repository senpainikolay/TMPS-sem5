package com.PaymentStrategy;

public class Paypal extends PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Paying with paypal.");
    }
}
