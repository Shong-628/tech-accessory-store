public class LoginPage {
    // No Argument Constructor
    public LoginPage() {

    }

    // Login customer
    public Register login(String username, String password, Register[] registerArr) {

        Boolean flag = false;
        int i;

        for (i = 0; i < registerArr.length; i++) {

            if (registerArr[i] != null) {
                String registerName = registerArr[i].getCustomer().getName();
                String registerPassword = registerArr[i].getCustomer().getPassword();
                if (registerName.equals(username) && registerPassword.equals(password)) {
                    flag = true;
                    break;
                }
            }

        }
        if (!flag) {
            return null;
        }
        return registerArr[i];

    }
}