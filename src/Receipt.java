import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    private ArrayCart cart;
    private double totalPrice;
    private double tax;
    private double discountAmount;
    private double totalAmount;
    private static int transactionCounter = 1000;
    private String paymentMethod;

    // No Argument Constructor
    public Receipt() {
        this.cart = null;
        this.totalPrice = 0.0;
        this.tax = 0;
        this.discountAmount = 0;
        this.totalAmount = 0;
        this.paymentMethod = "";
    }

    // Constructor to initialize receipt details
    public Receipt(ArrayCart cart, double totalPrice, double tax, double discountAmount, double totalAmount,
            String paymentMethod) {
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.discountAmount = discountAmount;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    // Getter & Setter
    public ArrayCart getCart() {
        return cart;
    }

    public void setCart(ArrayCart cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static int getTransactionCounter() {
        return transactionCounter;
    }

    public static void setTransactionCounter(int transactionCounter) {
        Receipt.transactionCounter = transactionCounter;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Method to save order into Order History
    public void saveOrder(OrderHistory orderHistory) {
        Date date = new Date();
        String transactionNumber = "TNX" + (++transactionCounter);
        Order order = new Order(transactionNumber, totalAmount, date, new ArrayList<>(cart.getCart()));
        orderHistory.addOrder(order);
    }

    // Method to print receipt
    public void printReceipt() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String transactionNumber = "TNX" + (transactionCounter);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|                                         Receipt                                       |");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Date and Time: " + dateFormat.format(date));
        System.out.println("Transaction Number: " + transactionNumber);
        System.out.println();
        System.out.println("Product Purchased: ");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-5s %-40s %-12s %-5s %-20s%n", "No.", "Product Name", "Price(RM)", "Qty", "Total (RM)");
        System.out.println("---------------------------------------------------------------------------------");

        int i = 1;
        for (CartItem item : cart.getCart()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            double pricePerItem = product.getPrice();
            double totalPricePerItem = quantity * pricePerItem;

            System.out.printf("%-5d %-40s %-12.2f %-5d %15.2f%n", i++, product.getProductName(), pricePerItem,
                    quantity, totalPricePerItem);
        }

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-67s RM %10.2f%n", "Total Price (Before Discount):", totalPrice);
        System.out.printf("%-67s RM %10.2f%n", "Discount Applied:", -discountAmount);
        System.out.printf("%-67s RM %10.2f%n", "Total Price (After Discount):", (totalPrice - discountAmount));
        System.out.printf("%-67s RM %10.2f%n", ("Tax (" + Payment.getTaxRate() + "%):"), tax);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-67s RM %10.2f%n", "Total Amount:", totalAmount);
        System.out.println();
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println();
        System.out.println("                           Thank you for your purchase!");
        System.out.println("---------------------------------------------------------------------------------");
    }

    // To String Method
    @Override
    public String toString() {
        return "Receipt" +
                "\nCart =" + cart +
                "\nTotal Price =" + totalPrice +
                "\nTax =" + tax +
                "\nDiscount Amount =" + discountAmount +
                "\nTotal Amount =" + totalAmount +
                "\nPayment Method =" + paymentMethod;
    }
}