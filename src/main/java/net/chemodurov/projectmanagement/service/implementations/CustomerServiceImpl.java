package net.chemodurov.projectmanagement.service.implementations;

import net.chemodurov.projectmanagement.dao.CustomerDAO;
import net.chemodurov.projectmanagement.model.Customer;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.service.CustomersService;

import java.util.Set;

public class CustomerServiceImpl implements CustomersService{
    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void addCustomer(Customer customer) {
        this.customerDAO.insert(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customerDAO.update(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        this.customerDAO.delete(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return this.customerDAO.getById(id);
    }

    @Override
    public Customer getCustomerByName(String firstName, String lastName) {
        return this.customerDAO.getByName(firstName, lastName);
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return this.customerDAO.getAll();
    }

    @Override
    public Project getProjectByName(String name) {
        return this.customerDAO.getProjectByName(name);
    }

    @Override
    public void deleteProjectsFromCustomer(Long id) {
        this.customerDAO.deleteProjectsFromCustomer(id);
    }
}
