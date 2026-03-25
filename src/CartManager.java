import java.util.Scanner;

// Handles USER interaction
public class CartManager {
    private static Scanner input = new Scanner(System.in);

    public static boolean manageCart(ArrayCart cart, OrderHistory orderHistory) {
        boolean inCartMenu = true;
        while (inCartMenu) {
            System.out.println("\n-----------------------------------");
            System.out.println("|           Cart Option:          |");
            System.out.println("-----------------------------------");
            System.out.println("| [1] Add more item               |");
            System.out.println("| [2] Remove item                 |");
            System.out.println("| [3] Process payment             |");
            System.out.println("| [0] Back to main menu           |");
            System.out.println("-----------------------------------");
            System.out.print("Please enter the number (0-3): ");

            String cartOption = input.nextLine();
            switch (cartOption) {
                case "1" -> {
                    return true;
                    // return true to be redirected to product page
                }

                case "2" -> {
                    // Only Display cart if the cart is not empty
                    if (!cart.isEmpty()) {
                        cart.viewCart();
                    }
                    // Remove item from cart and view the cart again
                    cart.removeItem();
                    // Show cart again
                    if (!cart.isEmpty()) {
                        cart.viewCart();
                    }
                }

                case "3" -> {
                    // Proceedig to payment and the checkout process
                    if (cart.isEmpty()) {
                        System.out.println("\nYour cart is empty! Cannot proceed to payment.");
                    } else {
                        System.out.println("Proceeding to payment...");
                        Payment payment = new Payment(cart);
                        payment.processPayment(orderHistory);

                        // Update quantity of stock
                        cart.updateStock();

                        // clear the cart after payment is finished
                        cart.clearCart();
                        System.out.println("\nCart has beeen cleared after payment.");
                        inCartMenu = false;
                    }
                }

                case "0" -> inCartMenu = false; // exit the cart menu
                default -> System.out.print("Invalid option. Please enter a valid number (0-3).");
            }
        }
        return inCartMenu;
    }
}
