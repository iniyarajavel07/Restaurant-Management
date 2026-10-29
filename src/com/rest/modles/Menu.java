package src.com.rest.modles;

public class Menu {
    private int menuId;
    private String menuItem;
    private float price;

    public Menu(int menuId, String menuItem, float price) {
        this.menuId = menuId;
        this.menuItem = menuItem;
        this.price = price;
    }

    public int getMenuId() {
        return menuId;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public float getPrice() {
        return price;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}