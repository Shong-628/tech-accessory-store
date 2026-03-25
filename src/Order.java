import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String paymentID;
    private double totalPrice;
    private Date date;
    private ArrayList<CartItem> items; // To hold purchase items

    // No Argument Consturctor
    public Order() {
        paymentID = "";
        totalPrice = 0.0;
        date = new Date();
        items = null;
    }

    // Constructor
    public Order(String paymentID, double totalPrice, Date date, ArrayList<CartItem> items) {
        this.paymentID = paymentID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.items = items;
    }

    // Getter & Setter
    public String getPaymentID() {
        return paymentID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public List<CartItem> getOrderDetails() {
        return items;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    // To String Method
    @Override
    public String toString() {
        return "Order " + paymentID + 
        "\nTotal Price =" + totalPrice + 
        "\nDate =" + date + 
        "\nItems =" + items;
    }

}
