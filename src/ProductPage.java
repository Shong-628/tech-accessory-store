import java.util.InputMismatchException;
import java.util.Scanner;

// Utility Class for Product
public class ProductPage {
    private static Product[] productsArray;
    private static Product[] filteredArray;
    private static Scanner input = new Scanner(System.in);

    // Getter and Setter
    public static Product[] getProductsArray() {
        return productsArray;
    }

    public static void setProductsArray(Product[] productsArray) {
        ProductPage.productsArray = productsArray;
    }

    public static Product[] getFilteredArray() {
        return filteredArray;
    }

    public static void setFilteredArray(Product[] filteredArray) {
        ProductPage.filteredArray = filteredArray;
    }

    // Method to Create products
    public static void createProducts(String[][] productsData) {
        // Verify both arrays exist
        if (productsData == null || productsArray == null) {
            System.out.println("Product Data array or Product Array is not found.");
            return;
        }

        for (int i = 0; i < productsData.length; i++) {
            try {

                String productID = String.valueOf(i + 1);
                String productName = productsData[i][1];
                String description = productsData[i][2];
                String brand = productsData[i][3];
                double price = Double.parseDouble(productsData[i][4]);
                int stockQuantity = Integer.parseInt(productsData[i][5]);

                switch (productsData[i][0]) {
                    case "1":
                        productsArray[i] = new ProductAudio(productID, productName, description, brand, price,
                                stockQuantity, Boolean.parseBoolean(productsData[i][6]),
                                productsData[i][7], productsData[i][8],
                                productsData[i][9]);
                        break;

                    case "2":
                        productsArray[i] = new ProductKeyboard(productID, productName, description, brand, price,
                                stockQuantity, Boolean.parseBoolean(productsData[i][6]),
                                productsData[i][7], productsData[i][8],
                                Boolean.parseBoolean(productsData[i][9]));
                        break;

                    case "3":
                        productsArray[i] = new ProductMonitor(productID, productName, description, brand, price,
                                stockQuantity, productsData[i][6], productsData[i][7], productsData[i][8],
                                productsData[i][9]);
                        break;

                    case "4":
                        productsArray[i] = new ProductMouse(productID, productName, description, brand, price,
                                stockQuantity, Boolean.parseBoolean(productsData[i][6]),
                                productsData[i][7], productsData[i][8]);
                        break;

                    default:
                        System.out
                                .println("Product [" + i + "] failed to be created. Product type is unidentified.");
                        break;
                }

            } catch (NumberFormatException ex) {
                System.out.println(
                        "Product [" + i + "] failed to be created. Invalid format for price or stock quantity.");
            } catch (Exception ex) {
                System.out.println("Product [" + i + "] failed to be created. Reason: " + ex.getMessage());
            }
        }
    }

    // Method to Display Products in a Table Format
    public static void displayProducts(Product[] productsArray) {
        // Verify array exist
        if (productsArray == null) {
            System.out.println("Product Data array or Product Array is not found.");
            return;
        }

        // Products Header
        System.out.println(
                "==============================================================================================================");
        System.out.printf("%-5s %-40s %-15s %-15s %-20s %-10s %n", "ID", "Name", "Brand", "Category",
                "In Stock Quantity", "Price (RM)");
        System.out.println(
                "==============================================================================================================");

        // Display all products using for-each loop
        for (Product product : productsArray) {
            if (product != null) {
                System.out.println(product);
            }
        }
    }

    // Display Product Main Menu
    public static void displayProductMainMenu() {
        System.out.println("\n==========Product Menu===========");
        System.out.println("[1] View Product (Buy Now)");
        System.out.println("[2] Sort by A-Z");
        System.out.println("[3] Sort by Stock Quantity");
        System.out.println("[4] Sort by Price");
        System.out.println("[5] Filter by Price Range");
        System.out.println("[6] Filter by Stock Quantity Range");
        System.out.println("[7] Filter by Category");
        System.out.println("[8] Search by Name/Brand");
        System.out.println("[9] Display ALL Products");
        System.out.println("=================================");
        System.out.println("[0] Back to Previous Page");
    }

