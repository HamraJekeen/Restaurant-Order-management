package queuepackage;

public class Order {
	private String customerName;
    private String orderedItems;
    private String orderTime;
    private String status;
    private String specialInstructions;

    // Constructor to create a new order
    public Order(String customerName, String orderedItems, String orderTime) {
        this.customerName = customerName;
        this.orderedItems = orderedItems;
        this.orderTime = orderTime;
        this.status = "Pending";
        this.specialInstructions = "";
    }
    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getOrderedItems() {
        return orderedItems;
    }
    public void setOrderedItems(String orderedItems) {
        this.orderedItems = orderedItems;
    }
    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSpecialInstructions() {
        return specialInstructions;
    }
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Ordered Items: " + orderedItems);
        System.out.println("Order Time: " + orderTime);
        System.out.println("Status: " + status);
        System.out.println("Special Instructions: " + specialInstructions);
    }


}








