
import src.com.rest.CLI.MenuCli;
import src.com.rest.CLI.TableCli;
import src.com.rest.CLI.OrderCli;
import src.com.rest.CLI.PaymentCli;

import src.com.rest.service.MenuService;
import src.com.rest.service.TableServices;
import src.com.rest.service.OrderService;
import src.com.rest.service.PaymentServices;

public class Restaurant {
    public static void main(String[] args) {

        // Table module
        TableServices serv = new TableServices();
        TableCli CLI = new TableCli(serv);

        // Menu module
        MenuService service = new MenuService();
        MenuCli cli = new MenuCli(service);

        // Order module
        OrderService services = new OrderService();
        OrderCli Cli = new OrderCli(services);

        // Payment module - NEW
        PaymentServices paymentService = new PaymentServices();
        PaymentCli paymentCli = new PaymentCli(paymentService);

        // Start each module
        CLI.start();
        cli.start();
        Cli.start();
        paymentCli.start();  // NEW
    }
}
