package net.chemodurov.projectmanagement.controller.hibernate_controllers;

import net.chemodurov.projectmanagement.controller.CompanyController;
import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.service.CompanyService;

import java.util.Set;

public class HibernateCompanyControllerImpl implements CompanyController {
    private CompanyService companyService;

    public HibernateCompanyControllerImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void addCompany(Company company) {
        this.companyService.addCompany(company);
    }

    @Override
    public void updateCompany(Company company) {
        this.companyService.updateCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        this.companyService.deleteCompany(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return this.companyService.getCompanyById(id);
    }

    @Override
    public Company getCompanyByName(String name) {
        return this.companyService.getCompanyByName(name);
    }

    @Override
    public Set<Company> getAllCompanies() {
        return this.companyService.getAllCompanies();
    }

    @Override
    public Project getProjectByName(String name) {
        return this.companyService.getProjectByName(name);
    }

    @Override
    public void deleteProjectsFromCompany(Long id) {
        this.companyService.deleteProjectsFromCompany(id);
    }
}
