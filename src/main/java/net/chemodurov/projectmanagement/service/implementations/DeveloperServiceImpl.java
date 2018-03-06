package net.chemodurov.projectmanagement.service.implementations;

import net.chemodurov.projectmanagement.dao.DeveloperDAO;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Skill;
import net.chemodurov.projectmanagement.service.DeveloperService;

import java.util.Set;

public class DeveloperServiceImpl implements DeveloperService{
    private DeveloperDAO developerDAO;

    public DeveloperServiceImpl(DeveloperDAO developerDAO) {
        this.developerDAO = developerDAO;
    }

    @Override
    public void addDeveloper(Developer developer) {
        this.developerDAO.insert(developer);
    }

    @Override
    public void updateDeveloper(Developer developer) {
        this.developerDAO.update(developer);

    }

    @Override
    public void deleteDeveloper(Long id) {
        this.developerDAO.delete(id);
    }

    @Override
    public Developer getDeveloperById(Long id) {
        return this.developerDAO.getById(id);
    }

    @Override
    public Developer getDeveloperByName(String firstName, String lastName) {
        return this.developerDAO.getByName(firstName, lastName);
    }

    @Override
    public Set<Developer> getAllDevelopers() {
        return this.developerDAO.getAll();
    }
    @Override
    public Skill getSkillByName(String name) {
        return this.developerDAO.getSkillByName(name);
    }

    @Override
    public void deleteSkillsFromDev(Long id) {
        this.developerDAO.deleteSkillsFromDev(id);
    }
}
