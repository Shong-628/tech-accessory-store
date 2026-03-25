public class Customer extends User {
    private ArrayCart cart;
    private OrderHistory orderHistory;
    private String ic;
    private String contact;
    private String address;

    // No argument Constructor
    public Customer() {
        super("", "");
        this.ic = "";
        this.contact = "";
        this.address = "";
        this.cart = new ArrayCart();
        this.orderHistory = new OrderHistory();
    }

    // constructor
    public Customer(String name, String ic, String contact, String password, String address) {
        super(name, password);
        this.ic = ic;
        this.contact = contact;
        this.address = address;
        this.cart = new ArrayCart();
        this.orderHistory = new OrderHistory();
    }

    // To string Method
    @Override
    public String toString() {
        return super.toString() +
                "\n IC = " + ic +
                "\n Contact = " + contact +
                "\n Address = " + address;
    }

    // Getter & Setter
    public ArrayCart getCart() {
        return cart;
    }

    public void setCart(ArrayCart cart) {
        this.cart = cart;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
