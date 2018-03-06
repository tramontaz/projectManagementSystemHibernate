package net.chemodurov.projectmanagement.dao;

import net.chemodurov.projectmanagement.model.Skill;

import java.util.UUID;

public interface SkillDAO extends GenericDAO<Skill, Long> {
    Skill getByName(String name);
}
