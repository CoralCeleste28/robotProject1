package data;

import models.MenuItem;
import models.Restaurant;

import java.math.BigDecimal;
import java.util.List;

public interface MenuItemDao {
    List<MenuItem> search(Integer restaurantId);
    List<MenuItem> listByMenuItemId(int restaurantId);
    MenuItem getByMenuItemId(int menuItemId);
    Restaurant create(MenuItem menuItem);
    void update(int menuItemId, MenuItem menuItem);
    void delete(int menuItemId);
}
