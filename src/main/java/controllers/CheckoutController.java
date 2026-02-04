package controllers;

public class CheckoutController {
    @PostMapping("/checkout/submit")
    public String submitPaymentInfo(@ModelAttribute("profile") PaymentProfile updatedProfile,
                                    HttpSession session) {

        // Save latest values back into session (later: DB)
        session.setAttribute("paymentProfile", updatedProfile);

        // Next screen will be provided later
        return "redirect:/next-screen";
    }
}
