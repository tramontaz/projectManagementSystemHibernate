package net.chemodurov.projectmanagement.controller.hibernate_controllers;

import net.chemodurov.projectmanagement.controller.CustomerController;
import net.chemodurov.projectmanagement.model.Customer;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.service.CustomersService;

import java.util.Set;

public class HibernateCustomerControllerImpl implements CustomerController {
    private CustomersService customersService;

    public HibernateCustomerControllerImpl(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public void addCustomer(Customer customer) {
        this.customersService.addCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customersService.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        this.customersService.deleteCustomer(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return this.customersService.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByName(String firstName, String lastName) {
        return this.customersService.getCustomerByName(firstName, lastName);
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return this.customersService.getAllCustomers();
    }

    @Override
    public Project getProjectByName(String name) {
        return this.customersService.getProjectByName(name);
    }

    @Override
    public void deleteProjectsFromCustomer(Long id) {
        this.customersService.deleteProjectsFromCustomer(id);
    }
}
