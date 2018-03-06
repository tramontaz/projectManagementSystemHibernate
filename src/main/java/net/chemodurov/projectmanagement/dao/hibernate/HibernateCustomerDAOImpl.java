package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.CustomerDAO;
import net.chemodurov.projectmanagement.model.Customer;
import net.chemodurov.projectmanagement.model.Project;

import java.util.Set;

public class HibernateCustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer getByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Project getProjectByName(String name) {
        return null;
    }

    @Override
    public void deleteProjectsFromCustomer(Long id) {

    }

    @Override
    public void insert(Customer entity) {

    }

    @Override
    public Customer getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Customer entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Set<Customer> getAll() {
        return null;
    }
}
