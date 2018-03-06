package net.chemodurov.projectmanagement.dao;

import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Project;

import java.util.UUID;

public interface CompanyDAO extends GenericDAO<Company, Long> {
    Company getByName(String name);
    Project getProjectByName(String name);
    void deleteProjectsFromCompany(Long id);
}
