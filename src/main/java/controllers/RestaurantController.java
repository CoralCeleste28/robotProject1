package controllers;

import data.MenuItemDao;
import data.RestaurantDao;
import models.MenuItem;
import models.Restaurant;

import java.util.List;
import com.example.robotdelivery.model.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantController {

    private RestaurantDao restaurantDao;
    private MenuItemDao menuItemDao;

    @GetMapping("/restaurant")
    public String restaurantPage(Model model) {

        // Restaurant info
        model.addAttribute("restaurantName", "Saffron & Serrano");
        model.addAttribute("slogan", "Where Indian spice meets Mexican soul.");
        model.addAttribute("logoPath", "/images/logo.png"); // put your logo in static/images/

        // Menu items
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem(
                1,
                "Taco Combo",
                new Double("15.00"),
                "Three ribeye steak tacos wrapped in handmade corn tortillas. Served with a side of basmati rice and refried beans."
        ));
        menu.add(new MenuItem(
                2,
                "Butter Chicken",
                new Double("15.00"),
                "Tender chicken pieces cooked in a creamy tomato-based sauce with aromatic spices."
        ));

        model.addAttribute("menu", menu);

        return "restaurant";
    }

    @PostMapping("/add-to-order")
    public String addToOrder(@RequestParam int itemId) {
        // TODO: Later you’ll store this in a cart (session or DB)
        // For now, just redirect back to restaurant page
        return "redirect:/restaurant";
    }

    // THE CODE BELOW IS IN CASE W ADD A SEARCH BAR

//    public List<Restaurant> getAll() {
//        return null;
//    }
//
//    public Restaurant getByRestaurantId(@PathVariable int menuItemId) {
//        // get the category by id
//        return null;
//    }
//
//    // @GetMapping("{restaurantId}/menuItem")
//    public List<MenuItem> getMenuItemByID(@PathVariable int restaurantId) {
//        // get a list of product by categoryId
//        return null;
//    }
//
//    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
//        // insert the category
//        return null;
//    }
}


