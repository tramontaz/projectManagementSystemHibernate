package net.chemodurov.projectmanagement.service.implementations;

import net.chemodurov.projectmanagement.dao.ProjectDAO;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;
import net.chemodurov.projectmanagement.service.ProjectService;

import java.util.Set;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDAO projectDAO;

    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public void addProject(Project project) {
        this.projectDAO.insert(project);
    }

    @Override
    public void updateProject(Project project) {
        this.projectDAO.update(project);
    }

    @Override
    public void deleteProject(Long id) {
        this.projectDAO.delete(id);
    }

    @Override
    public Project getProjectById(Long id) {
        return this.projectDAO.getById(id);
    }

    @Override
    public Project getProjectByName(String name) {
        return this.projectDAO.getByName(name);
    }

    @Override
    public Set<Project> getAllProjects() {
        return this.projectDAO.getAll();
    }

    @Override
    public Team getTeamByName(String name) {
        return this.projectDAO.getTeamByName(name);
    }

    @Override
    public void deleteTeamsFromProject(Long id) {
        this.projectDAO.deleteTeamsFromProject(id);
    }
}
