package com.embarkx.jobapp.controller.company;

import com.embarkx.jobapp.model.company.Company;
import com.embarkx.jobapp.service.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company newCompany){
        companyService.createCompany(newCompany);
        return new ResponseEntity<>("New Company added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompanyById(@RequestBody Company updatedCompany ,
                                                    @PathVariable Long companyId){
        boolean isCompanyUpdated = companyService.updateCompany(updatedCompany,companyId);
        if (isCompanyUpdated)
            return new ResponseEntity<>("Company updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
