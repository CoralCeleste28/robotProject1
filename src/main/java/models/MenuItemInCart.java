package models;

import java.awt.*;
import java.math.BigDecimal;

public class MenuItemInCart {
    private MenuItem menuItemName = null;
    private int quantity = 1;

    public MenuItemInCart(int i, String menuItemName, String s, Double aDouble, String s1, int i1) {
    }


    public MenuItem getMenuItem(){
        return menuItemName;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getMenuItemId(){
        return this.menuItemName.getMenuItemId();
    }

    public void setMenuItem(MenuItem menuItem){
        this.menuItemName = menuItem;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getMenuItemTotal(){
        double basePrice = menuItemName.getMenuItemPrice();
        int quantity = new int(this.quantity);

        double subTotal = basePrice * (quantity);
        double taxes = subTotal * (.08);

        return subTotal * (taxes);
    }
}
