package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.SkillDAO;
import net.chemodurov.projectmanagement.model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateSkillDAOImpl implements SkillDAO {
    private Session session;
    private SessionFactory sessionFactory;

    public HibernateSkillDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Skill getByName(String name) {
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
    public void insert(Skill skill) {
        session = sessionFactory.openSession();
        session.save(skill);
        session.close();
    }

    @Override
    public Skill getById(Long id) {
        session = sessionFactory.openSession();
        Skill skill = session.get(Skill.class, id);
        session.close();
        return skill;
    }

    @Override
    public void update(Skill skill) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(skill);
        session.flush();
        session.close();
    }

    @Override
    public void delete(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Skill skill = session.get(Skill.class, id);
        session.delete(skill);
        session.flush();
        session.close();
    }

    @Override
    public Set<Skill> getAll() {
        Set<Skill> skills;
        session = sessionFactory.openSession();
        session.createQuery("FROM Skill").list();
        skills = new HashSet<Skill>(session.createQuery("FROM Skill").list());
        session.close();
        return skills;
    }
}
