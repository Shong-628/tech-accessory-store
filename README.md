# Tech Accessory Store (CLI Java Application)

## Project Description

**Tech Accessory Store** is a fully console-based Java application that simulates an end-to-end shopping system for computer accessories. The system is designed to demonstrate core Object-Oriented Programming (OOP) principles along with robust input validation and error handling.

Users can browse products, manage a shopping cart, process payments, and view order history, while administrators can manage product details and system configurations such as tax rates. The application is entirely built using core Java without external frameworks, focusing on clean architecture and maintainability.

The program starts execution from:

```
MainPage.java
```

---

## Features

### Customer Features

* User registration and login system
* Browse and view product catalog
* Search and filter products (by name, brand, category, price, stock)
* Add/remove items from shopping cart
* Real-time cart total calculation
* Simulated checkout process with:

  * Discount code support
  * Tax calculation
  * Multiple payment methods (TNG, Bank Transfer, Credit Card)
* View detailed order history
* Edit user profile (username, password, contact, etc.)

### Admin Features

* Admin authentication system
* Edit product details:

  * Name, description, brand
  * Price and stock quantity
* View detailed product information
* Modify global tax rate

### System Features

* Strong input validation using exception handling
* Modular design with separation of concerns
* Dynamic cart and order management using collections
* Sorting and filtering system for products
* Console UI with structured menus and formatted output

---

## Screenshots / Demo

> Since this is a CLI-based application, below is a sample interaction flow:

```
-----------------------------------
|          User Option:           |
-----------------------------------
| [1] Admin                       |
| [2] Customer                    |
| [0] Exit                        |
-----------------------------------
Enter your choice: 2

-----------------------------------
|        Customer Option:         |
-----------------------------------
| [1] Login                       |
| [2] Register                    |
| [0] Exit                        |
-----------------------------------
```

```
+-------------------------------------------------------------+
|           Welcome to BEN10 Computer Accessories:            |
+-------------------------------------------------------------+
[1] View Products
[2] View Shopping Cart
[3] View Order History
[4] Edit Profile
[5] Logout
```

```
Items in your cart
------------------------------------------------------------
No.   Item                         Quantity   Price    Total
------------------------------------------------------------
1     Wireless Mouse               2          79.00    158.00

Total Price (RM): 158.00
```

---

## OOP Concepts Used

### 1. Encapsulation

* Data hiding using private attributes with public getters/setters
* Validation logic embedded within setters (e.g., price, stock limits)

### 2. Inheritance

* Base abstract class: `Product`
* Derived classes:

  * `ProductAudio`
  * `ProductKeyboard`
  * `ProductMonitor`
  * `ProductMouse`
* Promotes code reuse and hierarchical structure

### 3. Polymorphism

* Method overriding:

  * `getProductDetails()` implemented differently in each product type
* Method overloading:

  * Multiple setters and constructors
* Dynamic behavior when handling different product types

### 4. Abstraction

* Abstract class `Product` defines common structure and behavior
* Hides implementation details while exposing essential functionality

---

## Error Handling

The system demonstrates **robust and elegant error handling**, including:

* `try-catch` blocks for user input validation
* Handling `InputMismatchException` for invalid input types
* Throwing custom `IllegalArgumentException` for:

  * Invalid product data
  * Invalid quantities and prices
  * Incorrect user inputs
* Continuous prompting until valid input is received

---

## How to Run

This is a simple CLI-based Java application and does not require any additional setup beyond a Java-supported IDE.

### Run using Visual Studio Code (Recommended)

1. Open the project folder in **Visual Studio Code**
2. Ensure you have the **Java Extension Pack** installed
3. Locate the file:
   MainPage.java
4. Press **F5** or click **Run** to start the program

### Notes

* No external libraries or dependencies are required
* The application runs entirely in the terminal/console
* Make sure Java is properly installed on your system (JDK 8 or above)

---

## 📂 Project Structure

```
tech-accessory-store/
└── src/
    ├── MainPage.java           → Application entry point
    ├── MenuPage.java           → Customer main menu navigation
    ├── AdminPage.java          → Admin functionalities and controls

    ├── User.java               → Base user class
    ├── Customer.java           → Customer model (inherits from User)
    ├── Register.java           → User registration handling
    ├── LoginPage.java          → Authentication logic
    ├── EditProfilePage.java    → Profile editing functionality

    ├── Product.java            → Abstract base class for all products
    ├── ProductAudio.java       → Audio product subclass
    ├── ProductKeyboard.java    → Keyboard product subclass
    ├── ProductMonitor.java     → Monitor product subclass
    ├── ProductMouse.java       → Mouse product subclass
    ├── ProductPage.java        → Product creation and display logic
    ├── ProductDriver.java      → Product interaction controller
    ├── ProductFilter.java      → Sorting, filtering, and search logic

    ├── ArrayCart.java          → Shopping cart implementation
    ├── CartItem.java           → Cart item model
    ├── CartDisplay.java        → Cart UI display
    ├── CartManager.java        → Cart interaction controller

    ├── Payment.java            → Payment processing logic
    ├── Receipt.java            → Receipt generation and output

    ├── Order.java              → Order model
    └── OrderHistory.java       → Order tracking and history
```

---

## 👨‍💻 Authors

* Leow Shi Hao
* Cheh Shu Hong
* Chong Yu Xuan
* Ng Zhi Ling

---

## Notes

* This project is built purely with **core Java (no frameworks)**.
* Designed for academic purposes to demonstrate OOP mastery and system design.
* Emphasis on clean code, modularity, and user interaction handling.

The **Tech Accessory Store CLI Application** showcases a complete, real-world simulation of an e-commerce system while emphasizing strong OOP design and reliable error handling. It serves as a solid foundation for transitioning into GUI-based or web-based systems in the future.
