
package src.com.rest.CLI;

import java.util.Scanner;
import src.com.rest.modles.Table;
import src.com.rest.service.TableServices;

public class TableCli {
    private final TableServices service;
    private final Scanner a = new Scanner(System.in);

    public TableCli(TableServices service) {
        this.service = service;
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n--- Table Management ---");
            System.out.println("1. View all tables");
            System.out.println("2. Add table");
            System.out.println("3. Edit table");
            System.out.println("4. Remove table");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = a.nextInt();

            switch (choice) {
                case 1:
                    for (Table t : service.getAll()) {
                        System.out.println(
                            "ID: " + t.getId()
                            + ", Capacity: " + t.viewcapacity()
                            + ", Status: " + t.getstatus()
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter new table ID: ");
                    int id = a.nextInt();

                    System.out.print("Enter capacity: ");
                    int capacity = a.nextInt();

                    if (service.addTable(id, capacity)) {
                        System.out.println("Table added successfully!");
                    } else {
                        System.out.println(
                            "Invalid details or duplicate ID."
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter table ID to edit: ");
                    int editId = a.nextInt();

                    System.out.print("Enter new capacity: ");
                    int newCapacity = a.nextInt();

                    if (service.editTable(editId, newCapacity)) {
                        System.out.println("Table updated successfully!");
                    } else {
                        System.out.println(
                            "Table not found or invalid capacity."
                        );
                    }
                    break;

                case 4:
                    System.out.print("Enter table ID to remove: ");
                    int removeId = a.nextInt();

                    if (service.removeTable(removeId)) {
                        System.out.println("Table removed successfully!");
                    } else {
                        System.out.println("Table not found.");
                    }
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
