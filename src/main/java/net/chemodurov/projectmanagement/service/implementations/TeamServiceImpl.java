package net.chemodurov.projectmanagement.service.implementations;

import net.chemodurov.projectmanagement.dao.TeamDAO;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Team;
import net.chemodurov.projectmanagement.service.TeamService;

import java.util.Set;

public class TeamServiceImpl implements TeamService {
    private TeamDAO teamDAO;

    public TeamServiceImpl(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    public void addTeam(Team team) {
        this.teamDAO.insert(team);
    }

    @Override
    public void updateTeam(Team team) {
        this.teamDAO.update(team);
    }

    @Override
    public void deleteTeam(Long id) {
        this.teamDAO.delete(id);
    }

    @Override
    public Team getTeamById(Long id) {
        return this.teamDAO.getById(id);
    }

    @Override
    public Team getTeamByName(String name) {
        return this.teamDAO.getByName(name);
    }

    @Override
    public Set<Team> getAllTeams() {
        return this.teamDAO.getAll();
    }

    @Override
    public Developer getDeveloperByName(String firstName, String lastName) {
        return this.teamDAO.getDevByName(firstName, lastName);
    }

    @Override
    public void deleteDevelopersFromTeam(Long id) {
        this.teamDAO.deleteDevFromTeam(id);
    }
}
