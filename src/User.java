public class User {
    private String name;
    private String password;

    // constructor
    public User() {
        name = "";
        password = "";
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // to string
    @Override
    public String toString() {
        return "\n Username = " + name +
                "\n Password = " + password;
    }

    // getter and setter method
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

}