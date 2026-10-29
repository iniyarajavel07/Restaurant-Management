package src.com.rest.modles;

public interface PaymentMethod {
    int getPaymentId();

    int getOrderId();

    double getAmount();

    String getPaymentType();

    boolean pay();
}