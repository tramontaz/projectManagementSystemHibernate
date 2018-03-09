package net.chemodurov.projectmanagement.service;

import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;

import java.util.Set;

public interface ProjectService {
    void addProject(Project project);

    void updateProject(Project project);

    void deleteProject(Long id);

    Project getProjectById(Long id);

    Project getProjectByName(String name);

    Set<Project> getAllProjects();

    Team getTeamByName(String name);

    void deleteTeamsFromProject(Long id);
}
