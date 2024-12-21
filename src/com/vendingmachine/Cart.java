package com.vendingmachine;
import java.util.HashMap;
import java.util.Map;

public class Cart implements CartOperations {
    private Map<Product, Integer> cartItems;
    public Cart() {
        this.cartItems = new HashMap<>();
    }

    @Override
    public boolean addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return false;
        }
        if (product.getQuantity() < quantity) {
            System.out.println("Not enough stock for product: " + product.getName());
            return false;
        }
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
        product.setQuantity(product.getQuantity() - quantity);
        System.out.println(quantity + " " + product.getName() + "(s) added to the cart.");
        return true;
    }

    @Override
    public void removeProduct(Product product, int quantity) {
        if (!cartItems.containsKey(product)) {
            System.out.println("Product not in cart: " + product.getName());
            return;
        }
        int currentQuantity = cartItems.get(product);
        if (quantity >= currentQuantity) {
            cartItems.remove(product);
            product.setQuantity(product.getQuantity() + currentQuantity);
            System.out.println("Removed all " + product.getName() + "(s) from the cart.");
        } else {
            cartItems.put(product, currentQuantity - quantity);
            product.setQuantity(product.getQuantity() + quantity);
            System.out.println(quantity + " " + product.getName() + "(s) removed from the cart.");
        }
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    public boolean iscartempty(){
        return cartItems.isEmpty();
    }

    public void clearCart() {
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setQuantity(product.getQuantity() + quantity); // Return stock to products
        }
        cartItems.clear();
        System.out.println("Cart cleared successfully.");
    }
}
