package com.PaymentStrategy;

public class TicketCompany {
    private PaymentStrategy ourStrategy;

    public TicketCompany(PaymentStrategy ourStrategy) {
        this.ourStrategy = ourStrategy;
    }

    public void pay(){
        ourStrategy.pay();
    }
}