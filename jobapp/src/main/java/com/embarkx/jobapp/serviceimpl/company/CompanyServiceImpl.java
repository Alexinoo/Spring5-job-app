package com.embarkx.jobapp.serviceimpl.company;

import com.embarkx.jobapp.model.company.Company;
import com.embarkx.jobapp.repository.company.CompanyRepository;
import com.embarkx.jobapp.service.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void createCompany(Company newCompany) {
        companyRepository.save(newCompany);
    }
    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company existingCompany = companyOptional.get();
            existingCompany.setName(updatedCompany.getName());
            existingCompany.setDescription(updatedCompany.getDescription());
            existingCompany.setJobs(updatedCompany.getJobs());
            companyRepository.save(existingCompany);
            return true;
        }
        return false;
    }



}
