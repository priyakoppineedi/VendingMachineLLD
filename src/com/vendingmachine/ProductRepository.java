package com.vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Optional<Product> findProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }

    public boolean removeProductById(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    public int getNextProductId() {
        return products.size() + 1;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
