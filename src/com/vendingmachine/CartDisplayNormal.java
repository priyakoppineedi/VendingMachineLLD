package com.vendingmachine;

public class CartDisplayNormal implements CartDisplay {

    public void displayCart(Cart cart) {
        if (cart.getCartItems().isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("Cart Items:");
        cart.getCartItems().forEach((product, quantity) -> {
            System.out.println(product.getName() + " - Quantity: " + quantity
                    + ", Total Price: " + product.getPrice() * quantity);
        });
    }
}
