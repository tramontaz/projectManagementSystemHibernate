package net.chemodurov.projectmanagement.controller;

import net.chemodurov.projectmanagement.model.Customer;
import net.chemodurov.projectmanagement.model.Project;

import java.util.Set;

public interface CustomerController {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer getCustomerById(Long id);

    Customer getCustomerByName(String firstName, String lastName);

    Set<Customer> getAllCustomers();

    Project getProjectByName(String name);

    void deleteProjectsFromCustomer(Long id);
}
