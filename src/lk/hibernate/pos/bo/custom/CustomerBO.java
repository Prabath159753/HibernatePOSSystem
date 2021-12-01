package lk.hibernate.pos.bo.custom;

import lk.hibernate.pos.bo.SuperBO;
import lk.hibernate.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public interface CustomerBO extends SuperBO {

    ArrayList<CustomerDTO> getAllCustomer() throws Exception;

    boolean addCustomer(CustomerDTO customerDTO) throws Exception;

    boolean updateCustomer(CustomerDTO customerDTO) throws Exception;

    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws Exception;

    String generateNewID() throws SQLException, ClassNotFoundException;
}
