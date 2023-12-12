package com.Lantz.bean;

import com.Lantz.utils.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

    private int orderId;
    private List<OrderItem> orderItemList = new ArrayList<>(); // 用来存储订单项
    private String createData;
    private float sum; // 总金额
    private OrderStatusType status = OrderStatusType.UNPAID; // 状态
    private int userId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getCreateData() {
        return createData;
    }

    public void setCreateData(String createData) {
        this.createData = createData;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Order(int orderId, List<OrderItem> orderItemList, String createData, float sum, OrderStatusType status, int userId) {
        this.orderId = orderId;
        this.orderItemList = orderItemList;
        this.createData = createData;
        this.sum = sum;
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItemList=" + orderItemList +
                ", createData='" + createData + '\'' +
                ", sum=" + sum +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
