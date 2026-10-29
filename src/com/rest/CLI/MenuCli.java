
package src.com.rest.CLI;

import java.util.Scanner;
import src.com.rest.modles.Menu;
import src.com.rest.service.MenuService;

public class MenuCli {
    private final MenuService service;
    private final Scanner sc = new Scanner(System.in);

    public MenuCli(MenuService service) {
        this.service = service;
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n--- Menu Management ---");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu");
            System.out.println("3. Edit Menu");
            System.out.println("4. Remove Menu");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Menu m : service.getAll()) {
                        System.out.println(
                            "ID: " + m.getMenuId()
                            + ", Item: " + m.getMenuItem()
                            + ", Price: Rs." + m.getPrice()
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter Menu ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    float price = sc.nextFloat();

                    System.out.println(
                        service.addMenu(id, name, price)
                        ? "Menu added successfully!"
                        : "Invalid details or duplicate ID."
                    );
                    break;

                case 3:
                    System.out.print("Enter Menu ID to edit: ");
                    int editId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Item Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Price: ");
                    float newPrice = sc.nextFloat();

                    System.out.println(
                        service.editMenu(editId, newName, newPrice)
                        ? "Menu updated successfully!"
                        : "Menu not found or invalid details."
                    );
                    break;

                case 4:
                    System.out.print("Enter Menu ID to remove: ");
                    int removeId = sc.nextInt();

                    System.out.println(
                        service.removeMenu(removeId)
                        ? "Menu removed successfully!"
                        : "Menu not found."
                    );
                    break;

                case 0:
                    System.out.println("Exiting Menu Management.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
