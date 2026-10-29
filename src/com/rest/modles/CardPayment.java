package src.com.rest.modles;

public class CardPayment implements PaymentMethod {
    private int paymentId;
    private int orderId;
    private double amount;
    private String lastFourDigits;

    public CardPayment(int paymentId, int orderId,
                       double amount, String lastFourDigits) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.lastFourDigits = lastFourDigits;
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

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    @Override
    public String getPaymentType() {
        return "Card";
    }

    @Override
    public boolean pay() {
        return paymentId > 0
                && orderId > 0
                && amount > 0
                && lastFourDigits != null
                && lastFourDigits.matches("\\d{4}");
    }
}