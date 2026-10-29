package src.com.rest.service;

import java.util.List;
import src.com.rest.modles.PaymentMethod;
import src.com.rest.repository.PaymentRepository;

public class PaymentServices {
    private final PaymentRepository repository =
            new PaymentRepository();

    public List<PaymentMethod> getAll() {
        return repository.show();
    }

    public boolean processPayment(PaymentMethod payment) {
        if (payment == null || !payment.pay()) {
            return false;
        }

        return repository.add(payment);
    }

    public boolean removePayment(int paymentId) {
        return repository.remove(paymentId);
    }
}