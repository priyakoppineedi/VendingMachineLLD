package com.vendingmachine;

import java.util.Scanner;

public class SupplierMenu {
    private final Supplier vendor;
    private final Scanner scanner;

    public SupplierMenu(ProductRepository productRepository) {
        this.vendor = new Supplier(productRepository);
        this.scanner = new Scanner(System.in);
    }

    public void showVendorMenu() {
        while (true) {
            System.out.println("\n========================");
            System.out.println("1. Add New Product");
            System.out.println("2. Restock Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Return to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addNewProduct();
                case 2 -> restockProduct();
                case 3 -> removeProduct();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewProduct() {
        System.out.print("Enter product name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        vendor.addProduct(name, price, quantity);
    }

    private void restockProduct() {
        System.out.print("Enter product ID to restock: ");
        int id = scanner.nextInt();

        System.out.print("Enter quantity to add: ");
        int quantity = scanner.nextInt();

        vendor.restockProduct(id, quantity);
    }

    private void removeProduct() {
        System.out.print("Enter product ID to remove: ");
        int id = scanner.nextInt();

        vendor.removeProduct(id);
    }
}
