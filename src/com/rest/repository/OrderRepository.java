
package src.com.rest.repository;

import java.util.ArrayList;
import java.util.List;
import src.com.rest.modles.OrderId;

public class OrderRepository {
    private final List<OrderId> orders = new ArrayList<>();

    public List<OrderId> show() {
        return orders;
    }

    public boolean add(OrderId order) {
        for (OrderId o : orders) {
            if (o.getOrderId() == order.getOrderId()) {
                return false;
            }
        }
        orders.add(order);
        return true;
    }

    public boolean edit(int id, int quantity, float totalPrice) {
        for (OrderId o : orders) {
            if (o.getOrderId() == id) {
                o.setQuantity(quantity);
                o.setTotalPrice(totalPrice);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int id) {
        return orders.removeIf(o -> o.getOrderId() == id);
    }
}

