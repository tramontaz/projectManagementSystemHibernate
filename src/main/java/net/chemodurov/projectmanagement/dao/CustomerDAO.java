package net.chemodurov.projectmanagement.dao;

import net.chemodurov.projectmanagement.model.Customer;
import net.chemodurov.projectmanagement.model.Project;

import java.util.UUID;

public interface CustomerDAO extends GenericDAO<Customer, Long> {
    Customer getByName(String firstName, String lastName);
    Project getProjectByName(String name);
    void deleteProjectsFromCustomer(Long id);
}

