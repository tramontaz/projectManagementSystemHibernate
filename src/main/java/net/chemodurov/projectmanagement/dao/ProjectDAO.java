package net.chemodurov.projectmanagement.dao;

import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;

import java.util.UUID;

public interface ProjectDAO extends GenericDAO<Project, Long>{
    Project getByName(String name);
    Team getTeamByName(String name);
    void deleteTeamsFromProject(Long id);
}
