public class ProductMouse extends Product {
    private boolean wireless;
    private String batteryLife;
    private String sensitivity_dpi;

    // No Argument Constructor
    public ProductMouse() {
        super("", "", "", "", 0.0, 0, "Mouse");
        this.wireless = true;
        this.batteryLife = "";
        this.sensitivity_dpi = "";
    }

    // Constructor
    public ProductMouse(String productID, String productName, String description, String brand, double price,
            int stockQuantity, boolean wireless, String batteryLife, String sensitivity_dpi) {
        super(productID, productName, description, brand, price, stockQuantity, "Mouse");
        this.wireless = wireless;
        this.batteryLife = batteryLife;
        this.sensitivity_dpi = sensitivity_dpi;
    }

    // Getter & Setter
    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String getSensitivity_dpi() {
        return sensitivity_dpi;
    }

    public void setSensitivity_dpi(String sensitivity_dpi) {
        this.sensitivity_dpi = sensitivity_dpi;
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
                "\nBattery Life      : " + batteryLife +
                "\nSensitivity (DPI) : " + sensitivity_dpi +
                "\n\n";
    }
}
