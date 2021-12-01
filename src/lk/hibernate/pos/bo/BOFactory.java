package lk.hibernate.pos.bo;

import lk.hibernate.pos.bo.custom.impl.CustomerBOImpl;
import lk.hibernate.pos.bo.custom.impl.ItemBOImpl;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case ITEM:
                return new ItemBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        CUSTOMER, ITEM
    }
}

