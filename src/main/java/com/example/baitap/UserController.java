package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new UserDemo());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String submitUser(@ModelAttribute("user") UserDemo user, Model model) {
        userService.saveUser(user);
        return "redirect:/allUsers";
    }

    @GetMapping("/allUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "result";
    }
}