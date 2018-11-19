package com.maomao2.databasesharding.service.impl;

import com.maomao2.databasesharding.mapper.pkg3.OrderMapper;
import com.maomao2.databasesharding.model.Order;
import com.maomao2.databasesharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderById(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean addOrder(Order order) {
        boolean result = false;
        try {
            orderMapper.insertSelective(order);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
