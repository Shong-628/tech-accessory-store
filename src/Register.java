import java.util.Scanner;

public class Register {
    private int regNo;
    private Customer customer = new Customer();
    private static int nextRegNo = 2401;

    String userNameRig, userIC, userPassword, userContact, userAddress;
    // count register letter and digit
    int countDigit;
    int countLetter;
    Scanner scanner = new Scanner(System.in);
    boolean validInput;

    public Register() {
        this.customer = null;
        this.regNo = 0;
        nextRegNo++;
    }

    public Register(Customer customer) {
        this.customer = customer;
        this.regNo = nextRegNo;
        nextRegNo++;
    }

    @Override
    public String toString() {
        return "\n-----------------------------------" +
                "\nUser Info" +
                "\n-----------------------------------" +
                "\n User ID = " + regNo + customer + "\n";
    }

    // register username
    public String regUsername() {
        do {
            countLetter = 0;
            validInput = true;
            System.out.print("Enter your username (alphaberts and numbers only): ");
            String username = scanner.nextLine();
            username.trim();

            if (username.length() == 0) {
                validInput = false;
            }

            // check username length
            for (int k = 0; k < username.length() && validInput == true; k++) {
                if (Character.isLetter(username.charAt(k))) {
                    countLetter++;
                } else {
                    validInput = false;
                    if (Character.isDigit(username.charAt(k))) {
                        validInput = true;
                    }
                }
            }
            if (countLetter == 0) {
                validInput = false;
            }

            if (validInput == true) {
                this.userNameRig = username;
            } else {
                System.out.println("Username is invalid. Cannot contain SYMBOLS or SPACES.");
            }
        } while (validInput != true);
        System.out.println("Enter username success");
        return this.userNameRig;
    }

    // register ic
    public String userIC() {
        do {
            countDigit = 0;

            validInput = true;
            System.out.print("Enter your IC (Example: 000111141458): ");
            String ic = scanner.nextLine();
            ic.trim();
            // check IC length
            if (ic.length() == 12) {

                for (int t = 0; t < ic.length() && validInput == true; t++) {
                    if (Character.isLetter(ic.charAt(t))) {
                        validInput = false;
                    } else if (Character.isDigit(ic.charAt(t))) {
                        countDigit++;
                    } else {
                        validInput = false;
                    }
                }
                if (countDigit == 0) {
                    validInput = false;
                }

            } else {
                validInput = false;
            }

            if (validInput) {
                this.userIC = ic;
            } else {
                System.out.println("IC is invalid. Please enter correct IC number(Example: 000111141458)");
            }
        } while (validInput != true);
        System.out.println("Enter IC success");
        return this.userIC;
    }

    // register password
    public String userPassword() {
        do {
            countLetter = 0;
            countDigit = 0;

            validInput = true;
            System.out.print("Enter your password (8 characters and no spacing gap): ");
            String password = scanner.nextLine();
            password.trim();
            // check password length
            // at least 8 char
            if (password.length() >= 8) {

                for (int j = 0; j < password.length() && validInput == true; j++) {
                    if (Character.isLetter(password.charAt(j))) {
                        countLetter++;
                    } else if (Character.isDigit(password.charAt(j))) {
                        countDigit++;
                    } else {
                        validInput = false;
                    }
                }
                if (countLetter == 0 || countDigit == 0) {
                    validInput = false;
                }

            } else {
                validInput = false;
            }

            if (validInput) {
                this.userPassword = password;
            } else {
                System.out.println(
                        "Password is invalid. Please enter at least 8 characters of alphabet letters or numbers");
            }
        } while (validInput != true);
        System.out.println("Enter password success");
        return this.userPassword;
    }

    // register contact number
    public String userContact() {
        do {
            countDigit = 0;

            validInput = true;
            System.out.print("Enter your contact number (numbers only): ");
            String contactNo = scanner.nextLine();
            contactNo.trim();
            // check Contact length, at least 9 numbers
            if (contactNo.length() >= 9) {

                for (int y = 0; y < contactNo.length() && validInput == true; y++) {
                    if (Character.isLetter(contactNo.charAt(y))) {
                        validInput = false;
                    } else if (Character.isDigit(contactNo.charAt(y))) {
                        countDigit++;
                    } else {
                        validInput = false;
                    }
                }
                if (countDigit == 0) {
                    validInput = false;
                }

            } else {
                validInput = false;
            }

            if (validInput) {
                this.userContact = contactNo;
            } else {
                System.out.println("Contact number is invalid.");
            }
        } while (validInput != true);
        System.out.println("Enter contact number success");
        return this.userContact;
    }

    // register address
    public String userAddress() {
        do {
            validInput = true;
            System.out.print("Enter your address: ");
            String address = scanner.nextLine();
            // check address length
            if (address.length() <= 6) {
                validInput = false;
            }

            if (validInput) {
                this.userAddress = address;
            } else {
                System.out.println("Address is invalid.");
            }
        } while (validInput != true);
        System.out.println("Enter address success");
        return this.userAddress;
    }

    public int getRegNo() {
        return this.regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getNextRegNo() {
        return nextRegNo;
    }

    public static void setNextRegNo(int nextRegNo) {
        Register.nextRegNo = nextRegNo;
    }

}