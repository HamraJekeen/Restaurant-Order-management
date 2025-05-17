package queuepackage;
import java.util.Scanner;

public class DriverClass {
	public static void main(String[] args) {
//        Queue queue = new Queue();
//
//        // Place orders
//        queue.enqueue("Alice", "Burger, Fries", "12:00 PM");
//        queue.enqueue("Bob", "Pizza", "12:05 PM");
//        queue.enqueue("Charlie", "Pasta, Salad", "12:10 PM");
//
//        // Display all pending orders
//        queue.displayOrders();
//
//        // Update an order
//        queue.updateOrder("Bob","completed" ,"Add extra cheese");
//
//        // Process orders
//        //queue.dequeue(); // Process Alice's order
//        //queue.dequeue(); // Process Bob's order
//
//        // Display remaining orders
//        queue.displayOrders();
//
//        // Add more orders
//        queue.enqueue("David", "Sandwich, Coffee", "12:15 PM");
//        queue.enqueue("Eva", "Sushi", "12:20 PM");
//
//        // Display updated queue
//        queue.displayOrders();
//
//        // Process all orders
//        //queue.dequeue();
//        //queue.dequeue();
//        //queue.dequeue();
//
//        // Attempt to process an order when the queue is empty
//        //queue.dequeue();
		Queue orderQueue = new Queue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Restaurant Order Management System ---");
                System.out.println("1. Add New Order");
                System.out.println("2. Process Order");
                System.out.println("3. Update Order");
                System.out.println("4. Display Orders");
                System.out.println("5. Display Queue Size");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add New Order
                        System.out.print("Enter customer name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Enter ordered items: ");
                        String orderedItems = scanner.nextLine();
                        System.out.print("Enter order time: ");
                        String orderTime = scanner.nextLine();
                        orderQueue.enqueue(customerName, orderedItems, orderTime);
                        break;

                    case 2:
                        // Process Order
                        orderQueue.dequeue();
                        break;

                    case 3:
                        // Update Order
                    	System.out.print("\nEnter customer name to update their order: ");
                        String updateCustomerName = scanner.nextLine();
                        
                        // Call updateOrder method to allow the user to update the order
                        orderQueue.updateOrder(updateCustomerName);
                        break;

                    case 4:
                        // Display Orders
                        orderQueue.displayOrders();
                        break;

                    case 5:
                        // Display Queue Size
                        orderQueue.displaySize();
                        break;

                    case 6:
                        // Exit
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

}
