package controllers;

import com.example.robotdelivery.model.CartItem;
import com.example.robotdelivery.model.DeliveryAddress;
import com.example.robotdelivery.model.PaymentProfile;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderConfirmationController {

    @Controller
    public class OrderConfirmationController {

        private static final String SESSION_ITEM_KEY = "currentItem";
        private static final String SESSION_PROFILE_KEY = "paymentProfile";
        private static final String SESSION_DELIVERY_KEY = "deliveryAddress";

        private static final BigDecimal TAX_RATE = new BigDecimal("0.0825"); // same as order page

        @GetMapping("/confirmation")
        public String confirmationPage(HttpSession session, Model model) {

            menuItmInCart menuItemInCart = (menuItemInCart) session.getAttribute(SESSION_ITEM_KEY);
            PaymentProfile profile = (PaymentProfile) session.getAttribute(SESSION_PROFILE_KEY);

            // Delivery address (auto-filled / placeholder for now)
            DeliveryAddress delivery = (DeliveryAddress) session.getAttribute(SESSION_DELIVERY_KEY);
            if (delivery == null) {
                delivery = new DeliveryAddress(
                        "112 Sunbird Ln",
                        "Sunnyvale",
                        "TX",
                        "75182",
                        "United States"
                );
                session.setAttribute(SESSION_DELIVERY_KEY, delivery);
            }

            if (menuItemInCart == null) {
                // If user jumps here accidentally, send them back to order
                return "redirect:/order";
            }

            // Calculate totals
            BigDecimal subtotal = menuItemInCart.getMenuItemPrice().multiply(new BigDecimal(menuItemInCart.getQuantity()));
            BigDecimal taxes = subtotal.multiply(TAX_RATE).setScale(2, RoundingMode.HALF_UP);
            BigDecimal total = subtotal.add(taxes).setScale(2, RoundingMode.HALF_UP);

            model.addAttribute("item", menuItemInCart);
            model.addAttribute("profile", profile);
            model.addAttribute("delivery", delivery);

            model.addAttribute("subtotal", subtotal.setScale(2, RoundingMode.HALF_UP));
            model.addAttribute("taxes", taxes);
            model.addAttribute("total", total);

            return "confirmation";
        }

        @PostMapping("/confirmation/confirm-order")
        public String confirmOrder(HttpSession session) {

            // TODO next: create order record + send to status page
            // For now redirect to status placeholder
            return "redirect:/order-status";
        }
}
