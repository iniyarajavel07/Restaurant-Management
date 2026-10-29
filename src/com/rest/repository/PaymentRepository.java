package src.com.rest.repository;

import java.util.ArrayList;
import java.util.List;
import src.com.rest.modles.PaymentMethod;

public class PaymentRepository {
    private final List<PaymentMethod> payments = new ArrayList<>();

    public List<PaymentMethod> show() {
        return payments;
    }

    public boolean add(PaymentMethod payment) {
        for (PaymentMethod p : payments) {
            if (p.getPaymentId() == payment.getPaymentId()) {
                return false;
            }
        }

        payments.add(payment);
        return true;
    }

    public boolean remove(int paymentId) {
        return payments.removeIf(
            p -> p.getPaymentId() == paymentId
        );
    }
}