package net.chemodurov.projectmanagement.controller;

import net.chemodurov.projectmanagement.model.Skill;

import java.util.Set;

public interface SkillController {
    void addSkill(Skill skill);

    void updateSkill(Skill skill);

    void deleteSkill(Long id);

    Skill getSkillById(Long id);

    Skill getSkillByName(String name);

    public Set<Skill> getAllSkills();

}
