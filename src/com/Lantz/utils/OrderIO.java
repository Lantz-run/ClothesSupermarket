package com.Lantz.utils;

import com.Lantz.bean.Order;
import com.Lantz.ui.RegisterClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIO extends RegisterClass {

    private static List<Order> orders = new ArrayList<>();
    private static final String ORDER_FILE = "order.obj";

    public void add(Order order) throws BusinessException{
        orders.add(order);
        writeOrders();
    }

    public List<Order> list() throws BusinessException{
        readOrders();
        return orders;
    }

    public void buyProducts(){
        // Éú³É¶©µ¥
        boolean flag = true;
        while (flag){
            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
        }
    }

    public Order findByOderId(int orderId) throws BusinessException{
        Order order = null;
        int oid;
        for (Order o : orders
             ) {
            oid = o.getOrderId();
            if (oid == orderId){
                order = o;
                break;
            }
        }

        return order;
    }

    public boolean writeOrders(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            out.writeObject(orders);
            out.close();
            return true;
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean readOrders(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ORDER_FILE));
            orders = (List<Order>) in.readObject();
            in.close();
            return true;
        } catch(IOException e) {
            throw new RuntimeException(e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
