package com.vendingmachine;
import java.util.List;
public class ProductsDisplay {
    public void displayProducts(List<Product> products) {
        System.out.println("\nAvailable Products:");
        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + " - Price: $" + product.getPrice() + " - Stock: " + product.getQuantity());
        }
    }
}
