package com.vendingmachine;
import java.util.*;
public class CartTotal {

    public double calculateTotal(Cart cart) {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.getCartItems().entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
