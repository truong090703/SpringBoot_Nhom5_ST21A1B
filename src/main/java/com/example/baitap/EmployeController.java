package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/addEmploye")
    public String showAddEmployeForm(Model model) {
        model.addAttribute("employe", new Employe());
        model.addAttribute("allCompanies", companyService.getAll());
        return "addEmploye";
    }

    @PostMapping("/addEmploye")
    public String submitEmploye(@ModelAttribute("employe") Employe employe) {
        employeService.saveEmploye(employe);
        return "redirect:/allEmployes";
    }

    @GetMapping("/allEmployes")
    public String showAllEmployes(Model model) {
        List<Employe> employes = employeService.getAllEmployes();
        model.addAttribute("employes", employes);
        return "listEmployes";
    }

    @GetMapping("/editEmploye/{id}")
    public String showEditEmployeForm(@PathVariable("id") int id, Model model) {
        Employe employe = employeService.getEmployeById(id);
        model.addAttribute("employe", employe);
        model.addAttribute("allCompanies", companyService.getAll());
        return "editEmploye";
    }

    @PostMapping("/editEmploye/{id}")
    public String updateEmploye(@PathVariable("id") int id, @ModelAttribute("employe") Employe updatedEmploye) {
        employeService.saveEmploye(updatedEmploye);
        return "redirect:/allEmployes";
    }


    @GetMapping("/deleteEmploye/{id}")
    public String deleteEmploye(@PathVariable("id") int id) {
        employeService.deleteEmploye(id);
        return "redirect:/allEmployes";
    }
}
