package lk.hibernate.pos.dao.custom.impl;

import lk.hibernate.pos.dao.custom.CustomerDAO;
import lk.hibernate.pos.entity.Customer;
import lk.hibernate.pos.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Customer WHERE id = :id");
        query.setParameter("id", id);
        if (query.executeUpdate() > 0) {
            transaction.commit();
            session.close();
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Customer search(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        if (customer != null) {
            transaction.commit();
            session.close();
            return customer;
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Customer");
        List<Customer> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<Customer>) list;
    }

    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT id FROM Customer WHERE id=:id");
        String code = (String) query.setParameter("id", id).uniqueResult();
        if (code != null) {
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();

        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "C-00" + tempId;
            } else if (tempId <= 99) {
                return "C-0" + tempId;
            } else {
                return "C-" + tempId;
            }
        } else {
            return "C-001";

        }
    }
}
