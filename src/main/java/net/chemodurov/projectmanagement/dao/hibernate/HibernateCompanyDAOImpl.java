package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.CompanyDAO;
import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class HibernateCompanyDAOImpl implements CompanyDAO {
    private Session session;
    private SessionFactory sessionFactory;

    public HibernateCompanyDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Company getByName(String name) {
        Company company = null;
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Company where name = '" + name + "'");
        if (!query.list().isEmpty()) {
            company = (Company) query.list().get(0);
        }
        session.close();
        return company;
    }

    @Override
    public Project getProjectByName(String name) {
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
    public void deleteProjectsFromCompany(Long id) {

    }

    @Override
    public void insert(Company entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        session.close();
    }

    @Override
    public Company getById(Long id) {
        session = sessionFactory.openSession();
        Company company = session.get(Company.class, id);
        session.close();
        return company;
    }

    @Override
    public void update(Company entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.flush();
        session.close();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Set<Company> getAll() {
        Set<Company> companies;
        session = sessionFactory.openSession();
        session.createQuery("FROM Company").list();
        companies = new HashSet<Company>(session.createQuery("FROM Company").list());
        session.close();
        return companies;
    }
}
