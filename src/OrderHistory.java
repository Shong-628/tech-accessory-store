import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderHistory {
    private List<Order> orderHistory; // List to store all receipts (order history)
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public OrderHistory() {
        this.orderHistory = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Order History = " + orderHistory;
    }

    // Getter
    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    // Setter
    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    // Add an order to the order history
    public void addOrder(Order order) {
        this.orderHistory.add(order);
    }

    // View order history
    public void viewOrderHistory() {

        if (orderHistory.isEmpty()) {
            System.out.println("No Order History available.");
            return;
        }

        System.out.println("\n-----------------------------------");
        System.out.println("|           Order History:        |");
        System.out.println("-----------------------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.printf("%-5s %-20s %-15s %s%n", "No.", "Payment ID", "Total Price", "Date");

        for (int i = 0; i < orderHistory.size(); i++) {
            Order order = orderHistory.get(i);
            System.out.printf("%-5d %-20s RM%-13.2f %s%n", (i + 1), order.getPaymentID(), order.getTotalPrice(),
                    dateFormat.format(order.getDate()));
        }

        // Call the method to handle user selection after displaying order history
        handleOrderSelection();
    }

    private void handleOrderSelection() {
        boolean exit = false;
        while (exit == false) {
            try {
                System.out.print("\nEnter the order number to view details (or 0 to exit): ");
                int choiceViewOrderHistory = scanner.nextInt();
                scanner.nextLine();

                if (choiceViewOrderHistory == 0) {
                    System.out.println("Going back to Main Menu...");
                    exit = true; // Exit the loop
                } else if (choiceViewOrderHistory > 0 && choiceViewOrderHistory <= orderHistory.size()) {
                    // Valid input, view order details
                    viewOrderDetails(choiceViewOrderHistory - 1);
                } else {
                    // If input is out of range, display an error message
                    System.out.println("Invalid input. Please enter a valid order number. ");
                }
            } catch (InputMismatchException e) {
                // If a non-integer value was entered, handle the error and prompt again
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear input buffer
            }
        }
    }

    // View order details by index
    private void viewOrderDetails(int index) {

        Order order = orderHistory.get(index);
        System.out.println("\n----- Order Details -----");
        System.out.printf("%-5s %-40s %-15s %-10s%n", "No.", "Product Name", "Price (RM)", "Quantity");

        ArrayList<CartItem> items = (ArrayList<CartItem>) order.getOrderDetails();
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            System.out.printf("%-5d %-40s %-15.2f %10d\n", i + 1, item.getProduct().getProductName(),
                    item.getProduct().getPrice(), item.getQuantity());
        }
    }
}