    // (Admin) Display Product Main Menu
    public static void displayProductMainMenu(boolean isAdmin) {
        System.out.println("\n=====Admin Product Menu========");
        System.out.println("[1] View Product");
        System.out.println("[2] Sort by A-Z");
        System.out.println("[3] Sort by Stock Quantity");
        System.out.println("[4] Sort by Price");
        System.out.println("[5] Filter by Price Range");
        System.out.println("[6] Filter by Stock Quantity Range");
        System.out.println("[7] Filter by Category");
        System.out.println("[8] Search by Name/Brand");
        System.out.println("[9] Display ALL Products");
        System.out.println("=================================");
        System.out.println("[0] Close Product Menu");
    }

    // (Admin) view product
    public static void viewProduct(boolean isAdmin) {
        boolean exit = false;
        while (exit == false) {
            try {
                // prompt admin to enter product ID
                System.out.print(
                        "Enter the ID of the product you would like to view (1-" + (productsArray.length) + "): ");
                int view_input = input.nextInt() - 1;
                input.nextLine(); // clear newline buffer

                if (view_input < 0 || view_input >= productsArray.length) {
                    System.out.println("No product match was found.");
                    continue;
                } else {
                    // display product details
                    System.out.println(productsArray[view_input].getProductDetails());
                    exit = true;
                }

            } catch (InputMismatchException ex) {
                System.out.println(
                        "Invalid input. Please enter a valid numeric only product ID number. Out or range values are not allowed.");
                input.nextLine(); // Clear input buffer
            }
        }
    }

    // Method to view specific product
    public static void viewProduct(ArrayCart cart) {
        boolean exit = false;
        while (exit == false) {
            try {
                // Prompt user to enter product ID
                System.out.print("Enter the ID of the product you would like to view (1-"
                        + (productsArray.length) + "): ");
                int view_input = input.nextInt() - 1;
                input.nextLine(); // clear newline buffer

                if (view_input < 0 || view_input >= productsArray.length) {
                    System.out.println("No product match was found.");
                    continue;
                }

                // Display product details
                System.out.println(productsArray[view_input].getProductDetails());
                // Handle add to cart of product
                if (productsArray[view_input].getStockQuantity() == 0) {
                    System.out.println(
                            "Product has ran out of stock and is currently unavailable. Going back to Product Menu...");
                } else {
                    handlePurchase(cart, view_input);
                }

                // Exit after one purchase or rejected purchase
                exit = true;

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number. ");
                input.nextLine(); // Clear input buffer
            }
        }
    }

