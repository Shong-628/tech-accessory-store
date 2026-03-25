import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayCart {
    private ArrayList<CartItem> cart;
    private static Scanner input = new Scanner(System.in);
    private static Product[] productsArray;

    // Constructor
    public ArrayCart() {
        cart = new ArrayList<>();
    }

    // Getter & Setter
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public void setCart(ArrayList<CartItem> cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be set to null values.");
        }
        this.cart = cart;
    }

    public static Product[] getProductsArray() {
        return productsArray;
    }

    public static void setProductsArray(Product[] productsArray) {
        ArrayCart.productsArray = productsArray;
    }

    // To String Method
    @Override
    public String toString() {
        return "Cart =" + cart;
    }

    // Method to add item to cart
    public void addItem(Product product, int userQuantity) {
        if (userQuantity < 0) {
            throw new IllegalArgumentException("Invalid Quantity. Please add at least 1 item.");
        }

        boolean itemExists = false;

        // Check if the item is already in the cart
        for (CartItem item : cart) {
            if (item.getProduct().getProductName().equals(product.getProductName())) {
                // If the product is already in the cart, update the quantity
                int newQuantity = item.getQuantity() + userQuantity;
                try {
                    item.setQuantity(newQuantity);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                itemExists = true;
                break;
            }
        }

        // If the item is not in the cart, add it as a new CartItem
        if (!itemExists) {
            CartItem cartItem = new CartItem(product, userQuantity);
            cart.add(cartItem);
        }

        System.out.println(userQuantity + " " + product.getProductName() + " succesfully added to your Shopping Cart.");
    }

    // Method to check if cart is empty
    public boolean isEmpty() {
        return cart.isEmpty();
    }

    // Method to clear cart
    public void clearCart() {
        cart.clear();
    }

    // Method to view cart
    public void viewCart() {
        CartDisplay.displayCart(this);
    }

    // Method to remove item from cart
    public void removeItem() {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        if (cart.isEmpty()) {
            System.out.println(RED + "\nYour cart is empty. Nothing to remove" + RESET);
            return;
        }

        boolean validInput = false;
        while (validInput == false) {
            System.out.print("\nEnter the item number you want to remove: ");
            try {
                int itemNumber = input.nextInt() - 1;
                if (itemNumber >= 0 && itemNumber < cart.size()) {
                    System.out.println(
                            "\nRemoving " + cart.get(itemNumber).getProduct().getProductName() + " from the cart.");
                    cart.remove(itemNumber);
                    validInput = true;
                } else {
                    System.out.println(RED + "\nInvalid item number." + RESET);
                }

            } catch (InputMismatchException ex) {
                System.out.println(RED + "\nInvalid input, please enter a valid number." + RESET);
                input.nextLine(); // Clear input buffer
            }
        }
    }

    // Method to get total price of items in cart
    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    // Update the stock quantity of product page (deduct quantity of stock after
    // check out)
    public void updateStock() {
        for (CartItem item : cart) {
            // Product ID = index + 1
            int index = Integer.parseInt(item.getProduct().getProductID()) - 1;
            int minusQuantity = item.getQuantity();
            productsArray[index].minusStockQuantity(minusQuantity);
        }
    }
}