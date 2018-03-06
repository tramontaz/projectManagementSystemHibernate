package net.chemodurov.projectmanagement.dao;

import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Team;

import java.util.UUID;

public interface TeamDAO extends GenericDAO<Team, Long> {
    Team getByName(String name);
    Developer getDevByName(String firstName, String lastName);
    void deleteDevFromTeam(Long id);
}