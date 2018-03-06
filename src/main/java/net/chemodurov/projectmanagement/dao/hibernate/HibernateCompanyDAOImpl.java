package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.CompanyDAO;
import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Project;

import java.util.Set;

public class HibernateCompanyDAOImpl implements CompanyDAO {
    @Override
    public Company getByName(String name) {
        return null;
    }

    @Override
    public Project getProjectByName(String name) {
        return null;
    }

    @Override
    public void deleteProjectsFromCompany(Long id) {

    }

    @Override
    public void insert(Company entity) {

    }

    @Override
    public Company getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Company entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Set<Company> getAll() {
        return null;
    }
}
