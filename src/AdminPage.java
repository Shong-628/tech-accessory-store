import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminPage {
    private static Scanner input = new Scanner(System.in);

    // Display Admin Main Menu
    public static void displayAdminMainMenu() {
        System.out.println("\n=============Admin Menu===========");
        System.out.println("[1] Edit/Update Product's Details");
        System.out.println("[2] View More about Product");
        System.out.println("[3] Modify Tax Rate");
        System.out.println("==================================");
        System.out.println("[0] Back to previous page");
        System.out.println("==================================");
    }

    // Display Admin Edit Product Menu
    public static void displayAdminEditMenu() {
        System.out.println("==============Options============");
        System.out.println("[1] Edit Product Name");
        System.out.println("[2] Edit Product Description");
        System.out.println("[3] Edit Product Brand");
        System.out.println("[4] Update Product Price");
        System.out.println("[5] Restock Product");
        System.out.println("==================================");
        System.out.println("[0] Back to previous page");
        System.out.println("==================================");
    }

    // Get Admin inputs
    private static String getAdminEditOption() {
        System.out.print("\nEnter you option (0-5): ");
        return input.nextLine();
    }

    private static String getAdminMenuOption() {
        System.out.print("\nEnter you option (0-3): ");
        return input.nextLine();
    }

    // Get Product ID of the product that is going to be edited
    private static int getProductEditID(Product[] productsArray) {
        boolean exit = false;
        int edit_input = -1;
        while (exit == false) {
            try {
                System.out.print(
                        "Enter the ID of the product you would like to edit (1-" + (productsArray.length) + "): ");
                edit_input = input.nextInt() - 1;
                input.nextLine(); // clear newline buffer

                if (edit_input < 0 || edit_input >= productsArray.length) {
                    System.out.println("No product match was found.");
                    continue;
                } else {

                    exit = true;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input for product ID, Please enter a valid number.");
                input.nextLine();
            }
        }
        return edit_input;
    }

    public static void editProduct(Product[] productsArray) {
        int productID = getProductEditID(productsArray);
        String displayID = String.valueOf(productID + 1);
        System.out.println(productsArray[productID].getProductDetails());

        boolean exit2 = false;
        while (exit2 == false) {
            System.out.println("\nCurrently editing Product ID: " + displayID);

            displayAdminEditMenu();
            String adminSubOption = getAdminEditOption();

            switch (adminSubOption) {
                case "0":
                    exit2 = true; // exit edit menu
                    break;
                case "1":
                    editProductName(productsArray, productID, displayID);
                    break;
                case "2":
                    editProductDesc(productsArray, productID, displayID);
                    break;
                case "3":
                    editProductBrand(productsArray, productID, displayID);
                    break;
                case "4":
                    editProductPrice(productsArray, productID, displayID);
                    break;
                case "5":
                    updateStock(productsArray, productID, displayID);
                    break;
                default:
                    System.out.println("Invalid option. Please select (0-5).");
                    break;
            }

        }
    }

    public static void editProductName(Product[] productsArray, int productID, String displayID) {
        System.out.print("Enter new Product's name: ");
        String newProductName = input.nextLine();
        try {
            productsArray[productID].setProductName(newProductName);
            // If no exception caught, edit success
            System.out.println("Product " + displayID + " Name is updated successfully.");
        } catch (IllegalArgumentException ex) {
            // Display error message
            System.out.println(ex.getMessage());
            System.out.println("Product " + displayID + " Name updating failed.");
        }
    }

    public static void editProductDesc(Product[] productsArray, int productID, String displayID) {
        System.out.print("Enter new Product's description: ");
        String editDescription = input.nextLine();
        try {
            productsArray[productID].setDescription(editDescription);
            // If no exception caught, edit success
            System.out.println("Product " + displayID + " Description updated.");
        } catch (IllegalArgumentException ex) {
            // Display error message
            System.out.println(ex.getMessage());
            System.out.println("Product " + displayID + " Description updating failed.");
        }
    }

    public static void editProductBrand(Product[] productsArray, int productID, String displayID) {
        System.out.print("Enter new Product's brand: ");
        String editBrand = input.nextLine();
        try {
            productsArray[productID].setBrand(editBrand);
            // If no exception caught, edit success
            System.out.println("Product " + displayID + " Brand updated.");
        } catch (IllegalArgumentException ex) {
            // Display error message
            System.out.println(ex.getMessage());
            System.out.println("Product " + displayID + " Brand updating failed.");
        }
    }

    public static void editProductPrice(Product[] productsArray, int productID, String displayID) {
        System.out.print("Enter new Product's price: ");
        try {
            Double editPrice = input.nextDouble();
            input.nextLine(); // clear input buffer
            productsArray[productID].setPrice(editPrice);
            // updated output
            System.out.println("Product " + displayID + " Price updated.");
        } catch (InputMismatchException ex) {
            System.out.println("Invalid Input. Please enter a number.");
            input.nextLine();
            System.out.println("Product " + displayID + " Price updating failed.");
        } catch (IllegalArgumentException ex) {
            // Error message caught from setPrice()
            System.out.println(ex.getMessage());
            System.out.println("Product " + displayID + " Price updating failed.");
        }
    }

    public static void updateStock(Product[] productsArray, int productID, String displayID) {
        System.out.print("Enter amount of stock you would like to add: ");
        try {
            int newStock = input.nextInt();
            input.nextLine(); // clear input buffer
            productsArray[productID].addStockQuantity(newStock);

            // updated output
            System.out.println("Product " + displayID + " Stock quantity added.");
        } catch (InputMismatchException ex) {
            System.out.println("Invalid Input. Please enter a number.");
            input.nextLine();
            System.out.println("Product " + displayID + " Stock quantity adding failed.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Product " + displayID + " Stock quantity adding failed.");
        }
    }

    public static void modifyTaxRate() {
        System.out.println("Current Tax Rate: (" + Payment.getTaxRate() + "%)");
        double newTax = 0.0;
        try {
            // user input
            System.out.print("Enter the new tax rate (0%-100%): ");
            newTax = input.nextDouble();
            input.nextLine(); // clear input buffer

            Payment.setTaxRate(newTax);
            // Success Updating of Tax Rate
            System.out.println("Tax Rate is updated to " + Payment.getTaxRate() + "% .");
        } catch (InputMismatchException ex) {
            System.out.println("Ivalid input. Please enter a number.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void adminDriver() {
        // Get productsArray from Product Page
        Product[] productsArray = ProductPage.getProductsArray();

        // Display all products in the beginning
        ProductPage.displayProducts(productsArray);

        boolean exit = false;
        while (exit == false) {
            displayAdminMainMenu();
            String adminOption = getAdminMenuOption();
            switch (adminOption) {
                case "0":
                    exit = true; // exit admin
                    break;
                case "1":
                    editProduct(productsArray);
                    break;
                case "2":
                    ProductDriver.productDriver(true);
                    break;
                case "3":
                    modifyTaxRate();
                    break;
                default:
                    System.out.println("Invalid option. Please select (0-3).");
                    break;
            }
        }
    }
}
