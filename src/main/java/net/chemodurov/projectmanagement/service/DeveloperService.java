package net.chemodurov.projectmanagement.service;

import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Skill;

import java.util.Set;

public interface DeveloperService {
    void addDeveloper(Developer developer);

    void updateDeveloper(Developer developer);

    void deleteDeveloper(Long id);

    Developer getDeveloperById(Long id);

    Developer getDeveloperByName(String firstName, String lastName);

    Set<Developer> getAllDevelopers();

    Skill getSkillByName(String name);

    void deleteSkillsFromDev(Long id);
}
