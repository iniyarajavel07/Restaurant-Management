
package src.com.rest.service;

import java.util.List;
import src.com.rest.modles.Table;
import src.com.rest.repository.TableRepository;

public class TableServices {
    private final TableRepository repository;

    public TableServices() {
        repository = new TableRepository();
    }

    public List<Table> getAll() {
        return repository.show();
    }

    public boolean addTable(int id, int capacity) {
        if (id <= 0 || capacity <= 0) {
            return false;
        }

        return repository.add(new Table(id, capacity));
    }

    public boolean editTable(int id, int capacity) {
        if (capacity <= 0) {
            return false;
        }

        return repository.edit(id, capacity);
    }

    public boolean removeTable(int id) {
        return repository.remove(id);
    }
}
