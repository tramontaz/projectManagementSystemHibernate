package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.TeamDAO;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Team;

import java.util.Set;

public class HibernateTeamDAOImpl implements TeamDAO {
    @Override
    public Team getByName(String name) {
        return null;
    }

    @Override
    public Developer getDevByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public void deleteDevFromTeam(Long id) {

    }

    @Override
    public void insert(Team entity) {

    }

    @Override
    public Team getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Team entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Set<Team> getAll() {
        return null;
    }
}
