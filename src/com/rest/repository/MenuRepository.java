
package src.com.rest.repository;

import java.util.ArrayList;
import java.util.List;
import src.com.rest.modles.Menu;

public class MenuRepository {
    private final List<Menu> menus = new ArrayList<>();

    public MenuRepository() {
        menus.add(new Menu(1, "Dosa", 50.0f));
        menus.add(new Menu(2, "Idli", 30.0f));
        menus.add(new Menu(3, "Meals", 100.0f));
    }

    public List<Menu> show() {
        return menus;
    }

    public boolean add(Menu menu) {
        for (Menu m : menus) {
            if (m.getMenuId() == menu.getMenuId()) {
                return false;
            }
        }
        menus.add(menu);
        return true;
    }

    public boolean edit(int id, String name, float price) {
        for (Menu m : menus) {
            if (m.getMenuId() == id) {
                m.setMenuItem(name);
                m.setPrice(price);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int id) {
        return menus.removeIf(m -> m.getMenuId() == id);
    }
}
