package lk.hibernate.pos.dao.custom.impl;

import lk.hibernate.pos.dao.custom.ItemDAO;
import lk.hibernate.pos.entity.Item;
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

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String itemCode) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Item WHERE itemCode = :itemCode");
        query.setParameter("itemCode", itemCode);

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
    public boolean update(Item item) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Item search(String itemCode) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class, itemCode);

        if (item != null) {
            transaction.commit();
            session.close();
            return item;
        }

        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Item");
        List<Item> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<Item>) list;
    }

    @Override
    public boolean ifItemExist(String itemCode) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT itemCode FROM Item WHERE itemCode = :itemCode");
        String code = (String) query.setParameter("itemCode", itemCode).uniqueResult();

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
        NativeQuery query = session.createSQLQuery("SELECT itemCode FROM Item ORDER BY itemCode DESC LIMIT 1");
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();

        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "I-00" + tempId;
            } else if (tempId <= 99) {
                return "I-0" + tempId;
            } else {
                return "I-" + tempId;
            }
        } else {
            return "I-001";
        }
    }
}
