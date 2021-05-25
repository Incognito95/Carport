package business.services;

import business.entities.Order;
import business.entities.OrderConfirmation;
import business.entities.User;
import business.persistence.Database;
import business.persistence.OrderConfirmationMapper;


public class OrderConfirmationFacade {

    private OrderConfirmationMapper orderConfirmationMapper;

    public OrderConfirmationFacade(Database database) {
        this.orderConfirmationMapper = new OrderConfirmationMapper(database);
    }

    public OrderConfirmation getOrderById(int orderid) throws Exception {
        return orderConfirmationMapper.getOrderById(orderid);
    }


}
