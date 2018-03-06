package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.DeveloperDAO;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Skill;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateDeveloperDAOImpl implements DeveloperDAO {
    private Session session;
    private SessionFactory sessionFactory;

    public HibernateDeveloperDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Developer getByName(String firstName, String lastName) {
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
    public Skill getSkillByName(String name) {
        session = sessionFactory.openSession();
        Skill skill = null;
        Query query = session.createQuery("from Skill where name = '" + name + "'");
        if (!query.list().isEmpty()) {
            skill = (Skill) query.list().get(0);
        }
        session.close();
        return skill;
    }

    @Override
    public void deleteSkillsFromDev(Long id) {

    }

    @Override
    public void insert(Developer developer) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(developer);
        session.flush();
        session.close();
    }

    @Override
    public Developer getById(Long id) {
        session = sessionFactory.openSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;
    }


    @Override
    public void update(Developer entity) {
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
        Developer developer = session.get(Developer.class, id);
        session.delete(developer);
        session.flush();
        session.close();
    }

    @Override
    public Set<Developer> getAll() {
        Set<Developer> developers;
        session = sessionFactory.openSession();
        session.createQuery("FROM Developer ").list();
        developers = new HashSet<Developer>(session.createQuery("FROM Developer d ").list());
        session.close();
        return developers;
    }
}
