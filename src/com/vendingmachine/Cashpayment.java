package com.vendingmachine;

import java.util.Scanner;

public class Cashpayment implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Total amount to pay: $" + amount);
        System.out.println("Enter amount to pay:");

        Scanner scanner = new Scanner(System.in);
        double enteredAmount = scanner.nextDouble();

        if (enteredAmount < amount) {
            System.out.println("Insufficient amount. Transaction failed!");
            return false;
        }

        System.out.println("Payment Successful! Thank you.");
        double change = enteredAmount - amount;

        if (change > 0) {
            System.out.printf("Please collect your change: $%.2f\n", change);
        }
        return true;
    }
}
