package org.example;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy){
        this.strategy = paymentStrategy;
    }

    public void executePayment(double amount){
        strategy.processPayment(amount);
    }

}
