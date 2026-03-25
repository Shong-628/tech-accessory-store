// Written in collaboration of Leow Shi Hao, Cheh Shu Hong, Chong Yu Xuan, and Ng Zhi Ling
// Group: RSW1S3G2 
// BACS2023 Assignment 2024/2025
import java.util.Scanner;

public class MainPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2D String array - productsData: store all details of exisitng products
        String[][] productsData = {
                { "1", "Bluetooth Headphones",
                        "High-quality wireless headphones with noise cancellation.",
                        "AudioMax", "149.00", "50", "true", "20 hours", "Over-Ear", "32" },
                { "1", "Wired Earbuds",
                        "Compact earbuds with excellent sound quality and comfort.",
                        "SoundPro", "29.00", "100", "false", "N/A", "In-Ear", "16" },
                { "1", "Noise Cancelling Headphones",
                        "Premium headphones with active noise cancellation and deep bass.",
                        "QuietSound", "199.00", "30", "true", "25 hours", "Over-Ear", "28" },
                { "1", "Portable Bluetooth Speaker",
                        "Durable and portable speaker with powerful sound and long battery life.",
                        "SoundWave", "89.00", "75", "true", "15 hours", "Portable", "4" },
                { "1", "Gaming Headset",
                        "Comfortable gaming headset with a built-in microphone and surround sound.",
                        "GamerPro", "89.00", "40", "false", "N/A", "Over-Ear", "32" },
                { "2", "Wireless Mechanical Keyboard",
                        "A high-performance mechanical keyboard with customizable RGB backlighting and wireless connectivity.",
                        "KeyTech", "129.00", "25", "true", "450mm x 150mm x 40mm", "Aluminum",
                        "true" },
                { "2", "Compact Gaming Keyboard",
                        "A compact and durable gaming keyboard with programmable keys and red backlighting.",
                        "GamerEdge", "79.00", "40", "false", "300mm x 130mm x 35mm", "Plastic",
                        "true" },
                { "2", "Ergonomic Office Keyboard",
                        "An ergonomic keyboard designed for office use, featuring a split layout and soft-touch keys.",
                        "WorkFlow", "99.00", "30", "true", "400mm x 160mm x 50mm", "Plastic",
                        "false" },
                { "2", "Backlit Mechanical Keyboard",
                        "A mechanical keyboard with vibrant backlighting and programmable macros, perfect for gamers and typists alike.",
                        "TechMaster", "149.00", "20", "false", "430mm x 140mm x 45mm", "Steel",
                        "true" },
                { "2", "Wireless Slim Keyboard",
                        "A sleek and slim wireless keyboard with low-profile keys and a minimalist design.",
                        "SlimTech", "59.00", "50", "true", "360mm x 120mm x 25mm", "Aluminum",
                        "false" },
                { "3", "4K Ultra HD Monitor",
                        "A 27-inch monitor with 4K resolution and high dynamic range for stunning visuals.",
                        "VisionPro", "399.00", "20", "27 inches", "3840 x 2160", "60Hz",
                        "16:9" },
                { "3", "Curved Gaming Monitor",
                        "A 34-inch curved monitor with ultra-wide resolution and high refresh rate, ideal for gaming.",
                        "GameView", "549.00", "15", "34 inches", "3440 x 1440", "120Hz",
                        "21:9" },
                { "3", "Office LED Monitor",
                        "A 24-inch monitor with full HD resolution and an ultra-thin design for office use.",
                        "WorkPro", "149.00", "50", "24 inches", "1920 x 1080", "75Hz", "16:9" },
                { "3", "Professional Graphics Monitor",
                        "A 32-inch monitor with 4K resolution and high color accuracy for graphic design and video editing.",
                        "PixelPerfect", "699.00", "10", "32 inches", "3840 x 2160", "60Hz",
                        "16:9" },
                { "3", "Compact Desktop Monitor",
                        "A 21.5-inch monitor with full HD resolution, perfect for small desks and home offices.",
                        "DeskMate", "119.00", "35", "21.5 inches", "1920 x 1080", "60Hz",
                        "16:9" },
                { "4", "Wireless Gaming Mouse",
                        "A high-performance wireless mouse with adjustable DPI settings and long battery life.",
                        "GameMaster", "79.00", "30", "true", "50 hours", "16000" },
                { "4", "Ergonomic Wired Mouse",
                        "An ergonomic wired mouse designed for comfort during long hours of use, with precise tracking.",
                        "ComfortTech", "39.00", "45", "false", "N/A", "8000" },
                { "4", "Compact Wireless Mouse",
                        "A compact and portable wireless mouse, perfect for travel and everyday use.",
                        "TravelEase", "29.00", "60", "true", "30 hours", "1200" },
                { "4", "High-DPI Gaming Mouse",
                        "A gaming mouse with customizable RGB lighting and ultra-high DPI settings for competitive play.",
                        "ProGamer", "99.00", "20", "true", "40 hours", "26000" },
                { "4", "Silent Click Mouse",
                        "A quiet, wireless mouse with silent click technology, ideal for office environments.",
                        "QuietClick", "49.00", "35", "true", "60 hours", "1600" }
        };

        // Product Type array productsArray : store all products object
        Product[] productsArray = new Product[productsData.length];

        // temporary array used only for sorting
        Product[] filteredArray = {};

        // Assign productsArray to ProductPage
        ProductPage.setProductsArray(productsArray);
        ProductPage.setFilteredArray(filteredArray);

        // Assign productsArray to ArrayCart
        ArrayCart.setProductsArray(productsArray);

        // Create Products
        ProductPage.createProducts(productsData);

        Register[] registerArr = new Register[3];

        // Customer Array size based on Registration
        Customer[] customerArray = new Customer[registerArr.length];

        // Test Acc: for testing purpose only
        Customer testCustomer = new Customer("test123", "", "", "qweqwe123", "");
        registerArr[0] = new Register(testCustomer);

        // Populate the customerArray with empty Customer
        for (int i = 0; i < customerArray.length; i++) {
            customerArray[i] = new Customer();
        }
        customerArray[0] = testCustomer;

        // check main page
        int mainSelect = -1;
        int adminSelect = -1;

        // check login accounts
        int i = 1;

        // admin id and password
        String adminUsername = "Admin";
        String adminPassword = "123456";

        do {

            try {
                System.out.println("-----------------------------------");
                System.out.println("|          User Option:           |");
                System.out.println("-----------------------------------");
                System.out.println("| [1] Admin                       |");
                System.out.println("| [2] Customer                    |");
                System.out.println("| [0] Exit                        |");
                System.out.println("-----------------------------------");
                System.out.print("Enter your choice: ");
                adminSelect = scanner.nextInt();
                scanner.nextLine(); // clear memory buffer

                if (adminSelect == 1) {
                    System.out.println("-----------------------------------");
                    System.out.println("|          Admin Option:          |");
                    System.out.println("-----------------------------------");
                    System.out.print("Enter Username: ");
                    String adminInputUsername = scanner.nextLine();

                    System.out.print("Enter Password: ");
                    String adminInputPassword = scanner.nextLine();

                    if (adminInputUsername.equals(adminUsername) && adminInputPassword.equals(adminPassword)) {
                        System.out.println("Login Admin successful");
                        System.out.println("\nWelcome to Admin");
                        // Admin Page functionality
                        AdminPage.adminDriver();
                    } else {
                        System.out.println("Account Invalid");
                    }

                } else if (adminSelect == 2) {
                    do {
                        try {
                            System.out.println("\n-----------------------------------");
                            System.out.println("|        Customer Option:         |");
                            System.out.println("-----------------------------------");
                            System.out.println("| [1] Login                       |");
                            System.out.println("| [2] Register                    |");
                            System.out.println("| [0] Exit                        |");
                            System.out.println("-----------------------------------");
                            System.out.print("Select your choice: ");
                            mainSelect = scanner.nextInt();

                            scanner.nextLine(); // clear memory buffer
                            if (mainSelect == 1) {

                                System.out.println("\n-----------------------------------");
                                System.out.println("|             Login:              |");
                                System.out.println("-----------------------------------");
                                System.out.print("Enter username: ");
                                String username = scanner.nextLine();

                                System.out.print("Enter password: ");
                                String password = scanner.nextLine();
                                LoginPage loginPage = new LoginPage();

                                Register userInfo = loginPage.login(username, password, registerArr);

                                if (userInfo != null) {
                                    // Login succesful
                                    System.out.println("Login Customer successful");
                                    MenuPage menuPage = new MenuPage();
                                    Register returnUserInfo = menuPage.menu(username, password, userInfo,
                                            customerArray);
                                    int j;
                                    for (j = 0; j < registerArr.length; j++) {
                                        if (registerArr[j].getCustomer().getName()
                                                .equals(userInfo.getCustomer().getName())) {
                                            break;
                                        }
                                    }
                                    registerArr[j] = returnUserInfo;
                                } else {
                                    System.out.println("Account Invalid");
                                }

                            } else if (mainSelect == 2) {
                                if (i == registerArr.length) {
                                    System.out.println("Your registration field is full, please login");
                                } else {
                                    // enter register
                                    System.out.println("-----------------------------------");
                                    System.out.println("|           Register:             |");
                                    System.out.println("-----------------------------------");

                                    // username
                                    Register register = new Register();
                                    String userNameRig = register.regUsername();

                                    // IC
                                    String userIC = register.userIC();

                                    // password
                                    String userPassword = register.userPassword();

                                    // contact number
                                    String userContact = register.userContact();

                                    // address
                                    String userAddress = register.userAddress();

                                    // create new user to objectS
                                    Customer customer = new Customer(userNameRig, userIC, userContact, userPassword,
                                            userAddress);

                                    if (customer != null) {
                                        System.out.println("Register success");
                                        registerArr[i] = new Register(customer);
                                        customerArray[i] = customer;
                                        i++;
                                    }

                                }

                            } else if (mainSelect > 2 || mainSelect < 0) {
                                System.out.println("Please only choose available option of (0-2).");
                            }

                        } catch (Exception e) {
                            System.out.println("Invalid input. Choose number only (0-2).");
                            scanner.nextLine(); // clear memory buffer
                        }

                    } while (mainSelect != 0);
                } else if (adminSelect > 2 || adminSelect < 0) {
                    System.out.println("Please only choose available option of (0-2).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Choose number only (0-2).");
                scanner.nextLine(); // clear memory buffer
            }

        } while (adminSelect != 0);

    }
}