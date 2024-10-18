package com.example.baitap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    // Display the login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserLogin());  // Empty user object to bind form data
        return "login";  // Display the login.html form
    }

    // Handle the login form submission
    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("user") UserLogin user, Model model) {
        // Simulate checking credentials (you can add real authentication logic here)
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return "redirect:/welcome";  // Redirect to a welcome page after successful login
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";  // Reload the login form with error message
        }
    }
}
