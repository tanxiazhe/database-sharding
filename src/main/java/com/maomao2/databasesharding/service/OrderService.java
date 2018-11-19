package com.maomao2.databasesharding.service;

import com.maomao2.databasesharding.model.Order;
import com.maomao2.databasesharding.model.User;

public interface OrderService {
    Order getOrderById(int id);

    boolean addOrder(Order order);
}
