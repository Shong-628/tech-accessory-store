public class ProductAudio extends Product {
    private boolean wireless;
    private String batteryLife;
    private String type;
    private String impedanceOhm;

    // No Argument Constructor
    public ProductAudio() {
        super("", "", "", "", 0.0, 0, "Audio");
        this.wireless = true;
        this.batteryLife = "";
        this.type = "";
        this.impedanceOhm = "";
    }

    // Constructor
    public ProductAudio(String productID, String productName, String description, String brand, double price,
            int stockQuantity, boolean wireless, String batteryLife, String type,
            String impedanceOhm) {
        super(productID, productName, description, brand, price, stockQuantity, "Audio");
        this.wireless = wireless;
        this.batteryLife = batteryLife;
        this.type = type;
        this.impedanceOhm = impedanceOhm;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImpedanceOhm() {
        return impedanceOhm;
    }

    public void setImpedanceOhm(String impedanceOhm) {
        this.impedanceOhm = impedanceOhm;
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
                "\nType              : " + type +
                "\nImpedance (Ohm)   : " + impedanceOhm +
                "\n\n";
    }
}
