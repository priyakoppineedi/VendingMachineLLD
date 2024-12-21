package com.vendingmachine;

public interface PaymentProcessor {
    boolean processPayment(double amount);
}
