package net.chemodurov.projectmanagement.service;

import net.chemodurov.projectmanagement.model.Skill;

import java.util.Set;

public interface SkillService {

    void addSkill(Skill skill);

    void updateSkill(Skill skill);

    void deleteSkill(Long id);

    Skill getSkillById(Long id);

    Skill getSkillByName(String name);

    Set<Skill> getAllSkills();
}
