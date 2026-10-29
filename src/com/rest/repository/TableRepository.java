
package src.com.rest.repository;

import java.util.ArrayList;
import java.util.List;
import src.com.rest.modles.Table;

public class TableRepository {
    private final List<Table> tables = new ArrayList<>();

    public TableRepository() {
        tables.add(new Table(1, 5));
        tables.add(new Table(2, 2));
        tables.add(new Table(3, 7));
    }

    // View all tables
    public List<Table> show() {
        return tables;
    }

    // Add table
    public boolean add(Table table) {
        for (Table t : tables) {
            if (t.getId() == table.getId()) {
                return false;
            }
        }

        tables.add(table);
        return true;
    }

    // Edit table capacity
    public boolean edit(int id, int capacity) {
        for (Table t : tables) {
            if (t.getId() == id) {
                t.setCapacity(capacity);
                return true;
            }
        }

        return false;
    }

    // Remove table
    public boolean remove(int id) {
        return tables.removeIf(t -> t.getId() == id);
    }
}
