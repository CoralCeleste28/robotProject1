package controllers;

import com.example.robotdelivery.model.CartItem;
import models.MenuItemInCart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.math.RoundingMode;

@Controller
public class CartController {
    private CartControllerDAO cartControllerDAO;
    private UserDAO userDAO;
    private MenuItemDao manuItemDAO;


    private static final String SESSION_ITEM_KEY = "currentItem";
    private static final Double TAX_RATE = new Double("0.0825"); // 8.25% example

    public OrderCart getCart(){

    }

    @GetMapping("/order")
    public String orderPage(
            @RequestParam(required = false) Integer menuItemId,
            HttpSession session,
            Model model
    ) {
        // If we arrived from restaurant page with an itemId, load that item into session
        if (menuItemId != null) {
            MenuItemInCart selected = buildItemById(menuItemId);
            if (selected != null) {
                session.setAttribute(SESSION_ITEM_KEY, selected);
            }
        }

        MenuItemInCart item = (MenuItemInCart) session.getAttribute(SESSION_ITEM_KEY);

        // Fallback (in case user goes directly to /order)
        if (item == null) {
            item = buildItemById(1);
            session.setAttribute(SESSION_ITEM_KEY, menuItemId);
        }

        Double subtotal = item.getMenuItemTotal().multiply(new Double(item.getQuantity()));
        Double taxes = subtotal.multiply(TAX_RATE).setScale(2, RoundingMode.HALF_UP);
        Double total = subtotal.add(taxes).setScale(2, RoundingMode.HALF_UP);

        model.addAttribute("item", item);
        model.addAttribute("subtotal", subtotal.setScale(2, RoundingMode.HALF_UP));
        model.addAttribute("taxes", taxes);
        model.addAttribute("total", total);

        return "order";
    }

    @PostMapping("/order/quantity")
    public String updateQuantity(@RequestParam String action, HttpSession session) {
        MenuItemInCart item = (MenuItemInCart) session.getAttribute(SESSION_ITEM_KEY);
        if (item == null) return "redirect:/order";

        int qty = item.getQuantity();

        if ("plus".equalsIgnoreCase(action)) {
            qty++;
        } else if ("minus".equalsIgnoreCase(action)) {
            qty = Math.max(1, qty - 1);
        }

        item.setQuantity(qty);
        session.setAttribute(SESSION_ITEM_KEY, item);

        return "redirect:/order";
    }

    @PostMapping("/cart/add")
    public String addToCart(HttpSession session) {
        // TODO: In the next step, store this in a real cart list in session or DB
        // For now, just redirect to a confirmation page or payment later
        return "redirect:/checkout";
    }

    private MenuItemInCart buildItemById(int itemId) {
        if (itemId == 1) {
            return new MenuItemInCart(
                    1,
                    "Taco Combo",
                    "Three ribeye steak tacos wrapped in handmade corn tortillas. Served with a side of basmati rice and refried beans.",
                    new Double("15.00"),
                    "/images/taco-combo.jpg",
                    1
            );
        }
        if (itemId == 2) {
            return new MenuItemInCart(
                    2,
                    "Butter Chicken",
                    "Tender chicken pieces cooked in a creamy tomato-based sauce with aromatic spices.",
                    new Double("15.00"),
                    "/images/butter-chicken.jpg",
                    1
            );
        }
        return null;
    }

}
