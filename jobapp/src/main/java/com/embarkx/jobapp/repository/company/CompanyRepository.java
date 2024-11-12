package com.embarkx.jobapp.repository.company;

import com.embarkx.jobapp.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
