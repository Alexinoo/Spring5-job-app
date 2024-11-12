package com.embarkx.jobapp.serviceimpl.company;

import com.embarkx.jobapp.model.company.Company;
import com.embarkx.jobapp.repository.company.CompanyRepository;
import com.embarkx.jobapp.service.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
