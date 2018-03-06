package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.ProjectDAO;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;

import java.util.Set;
import java.util.UUID;

public class HibernateProjectDAOImpl implements ProjectDAO {
    @Override
    public Project getByName(String name) {
        return null;
    }

    @Override
    public Team getTeamByName(String name) {
        return null;
    }

    @Override
    public void deleteTeamsFromProject(Long id) {

    }

    @Override
    public void insert(Project entity) {

    }

    @Override
    public Project getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Project entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Set<Project> getAll() {
        return null;
    }
}
