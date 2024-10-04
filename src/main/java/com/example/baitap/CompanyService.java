package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Company company) {
        companyRepository.save(company);
    }

    public void delete(int id) {
        companyRepository.deleteById(id);
    }
}
