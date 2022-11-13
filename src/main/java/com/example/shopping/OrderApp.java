package com.example.shopping;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiveImpl;
import com.example.shopping.order.Order;
import com.example.shopping.order.OrderService;
import com.example.shopping.order.OrderServiceImpl;

public class OrderApp {



    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member = new Member("gaebabja111","gae", Grade.GALAXY);
        memberService.join(member);

         Order order = orderService.createOrder("gaebabja111","IPhone14 Pro",1000000);
        System.out.println("order = "+order.toString());
        System.out.println("point = "+order.getPoint());
    }
}
