package data;
import models.Restaurant;
import java.util.List;

public interface RestaurantDao {

    List<Restaurant> getAllRestaurants();
    Restaurant getByRestaurantId(int restaurantId);
    Restaurant create(Restaurant restaurant);
    void update(int restaurantId, Restaurant restaurant);
    void delete(int restaurantId);
}
