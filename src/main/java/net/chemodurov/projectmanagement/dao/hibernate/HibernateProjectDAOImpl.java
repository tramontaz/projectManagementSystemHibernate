package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.ProjectDAO;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class HibernateProjectDAOImpl implements ProjectDAO {
    private Session session;
    private SessionFactory sessionFactory;

    public HibernateProjectDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Project getByName(String name) {
        Project project = null;
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Project where name = '" + name + "'");
        if (!query.list().isEmpty()) {
            project = (Project) query.list().get(0);
        }
        session.close();
        return project;
    }

    @Override
    public Team getTeamByName(String name) {
        Team team = null;
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Team where name = '" + name + "'");
        if (!query.list().isEmpty()) {
            team = (Team) query.list().get(0);
        }
        session.close();
        return team;
    }

    @Override
    public void deleteTeamsFromProject(Long id) {

    }

    @Override
    public void insert(Project entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        session.close();
    }

    @Override
    public Project getById(Long id) {
        session = sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    @Override
    public void update(Project entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.flush();
        session.close();
    }

    @Override
    public void delete(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Project project = session.get(Project.class, id);
        session.delete(project);
        session.flush();
        session.close();
    }

    @Override
    public Set<Project> getAll() {
        Set<Project> projects;
        session = sessionFactory.openSession();
        session.createQuery("FROM Project ").list();
        projects = new HashSet<Project>(session.createQuery("FROM Project ").list());
        session.close();
        return projects;
    }
}
