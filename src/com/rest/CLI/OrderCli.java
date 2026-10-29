
package src.com.rest.CLI;

import java.util.Scanner;
import src.com.rest.modles.OrderId;
import src.com.rest.service.OrderService;

public class OrderCli {
    private final OrderService service;
    private final Scanner sc = new Scanner(System.in);

    public OrderCli(OrderService service) {
        this.service = service;
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n--- Order Management ---");
            System.out.println("1. View Orders");
            System.out.println("2. Add Order");
            System.out.println("3. Edit Order");
            System.out.println("4. Remove Order");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (OrderId o : service.getAll()) {
                        System.out.println(
                            "Order ID: " + o.getOrderId()
                            + ", Menu ID: " + o.getMenuId()
                            + ", Quantity: " + o.getQuantity()
                            + ", Total Price: Rs. " + o.getTotalPrice()
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Menu ID: ");
                    int menuId = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter price per item: ");
                    float price = sc.nextFloat();

                    System.out.println(
                        service.addOrder(id, menuId, quantity, price)
                        ? "Order added successfully!"
                        : "Invalid details or duplicate Order ID."
                    );
                    break;

                case 3:
                    System.out.print("Enter Order ID to edit: ");
                    int editId = sc.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = sc.nextInt();

                    System.out.print("Enter price per item: ");
                    float newPrice = sc.nextFloat();

                    System.out.println(
                        service.editOrder(editId, newQuantity, newPrice)
                        ? "Order updated successfully!"
                        : "Order not found or invalid details."
                    );
                    break;

                case 4:
                    System.out.print("Enter Order ID to remove: ");
                    int removeId = sc.nextInt();

                    System.out.println(
                        service.removeOrder(removeId)
                        ? "Order removed successfully!"
                        : "Order not found."
                    );
                    break;

                case 0:
                    System.out.println("Exiting Order Management.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
