package net.chemodurov.projectmanagement.controller.hibernate_controllers;

import net.chemodurov.projectmanagement.controller.DeveloperController;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Skill;
import net.chemodurov.projectmanagement.service.DeveloperService;

import java.util.Set;

public class HibernateDeveloperController implements DeveloperController {
    private DeveloperService developerService;

    public HibernateDeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @Override
    public void addDeveloper(Developer developer) {
        this.developerService.addDeveloper(developer);
    }

    @Override
    public void updateDeveloper(Developer developer) {
        this.developerService.updateDeveloper(developer);
    }

    @Override
    public void deleteDeveloper(Long id) {
        this.developerService.deleteDeveloper(id);
    }

    @Override
    public Developer getDeveloperById(Long id) {
        return this.developerService.getDeveloperById(id);
    }

    @Override
    public Developer getDeveloperByName(String firstName, String lastName) {
        return this.developerService.getDeveloperByName(firstName, lastName);
    }

    @Override
    public Set<Developer> getAllDevelopers() {
        return this.developerService.getAllDevelopers();
    }

    @Override
    public Skill getSkillByName(String name) {
        return this.developerService.getSkillByName(name);
    }

    @Override
    public void deleteSkillsFromDev(Long id) {
        this.developerService.deleteSkillsFromDev(id);
    }
}
