package net.chemodurov.projectmanagement.service;

import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Team;

import java.util.Set;

public interface TeamService {
    void addTeam(Team team);

    void updateTeam(Team team);

    void deleteTeam(Long id);

    Team getTeamById(Long id);

    Team getTeamByName(String name);

    Set<Team> getAllTeams();

    Developer getDeveloperByName(String firstName, String lastName);

    void deleteDevelopersFromTeam(Long id);
}
