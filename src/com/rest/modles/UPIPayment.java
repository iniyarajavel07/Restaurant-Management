package src.com.rest.modles;

public class UPIPayment implements PaymentMethod {
    private int paymentId;
    private int orderId;
    private double amount;
    private String upiId;

    public UPIPayment(int paymentId, int orderId,
                      double amount, String upiId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.upiId = upiId;
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

    public String getUpiId() {
        return upiId;
    }

    @Override
    public String getPaymentType() {
        return "UPI";
    }

    @Override
    public boolean pay() {
        return paymentId > 0
                && orderId > 0
                && amount > 0
                && upiId != null
                && upiId.matches(
                    "[A-Za-z0-9._-]+@[A-Za-z0-9.-]+"
                );
    }
}