
package src.com.rest.service;

import java.util.List;
import src.com.rest.modles.Menu;
import src.com.rest.repository.MenuRepository;

public class MenuService {
    private final MenuRepository repository = new MenuRepository();

    public List<Menu> getAll() {
        return repository.show();
    }

    public boolean addMenu(int id, String name, float price) {
        if (id <= 0 || name == null || name.trim().isEmpty()
                || price <= 0) {
            return false;
        }
        return repository.add(new Menu(id, name, price));
    }

    public boolean editMenu(int id, String name, float price) {
        if (name == null || name.trim().isEmpty() || price <= 0) {
            return false;
        }
        return repository.edit(id, name, price);
    }

    public boolean removeMenu(int id) {
        return repository.remove(id);
    }
}
