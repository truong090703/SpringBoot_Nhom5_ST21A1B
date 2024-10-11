package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    public void saveEmploye(Employe employe) {
        employeRepository.save(employe);
    }

    public Employe getEmployeById(int id) {
        return employeRepository.findById(id).orElse(null);
    }

    public void deleteEmploye(int id) {
        employeRepository.deleteById(id);
    }
}
