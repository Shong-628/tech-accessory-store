import java.util.InputMismatchException;
import java.util.Scanner;

public class Payment {
    private ArrayCart cart;
    private double totalPrice;
    private static double taxRate = 6; // 6% tax
    private double tax;
    private static String discountCode = "DISCOUNT10";
    private static double discountRate = 10; // 10%
    private double discountAmount;
    private double totalAmount;

    private String paymentMethod;

    private static Scanner scanner = new Scanner(System.in);

    public Payment() {
        this.cart = new ArrayCart();
        this.totalPrice = 0.0;
        this.tax = 0.0;
        this.discountAmount = 0.0;
        this.totalAmount = calTotalAmount();
        this.paymentMethod = "";
    }

    public Payment(ArrayCart cart) {
        this.cart = cart;
        this.totalPrice = cart.getTotalPrice();
        this.tax = 0.0;
        this.discountAmount = 0.0;
        this.totalAmount = calTotalAmount();
        this.paymentMethod = "";
    }

    // Getter & Setter
    public ArrayCart getCart() {
        return cart;
    }

    public void setCart(ArrayCart cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public static boolean setTaxRate(double taxRate) {
        // Validation to prevent negative tax rate
        if (taxRate >= 0 && taxRate <= 100) {
            Payment.taxRate = taxRate;
            return true;
        } else {
            System.out.println("Tax rate cannot be less than 0 or more than 100.");
            return false;
        }
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public static String getDiscountCode() {
        return discountCode;
    }

    public static void setDiscountCode(String discountCode) {
        Payment.discountCode = discountCode;
    }

    public static double getDiscountRate() {
        return discountRate;
    }

    public static void setDiscountRate(double discountRate) {
        Payment.discountRate = discountRate;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "\nPayment " +
                "\nCart =" + cart +
                "\nTotal Price =" + totalPrice +
                "\nTax =" + tax +
                "\nDiscount Amount =" + discountAmount +
                "\nTotal Amount =" + totalAmount +
                "\nPayment Method =" + paymentMethod;
    }

    // Method to calculate tax amount
    private double calTax() {
        return (totalPrice - discountAmount) * (Payment.taxRate / 100); // 6% tax
    }

    // Method to calculate Total amount
    private double calTotalAmount() {
        tax = calTax();
        return (totalPrice - discountAmount) + tax;
    }

    // Method to calculate discount amount
    private double calDiscountAmount() {
        return (totalPrice * discountRate / 100); // % discount
    }

    // Method to prompt user to apply discount
    public void applyDiscount() {
        String response = "";
        while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("yes")
                && !response.equalsIgnoreCase("no")) {
            System.out.print("Do you have a promo/discount code? (Y/N): ");
            response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes")) {
                System.out.print("Enter your promo code: ");
                String userCode = scanner.nextLine();
                validatePromoCode(userCode);
            } else if (response.equalsIgnoreCase("N") || response.equalsIgnoreCase("no")) {
                this.discountAmount = 0.0;
                System.out.println("No discount code applied.");
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }

    // Validate the promo code and apply this discount
    private void validatePromoCode(String userCode) {
        if (userCode.trim().equalsIgnoreCase(discountCode)) {
            this.discountAmount = calDiscountAmount();
            System.out.printf("Promo code applied. You saved RM %.2f\n ", discountAmount);
        } else {
            this.discountAmount = 0.0;
            System.out.println("Invalid promo code. No discount applied.");
        }
    }

    public void processPaymentMethod() {
        boolean validInput = false;
        while (validInput == false) {
            try {
                // Display payment options
                System.out.println("\n1. Touch N Go");
                System.out.println("2. Bank Transfer");
                System.out.println("3. Credit Card");
                System.out.print("Choose Payment Method: ");

                // Attempt to read an integer from the user
                int paymentChoice = scanner.nextInt();
                scanner.nextLine();

                // Handle valid payment options
                if (paymentChoice == 1) {
                    processTNGPayment();
                    validInput = true;
                } else if (paymentChoice == 2) {
                    processBankTransfer();
                    validInput = true;
                } else if (paymentChoice == 3) {
                    processCreditCardPayment();
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number (1-3)");
                }

            } catch (InputMismatchException ex) {
                // Handle invalid input (non-integer input like characters)
                System.out.println("Invalid input. Please enter a number (1-3).");
                scanner.nextLine();
            }
        }
    }

    // Method to process Touch'n Go payment
    private void processTNGPayment() {
        boolean validInput = false;
        while (validInput == false) {
            System.out.print("Enter your TNG PIN (6-digit): ");
            String tngPin = scanner.nextLine();

            // Check if the input is a valid 6-digit PIN
            if (tngPin.matches("\\d{6}")) {
                System.out.println("TNG PIN accepted.");
                validInput = true;
            } else {
                System.out.println("Invalid TNG PIN. Please enter a (6-digit) numeric PIN.");
            }
        }
        paymentMethod = "Touch N Go";
    }

    // Method to process Bank Transfer payment
    private void processBankTransfer() {
        boolean validInput = false;
        while (validInput == false) {
            System.out.print("Enter your Bank Account Number (10-14 digits): ");
            String bankAccount = scanner.nextLine();

            // Check if the input is valid (10-14 digits)
            if (bankAccount.matches("\\d{10,14}")) {
                System.out.println("Bank Account accepted.");
                validInput = true;
            } else {
                System.out.println("Invalid Bank Account Number. Please enter a valid number (10-14 digits).");
            }
        }
        paymentMethod = "Bank Transfer";
    }

    // Method to process Credit Card payment
    private void processCreditCardPayment() {
        boolean validInput = false;
        while (validInput == false) {
            System.out.print("Enter your Credit Card Number (16-digit): ");
            String creditCartNum = scanner.nextLine();

            // Check if the input is a valid 16-digit number
            if (creditCartNum.matches("\\d{16}")) {
                processCVV();
                validInput = true;
            } else {
                System.out.println("Invalid Credit Card Number. Please enter a valid 16-digit number.");
            }
        }
        paymentMethod = "Credit Card";
    }

    // Method to process CVV for credit card payments
    private void processCVV() {
        boolean validInput = false;
        while (validInput == false) {
            System.out.print("Enter your CVV (3-digit): ");
            String cvv = scanner.nextLine();

            // Check if the input is a valid 3-digit CVV
            if (cvv.matches("\\d{3}")) {
                System.out.println("Credit Card CVV accepted.");
                validInput = true;
            } else {
                System.out.println("Invalid CVV. Please enter a 3-digit numeric CVV.");
            }
        }
    }

    // Method to select payment method and process payment
    public void processPayment(OrderHistory orderHistory) {
        // Apply discount before calculating total amount
        applyDiscount();
        this.totalAmount = calTotalAmount();

        double totalPriceAfterDiscount = totalPrice - discountAmount;

        System.out.println();
        System.out.printf("%-32s RM %12.2f\n", "Total Price (Before Discount):", totalPrice);
        System.out.printf("%-32s RM %12.2f\n", "Discount Applied:", discountAmount);
        System.out.printf("%-32s RM %12.2f\n", "Total Price (After Discount):", totalPriceAfterDiscount);
        System.out.printf("%-32s RM %12.2f\n", "Tax (" + (Payment.getTaxRate()) + "%):", tax);
        System.out.printf("%-32s RM %12.2f\n", "Total Amount :", totalAmount);

        // Call the method to select the payment method
        processPaymentMethod();

        // Display payment success message
        System.out.println("Payment Successful!");

        // After payment, generate receipt
        Receipt receipt = new Receipt(cart, totalPrice, tax, discountAmount, totalAmount, paymentMethod);
        receipt.saveOrder(orderHistory);
        receipt.printReceipt();
    }
}