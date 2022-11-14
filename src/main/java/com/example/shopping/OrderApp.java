package com.example.shopping;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiveImpl;
import com.example.shopping.order.Order;
import com.example.shopping.order.OrderService;
import com.example.shopping.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    //DI의존성주입

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
        
        Member member = new Member("gaebabja111","gae", Grade.GALAXY);
        memberService.join(member);

         Order order = orderService.createOrder("gaebabja111","IPhone14 Pro",1000000);
        System.out.println("order = "+order.toString());
        System.out.println("point = "+order.getPoint());
    }
}
