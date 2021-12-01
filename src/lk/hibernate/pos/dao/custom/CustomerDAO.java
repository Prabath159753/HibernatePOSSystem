package lk.hibernate.pos.dao.custom;

import lk.hibernate.pos.dao.SuperDAO;
import lk.hibernate.pos.entity.Customer;

import java.sql.SQLException;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public interface CustomerDAO extends SuperDAO<Customer, String> {
    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;
}
