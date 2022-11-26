package com.example.shopping.Singleton;

import com.example.shopping.AppConfig;
import com.example.shopping.member.MemberRepository;
import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiceImpl;
import com.example.shopping.member.MemoryMemberRepository;
import com.example.shopping.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {


    @Test
    @DisplayName("@Configuration과 싱글톤")
    void configuratinTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemoryMemberRepository memberRepository = ac.getBean("memoryMemberRepository",MemoryMemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository: "+memberRepository1);
        System.out.println("orderService -> memberRepository: "+memberRepository2);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }


    @Test
    @DisplayName("AppConfig의 빈")
    void configuratinTestDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = "+ bean);
    }
}
