package net.chemodurov.projectmanagement.controller.hibernate_controllers;

import net.chemodurov.projectmanagement.controller.SkillController;
import net.chemodurov.projectmanagement.model.Skill;
import net.chemodurov.projectmanagement.service.SkillService;

import java.util.Set;

public class HibernateSkillControllerImpl implements SkillController {
    private SkillService skillService;

    public HibernateSkillControllerImpl(SkillService skillService) {
        this.skillService = skillService;
    }

    @Override
    public void addSkill(Skill skill) {
        this.skillService.addSkill(skill);
    }

    @Override
    public void updateSkill(Skill skill) {
        this.skillService.updateSkill(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        this.skillService.deleteSkill(id);
    }

    @Override
    public Skill getSkillById(Long id) {
        return this.skillService.getSkillById(id);
    }

    @Override
    public Skill getSkillByName(String name) {
        return this.skillService.getSkillByName(name);
    }

    @Override
    public Set<Skill> getAllSkills() {
        return this.skillService.getAllSkills();
    }
}
