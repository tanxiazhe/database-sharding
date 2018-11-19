package com.maomao2.databasesharding.controller;

import com.maomao2.databasesharding.model.Order;
import com.maomao2.databasesharding.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Orders")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping
    public Order get(@RequestParam int id) {
        Order order = this.orderService.getOrderById(id);
        return order;
    }

    @PostMapping
    public boolean create(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
}
