import java.util.InputMismatchException;
import java.util.Scanner;

public class EditProfilePage {

    public Register editProfile(String username, String password, Register regDetail) {
        Scanner scanner = new Scanner(System.in);
        String[] editMenu = { "Username", "IC Number", "Password", "Contact Number", "Address", "Back" };
        int editselection = -1; // Initialize with invalid number

        // count register letter and digit
        int countDigit = 0;
        int countLetter = 0;
        boolean editValidInput;

        do {
            try {
                if (regDetail != null) {
                    String displayUser = regDetail.toString();
                    System.out.println(displayUser);
                }

                System.out.println("-----------------------------------");
                System.out.println("|          Edit Profile:          |");
                System.out.println("-----------------------------------");
                for (int q = 0; q < editMenu.length; q++) {
                    System.out.println("[" + (q + 1) + "] " + editMenu[q]);
                }

                System.out.print("Your selection: ");
                editselection = scanner.nextInt();
                scanner.nextLine(); // clear memory buffer

                switch (editselection) {
                    case 1:
                        do {
                            countLetter = 0;

                            editValidInput = true;
                            System.out.print("Enter your new username(alphaberts and numbers only): ");
                            String newUsername = scanner.nextLine();
                            newUsername = newUsername.trim();

                            if (newUsername.length() == 0) {
                                editValidInput = false;
                            }

                            // check username length
                            for (int k = 0; k < newUsername.length() && editValidInput == true; k++) {
                                if (Character.isLetter(newUsername.charAt(k))) {
                                    countLetter++;
                                } else {
                                    editValidInput = false;
                                    if (Character.isDigit(newUsername.charAt(k))) {
                                        editValidInput = true;
                                    }
                                }
                            }
                            if (countLetter == 0) {
                                editValidInput = false;
                            }

                            if (editValidInput) {
                                regDetail.getCustomer().setName(newUsername);
                            } else {
                                System.out.println("Username is invalid. Cannot contain SYMBOLS or SPACES.");
                            }
                        } while (editValidInput != true);
                        System.out.println("Update username success.");
                        break;

                    case 2:
                        do {
                            editValidInput = true;
                            System.out.print("Enter your new IC (Example: 000111141458): ");
                            String ic = scanner.nextLine();
                            ic = ic.trim();
                            // check IC length
                            if (ic.length() == 12) {

                                for (int t = 0; t < ic.length() && editValidInput == true; t++) {
                                    if (Character.isLetter(ic.charAt(t))) {
                                        editValidInput = false;
                                    } else if (Character.isDigit(ic.charAt(t))) {
                                        editValidInput = true;
                                    } else {
                                        editValidInput = false;
                                    }
                                }

                            } else {
                                editValidInput = false;
                            }

                            if (editValidInput) {
                                regDetail.getCustomer().setIc(ic);
                            } else {
                                System.out.println(
                                        "IC is invalid. Please enter correct IC number(Example: 000111141458)");
                            }
                        } while (editValidInput != true);
                        System.out.println("Update IC success.");
                        break;

                    case 3:
                        do {
                            countDigit = 0;
                            countLetter = 0;

                            editValidInput = true;
                            System.out.print("Enter your new password(8 characters and no spacing gap): ");
                            String newPassword = scanner.nextLine();
                            newPassword = newPassword.trim();
                            // check password length
                            // at least 8 char
                            if (newPassword.length() >= 8) {

                                for (int j = 0; j < newPassword.length() && editValidInput == true; j++) {
                                    if (Character.isLetter(newPassword.charAt(j))) {
                                        countLetter++;
                                    } else if (Character.isDigit(newPassword.charAt(j))) {
                                        countDigit++;
                                    } else {
                                        editValidInput = false;
                                    }
                                }
                                if (countLetter == 0 || countDigit == 0) {
                                    editValidInput = false;
                                }

                            } else {
                                editValidInput = false;
                            }

                            if (editValidInput) {
                                regDetail.getCustomer().setPassword(newPassword);
                            } else {
                                System.out.println(
                                        "Password is invalid. Please enter at least 8 characters of alphabet letters or numbers");
                            }
                        } while (editValidInput != true);
                        System.out.println("Update password success.");
                        break;

                    case 4:
                        do {
                            countDigit = 0;

                            editValidInput = true;
                            System.out.print("Enter your new contact number (numbers only): ");
                            String contactNo = scanner.nextLine();
                            contactNo = contactNo.trim();
                            // check Contact length
                            if (contactNo.length() >= 9) {

                                for (int y = 0; y < contactNo.length() && editValidInput == true; y++) {
                                    if (Character.isLetter(contactNo.charAt(y))) {
                                        editValidInput = false;
                                    } else if (Character.isDigit(contactNo.charAt(y))) {
                                        countDigit++;
                                    } else {
                                        editValidInput = false;
                                    }
                                }
                                if (countDigit == 0) {
                                    editValidInput = false;
                                }

                            } else {
                                editValidInput = false;
                            }

                            if (editValidInput) {
                                regDetail.getCustomer().setContact(contactNo);
                            } else {
                                System.out.println("Contact number is invalid.");
                            }
                        } while (editValidInput != true);
                        System.out.println("Update contact number success.");
                        break;

                    case 5:
                        do {
                            editValidInput = true;
                            System.out.print("Enter your address: ");
                            String address = scanner.nextLine();
                            // check address length
                            if (address.length() <= 6) {
                                editValidInput = false;
                            }

                            if (editValidInput) {
                                regDetail.getCustomer().setAddress(address);
                            } else {
                                System.out.println("Address is invalid.");
                            }
                        } while (editValidInput != true);
                        System.out.println("Update address success.");
                        break;
                    case 6:
                        // Exit the loop and go back to menu page
                        System.out.println("Going back to menu page...");
                        break;

                    default:
                        System.out.println("Invalid Input. Please enter a number (1-5).");
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid Input. Please enter a number (1-5).");
                scanner.nextLine(); // clear memory buffer
            }
        } while (editselection != 6);

        return regDetail;
    }

}