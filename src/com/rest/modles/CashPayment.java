package src.com.rest.modles;

public class CashPayment implements PaymentMethod {
    private int paymentId;
    private int orderId;
    private double amount;

    public CashPayment(int paymentId, int orderId, double amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
    }

    @Override
    public int getPaymentId() {
        return paymentId;
    }

    @Override
    public int getOrderId() {
        return orderId;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }

    @Override
    public boolean pay() {
        return paymentId > 0 && orderId > 0 && amount > 0;
    }
}