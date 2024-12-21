package com.vendingmachine;

import java.util.Scanner;

public class Menu {
    private final LockManager lockManager;
    private final ProductRepository productRepository;
    private final Cart cart;
    private final ProductsDisplay productsDisplay;
    private final CartDisplay cartDisplay;
    private final PaymentProcessor paymentProcessor;
    private final CartTotal cartTotal;
    private final Scanner scanner;

    public Menu(CartDisplay cartDisplay, PaymentProcessor paymentProcessor) {
        this.lockManager = new LockManager(); // Initialize LockManager
        this.productRepository = new ProductRepository();
        this.cart = new Cart();
        this.productsDisplay = new ProductsDisplay();
        this.cartDisplay = cartDisplay;
        this.paymentProcessor = paymentProcessor;
        this.cartTotal = new CartTotal();
        this.scanner = new Scanner(System.in);

        productRepository.addProduct(new Product(1, "Coke", 1.50, 10));
        productRepository.addProduct(new Product(2, "Chips", 2.00, 5));
        productRepository.addProduct(new Product(3, "Candy", 1.00, 20));
    }

    public void start() {
        while (true) {
            System.out.println("\nVending Machine Menu");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Products from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Supplier");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> productsDisplay.displayProducts(productRepository.getAllProducts());
                case "2" -> addProductToCart();
                case "3" -> cartDisplay.displayCart(cart);
                case "4" -> removeproducts();
                case "5" -> checkout();
                case "6" -> showVendorMenu();
                case "7" -> {
                    System.out.println("Thank you for using the vending machine!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addProductToCart() {
        if (lockManager.isLocked()) {
            System.out.println("The vending machine is currently locked. Please wait.");
            return;
        }
        System.out.print("Enter product ID to add: ");
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid product ID.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity;
        try {
            quantity = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid quantity.");
            scanner.nextLine();
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }

        Product product = productRepository.findProductById(id).orElse(null);

        if (product == null) {
            System.out.println("Invalid product ID.");
            return;
        }

        if (cart.addProduct(product, quantity))
            System.out.println("Added to cart: " + product.getName());
    }

    private void checkout() {
        if (lockManager.isLocked()) {
            System.out.println("The vending machine is currently locked. Please wait.");
            return;
        }

        double total = cartTotal.calculateTotal(cart);
        System.out.println("Your total is: $" + total);

        if (paymentProcessor.processPayment(total)) {
            lockManager.lock(); // Lock the interface
            System.out.println("Dispensing your items. Please wait...");
            try {
                Thread.sleep(5000);
                System.out.println("Please collect your items and change within 10 seconds...");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred during the dispensing process.");
            } finally {
                lockManager.unlock();
            }
            cart.clearCart();
            System.out.println("Thank you for your purchase!");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }


    private void removeproducts() {
        if (cart.iscartempty()) {
            System.out.println("Cart is Empty!");
            return;
        }
        System.out.print("Enter product ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter quantity to remove: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Product product = productRepository.findProductById(id).orElse(null);
        if (product == null) {
            System.out.println("Invalid product ID.");
            return;
        }
        cart.removeProduct(product, quantity);
    }


    private void showVendorMenu() {
        if (lockManager.isLocked()) {
            System.out.println("The vending machine is currently locked. Please wait.");
            return;
        }
        lockManager.lock();
        try {
            SupplierMenu vendorMenu = new SupplierMenu(productRepository);
            vendorMenu.showVendorMenu();
        } finally {
            lockManager.unlock();
        }
    }

}
