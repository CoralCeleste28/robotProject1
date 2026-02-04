package models;

import java.util.HashMap;
import java.util.Map;

public class OrderCart {
    private Map<Integer, MenuItemInCart> menuItemsMap = new HashMap<>();

    public Map<Integer, MenuItemInCart> getMenuItems(){
        return menuItemsMap;
    }

    public void setMenuItems(Map<Integer, MenuItemInCart> menuItemsMap){
        this.menuItems = menuItems;
    }
}
