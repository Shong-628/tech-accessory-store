public class CartDisplay {
    public static void displayCart(ArrayCart cart) {
        // ANSI escape codes for colors
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String CYAN = "\u001B[36m";

        if (cart.isEmpty()) {
            System.out.println(RED + "\nYour cart is empty.\n" + RESET);
        } else {
            System.out.println(YELLOW + "\nItems in your cart" + RESET);
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.printf(YELLOW + "%-5s %-30s %-15s %-18s %18s%n" + RESET, "No. ", "Item", "Quantity",
                    "Price per item", "Total Price Per Item");
            System.out.println(
                    "------------------------------------------------------------------------------------------------");

            int itemNumber = 1;
            for (CartItem item : cart.getCart()) {
                String itemName = item.getProduct().getProductName();
                int quantity = item.getQuantity();
                double pricePerItem = item.getProduct().getPrice();
                double totalPricePerItem = quantity * pricePerItem;

                System.out.printf("%-5d" + GREEN + "%-35s" + RESET + "%-17d" + BLUE + "%-18.2f" + RESET + CYAN
                        + "%10.2f%n" + RESET, itemNumber++, itemName, quantity, pricePerItem, totalPricePerItem);
                System.out.println(
                        "------------------------------------------------------------------------------------------------\n");
            }
            System.out.print(BLUE + "Total Price (RM): " + RESET);
            System.out.printf("%.2f", cart.getTotalPrice());
        }
    }
}