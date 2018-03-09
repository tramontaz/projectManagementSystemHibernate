package net.chemodurov.projectmanagement.dao.hibernate;

import net.chemodurov.projectmanagement.dao.CustomerDAO;
import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Customer;
import net.chemodurov.projectmanagement.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class HibernateCustomerDAOImpl implements CustomerDAO {
    private Session session;
    private SessionFactory sessionFactory;

    public HibernateCustomerDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Customer getByName(String firstName, String lastName) {
        Customer customer = null;
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Customer where firstName = '" + firstName + "' and lastName = '" + lastName + "'");
        if (!query.list().isEmpty()) {
            customer = (Customer) query.list().get(0);
        }
        session.close();
        return customer;
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
    public void deleteProjectsFromCustomer(Long id) {

    }

    @Override
    public void insert(Customer entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        session.close();
    }

    @Override
    public Customer getById(Long id) {
        session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public void update(Customer entity) {
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
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        session.flush();
        session.close();
    }

    @Override
    public Set<Customer> getAll() {
        Set<Customer> customers;
        session = sessionFactory.openSession();
        session.createQuery("FROM Company").list();
        customers = new HashSet<Customer>(session.createQuery("FROM Customer").list());
        session.close();
        return customers;
    }
}
