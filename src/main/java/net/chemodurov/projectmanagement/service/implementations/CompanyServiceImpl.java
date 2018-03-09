package net.chemodurov.projectmanagement.service.implementations;

import net.chemodurov.projectmanagement.dao.CompanyDAO;
import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.service.CompanyService;

import java.util.Set;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public void addCompany(Company company) {
        this.companyDAO.insert(company);
    }

    @Override
    public void updateCompany(Company company) {
        this.companyDAO.update(company);
    }

    @Override
    public void deleteCompany(Long id) {
        this.companyDAO.delete(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return this.companyDAO.getById(id);
    }

    @Override
    public Company getCompanyByName(String name) {
        return this.companyDAO.getByName(name);
    }

    @Override
    public Set<Company> getAllCompanies() {
        return this.companyDAO.getAll();
    }

    @Override
    public Project getProjectByName(String name) {
        return this.companyDAO.getProjectByName(name);
    }

    @Override
    public void deleteProjectsFromCompany(Long id) {
        this.companyDAO.deleteProjectsFromCompany(id);
    }
}
