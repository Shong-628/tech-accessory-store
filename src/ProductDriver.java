import java.util.Scanner;

public class ProductDriver {
    // Declare scanner for user input
    private static Scanner input = new Scanner(System.in);

    public static void productDriver(ArrayCart cart, boolean isAdmin) {
        // Get Product Array
        Product[] productsArray = ProductPage.getProductsArray();

        // Display all products
        System.out.println("\nProducts Page (All Products):");
        ProductPage.displayProducts(productsArray);

        boolean exitProduct = false;
        while (exitProduct == false) {
            // Display product Main Menu
            if (isAdmin == true) {
                ProductPage.displayProductMainMenu(isAdmin);
            } else {
                ProductPage.displayProductMainMenu();
            }
            

            System.out.print("\nEnter your option (0-9): ");
            // User input
            String prodMenuInput = input.nextLine().trim();

            // Perform action based on user input
            switch (prodMenuInput) {
                case "0":
                    // Back to Main Menu, exiting product Menu
                    exitProduct = true;
                    break;

                case "1":
                    // View Product and Buy Product
                    // Check if user is Admin, display a different View product without purchase
                    if (isAdmin == true) {
                        // View Product for Admin
                        ProductPage.viewProduct(isAdmin);
                    } else {
                        // View Product for Customer
                        ProductPage.viewProduct(cart);
                    }
                    break;

                case "2":
                    // Sort products alphabetically
                    ProductPage.sortByName();
                    break;

                case "3":
                    // Sort by Stock Quantity
                    ProductPage.sortByStockQuantity();
                    break;

                case "4":
                    // Sort by Price
                    ProductPage.sortByPrice();
                    break;

                case "5":
                    // Filter by Price
                    ProductPage.filterByPrice();
                    break;

                case "6":
                    // Filter by Stock Quantity
                    ProductPage.filterByStockQuantity();
                    break;

                case "7":
                    // Filter by Category
                    ProductPage.filterByCategory();
                    break;

                case "8":
                    // Search by Name/Brand
                    ProductPage.filterBySearch();
                    break;

                case "9":
                    // Display all products
                    ProductPage.displayProducts(productsArray);
                    break;

                default:
                    System.out.println("Invalid option entered. Please enter option (0-9).");
                    break;
            }
        }
    }

    // (Admin Product Driver)
    public static void productDriver(boolean isAdmin) {
        ArrayCart emptyCart = new ArrayCart();
        productDriver(emptyCart, isAdmin);
    }

}
