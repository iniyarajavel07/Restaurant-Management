package src.com.rest.CLI;

import java.util.List;
import java.util.Scanner;

import src.com.rest.modles.PaymentMethod;
import src.com.rest.modles.CashPayment;
import src.com.rest.modles.CardPayment;
import src.com.rest.modles.UPIPayment;
import src.com.rest.service.PaymentServices;

public class PaymentCli {
    private final PaymentServices service;
    private final Scanner sc = new Scanner(System.in);

    public PaymentCli(PaymentServices service) {
        this.service = service;
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n--- Payment Management ---");
            System.out.println("1. View Payments");
            System.out.println("2. Make Payment");
            System.out.println("3. Remove Payment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewPayments();
                    break;

                case 2:
                    makePayment();
                    break;

                case 3:
                    System.out.print("Enter Payment ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (service.removePayment(id)) {
                        System.out.println(
                            "Payment removed successfully!"
                        );
                    } else {
                        System.out.println("Payment not found.");
                    }
                    break;

                case 0:
                    System.out.println(
                        "Exiting Payment Management."
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private void makePayment() {
        System.out.print("Enter Payment ID: ");
        int paymentId = sc.nextInt();

        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. UPI");
        System.out.print("Select payment method: ");

        int method = sc.nextInt();
        sc.nextLine();

        PaymentMethod payment;

        switch (method) {
            case 1:
                payment = new CashPayment(
                    paymentId, orderId, amount
                );
                break;

            case 2:
                System.out.print(
                    "Enter last 4 card digits: "
                );
                String digits = sc.nextLine();

                payment = new CardPayment(
                    paymentId, orderId, amount, digits
                );
                break;

            case 3:
                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();

                payment = new UPIPayment(
                    paymentId, orderId, amount, upiId
                );
                break;

            default:
                System.out.println(
                    "Invalid payment method!"
                );
                return;
        }

        if (service.processPayment(payment)) {
            System.out.println(
                "Payment recorded successfully!"
            );
        } else {
            System.out.println(
                "Payment failed. Check the details or Payment ID."
            );
        }
    }

    private void viewPayments() {
        List<PaymentMethod> payments = service.getAll();

        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        for (PaymentMethod p : payments) {
            System.out.println(
                "Payment ID: " + p.getPaymentId()
                + ", Order ID: " + p.getOrderId()
                + ", Method: " + p.getPaymentType()
                + ", Amount: Rs. " + p.getAmount()
            );
        }
    }
}