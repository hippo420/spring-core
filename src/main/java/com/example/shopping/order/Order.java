package com.example.shopping.order;

import java.math.BigDecimal;

public class Order {

    private String memberId;
    private String itemName;
    private int itemPrice;
    private int point;

    public Order(String memberId, String itemName, int itemPrice, int point) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.point = point;
    }

//    public int calPoint(){
//
//        double rate = (double)point/1000;
//        return (int)(itemPrice * rate);
//    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId='" + memberId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", point=" + point +
                '}';
    }
}
