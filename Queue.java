package queuepackage;
import java.util.Scanner;

public class Queue {
	private QueueNode front;
    private QueueNode rear;
    private int count;

    public Queue() {
        front = rear = null;
        count = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue: Adding new orders to the queue
    public void enqueue(String customerName, String orderedItems, String orderTime) {
        try {
        	Order newOrder = new Order(customerName, orderedItems, orderTime);  // Create new order
            QueueNode newNode = new QueueNode(newOrder);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            count++;
            System.out.println("Order placed: " + customerName + " (" + orderedItems + ")");
        } catch (Exception e) {
            System.err.println("Error while adding order: " + e.getMessage());
        }
    }

    // Dequeue: Processing orders from the front of the queue
    public void dequeue() {
        try {
            if (isEmpty()) {
                System.err.println("Queue is empty. No orders to process.");
                return;
            }
            QueueNode processedOrder = front;
            processedOrder.order.setStatus("Completed");
            System.out.println("Processed order: " + processedOrder.order.getCustomerName() + " (" + processedOrder.order.getOrderedItems() + ")");
            front = front.next;
            count--;

            if (front == null) {
                rear = null;
            }
        } catch (Exception e) {
            System.err.println("Error while processing order: " + e.getMessage());
        }
    }

    // Update an order's status or special instructions
    public void updateOrder(String customerName) {
        try {
            Scanner scanner = new Scanner(System.in);
            QueueNode current = front;
            boolean found = false;

            // Search for the order by customer name
            while (current != null) {
                if (current.order.getCustomerName().equalsIgnoreCase(customerName)) {
                    found = true;
                    
                    // Display a menu for the user to choose what to update
                    System.out.println("Order found for " + customerName + ".");
                    System.out.println("What would you like to update?");
                    System.out.println("1. Status");
                    System.out.println("2. Special Instructions");
                    System.out.print("Enter your choice (1 or 2): ");
                    
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character left by nextInt()

                    switch (choice) {
                        case 1:
                            // Update status
                            System.out.print("Enter new status: ");
                            String newStatus = scanner.nextLine();
                            current.order.setStatus(newStatus);
                            System.out.println("Updated order for " + customerName + ": Status = " + newStatus);
                            break;
                        case 2:
                            // Update special instructions
                            System.out.print("Enter new special instructions: ");
                            String newInstructions = scanner.nextLine();
                            current.order.setSpecialInstructions(newInstructions);
                            System.out.println("Updated order for " + customerName + ": Instructions = " + newInstructions);
                            break;
                        default:
                            System.out.println("Invalid choice. Please select 1 or 2.");
                    }
                    break;
                }
                current = current.next;
            }

            // If no order was found
            if (!found) {
                System.out.println("Order for customer '" + customerName + "' not found.");
            }
        } catch (Exception e) {
            System.err.println("Error while updating order: " + e.getMessage());
        }
    }

//    // Display all orders in the queue
    public void displayOrders() {
        try {
            if (isEmpty()) {
                System.out.println("No pending orders.");
                return;
            }
            QueueNode current = front;
            System.out.println("Pending orders:");
            while (current != null) {
                System.out.println("--------------------------");
                current.order.displayOrderDetails(); // Use the displayOrderDetails method
                current = current.next;
            }
        } catch (Exception e) {
            System.err.println("Error while displaying orders: " + e.getMessage());
        }
    }


    // Display the current size of the queue
    public void displaySize() {
        try {
            System.out.println("Queue size: " + count);
        } catch (Exception e) {
            System.err.println("Error while displaying queue size: " + e.getMessage());
        }
    }
//  public void displayOrders() {
//  try {
//      if (isEmpty()) {
//          System.out.println("No pending orders.");
//          return;
//      }
//      QueueNode current = front;
//      System.out.println("Pending orders:");
//      while (current != null) {
//      	System.out.println("--------------------------");
//          System.out.println(
//          		"Customer: " + current.order.getCustomerName() +
//                  ", Items: " + current.order.getOrderedItems() +
//                  ", Time: " + current.order.getOrderTime() +
//                  ", Status: " + current.order.getStatus() +
//                  ", Instructions: " + current.order.getSpecialInstructions()
//          );
//          current = current.next;
//      }
//  } catch (Exception e) {
//      System.err.println("Error while displaying orders: " + e.getMessage());
//  }
//}
}
