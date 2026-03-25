import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPage {

    // Customer Menu Page
    public Register menu(String username, String password, Register regDetail, Customer[] customerArray) {
        Scanner scanner = new Scanner(System.in);
        String[] MainPage = { "View Products", "View Shopping Cart", "View Order History", "Edit Profile", "Logout" };

        int selection = -1;

        // Declare ArrayCart and OrderHistory
        ArrayCart cart = null;
        OrderHistory orderHistory = null;

        // Match customer based on customer name
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getName() != null) {
                if (username.equals(customerArray[i].getName())) {
                    Customer customer = regDetail.getCustomer();
                    cart = customer.getCart();
                    orderHistory = customer.getOrderHistory();
                }
            }
        }

        do {
            try {
                System.out.println("\n+-------------------------------------------------------------+");
                System.out.println("|           Welcome to BEN10 Computer Accessories:            |");
                System.out.println("+-------------------------------------------------------------+");
                for (int j = 0; j < MainPage.length; j++) {
                    System.out.println("[" + (j + 1) + "]" + " " + MainPage[j]);
                }
                System.out.print("Your selection: ");
                selection = scanner.nextInt();
                scanner.nextLine(); // clear memory buffer

                if (selection == 1) {
                    // view products
                    ProductDriver.productDriver(cart, false);
                } else if (selection == 2) {
                    // check carts
                    cart.viewCart();
                    boolean moreItem = CartManager.manageCart(cart, orderHistory);
                    if (moreItem) {
                        ProductDriver.productDriver(cart, false);
                    }
                } else if (selection == 3) {
                    // view order history
                    orderHistory.viewOrderHistory();
                } else if (selection == 4) {
                    // edit profile
                    EditProfilePage editProfilePage = new EditProfilePage();
                    regDetail = editProfilePage.editProfile(username, password, regDetail);
                } else if (selection > 5 || selection < 0) {
                    System.out.println("Invalid input. Please enter (1-4).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1-4).");
                scanner.nextLine(); // clear memory buffer
            }

        } while (selection != 5);

        return regDetail;
    }
}
