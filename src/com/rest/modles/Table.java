

package src.com.rest.modles;

public class Table {
    public enum Availability {
        occupy, free
    }

    private int id;
    private int capacity;
    private Availability status;

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.status = Availability.free;
    }

    public int getId() {
        return id;
    }

    public int viewcapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Availability getstatus() {
        return status;
    }

    public void booking() {
        status = Availability.occupy;
    }

    public void freeNow() {
        status = Availability.free;
    }
}
