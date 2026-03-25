import java.util.Comparator;

abstract class Product implements Comparable<Product> {
    private String productID;
    private String productName;
    private String description;
    private String brand;
    private double price;
    private int stockQuantity;
    protected String category;

    // No Argument Constructor
    public Product() {
        this.productID = "";
        this.productName = "";
        this.description = "";
        this.brand = "";
        setPrice(0);
        setStockQuantity(0);
        this.category = "";
    }

    // Constructor
    public Product(String productID, String productName, String description, String brand, double price,
            int stockQuantity, String category) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.brand = brand;
        setPrice(price);
        setStockQuantity(stockQuantity);
        this.category = category;
    }

    // Getter & Setter
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        // Check if product name is left empty
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Product name. Product name cannot be null or empty.");
        }
        // Check if product name exceeded character limit of 40
        if (productName.length() > 41) {
            throw new IllegalArgumentException(
                    "Invalid Product name. Product name needs to be less than 41 characters.");
        }
        this.productName = productName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        // Check if product brand is left empty
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Product Brand. Product Brand cannot be null or empty.");
        }
        // Check if product name exceeded character limit of 15
        if (brand.length() > 16) {
            throw new IllegalArgumentException(
                    "Invalid Product Brand. Product Brand cannot be more than 15 characters.");
        }
        this.brand = brand.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Validate price, price cannot be less than 0 or negative. Upper limit of RM
        // 100000
        if (price >= 0 && price <= 100000) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price of Product cannot be less than RM 0 or exceed RM 100,000.");
        }
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        // Validate stock quantity, stock quantity cannot be less than 0 or negative.
        if (stockQuantity >= 0 && stockQuantity <= 1000) {
            this.stockQuantity = stockQuantity;
        } else {
            throw new IllegalArgumentException("Stock Quantity of Product cannot be less than 0 or exceed 1,000.");
        }
    }

    public void setStockQuantity(double stockQuantity) {
        // Validate stock quantity, stock quantity cannot be less than 0 or negative.
        if (stockQuantity >= 0 && stockQuantity <= 1000) {
            this.stockQuantity = (int) Math.round(stockQuantity);
        } else {
            throw new IllegalArgumentException("Stock Quantity of Product cannot be less than 0 or exceed 1,000.");
        }
    }

    // Method to add more product's stock
    public void addStockQuantity(int stockQuantity) {
        if (stockQuantity <= 0) {
            throw new IllegalArgumentException("Stock Quantity of Product cannot be less than 0.");
        } else if ((this.stockQuantity + stockQuantity) > 1000) {
            throw new IllegalArgumentException("Stock Quantity of Product exceeded limit of 1,000.");
        } else {
            this.stockQuantity += stockQuantity;
        }
    }

    // Method to deduct product's stock
    public void minusStockQuantity(int stockQuantity) {
        if (stockQuantity <= 0) {
            throw new IllegalArgumentException("Stock Quantity of Product cannot be less than 0.");
        } else {
            this.stockQuantity -= stockQuantity;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // To String Method
    @Override
    public String toString() {
        return String.format("%-5s %-40s %-15s %-15s %10d %20.2f", productID, productName, brand, category,
                stockQuantity, price);
    }

    // Abstract Method for Product Details
    public abstract String getProductDetails();

    // Default compareTo() is used to sort quantity in ascending order
    @Override
    public int compareTo(Product compareProduct) {
        int compareQuantity = compareProduct.getStockQuantity();
        return this.stockQuantity - compareQuantity;
    }

    // Compare Product Name and sort by ascending/descending order
    public static Comparator<Product> ProductNameComparator(boolean ascending) {
        return new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                String productName1 = product1.getProductName().toUpperCase();
                String productName2 = product2.getProductName().toUpperCase();

                if (ascending) {
                    // ascending order (A-Z)
                    return productName1.compareTo(productName2);
                } else {
                    // descending order (Z-A)
                    return productName2.compareTo(productName1);
                }

            }
        };
    }

    // Compare Price and sort by ascending/descending order
    public static Comparator<Product> PriceComparator(boolean ascending) {
        return new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                double price1 = product1.getPrice();
                double price2 = product2.getPrice();

                if (ascending) {
                    // ascending order (A-Z)
                    return Double.compare(price1, price2);
                } else {
                    // descending order (Z-A)
                    return Double.compare(price2, price1);
                }

            }
        };
    }

    // Compare Stock Quantity and sort by ascending/descending order
    public static Comparator<Product> StockQuantityComparator(boolean ascending) {
        return new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                int quantity1 = product1.getStockQuantity();
                int quantity2 = product2.getStockQuantity();

                if (ascending) {
                    // ascending order (small to large)
                    return Integer.compare(quantity1, quantity2);
                } else {
                    // descending order (large to small)
                    return Integer.compare(quantity2, quantity1);
                }

            }
        };
    }
}
