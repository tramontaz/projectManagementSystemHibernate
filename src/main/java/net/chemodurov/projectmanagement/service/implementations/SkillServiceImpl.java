package net.chemodurov.projectmanagement.service.implementations;

import net.chemodurov.projectmanagement.dao.SkillDAO;
import net.chemodurov.projectmanagement.model.Skill;
import net.chemodurov.projectmanagement.service.SkillService;

import java.util.Set;
import java.util.UUID;

public class SkillServiceImpl implements SkillService{
    private SkillDAO skillDAO;

    public SkillServiceImpl(SkillDAO skillDAO) {
        this.skillDAO = skillDAO;
    }

    @Override
    public void addSkill(Skill skill) {
        this.skillDAO.insert(skill);
    }

    @Override
    public void updateSkill(Skill skill) {
        this.skillDAO.update(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        this.skillDAO.delete(id);
    }

    @Override
    public Skill getSkillById(Long id) {
        return this.skillDAO.getById(id);
    }

    @Override
    public Skill getSkillByName(String name) {
        return this.skillDAO.getByName(name);
    }

    @Override
    public Set<Skill> getAllSkills() {
        return this.skillDAO.getAll();
    }
}
