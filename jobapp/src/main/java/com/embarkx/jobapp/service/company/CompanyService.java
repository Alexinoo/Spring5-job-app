package com.embarkx.jobapp.service.company;

import com.embarkx.jobapp.model.company.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(Company company,Long id);

    void createCompany(Company newCompany);
}
