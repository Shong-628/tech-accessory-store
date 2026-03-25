public class ProductKeyboard extends Product {
    private boolean wireless;
    private String measurements;
    private String material;
    private boolean backlit;

    // No Argument Constructor
    public ProductKeyboard() {
        super("", "", "", "", 0.0, 0, "Keyboard");
        this.wireless = false;
        this.measurements = "";
        this.material = "";
        this.backlit = false;
    }

    // Constructor
    public ProductKeyboard(String productID, String productName, String description, String brand, double price,
            int stockQuantity, boolean wireless, String measurements, String material,
            boolean backlit) {
        super(productID, productName, description, brand, price, stockQuantity, "Keyboard");
        this.wireless = wireless;
        this.measurements = measurements;
        this.material = material;
        this.backlit = backlit;
    }

    // Getter & Setter
    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public String getMeasurements() {
        return measurements;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isBacklit() {
        return backlit;
    }

    public void setBacklit(boolean backlit) {
        this.backlit = backlit;
    }

    // To String Method, No Overriding
    @Override
    public String toString() {
        return super.toString();
    }

    // Get Product Details Method
    @Override
    public String getProductDetails() {
        return "\nProduct ID        : " + getProductID() +
                "\nName              : " + getProductName() +
                "\nDescription       : " + getDescription() +
                "\nBrand             : " + getBrand() +
                "\nCategory          : " + getCategory() +
                "\nIn Stock Quantity : " + getStockQuantity() +
                "\nPrice (RM)        : " + getPrice() +
                "\n=============================" +
                "\n|      Product Details      |" +
                "\n=============================" +
                "\nWireless          : " + wireless +
                "\nMeasurements      : " + measurements +
                "\nMaterial          : " + material +
                "\nBacklit           : " + backlit +
                "\n\n";
    }
}
