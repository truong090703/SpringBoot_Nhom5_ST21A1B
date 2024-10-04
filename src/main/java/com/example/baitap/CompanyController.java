package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @GetMapping("/addCompany")
    public String add(Model model) {
        model.addAttribute("company", new Company());
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String saveOrUpdate(@ModelAttribute("company") Company company) {
        List<UserDemo> users = userService.getAllUsers();
        company.setUsers(users);
        companyService.saveOrUpdate(company);
        return "redirect:/companies";
    }


    @GetMapping("/companies")
    public String trangChiTiet(Model model) {
        List<Company> companies = companyService.getAll();
        model.addAttribute("companies", companies);
        return "companies";
    }
}
