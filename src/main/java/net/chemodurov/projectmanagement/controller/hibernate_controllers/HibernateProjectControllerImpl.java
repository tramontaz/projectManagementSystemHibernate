package net.chemodurov.projectmanagement.controller.hibernate_controllers;

import net.chemodurov.projectmanagement.controller.ProjectController;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;
import net.chemodurov.projectmanagement.service.ProjectService;

import java.util.Set;

public class HibernateProjectControllerImpl implements ProjectController {
    private ProjectService projectService;

    public HibernateProjectControllerImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void addProject(Project project) {
        this.projectService.addProject(project);
    }

    @Override
    public void updateProject(Project project) {
        this.projectService.updateProject(project);
    }

    @Override
    public void deleteProject(Long id) {
        this.projectService.deleteProject(id);
    }

    @Override
    public Project getProjectById(Long id) {
        return this.projectService.getProjectById(id);
    }

    @Override
    public Project getProjectByName(String name) {
        return this.projectService.getProjectByName(name);
    }

    @Override
    public Set<Project> getAllProjects() {
        return this.projectService.getAllProjects();
    }

    @Override
    public Team getTeamByName(String name) {
        return this.projectService.getTeamByName(name);
    }

    @Override
    public void deleteTeamsFromProject(Long id) {
        this.projectService.deleteTeamsFromProject(id);
    }
}
