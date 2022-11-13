package com.example.shopping.order;

public interface OrderService {
    Order createOrder(String memberId, String itemName, int itemPrice);

}
