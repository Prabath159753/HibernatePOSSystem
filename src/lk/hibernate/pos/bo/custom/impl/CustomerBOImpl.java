package lk.hibernate.pos.bo.custom.impl;

import lk.hibernate.pos.bo.custom.CustomerBO;
import lk.hibernate.pos.dao.DAOFactory;
import lk.hibernate.pos.dao.custom.CustomerDAO;
import lk.hibernate.pos.dto.CustomerDTO;
import lk.hibernate.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public class CustomerBOImpl implements CustomerBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer customer : all) {
            allCustomers.add(new CustomerDTO(customer.getId(), customer.getTitle(), customer.getName(),
                    customer.getAddress(), customer.getCity(), customer.getProvince(), customer.getPostalCode()));
        }
        return allCustomers;
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.add(new Customer(customerDTO.getId(),
                customerDTO.getTitle(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getCity(),
                customerDTO.getProvince(),
                customerDTO.getPostalCode()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(new Customer(customerDTO.getId(), customerDTO.getTitle(), customerDTO.getName(), customerDTO.getAddress(),
                customerDTO.getCity(), customerDTO.getProvince(), customerDTO.getPostalCode()));
    }

    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.ifCustomerExist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }
}
