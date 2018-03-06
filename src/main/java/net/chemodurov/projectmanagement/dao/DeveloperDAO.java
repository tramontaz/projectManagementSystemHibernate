package net.chemodurov.projectmanagement.dao;

import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Skill;

import java.util.UUID;

public interface DeveloperDAO extends GenericDAO<Developer, Long> {

    Developer getByName(String firstName, String lastName); //select
    Skill getSkillByName(String name);
    void deleteSkillsFromDev(Long id);
}
