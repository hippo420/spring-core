package com.example.shopping;

import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiveImpl;
import com.example.shopping.member.MemoryMemberRepository;
import com.example.shopping.order.OrderService;
import com.example.shopping.order.OrderServiceImpl;
import com.example.shopping.point.CrazyPointPolicy;

public class AppConfig {



    public MemberService memberService(){
        return new MemberServiveImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new CrazyPointPolicy());
    }
}
