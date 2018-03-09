package net.chemodurov.projectmanagement.service;

import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Project;

import java.util.Set;

public interface CompanyService {
    void addCompany(Company company);

    void updateCompany(Company company);

    void deleteCompany(Long id);

    Company getCompanyById(Long id);

    Company getCompanyByName(String name);

    Set<Company> getAllCompanies();

    Project getProjectByName(String name);

    void deleteProjectsFromCompany(Long id);
}
