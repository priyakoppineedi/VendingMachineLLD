package com.vendingmachine;

import java.util.Optional;

public class Supplier {

    private final ProductRepository productRepository;

    public Supplier(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Add a new product
    public void addProduct(String name, double price, int quantity) {
        Product newProduct = new Product(productRepository.getNextProductId(), name, price, quantity);
        productRepository.addProduct(newProduct);
        System.out.println("Product added: " + newProduct.getName());
    }

    // Restock a product
    public void restockProduct(int productId, int additionalQuantity) {
        Optional<Product> productOpt = productRepository.findProductById(productId);
        productOpt.ifPresentOrElse(product -> {
            product.setQuantity(product.getQuantity() + additionalQuantity);
            System.out.println("Restocked " + additionalQuantity + " of " + product.getName());
        }, () -> System.out.println("Product not found with ID: " + productId));
    }

    // Remove a product
    public void removeProduct(int productId) {
        boolean removed = productRepository.removeProductById(productId);
        if (removed) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }
}
