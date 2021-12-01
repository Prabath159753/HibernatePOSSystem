package lk.hibernate.pos.dao.custom;

import lk.hibernate.pos.dao.SuperDAO;
import lk.hibernate.pos.entity.Item;

import java.sql.SQLException;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public interface ItemDAO extends SuperDAO<Item, String> {
    boolean ifItemExist(String itemCode) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;
}

