public class ProductMonitor extends Product {
    private String screenSize;
    private String resolution;
    private String refreshRate;
    private String aspectRatio;

    // No Argument Constructor
    public ProductMonitor() {
        super("", "", "", "", 0.0, 0, "Monitor");
        this.screenSize = "";
        this.resolution = "";
        this.refreshRate = "";
        this.aspectRatio = "";
    }

    // Constructor
    public ProductMonitor(String productID, String productName, String description, String brand, double price,
            int stockQuantity, String screenSize, String resolution, String refreshRate,
            String aspectRatio) {
        super(productID, productName, description, brand, price, stockQuantity, "Monitor");
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.aspectRatio = aspectRatio;
    }

    // Getter & Setter
    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(String refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    // To String Method, No Overriding
    @Override
    public String toString() {
        return super.toString();
    }

    // Get Product Details Method
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
                "\nScreen Size       : " + screenSize +
                "\nResolution        : " + resolution +
                "\nRefresh Rate      : " + refreshRate +
                "\nAspect Ratio      : " + aspectRatio +
                "\n\n";
    }
}
