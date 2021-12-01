package lk.hibernate.pos.bo.custom.impl;

import lk.hibernate.pos.bo.custom.ItemBO;
import lk.hibernate.pos.dao.DAOFactory;
import lk.hibernate.pos.dao.custom.ItemDAO;
import lk.hibernate.pos.dto.ItemDTO;
import lk.hibernate.pos.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public class ItemBOImpl implements ItemBO {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item i : all) {
            allItems.add(new ItemDTO(i.getItemCode(), i.getDescription(), i.getPackSize(), i.getUnitPrice(), i.getQtyOnHand()));
        }
        return allItems;
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return itemDAO.delete(code);
    }

    @Override
    public boolean addItem(ItemDTO dto) throws Exception {
        return itemDAO.add(new Item(dto.getItemCode(), dto.getDescription(), dto.getPackSize(), dto.getUnitPrice(), dto.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        return itemDAO.update(new Item(dto.getItemCode(), dto.getDescription(), dto.getPackSize(), dto.getUnitPrice(), dto.getQtyOnHand()));
    }

    @Override
    public boolean ifItemExist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.ifItemExist(code);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}
