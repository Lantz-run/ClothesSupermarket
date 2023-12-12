package com.Lantz.service.impl;

import com.Lantz.bean.Order;
import com.Lantz.service.OrderService;
import com.Lantz.utils.BusinessException;
import com.Lantz.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderIO orderIO = new OrderIO();

    @Override
    public void buyProducts(Order o) throws BusinessException {
        orderIO.add(o);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIO.findByOderId(orderId);
    }
}
