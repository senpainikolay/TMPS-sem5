package com.PaymentStrategy;

    public class OfficeTicket extends PaymentStrategy {
        @Override
        public void pay() {
            System.out.println("Paying in ticket office.");
        }
    }

