package com.vendingmachine;

public interface CartOperations {
    boolean addProduct(Product product, int quantity);
    void removeProduct(Product product, int quantity);
    void clearCart();
}