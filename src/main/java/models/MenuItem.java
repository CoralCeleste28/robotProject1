package models;

public class MenuItem {

    private int menuItemId;
    private String menuItemName;
    private Double menuItemPrice;
    private int restaurantId;
    private String menuItemDescription;
    private String imageUrl;

    public MenuItem(){

    }

    public MenuItem(int menuItemId, String menuItemName, Double menuItemPrice, int restaurantId, String menuItemDescription, String imageUrl){
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.menuItemPrice = menuItemPrice;
        this.restaurantId = restaurantId;
        this.menuItemDescription = menuItemDescription;
        this.imageUrl = imageUrl;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public Double getMenuItemPrice() {
        return menuItemPrice;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setMenuItemPrice(Double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
