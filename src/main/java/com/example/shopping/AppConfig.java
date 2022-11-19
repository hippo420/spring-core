package com.example.shopping;

import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiceImpl;
import com.example.shopping.member.MemoryMemberRepository;
import com.example.shopping.order.OrderService;
import com.example.shopping.order.OrderServiceImpl;
import com.example.shopping.point.CrazyPointPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService(){

        return new MemberServiceImpl(memoryMemberRepository());
    }

    @Bean
    public MemoryMemberRepository memoryMemberRepository(){

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){

        return new OrderServiceImpl(memoryMemberRepository(),crazyPointPolicy());
    }

    @Bean
    public CrazyPointPolicy crazyPointPolicy(){

        return new CrazyPointPolicy();
    }

}