    // Method to prompt user for add to cart
    public static void handlePurchase(ArrayCart cart, int view_input) {
        boolean purchasing = true;
        boolean validQuantity = false;

        while (purchasing == true && validQuantity == false) {
            // Prompt user to add product to cart (Y/N)
            System.out.print("Would you like to add this item to your shopping cart? (Y/N): ");
            String userProduct = input.nextLine();
            userProduct = userProduct.trim().toUpperCase();

            if (userProduct.equals("Y") || userProduct.equals("YES")) {
                try {
                    System.out.print(
                            "Enter the quantity (" + productsArray[view_input].getStockQuantity() + " available): ");
                    int userQuantity = input.nextInt();
                    input.nextLine(); // clear the input buffer

                    // Check quantity before allowing user to add to cart
                    if (userQuantity <= productsArray[view_input].getStockQuantity() && userQuantity > 0) {
                        try {
                            cart.addItem(productsArray[view_input], userQuantity);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                        validQuantity = true; // exit inner loop
                    } else {
                        System.out.println("Invalid quantity of product. Please try again.");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input. Please enter a number. ");
                    input.nextLine(); // Clear input buffer
                }
            } else if (userProduct.equals("N") || userProduct.equals("NO")) {
                System.out.println("Going Back to Product Menu...");
                purchasing = false; // Exit purchase loop
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    // All filtering and sort methods handles user input
    // Method to handle user input and sort the view of product by product name
    // (A-Z) or (Z-A)
    public static void sortByName() {
        System.out.println("Sort Product by Order of");
        System.out.println("[1] A-Z");
        System.out.println("[2] Z-A");
        boolean exit = false;
        while (exit == false) {
            System.out.print("\nEnter your option (1-2): ");
            String option = input.nextLine();

            // Catch Invalid Message from ProductFilter
            try {
                if (option.equals("1")) {
                    System.out.println("Product sorted from A-Z :");
                    filteredArray = ProductFilter.sortProducts(productsArray, "NAME", true);
                } else if (option.equals("2")) {
                    System.out.println("Product sorted from Z-A :");
                    filteredArray = ProductFilter.sortProducts(productsArray, "NAME", false);
                } else {
                    System.out.println("Invalid Order option. Please select (1 for A-Z, 2 for Z-A).");
                }

                if (option.equals("1") || option.equals("2")) {
                    exit = true;
                    displayProducts(filteredArray);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Method to sort product by stock quantity in ascending or descending order
    public static void sortByStockQuantity() {
        System.out.println("Sort (Stock Quantity) by Order of");
        System.out.println("[1] Ascending");
        System.out.println("[2] Descending");
        boolean exit = false;
        while (exit == false) {
            System.out.print("\nEnter your option (1-2): ");
            String option = input.nextLine();

            // Catch Invalid Message from ProductFilter
            try {
                if (option.equals("1")) {
                    System.out.println("Stock Quantity Sorted in Ascending Order:");
                    filteredArray = ProductFilter.sortProducts(productsArray, "QUANTITY", true);
                } else if (option.equals("2")) {
                    System.out.println("Stock Quantity Sorted in Descending Order:");
                    filteredArray = ProductFilter.sortProducts(productsArray, "QUANTITY", false);
                } else {
                    System.out.println("Invalid Order option. Please select (1 or 2).");
                }

                if (option.equals("1") || option.equals("2")) {
                    exit = true;
                    displayProducts(filteredArray);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Method to sort all product by price
    public static void sortByPrice() {
        System.out.println("Sort (Price) by Order of");
        System.out.println("[1] Ascending");
        System.out.println("[2] Descending");
        boolean exit = false;

        while (exit == false) {
            System.out.print("\nEnter your option (1-2): ");
            String option = input.nextLine();

            // Catch Invalid Message from ProductFilter
            try {
                if (option.equals("1")) {
                    System.out.println("Price Sorted in Ascending Order:");
                    filteredArray = ProductFilter.sortProducts(productsArray, "PRICE", true);
                } else if (option.equals("2")) {
                    System.out.println("Price Sorted in Descending Order:");
                    filteredArray = ProductFilter.sortProducts(productsArray, "PRICE", false);
                } else {
                    System.out.println("Invalid Order option.");
                }

                if (option.equals("1") || option.equals("2")) {
                    displayProducts(filteredArray);
                    exit = true;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Method to filter product by price range of <= or >=
    public static void filterByPrice() {
        System.out.println("Filter by Price Range of");
        System.out.println("[1] Less Than (<=)");
        System.out.println("[2] More Than (>=)");
        boolean exit = false;
        double userPriceFilter;

        while (exit == false) {
            System.out.print("\nEnter your option (1-2): ");
            String option = input.nextLine();
            if (!option.equals("1") && !option.equals("2")) {
                System.out.println("Invalid option.");
                continue;
            }

            try {
                System.out.print("\nEnter the range of price (RM): ");
                userPriceFilter = input.nextDouble();
                input.nextLine(); // clear buffer

                // Catch Invalid Message from ProductFilter
                try {
                    if (option.equals("1")) {
                        System.out.println("Price of Product less than " + userPriceFilter + " :");
                        filteredArray = ProductFilter.filter(productsArray, 0, userPriceFilter, "PRICE",
                                "LESS");
                    } else if (option.equals("2")) {
                        System.out.println("Price of Product more than " + userPriceFilter + " :");
                        filteredArray = ProductFilter.filter(productsArray, 0, userPriceFilter, "PRICE",
                                "MORE");
                    } else {
                        System.out.println("Invalid Range option.");
                        continue;
                    }

                    // Display the filtered result once input is valid
                    if (option.equals("1") || option.equals("2")) {
                        displayProducts(filteredArray);
                        exit = true;
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (InputMismatchException ex) {
                System.out.println(
                        "The value you entered is not a valid number. Please provide a numeric price range in RM.");
                input.nextLine(); // Clear input buffer
            }
        }
    }

    // Method to filter product by stock quantity range of <= or >=
    public static void filterByStockQuantity() {
        System.out.println("Filter by Stock Quantity's Range of");
        System.out.println("[1] Less Than (<=)");
        System.out.println("[2] More Than (>=)");
        boolean exit = false;
        int userQuantityFilter;

        while (exit == false) {
            System.out.print("\nEnter your option (1-2): ");
            String option = input.nextLine();
            if (!option.equals("1") && !option.equals("2")) {
                System.out.println("Invalid option.");
                continue;
            }

            try {
                System.out.print("\nEnter the range of quantity: ");
                userQuantityFilter = input.nextInt();
                input.nextLine();

                // Catch Invalid Message from ProductFilter
                try {
                    if (option.equals("1")) {
                        System.out.println("Quantity of Product less than " + userQuantityFilter + " :");
                        filteredArray = ProductFilter.filter(productsArray, userQuantityFilter, 0, "STOCK",
                                "LESS");
                    } else if (option.equals("2")) {
                        System.out.println("Quantity of Product more than " + userQuantityFilter + " :");
                        filteredArray = ProductFilter.filter(productsArray, userQuantityFilter, 0, "STOCK",
                                "MORE");
                    } else {
                        System.out.println("Invalid Range option.");
                        continue;
                    }

                    if (option.equals("1") || option.equals("2")) {
                        displayProducts(filteredArray);
                        exit = true;
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (InputMismatchException ex) {
                System.out.println(
                        "The value you entered is not a valid number. Please provide a numeric stock quantity.");
                input.nextLine(); // Clear input buffer
            }
        }
    }

    // Method to handle user input of filtering by category
    public static void filterByCategory() {
        System.out.println("Product Categories Filter: ");
        System.out.println("[1] Audio");
        System.out.println("[2] Keyboard");
        System.out.println("[3] Monitor");
        System.out.println("[4] Mouse");
        boolean exit = false;

        while (exit == false) {
            System.out.print("\nEnter your option (1-4): ");
            String option = input.nextLine();

            // Catch Invalid Message from ProductFilter
            try {
                if (option.equals("1")) {
                    filteredArray = ProductFilter.filter(productsArray, 1);
                } else if (option.equals("2")) {
                    filteredArray = ProductFilter.filter(productsArray, 2);
                } else if (option.equals("3")) {
                    filteredArray = ProductFilter.filter(productsArray, 3);
                } else if (option.equals("4")) {
                    filteredArray = ProductFilter.filter(productsArray, 4);
                } else {
                    System.out.println("Invalid Category option. Please enter (1-4).");
                }

                // Exit the loop if option is valid input
                if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")) {
                    displayProducts(filteredArray);
                    exit = true;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Method to handle user input of filtering by search
    public static void filterBySearch() {
        System.out.println("Search Product by");
        System.out.println("[1] Search (Brand)");
        System.out.println("[2] Search (Name)");

        boolean exit = false;
        String searchString = "";

        while (exit == false) {
            System.out.print("\nEnter your option (1-2): ");
            String option = input.nextLine();

            // Catch Invalid Message from ProductFilter
            try {
                if (option.equals("1")) {
                    System.out.print("Enter Brand Search Phrase: ");
                    searchString = input.nextLine();
                    filteredArray = ProductFilter.search(productsArray, searchString, "BRAND");
                } else if (option.equals("2")) {
                    System.out.print("Enter Name Search Phrase: ");
                    searchString = input.nextLine();
                    filteredArray = ProductFilter.search(productsArray, searchString, "NAME");
                } else {
                    System.out.println("Invalid Search option. Please enter (1 or 2).");
                }

                if (option.equals("1") || option.equals("2")) {
                    if (filteredArray.length != 0) {
                        // Display search result
                        System.out.println("Search Result for \"" + searchString + "\" :");
                        displayProducts(filteredArray);
                        exit = true;
                    } else {
                        // No matching searchString found
                        System.out.println("No result found for search: \"" + searchString + "\".");
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
