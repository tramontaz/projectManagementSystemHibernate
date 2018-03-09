package net.chemodurov.projectmanagement.controller.hibernate_controllers;

import net.chemodurov.projectmanagement.controller.TeamController;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Team;
import net.chemodurov.projectmanagement.service.TeamService;

import java.util.Set;

public class HibernateTeamsControllerImpl implements TeamController {
    private TeamService teamService;

    public HibernateTeamsControllerImpl(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void addTeam(Team team) {
        this.teamService.addTeam(team);
    }

    @Override
    public void updateTeam(Team team) {
        this.teamService.updateTeam(team);
    }

    @Override
    public void deleteTeam(Long id) {
        this.teamService.deleteTeam(id);
    }

    @Override
    public Team getTeamById(Long id) {
        return this.teamService.getTeamById(id);
    }

    @Override
    public Team getTeamByName(String name) {
        return this.teamService.getTeamByName(name);
    }

    @Override
    public Set<Team> getAllTeams() {
        return this.teamService.getAllTeams();
    }

    @Override
    public Developer getDeveloperByName(String firstName, String lastName) {
        return this.teamService.getDeveloperByName(firstName, lastName);
    }

    @Override
    public void deleteDevelopersFromTeam(Long id) {
        this.teamService.deleteDevelopersFromTeam(id);
    }
}
