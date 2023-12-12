package com.Lantz.bean;

import java.io.Serializable;

/**
 * 订单项
 */
public class OrderItem implements Serializable {

    private int ItemId;
    private Clothes clothes; // 商品
    private int shoppingNum;
    private float sum; // 购买金额

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderItem(int itemId, Clothes clothes, int shoppingNum, float sum) {
        ItemId = itemId;
        this.clothes = clothes;
        this.shoppingNum = shoppingNum;
        this.sum = sum;
    }

    public OrderItem() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "ItemId=" + ItemId +
                ", clothes=" + clothes +
                ", shoppingNum=" + shoppingNum +
                ", sum=" + sum +
                '}';
    }
}
