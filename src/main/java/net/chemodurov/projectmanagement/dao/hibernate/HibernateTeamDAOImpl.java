package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.TeamDAO;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class HibernateTeamDAOImpl implements TeamDAO {
    private Session session;
    private SessionFactory sessionFactory;

    public HibernateTeamDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public Team getByName(String name) {
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
    public Developer getDevByName(String firstName, String lastName) {
        Developer developer = null;
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Developer where firstName = '" + firstName + "' and lastName = '" + lastName + "'");
        if (!query.list().isEmpty()) {
            developer = (Developer) query.list().get(0);
        }
        session.close();
        return developer;
    }

    @Override
    public void deleteDevFromTeam(Long id) {

    }

    @Override
    public void insert(Team entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        session.close();
    }

    @Override
    public Team getById(Long id) {
        session = sessionFactory.openSession();
        Team team = session.get(Team.class, id);
        session.close();
        return team;
    }

    @Override
    public void update(Team entity) {
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
        Team team = session.get(Team.class, id);
        session.delete(team);
        session.flush();
        session.close();
    }

    @Override
    public Set<Team> getAll() {
        Set<Team> teams;
        session = sessionFactory.openSession();
        session.createQuery("FROM Team").list();
        teams = new HashSet<Team>(session.createQuery("FROM Team").list());
        session.close();
        return teams;
    }
}
