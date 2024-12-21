# Vending Machine Project

## Project Overview
This project implements a **Modern Vending Machine** system designed to emulate a shopping cart experience. Users can interact with the vending machine through a menu-driven interface, either as a **Buyer** or a **Vendor**. The Buyer can browse products, add them to the cart, and proceed to checkout, while the Vendor can add, restock, or remove products.

The project has been developed using **Java**.

---

## Features
### Buyer Features:
1. **View Products:** Displays all available products with their details (name, price, and stock).
2. **Add Products to Cart:** Allows the Buyer to add products and specify quantities.
3. **View Cart:** Displays the items in the cart, quantities, and total prices.
4. **Remove Products from Cart:** Enables the Buyer to remove specific products or quantities.
5. **Checkout:** Processes payments and dispenses products.

### Vendor Features:
1. **Add New Product:** Vendors can add new products to the repository.
2. **Restock Products:** Vendors can increase the stock of existing products.
3. **Remove Products:** Vendors can remove specific products from the repository.

### Additional Features:
- **Lock Manager:** Ensures the machine is locked during maintenance or item dispensing.
- **Payment Processing:** Supports cash-based payment.
- **Cart Management:** Allows Buyers to modify their cart dynamically.
- **Clear Cart:** Removes all items from the cart.

---

## Classes and Interfaces
### **Main**
The entry point of the application. It initializes the vending machine menu with the required components.

### **Cart**
Handles the addition, removal, and clearing of products in the cart.

### **CartDisplay**
Interface for displaying cart details.
- Implementation: `CartDisplayNormal`

### **CartOperations**
Interface defining cart-related operations such as add, remove, and clear.

### **CartTotal**
Calculates the total cost of items in the cart.

### **CashPayment**
Implements the `PaymentProcessor` interface for cash-based payments.

### **Menu**
Manages the main menu for Buyers and delegates tasks to the appropriate components.

### **LockManager**
Handles locking and unlocking of the vending machine during sensitive operations (e.g., dispensing products).

### **Product**
Represents individual products with attributes like ID, name, price, and quantity.

### **ProductRepository**
Manages the storage, retrieval, and modification of products.

### **ProductsDisplay**
Displays a list of all products to the Buyer.

### **Supplier**
Handles Vendor-specific operations such as adding, restocking, and removing products.

### **SupplierMenu**
Manages the menu interface for Vendors.

---
This design implements a modern vending machine with a cart-based system, combining simplicity and modularity. Here's an overview of key design choices:

## 1. Separation of Concerns
- **Cart, ProductRepository, Supplier** : Focused on specific functionalities such as managing products, cart operations, and supplier tasks.
- **Interfaces (CartOperations, CartDisplay, PaymentProcessor)**: Promote flexibility for alternative implementations.

## 2. Extensibility
- **Cart and Display** interface allows different cart views (e.g., `CartDisplayNormal`) without altering core logic.
- **Payment Processor** interface supports multiple payment methods like `CashPayment` and can be extended for card or digital payments.

## 3. Lock Management
- The `LockManager` ensures safe operation during maintenance or checkout by locking/unlocking the system.

## 4. Thread Safety
- Synchronization in `LockManager` prevents race conditions during concurrent operations.

---

## Future Improvements
1. **Payment Gateway Integration:** Add support for card payments and online wallets.
2. **GUI Interface:** Replace console-based interaction with a graphical user interface.
3. **Product Categories:** Organize products into categories for easier browsing.
4. **Advanced Locking:** Use more sophisticated locking mechanisms.


