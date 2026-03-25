import java.util.Arrays;
import java.util.Comparator;

public class ProductFilter {

    // Sorting Method
    public static Product[] sortProducts(Product[] productsArray, String sortingMethod, boolean ascending) {
        // Duplicate Array
        Product[] filteredArray = productsArray.clone();
        Comparator<Product> comparator;

        // Identify sorting method and assign comparator
        switch (sortingMethod) {
            case "NAME":
                // Product Name Alphabetical Order
                comparator = Product.ProductNameComparator(ascending);
                break;

            case "PRICE":
                // Price (small to large / large to small)
                comparator = Product.PriceComparator(ascending);
                break;

            case "QUANTITY":
                // Quantity (small to large / large to small)
                comparator = Product.StockQuantityComparator(ascending);
                break;

            default:
                // Try catch
                throw new IllegalArgumentException("Sorting type not found.");
        }

        // Sort Array using comparator
        Arrays.sort(filteredArray, comparator);
        return filteredArray;
    }

    // Filter range of stockQuantity or price (less than / more than)
    public static Product[] filter(Product[] productsArray, int stockQuantity, double price, String filterType,
            String range) {
        int matchCount = 0;

        double checkProductNum; // Original value in Product
        double checkUserNum; // Value input by User

        // Validate filterType
        if (!filterType.equals("STOCK") && !filterType.equals("PRICE")) {
            throw new IllegalArgumentException("Invalid Filter Type.");
        }

        // Validate range
        if (!range.equals("LESS") && !range.equals("MORE")) {
            throw new IllegalArgumentException("Invalid sorting range.");
        }

        // Count matches
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i] != null) {
                if (filterType.equals("STOCK")) {
                    checkProductNum = (double) (productsArray[i].getStockQuantity());
                    checkUserNum = (double) stockQuantity;
                } else {
                    checkProductNum = productsArray[i].getPrice();
                    checkUserNum = price;
                }

                if (range.equals("LESS") && checkProductNum <= checkUserNum) {
                    matchCount++;
                } else if (range.equals("MORE") && checkProductNum >= checkUserNum) {
                    matchCount++;
                }
            }
        }

        Product[] filteredArray = new Product[matchCount];
        int index = 0;

        // Append into new array
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i] != null) {
                if (filterType.equals("STOCK")) {
                    checkProductNum = (double) (productsArray[i].getStockQuantity());
                    checkUserNum = (double) stockQuantity;
                } else {
                    checkProductNum = productsArray[i].getPrice();
                    checkUserNum = price;
                }

                if (range.equals("LESS") && checkProductNum <= checkUserNum) {
                    filteredArray[index++] = productsArray[i];
                } else if (range.equals("MORE") && checkProductNum >= checkUserNum) {
                    filteredArray[index++] = productsArray[i];
                }
            }
        }

        return filteredArray;
    }

    // Filter by category
    public static Product[] filter(Product[] productsArray, int categoryFilter) {
        int matchCount = 0;
        // Count the Matching Category
        switch (categoryFilter) {
            case 1:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductAudio) {
                        matchCount++;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductKeyboard) {
                        matchCount++;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductMonitor) {
                        matchCount++;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductMouse) {
                        matchCount++;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("No matching category.");
        }

        // Create new Product Array
        Product[] filteredArray = new Product[matchCount];
        int index = 0;

        // Insert into array
        switch (categoryFilter) {
            case 1:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductAudio) {
                        filteredArray[index++] = productsArray[i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductKeyboard) {
                        filteredArray[index++] = productsArray[i];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductMonitor) {
                        filteredArray[index++] = productsArray[i];
                    }
                }
                break;
            case 4:
                for (int i = 0; i < productsArray.length; i++) {
                    if (productsArray[i] instanceof ProductMouse) {
                        filteredArray[index++] = productsArray[i];
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("No matching category.");
        }
        return filteredArray;
    }

    // Search Name of Product or Brand
    public static Product[] search(Product[] productsArray, String searchString, String searchType) {
        int matchCount = 0;
        int index = 0;

        // Covert searchString to lowercase
        String lowerCaseSearchString = searchString.toLowerCase();

        // Validate searchType
        if (!searchType.equals("NAME") && !searchType.equals("BRAND")) {
            throw new IllegalArgumentException("Invalid Search Type.");
        }

        // Count matches
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i] != null) {
                String targetString;
                if (searchType.equals("NAME")) {
                    targetString = productsArray[i].getProductName();
                } else {
                    targetString = productsArray[i].getBrand();
                }

                if (targetString.toLowerCase().contains(lowerCaseSearchString)) {
                    matchCount++;
                }
            }
        }

        Product[] filteredArray = new Product[matchCount];

        // Insert into new Array
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i] != null) {
                String targetString;
                if (searchType.equals("NAME")) {
                    targetString = productsArray[i].getProductName();
                } else {
                    targetString = productsArray[i].getBrand();
                }

                if (targetString.toLowerCase().contains(lowerCaseSearchString)) {
                    filteredArray[index++] = productsArray[i];
                }
            }
        }
        return filteredArray;
    }
}
