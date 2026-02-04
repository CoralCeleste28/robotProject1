package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {

    @Controller
    public class LoginController {

        @GetMapping("/login")
        public String showLoginPage() {
            return "login";
        }

        @PostMapping("/login")
        public String processLogin(
                @RequestParam String email,
                @RequestParam String password,
                Model model
        ) {
            // TEMP logic – replace later with real authentication
            if (email.equals("test@test.com") && password.equals("password")) {
                return "redirect:/order";
            }

            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
}
