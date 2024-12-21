package com.vendingmachine;

public class Main {
    public static void main(String[] args) {
        CartDisplay cartDisplay = new CartDisplayNormal();
        PaymentProcessor paymentProcessor = new Cashpayment();
        Menu vendingMachineMenu = new Menu(cartDisplay, paymentProcessor);
        vendingMachineMenu.start();
    }
}