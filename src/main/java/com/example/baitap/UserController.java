package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String submitUser(@ModelAttribute("user") UserDemo user) {
        userService.saveUser(user);
        return "redirect:/allUsers";
    }


    @GetMapping("/allUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "result";
    }

    @GetMapping("/allUsers/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        UserDemo user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userDetail";
        } else {
            return "redirect:/allUsers";
        }
    }


    @GetMapping("/editUser/{id}")
    public String showEditUserForm(@PathVariable("id") int id, Model model) {
        UserDemo user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "editUser";
        } else {
            return "redirect:/allUsers";
        }
    }


    @PostMapping("/editUser/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") UserDemo updatedUser) {
        userService.updateUser(id, updatedUser);
        return "redirect:/allUsers";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }
}
