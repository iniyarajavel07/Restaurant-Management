
package src.com.rest.service;

import java.util.List;
import src.com.rest.modles.OrderId;
import src.com.rest.repository.OrderRepository;

public class OrderService {
    private final OrderRepository repository = new OrderRepository();

    public List<OrderId> getAll() {
        return repository.show();
    }

    public boolean addOrder(int id, int menuId, int quantity,
                            float price) {
        if (id <= 0 || menuId <= 0 || quantity <= 0 || price <= 0) {
            return false;
        }

        float total = quantity * price;

        return repository.add(
            new OrderId(id, menuId, quantity, total)
        );
    }

    public boolean editOrder(int id, int quantity, float price) {
        if (quantity <= 0 || price <= 0) {
            return false;
        }

        return repository.edit(id, quantity, quantity * price);
    }

    public boolean removeOrder(int id) {
        return repository.remove(id);
    }
}

