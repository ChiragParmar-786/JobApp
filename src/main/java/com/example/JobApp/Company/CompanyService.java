package com.example.JobApp.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company findCompanyById(Long id);

    Boolean removeCompanyById(Long id);

    Boolean updateCompanyById(Long id, Company company);

}
