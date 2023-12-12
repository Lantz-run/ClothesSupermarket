package com.Lantz.service;

import com.Lantz.bean.Order;
import com.Lantz.utils.BusinessException;

import java.util.List;

public interface OrderService {

    public void buyProducts(Order o) throws BusinessException;
    public List<Order> list() throws BusinessException;
    public Order findById(int orderId) throws BusinessException;
}
