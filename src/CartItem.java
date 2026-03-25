public class CartItem {
    private Product product;
    private int quantity;

    // No Argument Constructor
    public CartItem() {
        this.product = null;
        this.quantity = 0;
    }

    // Constructor
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getter & Setter
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    // To String Method
    @Override
    public String toString() {
        return "Product =" + product +
                "\nQuantity = " + quantity;
    }

}
